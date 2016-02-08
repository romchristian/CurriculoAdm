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
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.entities.Nacionalidad;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.INacionalidadDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NacionalidadDAO implements INacionalidadDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Nacionalidad create(Nacionalidad entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Nacionalidad edit(Nacionalidad entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Nacionalidad entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Nacionalidad find(Object id) {
        return abmService.find(id, Nacionalidad.class);
    }

    @Override
    public List<Nacionalidad> findAll() {
        return abmService.getEM().createQuery("select obj from Nacionalidad obj").getResultList();
    }

    @Override
    public List<Nacionalidad> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Nacionalidad> findAllActive() {
        return abmService.getEM().createQuery("select obj from Nacionalidad obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Nacionalidad> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }
}
