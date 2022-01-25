/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.MotivoMulta;
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
public class MotivoMultaJpaController implements Serializable {

    public MotivoMultaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MotivoMulta motivoMulta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(motivoMulta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMotivoMulta(motivoMulta.getCodigo()) != null) {
                throw new PreexistingEntityException("MotivoMulta " + motivoMulta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MotivoMulta motivoMulta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            motivoMulta = em.merge(motivoMulta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                short id = motivoMulta.getCodigo();
                if (findMotivoMulta(id) == null) {
                    throw new NonexistentEntityException("The motivoMulta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(short id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MotivoMulta motivoMulta;
            try {
                motivoMulta = em.getReference(MotivoMulta.class, id);
                motivoMulta.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The motivoMulta with id " + id + " no longer exists.", enfe);
            }
            em.remove(motivoMulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MotivoMulta> findMotivoMultaEntities() {
        return findMotivoMultaEntities(true, -1, -1);
    }

    public List<MotivoMulta> findMotivoMultaEntities(int maxResults, int firstResult) {
        return findMotivoMultaEntities(false, maxResults, firstResult);
    }

    private List<MotivoMulta> findMotivoMultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MotivoMulta.class));
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

    public MotivoMulta findMotivoMulta(short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MotivoMulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getMotivoMultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MotivoMulta> rt = cq.from(MotivoMulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
