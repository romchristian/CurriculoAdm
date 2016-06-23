/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.sesionbeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import py.com.palermo.curriculoadm.entities.Estudio;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.QueryParameter;

/**
 *
 * @author Acer
 */
@Local
public interface IEstudioDAO extends AbstractDAO<Estudio> {

    @Override
    Estudio create(Estudio entity, String usuario);

    @Override
    Estudio edit(Estudio entity, String usuario);

    @Override
    Estudio find(Object id);

    @Override
    List<Estudio> findAll();

    @Override
    List<Estudio> findAll(String query, QueryParameter params);

    List<Estudio> findAllSinEmpresa();

    List<Estudio> findAllConEmpresa(Empresa empresa);

    @Override
    void remove(Estudio entity, String usuario);

}
