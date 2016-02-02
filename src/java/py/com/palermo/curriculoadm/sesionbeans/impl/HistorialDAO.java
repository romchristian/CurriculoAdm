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
import py.com.palermo.curriculoadm.entities.Historial;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IHistorialDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class HistorialDAO implements IHistorialDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Historial create(Historial entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Historial edit(Historial entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Historial entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Historial find(Object id) {
        return abmService.find(id, Historial.class);
    }

    @Override
    public List<Historial> findAll() {
        return abmService.getEM().createQuery("select obj from Historial obj").getResultList();
    }

    @Override
    public List<Historial> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
