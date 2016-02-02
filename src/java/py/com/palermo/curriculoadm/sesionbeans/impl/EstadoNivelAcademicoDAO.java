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
import py.com.palermo.curriculoadm.entities.EstadoNivelAcademico;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEstadoNivelAcademicoDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EstadoNivelAcademicoDAO implements IEstadoNivelAcademicoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public EstadoNivelAcademico create(EstadoNivelAcademico entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public EstadoNivelAcademico edit(EstadoNivelAcademico entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(EstadoNivelAcademico entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public EstadoNivelAcademico find(Object id) {
        return abmService.find(id, EstadoNivelAcademico.class);
    }

    @Override
    public List<EstadoNivelAcademico> findAll() {
        return abmService.getEM().createQuery("select obj from EstadoNivelAcademico obj").getResultList();
    }

    @Override
    public List<EstadoNivelAcademico> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
