/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Departamento;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IDepartamentoDAO extends AbstractDAO<Departamento> {

    @Override
    Departamento create(Departamento entity, String usuario);

    @Override
    Departamento edit(Departamento entity, String usuario);

    @Override
    Departamento find(Object id);

    @Override
    List<Departamento> findAll();

    @Override
    List<Departamento> findAll(String query, QueryParameter params);

    @Override
    void remove(Departamento entity, String usuario);

}
