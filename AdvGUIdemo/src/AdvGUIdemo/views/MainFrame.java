/*
 * This program acts a simulated grocery store item purchasing system
 *    The user select items to add to the cart and then can Checkout or
 *    remove items
 */
package AdvGUIdemo.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import AdvGUIdemo.common.FoodItem;
import java.awt.Font;
import java.awt.SystemColor;

public class MainFrame extends JFrame 
{

	private JPanel cartPane;
	private JTextField txtSearch;

	static Vector<FoodItem> cartList = new Vector<FoodItem>();//Stores the FoodItem 's in the cart
	static DefaultListModel foodList = new DefaultListModel();//Stores the names and cost of items in the cart
	
	//Parallel Vectors used to store all available food item names, types, and costs.
	static Vector<String> foodItemNames = new Vector<String>();
	static Vector<String> foodItemTypes = new Vector<String>();
	static Vector<Double> foodItemCosts = new Vector<Double>();
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					File foodFile = new File("src\\AdvGUIdemo\\resources\\foods.txt");
					Scanner inFile = new Scanner(foodFile);
					while(inFile.hasNextLine())//reads available food items in from foods.txt
					{
						String[] temp = new String[3];
						temp = inFile.nextLine().split(" ");//splits each line into respective elements [Name][Type][Cost]
						foodItemNames.addElement(temp[0]);
						foodItemTypes.addElement(temp[1]);
						foodItemCosts.addElement(Double.parseDouble(temp[2]));
					}	
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() 
	{				
		initComponents();		
	}
	
	public void initComponents()
	{
		setTitle("Food Supply");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		cartPane = new JPanel();
		cartPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cartPane);
		cartPane.setLayout(null);
				
		JScrollPane cartScrollPane = new JScrollPane();
		cartScrollPane.setBounds(615, 11, 169, 495);
		cartPane.add(cartScrollPane);
		
		JList cartJList = new JList(foodList);
		cartScrollPane.setViewportView(cartJList);
		
		JLabel inCartLbl = new JLabel("Items in cart");
		cartScrollPane.setColumnHeaderView(inCartLbl);
		
		DefaultListModel resultItemList = new DefaultListModel();
		JList resultsJList = new JList(resultItemList);
		
		JPanel searchPnl = new JPanel();
		searchPnl.setBounds(10, 11, 595, 549);
		cartPane.add(searchPnl);
		searchPnl.setLayout(null);
		
		JPanel resultsPanel = new JPanel();//declaring before the btnListener
		
