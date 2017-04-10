package deshpande.assign2.dietPlan;

import deshpande.assign2.meal.Dinner;
import deshpande.assign2.meal.Lunch;
import deshpande.assign2.meal.Meal;
import deshpande.assign2.mealOrder.HighCarb;
import deshpande.assign2.mealOrder.LowCarb;
import deshpande.assign2.mealOrder.MealCategory;

public class HighCarbDietPlan implements DietPlan {
	protected Meal lunch;
	protected Meal dinner;
	private String filename;	
	private String dayOfWeek;
	protected MealCategory highCarbMeal ;
	private int day_of_week;
	public HighCarbDietPlan() {
		super();
	}
		
	public HighCarbDietPlan(String filename, int day_of_week) {
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
		HighCarb highcarb = new HighCarb();
		setLowCarbMeal(highcarb);
		
		highcarb.loadRecipes(filename);
		
		Lunch lun = new Lunch(highCarbMeal);
		
		setLunch(lun);
		
		Dinner din = new Dinner(highCarbMeal);
		
		setDinner(din);
	}

	@Override
	public String showPlan() {
		String plan= (lunch.getDetails()+dinner.getDetails());
		System.out.println("Lunch Plan:"+lunch.getDetails()+" Dinner Plan:"+dinner.getDetails());
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
	public double getCostOfPlan()
	{
		/*should return the total cost of lunch and dinner.*/
		return lunch.getCost()+dinner.getCost();
	}

	public MealCategory getLowCarbMeal() {
		return highCarbMeal;
	}
	public void setLowCarbMeal(MealCategory highCarbMeal) {
		this.highCarbMeal = highCarbMeal;
	}
	public String getdayOfWeek() {
		return dayOfWeek;
	}


}
