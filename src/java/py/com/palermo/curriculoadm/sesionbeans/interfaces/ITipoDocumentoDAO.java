/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.TipoDocumento;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface ITipoDocumentoDAO extends AbstractDAO<TipoDocumento> {

    @Override
    TipoDocumento create(TipoDocumento entity, String usuario);

    @Override
    TipoDocumento edit(TipoDocumento entity, String usuario);

    @Override
    TipoDocumento find(Object id);

    @Override
    List<TipoDocumento> findAll();

    @Override
    List<TipoDocumento> findAll(String query, QueryParameter params);

    @Override
    void remove(TipoDocumento entity, String usuario);

}
