package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import clases.Empresa;
import clases.Mercado;
import clases.Noticia;
import enums.EnumeracionLugares;
import pantalla.Ventana;

public class Main {

	public static void main(String[] args) {

		String argN = ""; // Nombre Usuario
		String argC = ""; // Contraseña

		for (byte i = 0; i < args.length; i++) {
			if (args[i].equals("-argN")) {
				argN = (args[i + 1]);
			}
			if (args[i].equals("-argC")) {
				argC = args[i + 1];
			}
			if (args[i].equals("-help") || args[i].equals("?")) {
				System.out.println(
						"Argumentos disponibles:\n" + "\t-nU: Nombre de Usuario." + "\n\t-cU: Contraseña usuario.");
				System.exit(0);
			}
		}

		ArrayList<Noticia> subida = new ArrayList<Noticia>();
		Noticia buena = new Noticia("Buenos resultados", LocalDate.now(), "Es una buena noticia");
		subida.add(buena);
		ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();
		Empresa google = new Empresa("Alphabet", subida, EnumeracionLugares.USA, 2349);

		listaEmpresa.add(google);

		Ventana ventana = new Ventana(argN, argC);
		ventana.setVisible(true);
	}

}
