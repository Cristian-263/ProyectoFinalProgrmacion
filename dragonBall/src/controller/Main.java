package controller;

import modelo.*;

import java.sql.*;

import java.util.Scanner;

import daoDragonBall.*;

public class Main {

	public static void main(String[] args) throws SQLException {
	
	DatosJuego.cargarDatos();  
	
	Menus menu = new Menus();
	menu.menuLogin();
	
	Juego juego = new Juego();
	juego.inicializar();
	juego.mostrarProtagonistas();
	juego.mostrarEnemigos();
	juego.mostrarEnemigos();
	
	
     
     

 }

 }
	
	

		



