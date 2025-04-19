import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface MealPlan {
    String getCategory();
    List<String> getFoodItems();
}

class VegetarianMeal implements MealPlan {
    private List<String> foodItems;
    private final String category = "Vegetarian";

    public VegetarianMeal() {
        this.foodItems = new ArrayList<>();
        foodItems.add("Paneer Tikka");
        foodItems.add("Vegetable Biryani");
        foodItems.add("Palak Paneer");
        foodItems.add("Dal Makhani");
        foodItems.add("Mixed Vegetable Curry");
    }

     public String getCategory(){
        return this.category;
    }

    @Override
    public List<String> getFoodItems() {
        return foodItems;
    }
}

class VeganMeal implements MealPlan {
    private List<String> foodItems;
    private final String category = "Vegan";

    public VeganMeal() {
        this.foodItems = new ArrayList<>();
        foodItems.add("Tofu Stir-Fry");
        foodItems.add("Vegan Pasta Primavera");
        foodItems.add("Lentil Soup");
        foodItems.add("Vegan Burrito");
        foodItems.add("Vegan Chili");
    }
    public String getCategory(){
        return this.category;
    }

    @Override
    public List<String> getFoodItems() {
        return foodItems;
    }
}

class KetoMeal implements MealPlan {
    private List<String> foodItems;
     private final String category = "Keto";

    public KetoMeal() {
        this.foodItems = new ArrayList<>();
        foodItems.add("Steak with Avocado");
        foodItems.add("Bulletproof Coffee");
        foodItems.add("Salmon with Asparagus");
        foodItems.add("Chicken Salad with Olive Oil");
        foodItems.add("Keto Chili");
    }
    public String getCategory(){
        return this.category;
    }

    @Override
    public List<String> getFoodItems() {
        return foodItems;
    }
}

class HighProteinMeal implements MealPlan {
    private List<String> foodItems;
    private final String category = "High-Protein";

    public HighProteinMeal() {
        this.foodItems = new ArrayList<>();
        foodItems.add("Grilled Chicken Breast");
        foodItems.add("Quinoa Salad with Chickpeas");
        foodItems.add("Tuna Steak");
        foodItems.add("Protein Smoothie");
        foodItems.add("Lentil Soup");
    }

    public String getCategory(){
        return this.category;
    }
    @Override
    public List<String> getFoodItems() {
        return foodItems;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public List<String> getFoodItems() {
        return mealPlan.getFoodItems();
    }
     public String getCategory() {
        return mealPlan.getCategory();
    }

    public boolean validateMealPlan() {
        if (mealPlan.getFoodItems() == null || mealPlan.getFoodItems().isEmpty()) {
            return false;
        }
        return true;
    }

    public static <U extends MealPlan> Meal<U> generateMealPlan(Class<U> mealPlanClass) {
        try {
            U mealPlan = mealPlanClass.newInstance();
            Meal<U> meal = new Meal<>(mealPlan);
            if (meal.validateMealPlan()) {
                return meal;
            } else {
                return null;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class PlanningOfMeal {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = Meal.generateMealPlan(VegetarianMeal.class);
        Meal<VeganMeal> veganMeal = Meal.generateMealPlan(VeganMeal.class);
        Meal<KetoMeal> ketoMeal = Meal.generateMealPlan(KetoMeal.class);
        Meal<HighProteinMeal> highProteinMeal = Meal.generateMealPlan(HighProteinMeal.class);

        if (vegetarianMeal != null) {
            System.out.println("Vegetarian Meal Plan:");
            System.out.println("Category: " + vegetarianMeal.getCategory());
            System.out.println("Foods: " + vegetarianMeal.getFoodItems());
        } else {
            System.out.println("Failed to generate Vegetarian Meal Plan.");
        }

        if (veganMeal != null) {
            System.out.println("\nVegan Meal Plan:");
             System.out.println("Category: " + veganMeal.getCategory());
            System.out.println("Foods: " + veganMeal.getFoodItems());
        } else {
            System.out.println("Failed to generate Vegan Meal Plan.");
        }

        if (ketoMeal != null) {
            System.out.println("\nKeto Meal Plan:");
             System.out.println("Category: " + ketoMeal.getCategory());
            System.out.println("Foods: " + ketoMeal.getFoodItems());
        } else {
            System.out.println("Failed to generate Keto Meal Plan.");
        }

        if (highProteinMeal != null) {
            System.out.println("\nHigh-Protein Meal Plan:");
            System.out.println("Category: " + highProteinMeal.getCategory());
            System.out.println("Foods: " + highProteinMeal.getFoodItems());
        } else {
            System.out.println("Failed to generate High-Protein Meal Plan.");
        }
    }
}
