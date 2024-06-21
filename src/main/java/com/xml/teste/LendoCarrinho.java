package com.xml.teste;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xml.model.Produto;

public class LendoCarrinho {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		XStream stream=new XStream(new DomDriver());
		stream.alias("produto", Produto.class);
		stream.aliasAttribute(Produto.class,"codigo","codigo");
		stream.alias("carrinho", List.class);
		
		java.util.List<Produto>carrinho=(java.util.List<Produto>)stream.fromXML(new File("./carrinho.xml"));
		
		for(Produto p:carrinho) {
			System.out.println(p.getCodigo());
			System.out.println(p.getDescricao());
			System.out.println(p.getValor());
		}
	}

}
