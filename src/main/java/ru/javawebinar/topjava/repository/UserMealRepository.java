package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 *
 */
public interface UserMealRepository {
    void delete(int id);

    void get(int id);

    void save(Meal meal);

    Collection<Meal> getAll();
}
