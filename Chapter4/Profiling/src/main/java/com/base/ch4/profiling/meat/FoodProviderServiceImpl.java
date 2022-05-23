package com.base.ch4.profiling.meat;

import com.base.ch4.profiling.Food;
import com.base.ch4.profiling.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideFood() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("MEAT!!!!"));
        return foods;
    }
}
