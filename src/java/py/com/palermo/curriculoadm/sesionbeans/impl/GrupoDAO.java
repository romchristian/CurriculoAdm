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
import py.com.palermo.curriculoadm.entities.Grupo;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IGrupoDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GrupoDAO implements IGrupoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Grupo create(Grupo entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Grupo edit(Grupo entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Grupo entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Grupo find(Object id) {
        return abmService.find(id, Grupo.class);
    }

    @Override
    public List<Grupo> findAll() {
        return abmService.getEM().createQuery("select obj from Grupo obj").getResultList();
    }

    @Override
    public List<Grupo> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
