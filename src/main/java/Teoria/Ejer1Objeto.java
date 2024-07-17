/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Teoria;

import java.io.Serializable;

/**
 *
 * @author sepy3
 */
public class Ejer1Objeto implements Serializable{

    
        //Atributos
        String titulo;
        String isbn;
        String autor;
        
        //Metodos

    public Ejer1Objeto(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
        
    

 
}
