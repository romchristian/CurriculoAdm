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
import py.com.palermo.curriculoadm.entities.Curriculo;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICurriculoDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CurriculoDAO implements ICurriculoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Curriculo create(Curriculo entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Curriculo edit(Curriculo entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Curriculo entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Curriculo find(Object id) {
        return abmService.find(id, Curriculo.class);
    }

    @Override
    public List<Curriculo> findAll() {
        return abmService.getEM().createQuery("select obj from Curriculo obj").getResultList();
    }

    @Override
    public List<Curriculo> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
