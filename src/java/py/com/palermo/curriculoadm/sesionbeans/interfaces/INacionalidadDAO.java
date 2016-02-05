/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Nacionalidad;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface INacionalidadDAO extends AbstractDAO<Nacionalidad> {

    @Override
    Nacionalidad create(Nacionalidad entity, String usuario);

    @Override
    Nacionalidad edit(Nacionalidad entity, String usuario);

    @Override
    Nacionalidad find(Object id);

    @Override
    List<Nacionalidad> findAll();

    @Override
    List<Nacionalidad> findAll(String query, QueryParameter params);

    @Override
    void remove(Nacionalidad entity, String usuario);

}
