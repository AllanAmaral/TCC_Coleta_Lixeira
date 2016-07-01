package DAO;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author Allan.Amaral
 */
public class GenericDAO implements Serializable {
    
    private EntityManagerFactory emf = null;
    
    public GenericDAO() {
        this.emf = Persistence.createEntityManagerFactory("TCC_Coleta_LixoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Integer gerarId(CriteriaQuery cq, Root root, SingularAttribute attribute, EntityManager em) {
        cq.select(root.get(attribute));
        cq.orderBy(em.getCriteriaBuilder().desc(root.get(attribute)));
        Query q = em.createQuery(cq);
        q.setMaxResults(1);
        Integer id = q.getFirstResult();
        id++;
        return id;
    }
}
