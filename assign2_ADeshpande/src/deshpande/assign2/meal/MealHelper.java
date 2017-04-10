package deshpande.assign2.meal;

import deshpande.assign2.mealOrder.MealCategory;
import deshpande.assign2.mealOrder.Recipe;

public abstract class MealHelper implements Meal{
	private Recipe recipe;
	private MealCategory mealcategory;
	
	public MealHelper()
	{
		
	}
	public MealHelper(MealCategory mealcategory)
	{
		this.mealcategory = mealcategory;
		
		this.recipe = mealcategory.getARecipe();
	}
	@Override
	public Recipe getARecipe() {
		// TODO Auto-generated method stub
		return recipe;
	}

	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		return (recipe.getCalories());
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return recipe.getCost();
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		String abc = recipe.getName()+" "+recipe.getDescription()+" "+recipe.getCost()+" "+recipe.getCalories();
		// TODO Auto-generated method stub
		return abc;
	}

	
	
}
