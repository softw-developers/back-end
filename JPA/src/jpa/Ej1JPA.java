/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Servicios.ServicioAutor;
import jpa.Servicios.ServicioEditorial;
import jpa.Servicios.ServicioLibro;


public class Ej1JPA {

    public static void main(String[] args) {
        
        ServicioAutor serviautor = new ServicioAutor();
        ServicioEditorial serviedi = new ServicioEditorial();
        ServicioLibro servilibro = new ServicioLibro();

        try {

            EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPAPU");
            EntityManager em = EMF.createEntityManager();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

       serviautor.crear("Claudio", true);
       serviautor.crear("Fernando", true);
       serviautor.crear("Franco", true);
       serviedi.crear("Sur", true);
       serviedi.crear("Latin", true);
       serviedi.crear("Copada", true);
    }

    
}
