package applications;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number:");
			int nr_quarto=sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			LocalDate data_checkin=LocalDate.parse(sc.next(),fmt);
			System.out.print("Check-out date (dd/MM/yyyy):");
			LocalDate data_checkout=LocalDate.parse(sc.next(),fmt);
			
		
			Reservation r = new Reservation(nr_quarto,data_checkin,data_checkout);
			System.out.println(r);
			System.out.println();
				
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			LocalDate data_checkin_1=LocalDate.parse(sc.next(),fmt);
			System.out.print("Check-out date (dd/MM/yyyy):");
			LocalDate data_checkout_1=LocalDate.parse(sc.next(),fmt);
				
			r.updateDates(data_checkin_1, data_checkout_1);
			System.out.println(r);	
			
		}catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
			
	}	
}

