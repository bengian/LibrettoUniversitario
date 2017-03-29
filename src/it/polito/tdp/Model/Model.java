package it.polito.tdp.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	private List<Esame> esami;
	
	public Model(){
		this.esami= new LinkedList<Esame>(); //quando creo il modello inizializzo una lista vuota
	}
	/**
	 * aggiunge un nuovo esame a quelli già presenti
	 * verificando che non ci sia già -> tre diverse oluzioni: silent failure, ritorno un boolean, lancio un'eccezione
	 * 
	 * @param esame
	 * @param true se inserito correttamente
	 * @param false se è già presente
	 */
	public boolean addEsame(Esame esame){
		/* si può utilizzare contains perchè ho implementato precedentemente equals*/
		if(!esami.contains(esame)){
			esami.add(esame);
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Ricerca se esiste un esame con il codice specificato. Altrimenti restituisce null
	 * il metodo ricerca l'esame, dato il suo codice
	 * per cercare ho due possibilità: uso un for, oppure indexOf, o contains
	 * Non posso usare indexOf, perchè si aspetta un oggetto dello stesso tipo della lista, non si può passare una stringa
	 * @param codice codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame cercaEsame(String codice){
		/*creo uno stesso oggetto dello stesso tipo di quello che sto cercando */
		int pos=this.esami.indexOf(new Esame (codice, null, null));
		if(pos==-1){
			return null;
		}else{
			return esami.get(pos);
		}
		
	}
}
