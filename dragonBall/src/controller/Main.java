package controller;

import modelo.*;

import java.sql.*;

import java.util.Scanner;

import daoDragonBall.DaoAtaque;
import daoDragonBall.DaoUsuario;

public class Main {

	public static void main(String[] args) throws SQLException {
	
     Juego juego = new Juego();
     juego.inicializar();
     juego.mostrarEnemigos();
     juego.mostrarProtagonistas();
     juego.mostrarSecundarios();

    }
	
	

		
}


