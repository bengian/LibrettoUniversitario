package it.polito.tdp.Model;

import java.time.LocalDate;

public class TestEsame {

	public static void main(String[] args) {
		Esame tdp= new Esame("03FYZ", "TECNICHE DI PROGRAMMAZIONE", "Fulvio Corno");
		System.out.println(tdp);
		Esame ami= new Esame("01QZP", "AMBIENT INTELLIGENCE", "Fulvio Corno");
		System.out.println(ami);
		System.out.println(tdp.equals(ami));
		
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
		
	}

}
