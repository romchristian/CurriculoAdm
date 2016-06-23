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
import py.com.palermo.curriculoadm.entities.Estudio;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEstudioDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EstudioDAO implements IEstudioDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Estudio create(Estudio entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Estudio edit(Estudio entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Estudio entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Estudio find(Object id) {
        return abmService.find(id, Estudio.class);
    }

    @Override
    public List<Estudio> findAll() {
        return abmService.getEM().createQuery("select obj from Estudio obj").getResultList();
    }

    @Override
    public List<Estudio> findAllSinEmpresa() {
        return abmService.getEM().createQuery("select obj from Estudio obj WHERE OBJ.empresa IS NULL").getResultList();
    }

    @Override
    public List<Estudio> findAllConEmpresa(Empresa empresa) {
        return abmService.getEM().createQuery("select obj from Estudio obj WHERE OBJ.empresa = :empresa")
                .setParameter("empresa", empresa)
                .getResultList();
    }

    @Override
    public List<Estudio> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Estudio> findAllActive() {
        return abmService.getEM().createQuery("select obj from Estudio obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Estudio> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
