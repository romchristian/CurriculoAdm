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
import py.com.palermo.curriculoadm.entities.NivelAcademico;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.INivelAcademicoDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NivelAcademicoDAO implements INivelAcademicoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public NivelAcademico create(NivelAcademico entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public NivelAcademico edit(NivelAcademico entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(NivelAcademico entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public NivelAcademico find(Object id) {
        return abmService.find(id, NivelAcademico.class);
    }

    @Override
    public List<NivelAcademico> findAll() {
        return abmService.getEM().createQuery("select obj from NivelAcademico obj").getResultList();
    }

    @Override
    public List<NivelAcademico> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
