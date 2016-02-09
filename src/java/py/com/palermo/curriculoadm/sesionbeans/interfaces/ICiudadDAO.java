/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Ciudad;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface ICiudadDAO extends AbstractDAO<Ciudad> {

    @Override
    Ciudad create(Ciudad entity, String usuario);

    @Override
    Ciudad edit(Ciudad entity, String usuario);

    @Override
    Ciudad find(Object id);

    @Override
    List<Ciudad> findAll();

    @Override
    List<Ciudad> findAll(String query, QueryParameter params);

    @Override
    void remove(Ciudad entity, String usuario);

}
