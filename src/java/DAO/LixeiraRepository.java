package DAO;

import Business.Objects.Lixeira;
import Business.Objects.Lixeira_;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Allan.Amaral
 */
public class LixeiraRepository extends GenericDAO {
    
    public void registrar(Lixeira lixeira) throws Exception {
        EntityManager em = null;
        try {
            lixeira.setIdLixeira(gerarId());
            
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lixeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarLixeira(lixeira.getIdLixeira()) != null) {
                throw new Exception("Lixeira já existe", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    private Integer gerarId() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Lixeira> cq = em.getCriteriaBuilder().createQuery(Lixeira.class);
            Root<Lixeira> root = cq.from(Lixeira.class);
            return gerarId(cq, root, Lixeira_.idLixeira, em);
            
        } finally {
            em.close();
        }
    }

    public void editar(Lixeira lixeira) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lixeira = em.merge(lixeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lixeira.getIdLixeira();
                if (buscarLixeira(id) == null) {
                    throw new Exception("A lixeira não existe.");
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
            Lixeira lixeira;
            try {
                lixeira = em.getReference(Lixeira.class, id);
                lixeira.getIdLixeira();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("A lixeira não existe.", enfe);
            }
            em.remove(lixeira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Lixeira buscarLixeira(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lixeira.class, id);
        } finally {
            em.close();
        }
    }
    
    /*
    public List<Lixeira> findLixeiraEntities() {
        return findLixeiraEntities(true, -1, -1);
    }

    public List<Lixeira> findLixeiraEntities(int maxResults, int firstResult) {
        return findLixeiraEntities(false, maxResults, firstResult);
    }

    private List<Lixeira> findLixeiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lixeira.class));
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

    public int getLixeiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lixeira> rt = cq.from(Lixeira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
}
