package deshpande.assign2.meal;

import deshpande.assign2.mealOrder.MealCategory;
import deshpande.assign2.mealOrder.Recipe;

public class Dinner extends MealHelper implements Meal {
	
	protected Recipe recipe;
	protected MealCategory mealcategory;
	private boolean delivery;
	private  double  deliveryFee ;
	private double dinnerAmount;

	
	public Dinner() {
		super();
		
	}

	/**
	 * @param mealCategory
	 */
	public Dinner(MealCategory mealcategory) {
		super(mealcategory);
		setDeliveryFee(10.0);
		
	
	}

	public double showCost()
	{
		return recipe.getCost()+deliveryFee;
	}

	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		dinnerAmount = super.getCost()+deliveryFee;
		return (dinnerAmount);
	}

	
	


}
