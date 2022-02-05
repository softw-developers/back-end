
package jpa.Persistencia;

import jpa.Entidades.Editorial;


public class EditorialDAO extends DAO{
    
        public void guardar(Editorial objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Editorial editar(Editorial objeto){
        conectar();
        em.getTransaction().begin();
        Editorial e = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return e;
    }
    
    public void eliminar(Editorial objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
