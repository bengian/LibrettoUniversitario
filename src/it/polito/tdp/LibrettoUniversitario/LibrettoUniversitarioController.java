package it.polito.tdp.LibrettoUniversitario;
/**
 * Sample Skeleton for 'LibrettoUniversitario.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Model.Esame;
import it.polito.tdp.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoUniversitarioController {
	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCerca(ActionEvent event) {
    	String codice =txtCodice.getText();
    	if(codice.length()<5){
    		txtResult.appendText("Codice non valido\n");
    	}
    	Esame e=model.cercaEsame(codice);
    	if(e==null){
    		txtResult.appendText("codice "+codice+ " non trovato!!!\n");
    	}else{
    		txtResult.appendText("codice "+codice+ " trovato!!!\n");
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	// recuperare i dati dalla vista
    	String codice=txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente=txtDocente.getText();
    	
    	//verificare la validità dei dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtResult.appendText("Dati input non corretti\n");
    		return; //non faccio più niente
    	}
    	
    	//chiedi al Model di effettuare l'operazione
    	
    	Esame e=new Esame(codice, titolo, docente);
    	boolean b=model.addEsame(e);
    	if(b==true){
    		txtResult.appendText("operazione completata correttamente\n");
    	}else{
    		txtResult.appendText("Esame non aggiunto (codice duplicato)\n");
    	}
    	
    	//aggiorna la vista con il risultato dell'operazione

    	
    }
    /*Il main dice come usare il modello*/
    public void setModel(Model model) {
		this.model = model;
	}


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";

    }
}


