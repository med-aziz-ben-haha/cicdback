package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitImplTest {
	@Autowired
	IProduitService ProduitService;

	@Test
	public void testAddProduit() {
		//	List<Stock> stocks = stockService.retrieveAllStocks();
		//	int expected=stocks.size();
		Produit s = new Produit("Produit code","Produit",23);
		Produit savedProduit= ProduitService.addProduit(s);

		//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedProduit.getIdProduit());
		ProduitService.deleteProduit(savedProduit.getIdProduit());

	}

	@Test
	public void testAddProduitOptimized() {

		Produit s = new Produit("Produit code","Produit",23);
		Produit savedProduit= ProduitService.addProduit(s);
		assertNotNull(savedProduit.getIdProduit());
		assertSame("Produit code", savedProduit.getCodeProduit());
		assertTrue(savedProduit.getPrix() != 0);
		ProduitService.deleteProduit(savedProduit.getIdProduit());

	}


	@Test
	public void testDeleteProduit() {
		Produit s = new Produit("Produit code","Produit",23);
		Produit savedProduit= ProduitService.addProduit(s);
		ProduitService.deleteProduit(savedProduit.getIdProduit());
		assertNull(ProduitService.retrieveProduit(savedProduit.getIdProduit()));
	}


}
