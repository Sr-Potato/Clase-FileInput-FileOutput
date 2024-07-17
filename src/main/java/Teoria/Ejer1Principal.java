/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teoria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author sepy3
 */
public class Ejer1Principal {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Ejer1Objeto libro1 = new Ejer1Objeto("Mortadelo y Filemon","1231234","Francisco Ibañez");
        Ejer1Objeto libro2 = new Ejer1Objeto("Super Lopez","134266776","Jan");
        
        File fichero = new File("libros.dat");
        FileOutputStream fs = new FileOutputStream(fichero,false);
        FileInputStream fe = new FileInputStream("libros.dat");
        
        //DataOutputStream
        DataOutputStream datosSalida = new DataOutputStream(fs);
        datosSalida.writeUTF("Los pilares de la tierra");
        datosSalida.writeDouble(12345);
        datosSalida.writeUTF("ken Follet");
        fs.close();
        
        //DataInputStream
        DataInputStream datosEntrada = new DataInputStream(fe);
        String titulo = datosEntrada.readUTF();
        double paginas = datosEntrada.readDouble();
        String autor = datosEntrada.readUTF();
        
        System.out.println(titulo + " " + autor + " " + paginas);

        fe.close();
        
        //ObjectInputStream
        File ficheroObjeto = new File("LibroObjetos.dat");
        FileOutputStream fsalida = new FileOutputStream(ficheroObjeto, false);
        ObjectOutputStream objetoSalida = new ObjectOutputStream(fsalida);
        
        objetoSalida.writeObject(libro1);
        objetoSalida.writeObject(libro2);
        
        fsalida.close();
        objetoSalida.close();
        
        FileInputStream fentrada = new FileInputStream(ficheroObjeto);
        ObjectInputStream objetoEntrada = new ObjectInputStream(fentrada);
        
        Ejer1Objeto libro4 = new Ejer1Objeto("La quinta ola","134266776","Mark");
        //Ejer1Objeto libro3;
        try{
            while (true){
                libro4 = (Ejer1Objeto) objetoEntrada.readObject();
                System.out.println(libro4.getAutor() + " " + libro4.getIsbn() + " " + libro4.getTitulo());
            }
            
        }catch (IOException e){
            objetoEntrada.close();
            fentrada.close();
        }
        
    }
}
