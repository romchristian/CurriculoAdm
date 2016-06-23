/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Experiencia;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IExperienciaDAO extends AbstractDAO<Experiencia> {

    @Override
    Experiencia create(Experiencia entity, String usuario);

    @Override
    Experiencia edit(Experiencia entity, String usuario);

    @Override
    Experiencia find(Object id);

    @Override
    List<Experiencia> findAll();

    @Override
    List<Experiencia> findAll(String query, QueryParameter params);

    List<Experiencia> findAllSinEmpresa();

    List<Experiencia> findAllConEmpresa(Empresa empresa);

    @Override
    void remove(Experiencia entity, String usuario);

}
