package com.capgemini.collectionsexample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class MainFlower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet<FLower> flowerSet = new HashSet<FLower>();
		
		char ch;
		do
		{
			System.out.println("Enter 1 to create list of flowers");
			System.out.println("Enter 2 to display list of flowers");
			System.out.println("Enter 3 to remove flowers");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Flower id: ");
				int id = sc.nextInt();
				System.out.println("Enter Flower name: ");
				String name = sc.next();
				sc.nextLine();
				System.out.println("Enter Flower price per kg: ");
				double price = sc.nextDouble();
				System.out.println("Enter Flower the quantity : ");
				int qty = sc.nextInt();
				flowerSet.add(new FLower(id,name,price,qty));
				break;
			case 2:
				Iterator <FLower> fitr = flowerSet.iterator();
				while(fitr.hasNext())
				{
					FLower fr = fitr.next();
					System.out.println("Flower id: "+fr.getFid()+", name: "+fr.getFname()+", price per kg: "+fr.getPrice()+", quantity: "+fr.getQty());
				}
				break;
			case 3:
				Iterator <FLower> fitr_d = flowerSet.iterator();
				System.out.println("Enter the flower id and flower quantity: " );
				int d_id = sc.nextInt();
				int d_qty = sc.nextInt();
				while(fitr_d.hasNext())
				{
					FLower f = fitr_d.next();
					if(f.getFid() == d_id)
					{
						if(f.getQty()-d_qty > d_qty)
						{
							f.setQty(f.getQty() - d_qty);
							System.out.println("Current quantity of "+f.getFname()+" is: "+f.getQty());
						}
						else if(f.getQty()-d_qty < d_qty)
						{
							System.out.println("Not enough amount of "+f.getFname()+" is available.");
						}
						else if(f.getQty()-d_qty == 0)
						{
							fitr_d.remove();
							System.out.println("Flower is removed.");
						}
					}
				}
				break;
			default:
				System.out.println("Wrong Choice");
			}
			System.out.println("Enter y to continue.");
			ch = sc.next().trim().charAt(0);
		}while(ch == 'y');
		sc.close();
	}

}
