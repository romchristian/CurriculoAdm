/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Ciudad;
import py.com.palermo.curriculoadm.entities.Departamento;
import py.com.palermo.curriculoadm.entities.Localidad;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface ILocalidadDAO extends AbstractDAO<Localidad> {

    @Override
    Localidad create(Localidad entity, String usuario);

    @Override
    Localidad edit(Localidad entity, String usuario);

    @Override
    Localidad find(Object id);

    @Override
    List<Localidad> findAll();

    @Override
    List<Localidad> findAll(String query, QueryParameter params);

    List<Localidad> findAllActivePorDepartamento(Departamento d);

    @Override
    void remove(Localidad entity, String usuario);

}
