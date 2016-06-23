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
import py.com.palermo.curriculoadm.entities.Experiencia;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IExperienciaDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ExperienciaDAO implements IExperienciaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Experiencia create(Experiencia entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Experiencia edit(Experiencia entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Experiencia entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Experiencia find(Object id) {
        return abmService.find(id, Experiencia.class);
    }

    @Override
    public List<Experiencia> findAll() {
        return abmService.getEM().createQuery("select obj from Experiencia obj").getResultList();
    }

    @Override
    public List<Experiencia> findAllSinEmpresa() {
        return abmService.getEM().createQuery("select obj from Experiencia obj WHERE OBJ.empresa IS NULL").getResultList();
    }

    @Override
    public List<Experiencia> findAllConEmpresa(Empresa empresa) {
        return abmService.getEM().createQuery("select obj from Experiencia obj WHERE OBJ.empresa = :empresa")
                .setParameter("empresa", empresa)
                .getResultList();
    }

    @Override
    public List<Experiencia> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Experiencia> findAllActive() {
        return abmService.getEM().createQuery("select obj from Experiencia obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Experiencia> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
