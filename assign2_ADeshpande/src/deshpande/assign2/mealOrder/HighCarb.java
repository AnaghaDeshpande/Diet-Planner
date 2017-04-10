package deshpande.assign2.mealOrder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.midi.Receiver;

public class HighCarb implements MealCategory {
	
	private int randomInt;
	private  ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	@Override
	public ArrayList<Recipe> showRecipes() {
		// TODO Auto-generated method stub
		return recipeList;
	}
	@Override
	public Recipe getARecipe() {
		Random ran = new Random();
		randomInt = ran.nextInt(20)+0;
		Recipe r = recipeList.get(randomInt);
		Recipe tempRecipe = r;
		recipeList.remove(r);
		return tempRecipe;
		
	}
	@Override
	public void loadRecipes(String fileName) {
		try
		{
			FileInputStream fstream = new FileInputStream("HighCarb.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
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