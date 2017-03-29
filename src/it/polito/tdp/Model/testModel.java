package it.polito.tdp.Model;

public class testModel {

	public static void main(String[] args) {
		Model m=new Model();
		
		Esame tdp= new Esame("03FYZ", "TECNICHE DI PROGRAMMAZIONE", "Fulvio Corno");		
		Esame ami= new Esame("01QZP", "AMBIENT INTELLIGENCE", "Fulvio Corno");
		Esame ami2= new Esame("01QZP", "AMBIENT INTELLIGENCE", "Fulvio Corno");
		
		//m.addEsame(tdp);
		//m.addEsame(ami);
		
		System.out.println(m.cercaEsame("03FYZ"));
		System.out.println(m.cercaEsame("01QZP"));
		System.out.println(m.cercaEsame("01QZ"));
		
		System.out.println(m.addEsame(tdp));
		System.out.println(m.addEsame(ami));
		System.out.println(m.addEsame(tdp));
		

	}

}
