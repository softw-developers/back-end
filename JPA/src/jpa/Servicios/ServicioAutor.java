
package jpa.Servicios;



import jpa.Entidades.Autor;
import jpa.Persistencia.AutorDAO;


public class ServicioAutor {
    
    private AutorDAO dao;

    public ServicioAutor() {
        
        dao = new AutorDAO();
    }
    
    public void crear(String nombre, boolean alta){
        
        Autor a1 = new Autor();
        Autor a2 = new Autor();
        Autor a3 = new Autor();
        
        a1.setNombre(nombre);
        a1.setAlta(alta);
        a2.setNombre(nombre);
        a2.setAlta(alta);
        a3.setNombre(nombre);
        a3.setAlta(alta);
        
        dao.guardar(a1);
        dao.guardar(a2);
        dao.guardar(a3);
        
    }

   
    
    
}
