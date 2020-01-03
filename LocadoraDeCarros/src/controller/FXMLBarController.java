/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.model.Carro;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MaryR
 */
public class FXMLBarController implements Initializable {
    
    @FXML
    public TextField txtDados;
    
    @FXML
    public Button btnSalvar;
    
    @FXML
    public Label lblSalvo;
    
    @FXML
    private DatePicker dataCompra;
    
    /**
     * Initializes the controller class.
     * @param parametro
     * @param caminhoDoArquivo
     */
   
    @FXML
    public void escreverDadosCSV(String parametro, String caminhoDoArquivo){
        caminhoDoArquivo = "C:\\Users\\MaryR\\OneDrive\\Documentos\\NetBeansProjects\\LocadoraDeCarros\\src\\com\\dados\\DadosCarro.csv";
        
        parametro = (txtDados.getText());

        ManipuladorDeArquivo.escreveNoArquivoCSV(parametro, caminhoDoArquivo);
    }
    
    @FXML
    public void datandoCompra(Calendar dataDaCompra){
        Carro carro = new Carro();
        
        dataDaCompra = carro.getDataDaCompra();
    }
    @FXML
    public void salvarDados(ActionEvent event){
        System.out.println("Salvo!");
        lblSalvo.setText("Salvo!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
