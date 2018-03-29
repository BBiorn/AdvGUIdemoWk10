package AdvGUIdemo.common;

public class FoodItem 
{
   private String name;//Stores the name of the food item
   private double cost;//Stores the cost of the food item
   String foodType;// Stores the food type ex. Produce
   
   public FoodItem(String itemName,String typeOfFood, double itemCost)
   {
      name = itemName;
      foodType = typeOfFood;
      cost = itemCost;
   }
   
   public String getName()
   {
	   return name;
   }
   
   public String getFoodType()
   {
	   return foodType;
   }
   
   public double getCost()
   {
	   return cost;
   }
   
   public void setName(String itemName)
   {
	   name = itemName;
   }
   
   public void setFoodType(String typeOfFood)
   {
	   foodType = typeOfFood;
   }
   
   public void setCost(double itemCost)
   {
	   cost = itemCost;
   }
}