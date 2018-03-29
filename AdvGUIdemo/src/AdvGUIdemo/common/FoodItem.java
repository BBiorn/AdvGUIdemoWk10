package AdvGUIdemo.common;

public class FoodItem 
{
   private String name;
   private double cost;
   
   public FoodItem(String itemName, double itemCost)
   {
      name = itemName;
      cost = itemCost;
   }
   
   public String getName()
   {
	   return name;
   }
   
   public double getCost()
   {
	   return cost;
   }
   
   public void setName(String itemName)
   {
	   name = itemName;
   }
   
   public void setCost(double itemCost)
   {
	   cost = itemCost;
   }
}