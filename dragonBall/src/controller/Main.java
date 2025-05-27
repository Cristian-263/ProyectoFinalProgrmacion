package controller;

import modelo.*;

import java.sql.*;

import java.util.Scanner;

import daoDragonBall.DaoAtaque;
import daoDragonBall.DaoCondicionAtmosferica;
import daoDragonBall.DaoMomentoDia;
import daoDragonBall.DaoPersonaje;
import daoDragonBall.DaoTipoTerreno;
import daoDragonBall.DaoUsuario;

public class Main {

	public static void main(String[] args) throws SQLException {
	
	DatosJuego.cargarDatos();  
	
     Juego juego = new Juego();
     juego.inicializar();
     juego.mostrarEnemigos();
     juego.mostrarProtagonistas();
     juego.mostrarSecundarios();
     

 }

 }
	
	

		



