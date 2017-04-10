package deshpande.assign2.meal;

import deshpande.assign2.mealOrder.MealCategory;
import deshpande.assign2.mealOrder.Recipe;
import deshpande.assign2.mealOrder.VeganMeal;

public class Lunch extends MealHelper implements Meal{
//data members
	
	protected Recipe recipe;
	private MealCategory mealcategory;
	private double calorie;
	
	
	
	public Lunch() {
		super();
	}

	/**
	 * @param recipe
	 * @param mealcategory
	 */
	public Lunch(MealCategory mealcategory) {
		super(mealcategory);
		
		
	}


	
}
