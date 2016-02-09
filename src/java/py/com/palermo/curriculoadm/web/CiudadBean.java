/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Ciudad;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICiudadDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class CiudadBean extends BeanGenerico<Ciudad> implements Serializable {

    @EJB
    private ICiudadDAO ejb;

    @Override
    public AbstractDAO<Ciudad> getEjb() {
        return ejb;
    }

    @Override
    public Ciudad getNuevo() {
        return new Ciudad();
    }

}
