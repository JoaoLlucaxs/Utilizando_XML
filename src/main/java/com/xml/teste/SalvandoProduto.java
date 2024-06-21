package com.xml.teste;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xml.model.Produto;

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
		OutputStream outputStream=new FileOutputStream("./produto.xml");
		stream.toXML(sabonete,outputStream); // estou mandando sabonete para a saida "outputStream"
		
		//========================================================================================================
		/* Vamos supor que eu quero assim : 
		 * <produto codigo=1>
		  	<descricao>sabonete dove</descricao>
		  	<valor>29.90</valor>
		</produto>
		
		stream.alias("produto", Produto.class);
		stream.aliasAttribute(Produto.class,"codigo","codigo");
		Produto fruta=new Produto(1L, "morango", new BigDecimal("30.90"));
		
		String xmlFruta= stream.toXML(fruta);
		System.out.println(xmlFruta);
		
		OutputStream outpuStream=new FileOutputStream("./produto02.xml");
		stream.toXML(fruta,outputStream); // estou mandando fruta para a saida "outputStream"
		
		*/
		
	}

}
