package it.polito.tdp.Model;

import java.time.LocalDate;

/**OGGETTO SEMPLICE CHE CONTIENE I DATI RELATIVI AD UN SINGOLO ESAME
 * POJO - plain old java object
 * 
 * contine :
 * 		dati privati (proprietà)
 * 		costruttore
 * 		metodi get/set
 * 		metodi di servizio: (equals, compareTo, toString, hashCode)
 * */

public class Esame {
	
	private String codice;
	private String titolo;
	private String docente;
	
	private int voto;
	private boolean superato;
	private LocalDate dataSuperamento; /*usare le classi java.time per le date*/
	
	/**
	 *Nuovo esame, non ancora superato 
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del titolare del corso
	 */
	public Esame(String codice, String titolo, String docente) {
	
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato=false;  //quando costruisco l'oggetto l'esame non è ancora stato superato
	}
	




	/** deve restituire il voto solo se l'esame è stato superato, altrimenti eccezione
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		else
			throw new IllegalStateException("Esame ".toUpperCase()+ this.codice+" non ancora superato");
	}
	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}
	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}
	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}
	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
		else
			throw new IllegalStateException("Esame"+ this.codice+" non ancora superato");
	}
	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}


	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}
	
	

	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", voto=" + voto
				+ ", superato=" + superato + ", dataSuperamento=" + dataSuperamento + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

// CONFRONTO SOLO IL CODICE 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
/**
 * se l'esame non è ancora superato, lo considera superato con il voto e la data specificati
 * Se invece l'esame era già superato, genera un'eccezione
 * 
 * 
 * Il metodo va in sostituzione a setData/setVoto
 * @param voto
 */
	public void supera(int voto, LocalDate data){
		
		if(!this.superato){
			//non ancora superato :OK
			this.superato=true;
			this.dataSuperamento=data;
			this.voto=voto;
		} else{
			/*viene lanciata quando vengono richiamati metodi senza le giuste condizioni*/
			throw new IllegalStateException("Esame"+ this.codice+" gia' superato");
		}
	
	}
	
	
	

}
