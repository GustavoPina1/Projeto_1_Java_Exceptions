package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
		
		if(checkout.isBefore(checkin)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	
	public Integer duration() {
		int days=0;
		days=(int) ChronoUnit.DAYS.between(checkin, checkout);
		return days;	
	}
	public void updateDates(LocalDate checkin,LocalDate checkout) throws DomainException {
		
		if(checkin.isBefore(this.checkin) || checkout.isBefore(this.checkout)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		}
		else if(checkout.isBefore(checkin)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkin=checkin;
		this.checkout=checkout;
	}
	
	@Override
	public String toString() {
		
		return "Reservation: Room "+roomNumber+
				", check in: "+checkin.format(fmt)+", check out: "+
				checkout.format(fmt)+", "+duration()+" nights";
	}
	
	
}
