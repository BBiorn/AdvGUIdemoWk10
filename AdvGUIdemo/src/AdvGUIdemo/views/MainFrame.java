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

	Vector<FoodItem> foodList = new Vector<FoodItem>();
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
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
		
		JButton btnNewButton = new JButton("All");
		btnNewButton.setBounds(48, 124, 169, 174);
		cartPane.add(btnNewButton);
		
		JButton btnDairy = new JButton("Dairy");
		btnDairy.setBounds(48, 331, 169, 175);
		cartPane.add(btnDairy);
		
		JButton btnProduce = new JButton("Produce");
		btnProduce.setBounds(227, 124, 169, 174);
		cartPane.add(btnProduce);
		
		JButton btnFrozenGoods = new JButton("Frozen Goods");
		btnFrozenGoods.setBounds(227, 331, 169, 175);
		cartPane.add(btnFrozenGoods);
		
		JButton btnMeat = new JButton("Meat");
		btnMeat.setBounds(406, 124, 169, 174);
		cartPane.add(btnMeat);
		
		JButton btnBakedGoods = new JButton("Baked Goods");
		btnBakedGoods.setBounds(406, 331, 169, 175);
		cartPane.add(btnBakedGoods);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(48, 39, 261, 31);
		cartPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton removeItemBtn = new JButton("Remove Selected Item");
		removeItemBtn.setBounds(615, 513, 169, 23);
		cartPane.add(removeItemBtn);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(615, 537, 169, 23);
		cartPane.add(btnCheckout);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(319, 39, 31, 31);
		cartPane.add(btnNewButton_1);
	}
	
	public void createEvents()
	{
		
	}
}
