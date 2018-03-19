package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

@Service
public class MealServiceImpl implements MealService {
    @Override
    public Meal create(Meal meal, int userId) {
        return null;
    }

    @Override
    public void delete(int id, int userId) {

    }

    @Override
    public Meal get(int id, int userId) {
        return null;
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return null;
    }

    @Override
    public void update(Meal meal, int userId) {

    }

    private MealRepository repository;

}