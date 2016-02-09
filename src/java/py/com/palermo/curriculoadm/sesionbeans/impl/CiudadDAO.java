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
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICiudadDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CiudadDAO implements ICiudadDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Ciudad create(Ciudad entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Ciudad edit(Ciudad entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Ciudad entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Ciudad find(Object id) {
        return abmService.find(id, Ciudad.class);
    }

    @Override
    public List<Ciudad> findAll() {
        return abmService.getEM().createQuery("select obj from Ciudad obj").getResultList();
    }

    @Override
    public List<Ciudad> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Ciudad> findAllActive() {
        return abmService.getEM().createQuery("select obj from Ciudad obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Ciudad> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