		ActionListener btnListener = new ActionListener()//Action Listener for the buttons
		{
		   public void actionPerformed(ActionEvent e)
		   {
			    System.out.println(e.getActionCommand());
			    cartPane.remove(searchPnl);	 
				cartPane.repaint();
				if(e.getActionCommand().equals("All"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					for(int i = 0; i < foodItemNames.size(); i++)//Finds all available food items
					{
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
				
				else if(e.getActionCommand().equals("Produce"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					for(int i = 0; i < foodItemTypes.size(); i++)//Finds all Produce available
					{
						if(foodItemTypes.get(i).equals("Produce"))
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
				
				else if(e.getActionCommand().equals("Meat"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					for(int i = 0; i < foodItemTypes.size(); i++)//Finds all Meat Items available
					{
						if(foodItemTypes.get(i).equals("Meat"))
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
				
				else if(e.getActionCommand().equals("Dairy"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					for(int i = 0; i < foodItemTypes.size(); i++)//Finds all Dairy Items available
					{
						if(foodItemTypes.get(i).equals("Dairy"))
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
				
				else if(e.getActionCommand().equals("Frozen Goods"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					for(int i = 0; i < foodItemTypes.size(); i++)//Finds all Frozen Goods available
					{
						if(foodItemTypes.get(i).equals("Frozen"))
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
				
				else if(e.getActionCommand().equals("Baked Goods"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					for(int i = 0; i < foodItemTypes.size(); i++)//Finds all Baked Goods available 
					{
						if(foodItemTypes.get(i).equals("Baked"))
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
				
				else if(e.getActionCommand().equals("Add"))
				{
					int foodItemIndex;//stores the index of the food element to be able to pull data from parallel vectors
					String[] temp;//used to store segments from the selected value
					String selectedValue = resultsJList.getSelectedValue().toString();
					temp = selectedValue.split("     ");
					for(int i = 0; i < foodItemNames.size(); i++)
					{
						if(foodItemNames.get(i).equals(temp[1]))
						{
					       foodItemIndex = i;
					       cartList.addElement(new FoodItem(foodItemNames.get(i), foodItemTypes.get(i), foodItemCosts.get(i)));
					       foodList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "  " + foodItemNames.get(i)));
					       i = foodItemNames.size();
						}
					}
				}
				
				else if(e.getActionCommand().equals("Back"))//sends user back to the search screen
				{
					cartPane.remove(resultsPanel);
					resultItemList.clear();//Removes all items from the results list to allow for repeatable searches
					cartPane.add(searchPnl);
					cartPane.repaint();					
				}
				
				else if(e.getActionCommand().equals("Search for items"))
				{
					cartPane.add(resultsPanel);
					cartPane.repaint();
					System.out.println(txtSearch.getText());
					for(int i = 0; i < foodItemNames.size(); i++)//Finds all items starting with what the user entered in the search box
					{
						if(foodItemNames.get(i).toLowerCase().startsWith(txtSearch.getText().toLowerCase()))
						resultItemList.addElement(String.format("%s%.2f%s", "$", foodItemCosts.get(i), "     " + foodItemNames.get(i)));
					}
				}
		   }
		};
		
		JButton btnAll = new JButton("All");
		btnAll.setBounds(34, 123, 169, 174);
		btnAll.addActionListener(btnListener);
		searchPnl.add(btnAll);
		
		JButton btnDairy = new JButton("Dairy");
		btnDairy.setBounds(34, 300, 169, 175);
		btnDairy.addActionListener(btnListener);
		searchPnl.add(btnDairy);
		
		JButton btnProduce = new JButton("Produce");
		btnProduce.setBounds(211, 123, 169, 174);
		btnProduce.addActionListener(btnListener);
		searchPnl.add(btnProduce);
		
		JButton btnFrozenGoods = new JButton("Frozen Goods");
		btnFrozenGoods.setBounds(211, 300, 169, 175);
		btnFrozenGoods.addActionListener(btnListener);
		searchPnl.add(btnFrozenGoods);
		
		JButton btnMeat = new JButton("Meat");
		btnMeat.setBounds(389, 123, 169, 174);
		btnMeat.addActionListener(btnListener);
		searchPnl.add(btnMeat);
		
		JButton btnBakedGoods = new JButton("Baked Goods");
		btnBakedGoods.setBounds(389, 301, 169, 175);
		btnBakedGoods.addActionListener(btnListener);
		searchPnl.add(btnBakedGoods);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 31, 261, 31);
		searchPnl.add(txtSearch);
		txtSearch.setText("Search");
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search for items");
		btnSearch.setBounds(274, 31, 31, 31);
		btnSearch.addActionListener(btnListener);
		searchPnl.add(btnSearch);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(615, 537, 169, 23);
		btnCheckout.addActionListener(btnListener);
		
		
		resultsPanel.setBounds(10, 11, 595, 549);
		cartPane.add(resultsPanel);
		resultsPanel.setLayout(null);
		
		JScrollPane resultsScrollPane = new JScrollPane();
		resultsScrollPane.setBounds(10, 59, 575, 428);
		resultsPanel.add(resultsScrollPane);
		
		resultsJList.setBackground(SystemColor.text);
		resultsScrollPane.setViewportView(resultsJList);
		
		JLabel lblResultsFound = new JLabel("Results Found:");
		lblResultsFound.setBackground(SystemColor.text);
		lblResultsFound.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resultsScrollPane.setColumnHeaderView(lblResultsFound);
		
		JButton btnResultsBack = new JButton("Back");
		btnResultsBack.setBounds(98, 498, 192, 51);
		btnResultsBack.addActionListener(btnListener);
		resultsPanel.add(btnResultsBack);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(325, 498, 192, 51);
		btnAdd.addActionListener(btnListener);
		resultsPanel.add(btnAdd);
		cartPane.add(btnCheckout);
		
		JButton btnRemoveItem = new JButton("Remove Selected Item");
		btnRemoveItem.setBounds(615, 510, 169, 23);
		btnRemoveItem.addActionListener(btnListener);
		cartPane.add(btnRemoveItem);
		
		
	}
}
