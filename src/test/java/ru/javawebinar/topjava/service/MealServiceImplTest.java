package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.USER_MEAL;
import static ru.javawebinar.topjava.MealTestData.userId_admin;
import static ru.javawebinar.topjava.MealTestData.userId_user;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:db/initDB.sql","classpath:db/populateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceImplTest {


    @Autowired
    private MealService mealService;
    @Test
    public void get() throws Exception {
        Meal meal  = mealService.get(2,userId_user);
    }
    @Test(expected = NotFoundException.class)
    public void wrongGet() throws Exception {
        Meal meal  = mealService.get(4,userId_user);
    }

    @Test
    public void delete() throws Exception {
        mealService.delete(1, userId_user);
    }

    @Test
    public void getAll() throws Exception {
        mealService.getAll(userId_user);
    }

    @Test
    public void deleteAll(){
        mealService.deleteAll(userId_admin);
    }
    @Test
    public void update() throws Exception {
        Meal meal = new Meal(mealService.get(1,userId_user));
        mealService.create(meal,userId_user);
    }

    @Test(expected = NotFoundException.class)
    public void wrongUpdate() throws Exception {
        Meal meal = new Meal(mealService.get(1,userId_user));
        mealService.create(meal,userId_admin);
    }

    @Test
    public void create() throws Exception {
        Meal meal = new Meal(USER_MEAL);
        mealService.create(meal, userId_user);
    }
    @Test
    public void getBetweenDateTimes() {
         mealService.getBetweenDateTimes(LocalDateTime.of(2018,3,20,6,0),
                 LocalDateTime.of(2018,3,20,11,0), userId_user);
    }
}