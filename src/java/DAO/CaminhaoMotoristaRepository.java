package DAO;

import Business.Objects.Caminhao;
import Business.Objects.CaminhaoMotorista;
import Business.Objects.CaminhaoMotorista_;
import Business.Objects.Caminhao_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author Allan.Amaral
 */
public class CaminhaoMotoristaRepository extends GenericDAO {

    public void registrar(CaminhaoMotorista caminhaoMotorista) throws Exception {
        EntityManager em = null;
        try {
            caminhaoMotorista.setIdCaminhaoMotorista(gerarId());
            
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(caminhaoMotorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscarCaminhaoMotorista(caminhaoMotorista.getIdCaminhaoMotorista()) != null) {
                throw new Exception("O vínculo entre caminhão e motorista já existe.", ex);
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
            CriteriaQuery<CaminhaoMotorista> cq = em.getCriteriaBuilder()
                    .createQuery(CaminhaoMotorista.class);
            Root<CaminhaoMotorista> root = cq.from(CaminhaoMotorista.class);
            return gerarId(cq, root, CaminhaoMotorista_.idCaminhaoMotorista, em);
            
        } finally {
            em.close();
        }
    }    

    public void editar(CaminhaoMotorista caminhaoMotorista) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            caminhaoMotorista = em.merge(caminhaoMotorista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = caminhaoMotorista.getIdCaminhaoMotorista();
                if (buscarCaminhaoMotorista(id) == null) {
                    throw new Exception("O vínculo entre caminhão e motorista não existe.");
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
            CaminhaoMotorista caminhaoMotorista;
            try {
                caminhaoMotorista = em.getReference(CaminhaoMotorista.class, id);
                caminhaoMotorista.getIdCaminhaoMotorista();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O vínculo entre caminhão e motorista não existe.", enfe);
            }
            em.remove(caminhaoMotorista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public CaminhaoMotorista buscarCaminhaoMotorista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CaminhaoMotorista.class, id);
        } finally {
            em.close();
        }
    }
    
    public CaminhaoMotorista buscarCaminhaoMotoristaIdCaminhao(String idCaminhao) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<CaminhaoMotorista> cq = em.getCriteriaBuilder().createQuery(CaminhaoMotorista.class);
            Root<CaminhaoMotorista> root = cq.from(CaminhaoMotorista.class);
            Join<CaminhaoMotorista, Caminhao> caminhao = root.join(CaminhaoMotorista_.caminhao);
            cq.select(root);
            cq.distinct(true);
            cq.where(em.getCriteriaBuilder().like(caminhao.get(Caminhao_.idCaminhao), idCaminhao));
            Query q = em.createQuery(cq);
            List<CaminhaoMotorista> result = q.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
    
    /*
    public List<CaminhaoMotorista> findCaminhaoMotoristaEntities() {
        return findCaminhaoMotoristaEntities(true, -1, -1);
    }

    public List<CaminhaoMotorista> findCaminhaoMotoristaEntities(int maxResults, int firstResult) {
        return findCaminhaoMotoristaEntities(false, maxResults, firstResult);
    }

    private List<CaminhaoMotorista> findCaminhaoMotoristaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CaminhaoMotorista.class));
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

    public int getCaminhaoMotoristaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CaminhaoMotorista> rt = cq.from(CaminhaoMotorista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
}
