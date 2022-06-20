package oop;

//nombre clase
public class Auto {

	//atributos de la clase
	String color; 
	int anio; 
	long serie;
	String marca;
	String modelo; 
	float velocidad;
	float velocidadMaxima;
	boolean encendido; 

	//cuanod nace el objeto: constructor
	
	Auto(){
		velocidad = 0;
		anio = 2022;
		marca = "sin marca";
		modelo = "sin modelo";
		encendido = false;
		velocidadMaxima = 3;
	}
	
	
	//metodos
	
	void encender(){
		if(!encendido) {
			encendido = true; 
			System.out.println("Se ha Encendido el Auto");
		}else {
			System.out.println("No se puede Encender el Auto 2 Veces");
		}
	}
	
	void apagar() {
		if(encendido) {
			while(velocidad>0) {
				frenar();
			}
			encendido=false; 
			System.out.println("Se ha apagado el Auto correctamente");
		}else {
			System.out.println("No se puede apagar 2 veces.");
		}
	}
	
	void acelerar() {
		//if(encendido==true)
		if(encendido) {
			if(velocidad<velocidadMaxima) {
				velocidad++;
			}else {
				System.out.println("Error: no se puede superar la velocidad maxima.");
			}
		}else {
			System.out.println("Error: Debe encender el auto.");
		}
	}
	
	void frenar() {
		if(encendido) {
			if(velocidad>0) {
				velocidad--;
				System.out.println("Se ha reducido la velocidad del auto.");
			}
		}else {
			System.out.println("Error: Auto apagado.");
		}
	}
	
	void verVelocidad() {
		System.out.println(velocidad);
	}
}
