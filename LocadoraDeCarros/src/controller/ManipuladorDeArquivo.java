package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Carro;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManipuladorDeArquivo {
    public static void escreveNoArquivoCSV(String parametro, String caminhoDoArquivo) {
        try {
            FileWriter fw = new FileWriter(caminhoDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
  		
            pw.println(parametro);
            pw.flush();
            pw.close();
  			
            System.out.println("Salvo!");

        }catch(Exception e) {
  			System.out.println("Erro ao gravar chamado" + e.getMessage());
        }
    }
	
    public static void carregarDados(String path) throws IOException, CsvException{
        
        Path pathClass = new File("C:\\Users\\MaryR\\OneDrive\\Documentos\\NetBeansProjects\\LocadoraDeCarros\\src\\com\\dados\\DadosCarro.csv").toPath();
		
        Reader reader = Files.newBufferedReader(pathClass);
        
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        
        CSVReader csvReader = 
                new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(0).build();
        
        List<String[]> carros = csvReader.readAll();
        
        for (String[] carro : carros){
            System.out.println(Arrays.toString(carro));
            Carro carro1;
        }
    }
}