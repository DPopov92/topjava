package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 *
 */
public interface UserMealRepository {
    void delete(int id);

    Meal get(int id);

    Meal save(Meal meal);

    Collection<Meal> getAll();
}
