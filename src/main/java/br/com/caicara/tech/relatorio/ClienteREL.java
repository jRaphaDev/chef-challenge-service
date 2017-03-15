package br.com.caicara.tech.relatorio;

import java.util.Collection;
import java.util.List;

import br.com.caicara.tech.model.Person;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

 
public class ClienteREL {
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public ClienteREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/caicara/tech/templates/";
		System.out.println(path);
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir(Iterable<Person> people) {
		JasperReport report = null;
		try {
			System.out.println(this.getPathToReportPackage() + "teste_proc.jrxml");
			report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "teste_proc.jrxml");
			System.out.println(report);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JasperPrint print = null;
		try {
			print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource((Collection<Person>) people));
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		try {
			JasperExportManager.exportReportToPdfFile(print, "/Relatorio_de_Clientes.pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}