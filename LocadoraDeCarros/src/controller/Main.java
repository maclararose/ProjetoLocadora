/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.Scanner;
import model.Carro;

/**
 *
 * @author MaryR
 */
public class Main{
    public static void main(String[] args) throws IOException, CsvException{        
        Scanner scan = new Scanner(System.in);
        
        Carro carro = new Carro();
        
        String parametro;
        parametro = scan.nextLine();
        
        ManipuladorDeArquivo.escreveNoArquivoCSV(parametro, carro.getCaminhoDoArquivo());
    }
}
