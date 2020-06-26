package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;



public class Program {

	public static void main(String[] args) throws ParseException {

       Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);
       
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       List<Product> list = new ArrayList<Product>();
       
       System.out.print("Enter the number of products: ");
       int n = sc.nextInt();
       
       for(int i = 1; i <= n; i++) {
    	   
    	   System.out.println("Product #"+ i + "data:");
    	   
    	   System.out.print("Common, used or imported(c/u/i): ");
    	   char ch = sc.next().charAt(0);
    	   System.out.print("Name: ");
    	   sc.nextLine();
    	   String name = sc.nextLine();
    	   System.out.print("Price: ");
    	   double price = sc.nextDouble();
    	   if (ch == 'i') {
    		 System.out.print("Customs fee: ");
    		 double customsFree = sc.nextDouble();
    		 ImportedProduct imp = new ImportedProduct(name, price, customsFree);
    		 list.add(imp);
    	   }
    	   
    	   else if (ch == 'c') {
    		   Product pro = new Product(name, price);
    		   list.add(pro);
    	   }
    	   else {
    		   System.out.print("Manufacture date (DD/MM/YYYY): ");
    		   Date manufatureDate = sdf.parse(sc.next());
    		   UsedProduct use = new UsedProduct(name, price, manufatureDate);
    		   list.add(use);
    	   }
    	   
    	   
       }
       
       System.out.println();
       
       System.out.println("PRICE TAGS");
       for(Product pro: list) {
    	   System.out.println( pro.priceTag());
       }
       
       
       
       sc.close();

	}

}
