package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class PedidoApp {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("ENTER CLIENT DATA:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(nameClient, email, birthDate);

		System.out.println("ENTER ORDER DATA: ");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int num = sc.nextInt();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

		for (int i = 1; i <= num; i++) {
			System.out.println("Enter #" + i + " data:");
			System.out.print("Product name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(name, price);
			OrderItem oi = new OrderItem(quantity, price, product);
			order.addItem(oi);
		}

		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();
	}

}
