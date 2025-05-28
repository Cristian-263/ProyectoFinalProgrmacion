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
	
	try {
        // 1. Cargar todos los datos del juego desde la base de datos
        DatosJuego.cargarDatos();
        System.out.println("✅ Datos del juego cargados.\n");

        // 2. Seleccionar un protagonista y un enemigo
        Protagonista protagonista = DatosJuego.protagonistas.get(0); // Por ejemplo, Goku
        PersonajeCombatiente enemigo = DatosJuego.enemigos.get(0);  // Por ejemplo, Freezer

        // 3. Crear un combate con entorno aleatorio (ya lo hace el constructor)
        Combate combate = new Combate(protagonista, enemigo);

        // 4. Ejecutar el combate
        combate.combatir();

    } catch (Exception e) {
        System.out.println("❌ Error durante la ejecución del combate:");
        e.printStackTrace();
    }
	
	
     
     

 }

 }
	
	

		



