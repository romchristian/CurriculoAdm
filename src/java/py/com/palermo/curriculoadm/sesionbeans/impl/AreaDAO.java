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
import py.com.palermo.curriculoadm.entities.Area;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IAreaDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AreaDAO implements IAreaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Area create(Area entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Area edit(Area entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Area entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Area find(Object id) {
        return abmService.find(id, Area.class);
    }

    @Override
    public List<Area> findAll() {
        return abmService.getEM().createQuery("select obj from Area obj").getResultList();
    }

    @Override
    public List<Area> findAllSinEmpresa() {
        return abmService.getEM().createQuery("select obj from Area obj WHERE OBJ.empresa IS NULL").getResultList();
    }

    @Override
    public List<Area> findAllConEmpresa(Empresa empresa) {
        return abmService.getEM().createQuery("select obj from Area obj WHERE OBJ.empresa = :empresa")
                .setParameter("empresa", empresa)
                .getResultList();
    }

    @Override
    public List<Area> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Area> findAllActive() {
        return abmService.getEM().createQuery("select obj from Area obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Area> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
