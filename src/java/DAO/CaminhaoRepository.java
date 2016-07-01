package DAO;

import Business.Objects.Caminhao;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoRepository extends GenericDAO {
    
    public void registrar(Caminhao caminhao) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(caminhao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarCaminhao(caminhao.getIdCaminhao()) != null) {
                throw new Exception("Caminhão já existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Caminhao caminhao) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            caminhao = em.merge(caminhao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = caminhao.getIdCaminhao();
                if (buscarCaminhao(id) == null) {
                    throw new Exception("O caminhão não existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void excluir(Integer id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caminhao caminhao;
            try {
                caminhao = em.getReference(Caminhao.class, id);
                caminhao.getIdCaminhao();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O caminhão não existe.", enfe);
            }
            em.remove(caminhao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Caminhao buscarCaminhao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caminhao.class, id);
        } finally {
            em.close();
        }
    }
    
    /*
    public List<Caminhao> findCaminhaoEntities() {
        return findCaminhaoEntities(true, -1, -1);
    }
    
    public List<Caminhao> findCaminhaoEntities(int maxResults, int firstResult) {
        return findCaminhaoEntities(false, maxResults, firstResult);
    }

    private List<Caminhao> findCaminhaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caminhao.class));
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

    public int getCaminhaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caminhao> rt = cq.from(Caminhao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
}
