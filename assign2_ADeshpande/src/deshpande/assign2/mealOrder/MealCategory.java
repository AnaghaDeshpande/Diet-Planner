package deshpande.assign2.mealOrder;

import java.util.ArrayList;

public interface MealCategory {
	
	public ArrayList<Recipe> showRecipes();
	public Recipe getARecipe();
	public void loadRecipes(String fileName);

	
	
}
