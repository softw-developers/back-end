
package jpa.Persistencia;

import jpa.Entidades.Autor;


public class AutorDAO extends DAO{
    
      public void guardar(Autor objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Autor editar(Autor objeto){
        conectar();
        em.getTransaction().begin();
        Autor a = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return a;
    }
    
    public void eliminar(Autor objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
