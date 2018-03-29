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

public class MainFrame extends JFrame 
{

	private JPanel cartPane;
	private JTextField txtSearch;

	static Vector<FoodItem> foodList = new Vector<FoodItem>();
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
					while(inFile.hasNextLine())
					{
						String[] temp = new String[3];
						temp = inFile.nextLine().split(" ");
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
		
		JPanel searchPnl = new JPanel();
		searchPnl.setBounds(10, 11, 595, 549);
		cartPane.add(searchPnl);
		searchPnl.setLayout(null);
		

		ActionListener btnListener = new ActionListener()//Action Listener for the buttons
		{
		   public void actionPerformed(ActionEvent e)
		   {
				cartPane.remove(searchPnl);	 
				cartPane.repaint();
				
				
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
		cartPane.add(btnCheckout);
		
		JButton btnRemoveItem = new JButton("Remove Selected Item");
		btnRemoveItem.setBounds(615, 510, 169, 23);
		btnRemoveItem.addActionListener(btnListener);
		cartPane.add(btnRemoveItem);
		
		
	}
	
	public void createEvents()
	{
		
	}
}
