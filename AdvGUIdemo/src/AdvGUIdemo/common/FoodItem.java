package AdvGUIdemo.common;

public class FoodItem 
{
   private String name;
   private double cost;
   String foodType;
   
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