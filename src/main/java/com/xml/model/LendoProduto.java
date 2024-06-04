package com.xml.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LendoProduto {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		XStream stream=new XStream(new DomDriver());
		stream.alias("produto", Produto.class);
		stream.aliasAttribute(Produto.class,"codigo","codigo");
		
		// Pegar xml e transformar para objeto da classe
		Produto p=(Produto) stream.fromXML(new FileInputStream("./produto1.xml"));
		System.out.println(p.getCodigo());
		System.out.println(p.getDescricao());
		System.out.println(p.getValor());
	}

}
