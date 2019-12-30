/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.Year;
import java.util.Calendar;

/**
 *
 * @author MaryR
 */
public class Carro {
    String placa;
    Year anoCarro;
    String cor;
    String marcar;
    String modelo;
    String chassi;
    String proprietario;
    String caminhoDoArquivo = "C:\\Users\\MaryR\\OneDrive\\Documentos\\NetBeansProjects\\LocadoraDeCarros\\src\\com\\dados\\DadosCarro.csv";

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Year getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(Year anoCarro) {
        this.anoCarro = anoCarro;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarcar() {
        return marcar;
    }

    public void setMarcar(String marcar) {
        this.marcar = marcar;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getCaminhoDoArquivo() {
        return caminhoDoArquivo;
    }

    public void setCaminhoDoArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }
    
    
}