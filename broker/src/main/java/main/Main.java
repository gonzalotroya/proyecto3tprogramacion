package main;

import java.util.ArrayList;
import java.util.Collection;

import clases.Empresa;
import clases.Mercado;
import clases.Noticia;
import enums.EnumeracionLugares;
import pantalla.Ventana;
public class Main {

	public static void main(String[] args) {
		Ventana ventana=new Ventana();
		ventana.setVisible(true);
	
		
		ArrayList<Noticia> subida = new ArrayList<Noticia>();
		Empresa google = new Empresa ("Alphabet",subida, EnumeracionLugares.USA, 2349);
		
		
		subida.addAll((Collection<? extends Noticia>) google);
		
		
	}

}
