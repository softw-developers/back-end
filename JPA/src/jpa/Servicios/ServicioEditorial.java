
package jpa.Servicios;

import jpa.Entidades.Autor;
import jpa.Entidades.Editorial;
import jpa.Persistencia.EditorialDAO;


public class ServicioEditorial {
    
    private EditorialDAO dao;

    public ServicioEditorial() {
        
        dao = new EditorialDAO();
    }
    
    
     public void crear(String nombre, boolean alta){
        
        Editorial e1 = new Editorial();
        Editorial e2 = new Editorial();
        Editorial e3 = new Editorial();
        
       e1.setNombre(nombre);
       e1.setAlta(alta);
       e2.setNombre(nombre);
       e2.setAlta(alta);
       e3.setNombre(nombre);
       e3.setAlta(alta);
        
        dao.guardar(e1);
        dao.guardar(e2);
        dao.guardar(e3);
        
    }
}
