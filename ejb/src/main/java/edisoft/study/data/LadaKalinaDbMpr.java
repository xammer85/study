package edisoft.study.data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edisoft.study.model.LadaKalina;

@Stateless
public class LadaKalinaDbMpr {

	@PersistenceContext
	private EntityManager em;
	

	public LadaKalina find(String id) {
		return em.find(LadaKalina.class, id);
	}
	
	public LadaKalina create(LadaKalina car){
		em.persist(car);
		em.flush();
		
		//em.detach(car);
		
		return car;
	}
	
	public EntityManager getEm() {
		return em;
	}
}
