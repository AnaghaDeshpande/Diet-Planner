package deshpande.assign2.meal;

import deshpande.assign2.mealOrder.Recipe;

public interface Meal {
	public Recipe getARecipe();
	public int getCalories();
	public double getCost();
	public String getDetails();

}
