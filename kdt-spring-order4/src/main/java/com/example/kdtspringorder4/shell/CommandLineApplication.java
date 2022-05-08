package com.example.kdtspringorder4.shell;

import com.example.kdtspringorder4.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CommandLineApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Scanner in = new Scanner(System.in);
		System.out.println("=== Voucher Program ===");
		System.out.println("Type exit for Exit.");
		System.out.println("Type create to create a new voucher");
		System.out.println("Type list to list all vouchers");
		var running = true;
		String commandUnderGoing = null;
		do {
			String s = in.nextLine();
			switch (s) {
				case "exit":
					running = false;
					break;
				case "create":
					if (commandUnderGoing != null) {

					} else {

					}
					System.out.println("Select 1) ");
					break;
				case "list":
					break;
				default:
					System.out.println(s);
					break;
			}

		} while (running);
	}

}
