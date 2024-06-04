package com.xml.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SalvandoProduto {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		XStream stream=new XStream(new DomDriver());
		stream.alias("produto", Produto.class);
		
		Produto sabonete=new Produto(1L, "sabonete dove", new BigDecimal("29.90"));
		
		String xml= stream.toXML(sabonete);
		System.out.println(xml); 
		/*
		 * <produto>
  		<codigo>1</codigo>
  		<descricao>sabonete dove</descricao>
  		<valor>29.90</valor>
		</produto>
		 * */
		
		// E se eu quiser mandar isso para um arquivo
		OutputStream outputStream=new FileOutputStream("./produto1.xml");
		stream.toXML(sabonete,outputStream); // estou mandando sabonete para a saida "outputStream"
		
		
		/* Vamos supor que eu quero assim : 
		 * <produto codigo=1>
		  	<descricao>sabonete dove</descricao>
		  	<valor>29.90</valor>
		</produto>
		*/
		stream.aliasAttribute(Produto.class,"codigo","codigo");
		//OutputStream outputStream=new FileOutputStream("./produto2.xml");
		//stream.toXML(sabonete,outputStream); // estou mandando sabonete para a saida "outputStream"
		
	}

}
