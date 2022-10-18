package com.esprit.examen.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.services.CategorieProduitServiceImpl;


@RunWith(MockitoJUnitRunner.class)

class CategorieProduitControllerTest2 {

	
	@Mock
	CategorieProduitRepository categorieProduitRepository;
	
	@InjectMocks
	CategorieProduitServiceImpl categorieProduitServiceImpl;

	@Test
	void testGetCategorieProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testRetrieveCategorieProduit() {
		fail("Not yet implemented");
	}

}
