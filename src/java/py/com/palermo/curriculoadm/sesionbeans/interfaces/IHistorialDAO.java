/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Historial;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IHistorialDAO extends AbstractDAO<Historial> {

    @Override
    Historial create(Historial entity, String usuario);

    @Override
    Historial edit(Historial entity, String usuario);

    @Override
    Historial find(Object id);

    @Override
    List<Historial> findAll();

    @Override
    List<Historial> findAll(String query, QueryParameter params);

    @Override
    void remove(Historial entity, String usuario);

}
