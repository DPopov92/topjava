package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JpaMealRepositoryImpl implements MealRepository {

    @PersistenceContext
    private EntityManager em;


    @org.springframework.transaction.annotation.Transactional
    @Override
    public Meal save(Meal meal, int userId) {
        meal.setUser(em.getReference(User.class, userId));
        if (meal.isNew()) {
            em.persist(meal);
            return meal;
        } else {
            return get(meal.getId(), userId) == null ? null : em.merge(meal);
        }
    }

    @Override
    @javax.transaction.Transactional
    public boolean delete(int id, int userId) {
       return em.createNamedQuery(Meal.DELETE).
               setParameter(1, id).
               setParameter(2,userId).
               executeUpdate()!=0;
    }

    @Override
    public Meal get(int id, int userId) {
        Meal meal =  em.find(Meal.class,id);
        return meal.getUser().getId() == userId ? meal : null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return em.createNamedQuery(Meal.ALL_SORTED, Meal.class).
                setParameter(1,userId).
                getResultList();
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createNamedQuery(Meal.BETWEEN, Meal.class)
                .setParameter(1,userId)
                .setParameter(2,startDate)
                .setParameter(3,endDate)
                .getResultList();
    }
}