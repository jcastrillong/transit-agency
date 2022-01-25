/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Agente;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pc
 */
public class AgenteJpaController implements Serializable {

    public AgenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Agente agente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAgente(agente.getIdentificacion()) != null) {
                throw new PreexistingEntityException("Agente " + agente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agente agente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agente = em.merge(agente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = agente.getIdentificacion();
                if (findAgente(id) == null) {
                    throw new NonexistentEntityException("The agente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agente agente;
            try {
                agente = em.getReference(Agente.class, id);
                agente.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agente with id " + id + " no longer exists.", enfe);
            }
            em.remove(agente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agente> findAgenteEntities() {
        return findAgenteEntities(true, -1, -1);
    }

    public List<Agente> findAgenteEntities(int maxResults, int firstResult) {
        return findAgenteEntities(false, maxResults, firstResult);
    }

    private List<Agente> findAgenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Agente findAgente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agente.class, id);
        } finally {
            em.close();
        }
    }
    
    public Agente findAgentePorPlaca(short placa) {
        EntityManager em = getEntityManager();
        try {
            Agente a = (Agente) em.createNamedQuery("agente.buscarporplaca")
                    .setParameter("placa", placa).getSingleResult();
            return a;
        } finally {
            em.close();
        }
    }

    public int getAgenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agente> rt = cq.from(Agente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
