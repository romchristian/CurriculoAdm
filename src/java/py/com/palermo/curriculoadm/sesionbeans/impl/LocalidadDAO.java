/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.palermo.curriculoadm.entities.Ciudad;
import py.com.palermo.curriculoadm.entities.Departamento;
import py.com.palermo.curriculoadm.entities.Localidad;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ILocalidadDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LocalidadDAO implements ILocalidadDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Localidad create(Localidad entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Localidad edit(Localidad entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Localidad entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Localidad find(Object id) {
        return abmService.find(id, Localidad.class);
    }

    @Override
    public List<Localidad> findAll() {
        return abmService.getEM().createQuery("select obj from Localidad obj").getResultList();
    }

    @Override
    public List<Localidad> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Localidad> findAllActive() {
        return abmService.getEM().createQuery("select obj from Localidad obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    
    @Override
    public List<Localidad> findAllActivePorDepartamento(Departamento d ) {
        return abmService.getEM().createQuery("select obj from Localidad obj WHERE OBJ.estado = :estado AND OBJ.departamento = :dep")
                .setParameter("estado", Estado.ACTIVO)
                .setParameter("dep", d)
                .getResultList();
    }
    
    @Override
    public List<Localidad> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
