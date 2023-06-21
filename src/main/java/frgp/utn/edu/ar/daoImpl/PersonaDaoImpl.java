package frgp.utn.edu.ar.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.PersonaDao;
import frgp.utn.edu.ar.dominio.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean insertarPersona(Persona nuevo) {
		try {
			this.hibernateTemplate.save(nuevo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Persona obtenerPersonaPorDNI(String DNI) {
		return this.hibernateTemplate.get(Persona.class, DNI);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public boolean existePersona(String DNI) {
		return this.hibernateTemplate.get(Persona.class, DNI) != null;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarPersona(String DNI) {
		Persona art = new Persona();
		art.setDNI(DNI);
		this.hibernateTemplate.delete(art);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean actualizarPersona(Persona modificar) {
		try {
			this.hibernateTemplate.update(modificar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}
