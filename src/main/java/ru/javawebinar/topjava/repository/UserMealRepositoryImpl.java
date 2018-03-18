package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class UserMealRepositoryImpl implements UserMealRepository {
    private static final Map<Integer, Meal> repository = new ConcurrentHashMap<>();

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public void get(int id) {
        repository.get(id);
    }

    @Override
    public void save(Meal meal) {
        if(meal.isNew()){
            meal.setId(count.getAndIncrement());
            repository.put(meal.getId(), meal);
        }
    }

    @Override
    public Collection<Meal> getAll() {

        return repository.values();
    }
}
