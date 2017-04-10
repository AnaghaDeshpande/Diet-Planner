package deshpande.assign2.dietPlan;



import java.util.*;
import java.text.*;

public class DietPlanOrder {

	//enum MealType {VEGAN,LOW_CARB,HIGH_CARB};
	private String customerName;
	private DietPlan dietPlan;
	private boolean paymentStatus;
	SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
	private String dayOfWeek;
	String day = simpleDateformat.toString();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test Case 1 	      
		DietPlanOrder planOrder = new DietPlanOrder("Anagha",MealType.HIGH_CARB,"HighCarb.txt");
		
		if(planOrder.acceptPayment("MASTER","5166675556565345",12.0))
			{planOrder.generateInvoice();
			System.out.println("Total cost of the diet including delivery fee for dinner $10 added:");
			System.out.println("$"+planOrder.getCost());
			
			}
		else
			System.out.println("Card is Invalid");
		
	}

	/**
	 * @param customerName
	 * @param dietPlan
	 */
	public DietPlanOrder(String customerName,MealType mealType,String fileName ) {
		super();
		this.customerName = customerName;
		switch(mealType)
		{
		case VEGAN:
			VeganDietPlan vdp = new VeganDietPlan("VeganRecipe.txt",1);
			setDietPlan(vdp);
			dayOfWeek=vdp.getdayOfWeek();
			break;
		case LOW_CARB:
			LowCarbDietPlan lcdp = new LowCarbDietPlan("LowCarb.txt",2);
			setDietPlan(lcdp);
			dayOfWeek=lcdp.getdayOfWeek();
			break;
		case HIGH_CARB:
			HighCarbDietPlan hcdp = new HighCarbDietPlan("HighCarb.txt",3);
			setDietPlan(hcdp);
			dayOfWeek=hcdp.getdayOfWeek();
			break;
		}
	}
	
	public double getCost()
	{
		return dietPlan.getCost();
	}
	
	public boolean acceptPayment(String cardName, String cardNumber, double amount)
	{
		char[] ch = cardNumber.toCharArray();
		if(cardName.equals("VISA"))
		{
			if (
					((cardNumber.length()==16)||cardNumber.length()==13)
					&&(cardNumber.charAt(0)=='4'))
			{
				return true;
			}
		}else if(cardName.equals("MASTER"))
		{
			if(cardNumber.length()==16&& (cardNumber.charAt(0)=='5')
					&&cardNumber.charAt(1)>='1'&&cardNumber.charAt(1)<='5')
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	public void generateInvoice() 
	{
		System.out.println("------invoice----");
		System.out.println("Customer Name: "+customerName);
		System.out.println(dayOfWeek);
		Date dNow = new Date();
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy.MM.dd ");
        System.out.println("Today's Date: " + ft.format(dNow));
		dietPlan.showPlan();
		
	}

	

	public void setDietPlan(DietPlan dietPlan) {
		this.dietPlan = dietPlan;
	}

}
