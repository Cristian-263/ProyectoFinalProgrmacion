package controller;

import modelo.*;

import java.sql.*;

import java.util.Scanner;

import daoDragonBall.*;

public class Main {

	public static void main(String[] args) throws SQLException {
	
	
	  
	
	Menus menu = new Menus();
	menu.menuLogin();
	
	Juego juego = new Juego();
	juego.inicializar();
	
	juego.imprimirProtagonistas();
	
	//EL USUARIO ELIGE SU PROTAGONISTA
	Protagonista protagonista = juego.elegirProtagonistaInicial(); 
	
	//INICIAMOS LA HISTORIA QUE ELIJA
	switch (protagonista.getNombre().toLowerCase()) {
	    case "goku":
	        new HistoriaGoku(protagonista).iniciar();
	        break;
	    case "vegeta":
	        new HistoriaVegeta(protagonista).iniciar();
	        break;
	    case "majin boo":
	        new HistoriaBoo(protagonista).iniciar();
	        break;
	}
	
	/*Combate combate = new Combate(protagonista, enemigo, juego);*/
	


 }

 }
	
	

		



