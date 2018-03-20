package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal create(Meal meal, int userId) {
        return repository.save(meal, userId);
    }

    @Override
    public void delete(int id, int userId) {
        if (AuthorizedUser.id() == userId)
            repository.delete(id, userId);
        else
            throw new NotFoundException("Not your meal");
    }

    @Override
    public Meal get(int id, int userId) {
        if (AuthorizedUser.id() == userId)
            return repository.get(id, userId);
        else
            throw new NotFoundException("Not your meal");
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        if (AuthorizedUser.id() == userId)
            return repository.getAll(userId);
        else
            throw new NotFoundException("Not your meal");
    }

    @Override
    public void update(Meal meal, int userId) {
        if (AuthorizedUser.id() == userId)
            repository.save(meal, userId);
        else
            throw new NotFoundException("Not your meal");
    }

}