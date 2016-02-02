/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.EstadoNivelAcademico;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IEstadoNivelAcademicoDAO extends AbstractDAO<EstadoNivelAcademico> {

    @Override
    EstadoNivelAcademico create(EstadoNivelAcademico entity, String usuario);

    @Override
    EstadoNivelAcademico edit(EstadoNivelAcademico entity, String usuario);

    @Override
    EstadoNivelAcademico find(Object id);

    @Override
    List<EstadoNivelAcademico> findAll();

    @Override
    List<EstadoNivelAcademico> findAll(String query, QueryParameter params);

    @Override
    void remove(EstadoNivelAcademico entity, String usuario);

}
