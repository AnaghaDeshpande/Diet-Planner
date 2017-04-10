package deshpande.assign2.mealOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class VeganMeal implements MealCategory{
	
	private int randomInt;
	
	private  ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	@Override
	public ArrayList<Recipe> showRecipes() {
		// TODO Auto-generated method stub
		
		return recipeList;
	}

	@Override
	public Recipe getARecipe() {
		// TODO Auto-generated method stub

		Random ran = new Random();
		randomInt=ran.nextInt(20)+0;
		Recipe r = recipeList.get(randomInt);
		Recipe tempRecipe = r;
		recipeList.remove(r);
		return tempRecipe;
		
	}

	@Override
	public void loadRecipes(String fileName) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fstream = new FileInputStream("VeganRecipe.txt");
			InputStreamReader fr = new InputStreamReader(fstream);
			BufferedReader br = new BufferedReader(fr);
			String strline=null;
			while((strline=br.readLine()) != null)
			{
				String lines[]= strline.split(":");
				Recipe r = new Recipe();
				r.setName(lines[0]);
				r.setDescription(lines[1]);
				r.setCost(Double.parseDouble(lines[2]));
				r.setCalories(Integer.parseInt(lines[3]));
				
				recipeList.add(r);
			}
			showRecipes();
		}catch(Exception e)
		{
			System.out.println("Error in reading file");
		}
	}
	
	public String showPlan()
	{
		return null;
	}
	public double getCostOfPlan()
	{
		return 0.0;
	}
}
