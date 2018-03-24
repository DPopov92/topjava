package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;

import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 *
 */
public class MealTestData {
    public static final int userId_user = USER_ID;
    public static final int userId_admin = ADMIN_ID;

    Meal id_1= new Meal(LocalDateTime.parse("2018-03-20T07:36:38"),"Завтрак",500);
    Meal id_2= new Meal(LocalDateTime.parse("2018-03-20T15:36:38"),"Завтрак",1000);
    Meal id_3= new Meal(LocalDateTime.parse("2018-03-20T20:36:38"),"Завтрак",450);
    Meal id_4= new Meal(LocalDateTime.parse("2018-03-20T07:36:38"),"Завтрак",500);
    Meal id_5= new Meal(LocalDateTime.parse("2018-03-20T15:36:38"),"Завтрак",1000);
    Meal id_6= new Meal(LocalDateTime.parse("2018-03-20T20:36:38"),"Завтрак",550);


    public static final Meal USER_MEAL = new Meal(LocalDateTime.now(), "testUserMeal", 750);
    public static final Meal ADMIN_MEAL = new Meal(LocalDateTime.now(), "testAdminMeal", 350);
}
