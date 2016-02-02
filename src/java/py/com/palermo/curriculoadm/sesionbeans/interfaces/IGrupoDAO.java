/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Grupo;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IGrupoDAO extends AbstractDAO<Grupo> {

    @Override
    Grupo create(Grupo entity, String usuario);

    @Override
    Grupo edit(Grupo entity, String usuario);

    @Override
    Grupo find(Object id);

    @Override
    List<Grupo> findAll();

    @Override
    List<Grupo> findAll(String query, QueryParameter params);

    @Override
    void remove(Grupo entity, String usuario);

}
