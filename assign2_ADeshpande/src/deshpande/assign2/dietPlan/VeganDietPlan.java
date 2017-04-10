package deshpande.assign2.dietPlan;

import deshpande.assign2.meal.*;
import deshpande.assign2.mealOrder.*;

public class VeganDietPlan implements DietPlan {
//data members
	protected Meal lunch;
	protected Meal dinner;
	private String filename;	
	private String dayOfWeek;
	protected MealCategory veganMeal ;
	private int day_of_week;

	
	public VeganDietPlan() {
		super();
	}

	/**
	 * @param filename
	 * @param dayOfWeek
	 */
	public VeganDietPlan(String filename, int day_of_week) {
		super();
		this.filename = filename;
		this.day_of_week = day_of_week;
		switch (day_of_week)
		{
		case 1 : day_of_week = 1;
		dayOfWeek = "Monday";
		break;
		case 2 : day_of_week = 2;
		dayOfWeek = "Tuesday";
		break;
		case 3 : day_of_week = 3;
		dayOfWeek = "Wednesday";
		break;
		case 4 : day_of_week = 4;
		dayOfWeek = "Thursday";
		break;
		case 5 : day_of_week = 5;
		dayOfWeek = "Friday";
		break;
		case 6 : day_of_week = 6;
		dayOfWeek = "Saturday";
		break;
		case 7 : day_of_week = 7;
		dayOfWeek = "Sunday";
		break;
		
		default: dayOfWeek = "Invalid month";
        break;
		}
		VeganMeal v = new VeganMeal();
		setVeganMeal(v);
		
		v.loadRecipes(filename);
		
		Lunch lun = new Lunch(veganMeal);
//		System.out.println(lun.getDetails());
		setLunch(lun);
		
		Dinner din = new Dinner(veganMeal);
//		System.out.println(din.getDetails());
		setDinner(din);
	}

	@Override
	public String showPlan() {
		// TODO Auto-generated method stub
		
		/*Returns a String with description of lunch and dinner
		 *  (should call
		 *  the method getDetails()of lunch and dinner) and day of week. 
		 */
		String plan= (lunch.getDetails()+dinner.getDetails());
		System.out.println("Lunch Plan:"+lunch.getDetails()+" Dinner Plan "+dinner.getDetails());
		return plan;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		
		return getCostOfPlan();
	}

	public Meal getLunch() {
		return lunch;
	}

	public void setLunch(Meal lunch) {
		this.lunch = lunch;
	}
	
	public void setDinner(Meal dinner) {
		this.dinner = dinner;
	}
	
	public MealCategory getVeganMeal() {
		return veganMeal;
	}

	public void setVeganMeal(MealCategory veganMeal) {
		this.veganMeal = veganMeal;
	}
	
	public double getCostOfPlan()
	{
		
		/*should return the total cost of lunch and dinner.*/
		return lunch.getCost()+dinner.getCost();
	}
	public String getdayOfWeek() {
		return dayOfWeek;
	}

}
