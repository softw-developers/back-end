
package jpa.Persistencia;

import jpa.Entidades.Libro;


public class LibroDAO extends DAO{
    
     public void guardar(Libro objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Libro editar(Libro objeto){
        conectar();
        em.getTransaction().begin();
        Libro l = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return l;
    }
    
    public void eliminar(Libro objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    /*public Usuario buscarPorId(String id) {
        return em.find(Usuario.class, id);
    }
    
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
        return usuarios;
    }
    
}*/
    
}
