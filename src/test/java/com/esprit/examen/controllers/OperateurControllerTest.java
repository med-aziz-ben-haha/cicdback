package com.esprit.examen.controllers;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OperateurControllerTest {

    @Autowired
    OperateurRepository operateurRepository;

    Operateur operateur1 = new Operateur(2L,"Yassine","Ben Amor","Yassine",null);


}