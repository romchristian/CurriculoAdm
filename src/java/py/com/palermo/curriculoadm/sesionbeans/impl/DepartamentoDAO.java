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
import py.com.palermo.curriculoadm.entities.Departamento;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IDepartamentoDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DepartamentoDAO implements IDepartamentoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Departamento create(Departamento entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Departamento edit(Departamento entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Departamento entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Departamento find(Object id) {
        return abmService.find(id, Departamento.class);
    }

    @Override
    public List<Departamento> findAll() {
        return abmService.getEM().createQuery("select obj from Departamento obj").getResultList();
    }

    @Override
    public List<Departamento> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Departamento> findAllActive() {
        return abmService.getEM().createQuery("select obj from Departamento obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Departamento> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
