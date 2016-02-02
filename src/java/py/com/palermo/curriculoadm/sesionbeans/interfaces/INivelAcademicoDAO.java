/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.NivelAcademico;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface INivelAcademicoDAO extends AbstractDAO<NivelAcademico> {

    @Override
    NivelAcademico create(NivelAcademico entity, String usuario);

    @Override
    NivelAcademico edit(NivelAcademico entity, String usuario);

    @Override
    NivelAcademico find(Object id);

    @Override
    List<NivelAcademico> findAll();

    @Override
    List<NivelAcademico> findAll(String query, QueryParameter params);

    @Override
    void remove(NivelAcademico entity, String usuario);

}
