package com.capgemini.collectionsexample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainCust {
		public static int CheckId(int id)
		{
			String regex = "^.*[0-9]";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(String.valueOf(id));
			if(matcher.matches() && id != 0 )
				return  id;
			else
				return 0;
		}
		//name
		public static String CheckName(String name)
		{
			String regex = "^[a-zA-Z].{3,}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(name);
			if(matcher.matches() && name != null)
				return name;
			else
				return null;
		}
		//age
		public static int CheckAge(int age)
		{

			if( age>0 && age<100)
				return age;
			else
				return 0;
		}
		//mobile number
		public static long CheckMobile(long mobile)
		{	
			String regex = "[0-9]{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(String.valueOf(String.valueOf(mobile)));
			if(matcher.matches())
				return mobile;
			else
				return 0L;
		}
		//email
		public static String CheckEmail(String email)
		{
			String regex = "^[A-Za-z0-9+_.-]+@(.+)\\.(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			if(matcher.matches())
				return email;
			else
				return null;
		}

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Customer> clist = new ArrayList<Customer>();
		//Customer c = new Customer();
		int id,age;
		String dob;
		long mobile;
		String email,name;
		
		char ch;
		do
		{
			System.out.println("Enter 1 to create customer.");
			System.out.println("Enter 2 to update customer.");
			System.out.println("Enter 3 to display customer.");
			System.out.println("Enter 4 to delete customer.");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("ID: ");
				id = CheckId(sc.nextInt());
				//System.out.println(id);
				sc.nextLine();
				
				System.out.println("Name: ");
				name = CheckName(sc.nextLine());
				//System.out.println(name);
				
				
				System.out.println("Age: ");
				age = CheckAge(sc.nextInt());
				//System.out.println(age);
				
				System.out.println("Mobile No.: ");
				mobile = CheckMobile(sc.nextLong());
				//System.out.println(mobile);
				sc.nextLine();
				
				System.out.println("DOB: ");
				
				dob = sc.nextLine();
				Date date = sdf.parse(dob);
				//System.out.println(sdf.format(date));
				
				System.out.println("Email: ");
				email = CheckEmail(sc.nextLine());
				//System.out.println(email);
			
				if( id !=0 && name != null && age !=0 && email!= null && mobile != 0)
				{
					clist.add(new Customer(id,name,age,date,email,mobile));
				}
				else
				{
					System.out.println("Wrong Input. Can not create coustomer.");
				}
				break;
			case 2:
				System.out.println("Enter id to update: ");
				int u_id = sc.nextInt();
				for(int i=0; i<clist.size();i++)
				{
					if(clist.get(i).getCid() == u_id)
					{
						sc.nextLine();
						System.out.println("Name: ");
						name = sc.nextLine();
						String u_name = CheckName(name);
						//System.out.println(u_name);
						if(u_name != null)
							clist.get(i).setCustname(u_name);
						else
							System.out.println("Invalid input.");
						
						
						System.out.println("Age: ");
						age = sc.nextInt();
						int u_age = CheckAge(age);
						System.out.println(u_age);
						if(u_age != 0)
							clist.get(i).setAge(age);
						else
							System.out.println("Invalid input.");
						
						//sc.nextLine();
						System.out.println("Mobile No.: ");
						mobile = sc.nextLong();
						long u_mob = CheckMobile(mobile);
						if(u_mob != 0)
							clist.get(i).setMobileno(mobile);
						else
							System.out.println("Invalid input.");
						
						sc.nextLine();
						
						System.out.println("DOB: ");
						clist.get(i).setDate(sdf.parse(sc.nextLine()));
						
					
						System.out.println("Email: ");
						email = sc.nextLine();
						String u_email = CheckEmail(email);
						if(u_email != null)
						clist.get(i).setEmail(email);
						else
							System.out.println("Invalid input");
					}
				}
				break;
			case 3:
				Iterator<Customer> citr = clist.iterator();
				while(citr.hasNext())
				{
					Customer cs = citr.next();
					System.out.println("ID: "+cs.getCid()+", NAME: "+cs.getCustname()+", AGE: "+cs.getAge()+", Mobile No.: "+cs.getMobileno()+", EMAIL: "+cs.getEmail()+", DOB: "+sdf.format(cs.getDate()));
				}
				break;
			case 4:
				Iterator<Customer> d_citr = clist.iterator();
				System.out.println("Enter customer id: ");
				int d_id = sc.nextInt();
				while(d_citr.hasNext())
				{
					Customer cs = d_citr.next();
					if(cs.getCid() == d_id)
					{
						d_citr.remove();
					}
				}
				break;
			default:
				System.out.println("Wrong choice.");
			}
			System.out.println("Enter y to continue: ");
			ch = sc.next().trim().charAt(0);
		}while(ch == 'y');
		sc.close();
	}

}

