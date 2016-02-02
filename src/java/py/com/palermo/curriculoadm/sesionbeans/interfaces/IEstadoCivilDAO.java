/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.EstadoCivil;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IEstadoCivilDAO extends AbstractDAO<EstadoCivil> {

    @Override
    EstadoCivil create(EstadoCivil entity, String usuario);

    @Override
    EstadoCivil edit(EstadoCivil entity, String usuario);

    @Override
    EstadoCivil find(Object id);

    @Override
    List<EstadoCivil> findAll();

    @Override
    List<EstadoCivil> findAll(String query, QueryParameter params);

    @Override
    void remove(EstadoCivil entity, String usuario);

}
