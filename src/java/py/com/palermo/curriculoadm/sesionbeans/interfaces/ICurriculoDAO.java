/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Curriculo;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.entities.EstadoCurriculo;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface ICurriculoDAO extends AbstractDAO<Curriculo> {

    @Override
    Curriculo create(Curriculo entity, String usuario);

    @Override
    Curriculo edit(Curriculo entity, String usuario);

    @Override
    Curriculo find(Object id);

    @Override
    List<Curriculo> findAll();

    @Override
    List<Curriculo> findAll(String query, QueryParameter params);

    @Override
    void remove(Curriculo entity, String usuario);

    List<Curriculo> findAllFilter(String filter);

    Long countEstado(EstadoCurriculo estado);
}
