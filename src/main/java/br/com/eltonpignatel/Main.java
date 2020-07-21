package br.com.eltonpignatel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import org.apache.pdfbox.text.PDFTextStripper;

import br.com.eltonpignatel.model.NotaDeCorretagem;


public class Main {

	public static void main(String[] args) throws IOException {
		
		String [] linhas;
		
		int posInicialLanctos = 0;
		int posFinalLanctos = 0;
		
		int posInicialResumoFinanceiro = 0;
		int posInicialCustosOperacionais = 0;
		int posInicialResumoDosNegocios = 0;
		
		
		
		NotaDeCorretagem notaDeCorretagem = new NotaDeCorretagem();
		
        try 
        {
        	PDDocument document = PDDocument.load(new File("C:\\Users\\elton\\Documents\\Repositorios\\LeitorCorretagens\\notas\\nota.pdf"),"077");
        	
        	document.setAllSecurityToBeRemoved(true);
        	
            
            PDFTextStripper stripper;
			
			stripper = new PDFTextStripper();
			stripper.setSortByPosition(true);
			
			for (int p = 1; p <= 1/*document.getNumberOfPages()*/; ++p) {
                stripper.setStartPage(p);
                stripper.setEndPage(p);

                String text = stripper.getText(document);

                linhas = text.trim().split(System.lineSeparator());
                
                notaDeCorretagem.setCorretora(linhas[3]);
                notaDeCorretagem.setDataPregao(new SimpleDateFormat("dd/MM/yyyy").parse(linhas[2].split(" ")[2]));
                notaDeCorretagem.setNumeroCorretagem(Integer.parseInt(linhas[2].split(" ")[0]));
                                
                //Identifica e categoriza as linhas
                for (int i = 0; i < linhas.length; i++) {
                	System.out.println(linhas[i]);
                	if (linhas[i].equals("Negócios realizados")) {
                		posInicialLanctos = i+2;
                	}
                	
                	if (linhas[i].equals("Resumo dos Negócios Resumo Financeiro")) {
                		posFinalLanctos = i-1;
                	}
                	
                	if (linhas[i].endsWith("Custos Operacionais")) {
                		posInicialCustosOperacionais = i;                		
                	}
                	
                	if (linhas[i].startsWith("Resumo dos Negócios")) {
                		posInicialResumoDosNegocios = i;                		
                	}
                	
                	if (linhas[i].endsWith("Resumo Financeiro")) {
                		posInicialResumoFinanceiro = i;                		
                	}
                	
                }
                
                System.out.println("-----");      
                //Exibe os lanctos
                for (int i = posInicialLanctos; i <= posFinalLanctos; i++) {
                	System.out.println(linhas[i]);                	
                }
                
                System.out.println("-----");  
                
                //Resumo financeiro
                for (int i = posInicialResumoFinanceiro; i < posInicialCustosOperacionais; i++) {
                	
                	System.out.println(linhas[i]); 
                	
                	if (linhas[i].contains("Valor líquido das operações") ) {
                		notaDeCorretagem.setValorLiquidoOperacoes(Double.parseDouble(linhas[i].substring(linhas[i].indexOf("Valor líquido das operações")).split(" ")[4].replace(",", ".")));
                	}
                	
                	if (linhas[i].contains("Taxa de liquidação") ) {
                		notaDeCorretagem.setTaxaLiquidacao(Double.parseDouble(linhas[i].substring(linhas[i].indexOf("Taxa de liquidação")).split(" ")[3].replace(",", ".")));
                	}
                	
                	if (linhas[i].contains("Taxa de Registro") ) {
                		notaDeCorretagem.setTaxaRegistro (Double.parseDouble(linhas[i].substring(linhas[i].indexOf("Taxa de Registro")).split(" ")[3].replace(",", ".")));
                	}
                	
                	if (linhas[i].contains("Taxa de Registro") ) {
                		notaDeCorretagem.setTaxaRegistro (Double.parseDouble(linhas[i].substring(linhas[i].indexOf("Taxa de Registro")).split(" ")[3].replace(",", ".")));
                	}
                	
                	if (linhas[i].contains("Emolumentos") ) {
                		notaDeCorretagem.setEmolumentos(Double.parseDouble(linhas[i].substring(linhas[i].indexOf("Emolumentos")).split(" ")[1].replace(",", ".")));
                	}
                	
                }
                
                for (int i = posInicialCustosOperacionais; i < linhas.length; i++) {
                	if (linhas[i].contains("I.R.R.F. s/ operações") ) {
                		
                		notaDeCorretagem.setBaseIRRF(Double.parseDouble(linhas[i].substring(linhas[i].indexOf("I.R.R.F. s/ operações")).split(" ")[4].replace(",", ".").replace("R$", "")) );
                		notaDeCorretagem.setValorIRRF(Double.parseDouble(linhas[i].substring(linhas[i].indexOf("I.R.R.F. s/ operações")).split(" ")[5].replace(",", ".")));
                	}
                }

            }
	
         
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        System.out.println(notaDeCorretagem.toString());
		
	}
	


}