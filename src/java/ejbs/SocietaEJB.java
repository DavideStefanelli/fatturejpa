package ejbs;

import entities.Societa;
import entities.Utente;
import java.time.Instant;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import managedbeans.SocietaManagedBean;

@Stateless
public class SocietaEJB implements SocietaEJBLocal {

    @PersistenceContext(unitName = "FattureJpaPU")
    EntityManager em;
    
    @Override
    public Societa getByPiva(String piva) {
        TypedQuery<Societa> societa = em.createNamedQuery("Societa.findByPiva", Societa.class);
        if(societa.getResultList().isEmpty() == false){
            return societa.getSingleResult();
        }else{
            return null;
        }
    }

    @Override
    public boolean registra(SocietaManagedBean societa) {
        
        Societa sEntity = new Societa();
        sEntity.setIntestazione(societa.getIntestazione());
        sEntity.setCf(societa.getCf());
        sEntity.setDataregistrazione(Date.from(Instant.now()));
        sEntity.setPiva(societa.getPiva());
        sEntity.setRagsociale(societa.getRagsociale());
        em.persist(sEntity);
        return em.contains(sEntity);
        
    }

    @Override
    public Societa getByUtente(Utente utente) {
        
        TypedQuery<Societa> societa = em.createNamedQuery("Societa.findByContabile", Societa.class).setParameter("contabile", utente);
        
        if(societa.getResultList().isEmpty() == false){
            return societa.getSingleResult();
        }else{
            return null;
        }
    }

    
    
}
