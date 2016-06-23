/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Estudio;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEstudioDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class EstudioBean extends BeanGenerico<Estudio> implements Serializable {

    @EJB
    private IEstudioDAO ejb;

    @Override
    public AbstractDAO<Estudio> getEjb() {
        return ejb;
    }

    @Override
    public Estudio getNuevo() {
        return new Estudio();
    }

}
