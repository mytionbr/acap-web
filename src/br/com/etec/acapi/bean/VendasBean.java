package br.com.etec.acapi.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.etec.acapi.modelo.Compra;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modelo.Vendas;
import br.com.etec.acapi.modeloDAO.BancoDAO;

@ManagedBean
@ViewScoped
public class VendasBean {

	public List<Compra> getVendas(){
		BancoDAO dao = new BancoDAO();
		List<Compra> listaCompra = new ArrayList<Compra>();
		listaCompra = dao.buscaListaCompra();
		
		
		return listaCompra;
		
	}
	
	public BarChartModel getVendasModel() throws ParseException {

		
	   

		
	    BarChartModel model = new BarChartModel();
	    model.setAnimate(true);
	    ChartSeries vendas = new ChartSeries();
	    vendas.setLabel("Quantidade de vendas por produto");
	    List<Compra> listaVendasGrafico = getVendas();
	    System.out.println("Ola pessoal");
	    
	   
	   for (Compra venda : listaVendasGrafico) {
		   System.out.println(venda.getDataCompra());
		  
		   
		   vendas.set(parseData(venda.getDataCompra()), venda.getValorDaCompra());
	}
	   
	

	    
	    model.addSeries(vendas);
	    

	    return model;
	}
	private static String parseData(Calendar data) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = dateFormat.format(data);
      return dataFormatada;

	}
}
/*
  public List<Vendas> getVendas(){
		BancoDAO dao = new BancoDAO();
		List<Compra>listaCompra = dao.buscaListaCompra();
		List<Produto>listaAux = new ArrayList<Produto>();
		List<Vendas>listaVendas = new ArrayList<Vendas>();
		
		for (Compra compra : listaCompra) {
		    listaAux = compra.getProdutos();
		    for (Produto produtos : listaAux) {
		    	Vendas venda = new Vendas(produtos.getNome(), (produtos.getPreco()*produtos.getQtd()));
		    	listaVendas.add(venda);
			}
		}
		
		
		return listaVendas;
		
	}
	
	public BarChartModel getVendasModel() {

		
	   

		
	    BarChartModel model = new BarChartModel();
	    model.setAnimate(true);
	    ChartSeries vendas = new ChartSeries();
	    vendas.setLabel("Quantidade de vendas por produto");
	    List<Vendas> listaVendasGrafico = getVendas();
	    System.out.println("Ola pessoal");
	    
	   
	   for (Vendas venda : listaVendasGrafico) {
		   System.out.println(venda.getNome());
		   vendas.set(venda.getNome(), venda.getValor());
	}
	   
	

	    
	    model.addSeries(vendas);
	    

	    return model;
	}
	
}*/

	/*
	public List<Produto> getVendas(){
		BancoDAO dao = new BancoDAO();
		List<Produto>listaProdutos = dao.buscaListaProdutos();
		List<Produto>listaAux = new ArrayList<Produto>();
	
		
	
		
		
		return listaProdutos;
		
	}
	
	public BarChartModel getVendasModel() {

		
	   

		
	    BarChartModel model = new BarChartModel();
	    model.setAnimate(true);
	    ChartSeries estoque = new ChartSeries();
	    estoque.setLabel("Quantidade de vendas por produto");
	    List<Produto> listaVendasGrafico = getVendas();
	    System.out.println("Ola pessoal");
	    
	   
	   for (Produto venda : listaVendasGrafico) {
		   System.out.println(venda.getNome());
		   System.out.println(venda.getQtd());
		   estoque.set(venda.getNome(), venda.getQtd());
	}
	   
	

	    
	    model.addSeries(estoque);
	    

	    return model;
	}
	
}
*/	

	
	
	
	