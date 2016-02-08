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
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.entities.TipoDocumento;
import py.com.palermo.curriculoadm.generico.ABMService;
import py.com.palermo.curriculoadm.generico.QueryParameter;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ITipoDocumentoDAO;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TipoDocumentoDAO implements ITipoDocumentoDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public TipoDocumento create(TipoDocumento entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public TipoDocumento edit(TipoDocumento entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(TipoDocumento entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public TipoDocumento find(Object id) {
        return abmService.find(id, TipoDocumento.class);
    }

    @Override
    public List<TipoDocumento> findAll() {
        return abmService.getEM().createQuery("select obj from TipoDocumento obj").getResultList();
    }

    @Override
    public List<TipoDocumento> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<TipoDocumento> findAllActive() {
        return abmService.getEM().createQuery("select obj from TipoDocumento obj WHERE OBJ.estado = :estado")
                .setParameter("estado", Estado.ACTIVO)
                .getResultList();
    }

    @Override
    public List<TipoDocumento> findAllActive(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }
}
