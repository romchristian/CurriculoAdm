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
import py.com.palermo.curriculoadm.entities.Estudio;
import py.com.palermo.curriculoadm.entities.Experiencia;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEmpresaDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EmpresaDAO implements IEmpresaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Empresa create(Empresa entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Empresa edit(Empresa entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Empresa entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Empresa find(Object id) {
        return abmService.find(id, Empresa.class);
    }

    @Override
    public List<Empresa> findAll() {
        return abmService.getEM().createQuery("select obj from Empresa obj").getResultList();
    }

    @Override
    public List<Empresa> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Empresa> findAllActive() {
        return abmService.getEM().createQuery("select obj from Empresa obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<Empresa> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public boolean tieneArea(Empresa empresa) {
        boolean R = false;

        List<Area> lista = abmService.getEM().createQuery("SELECT a from Area a WHERE a.empresa = :empresa")
                .setParameter("empresa", empresa)
                .getResultList();
        if (lista != null && !lista.isEmpty()) {
            R = true;
        }

        return R;
    }

    @Override
    public boolean tieneEstudio(Empresa empresa) {
        boolean R = false;

        List<Estudio> lista = abmService.getEM().createQuery("SELECT e from Estudio e WHERE e.empresa = :empresa")
                .setParameter("empresa", empresa)
                .getResultList();
        if (lista != null && !lista.isEmpty()) {
            R = true;
        }

        return R;
    }

    @Override
    public boolean tieneExperiencia(Empresa empresa) {
        boolean R = false;

        List<Experiencia> lista = abmService.getEM().createQuery("SELECT e from Experiencia e WHERE e.empresa = :empresa")
                .setParameter("empresa", empresa)
                .getResultList();
        if (lista != null && !lista.isEmpty()) {
            R = true;
        }

        return R;
    }
}
