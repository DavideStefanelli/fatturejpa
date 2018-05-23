package ejbs;

import entities.Fattura;
import entities.Societa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import managedbeans.FatturaManagedBean;

@Stateless
public class FatturaEJB implements FatturaEJBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean registra(FatturaManagedBean fattura, String pIvaSocieta) {

        TypedQuery<Societa> societaList = em.createNamedQuery("Societa.findByPiva", Societa.class).setParameter("piva", pIvaSocieta);
        boolean insertOk = false;
        
        if (societaList.getResultList().isEmpty() == false) {
            Societa s = societaList.getSingleResult();

            Fattura fEntity = new Fattura();
            fEntity.setImporto(fattura.getImporto());
            fEntity.setDatapagamento(fattura.getDatapagamento());
            fEntity.setCliente(s);
            em.persist(fEntity);
            insertOk = em.contains(fEntity);
        }
        
        return insertOk;
    }

    @Override
    public List<Fattura> getByIdSocieta(int id) {
        return em.createNamedQuery("Fattura.findIdSocieta", Fattura.class).setParameter("idsocieta", id).getResultList();
    }

    @Override
    public List<Fattura> getAll() {
        return em.createNamedQuery("Fattura.findAll", Fattura.class).getResultList();
    }

    
}
