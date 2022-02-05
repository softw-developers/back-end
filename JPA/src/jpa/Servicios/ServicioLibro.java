
package jpa.Servicios;

import java.util.List;

import jpa.Entidades.Autor;
import jpa.Entidades.Editorial;
import jpa.Entidades.Libro;
import jpa.Persistencia.LibroDAO;


public final class ServicioLibro {
 
    private LibroDAO dao;

    public ServicioLibro() {
        
        dao = new LibroDAO();
    }
    
    public void crear(long isbn, String titulo, Integer anio, /*List<Integer> ejemplares,List<Integer> ejemplaresPrestados, 
                        List<Integer> ejemplaresREstantes*/ boolean alta, Autor autor, Editorial editorial ){
        
        Libro libroS = new Libro();
        
        libroS.setIsbn(111);
        libroS.setTitulo("Principito");
        libroS.setAnio(2022);
        //libroS.setEjemplares(ejemplares);
        //libroS.setEjemplaresPrestados(ejemplaresPrestados);
        //libroS.setEjemplaresRestantes(ejemplaresREstantes);
        libroS.setAlta(alta);
        libroS.setAutor(autor);
        libroS.setEditorial(editorial);
        
        dao.guardar(libroS);
        
    }

   
}
