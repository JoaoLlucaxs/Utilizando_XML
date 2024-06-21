package com.xml.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xml.model.Produto;

public class SalvandoCarrinho {
	public static void main(String[] args) throws FileNotFoundException {
		List<Produto> carrinho=new ArrayList<Produto>();
		carrinho.add(new Produto(1L, "Hotdog", new BigDecimal("2.30")));
		carrinho.add(new Produto(2L, "Hamburguer", new BigDecimal("5.30")));
		
		// Tenho uma lista e quero salvar em xml
		XStream xStream=new XStream(new DomDriver());
		xStream.alias("produto", Produto.class);
		xStream.aliasAttribute(Produto.class, "codigo","codigo");
		xStream.alias("carrinho",List.class);
		
		OutputStream os=new FileOutputStream("./carrinho.xml");
		xStream.toXML(carrinho, os);
	}
}
