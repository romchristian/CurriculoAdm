/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Localidad;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ILocalidadDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class LocalidadBean extends BeanGenerico<Localidad> implements Serializable {

    @EJB
    private ILocalidadDAO ejb;

    @Override
    public AbstractDAO<Localidad> getEjb() {
        return ejb;
    }

    @Override
    public Localidad getNuevo() {
        return new Localidad();
    }

}
