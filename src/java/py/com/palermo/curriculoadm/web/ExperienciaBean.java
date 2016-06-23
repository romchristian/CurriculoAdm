/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Experiencia;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IExperienciaDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ExperienciaBean extends BeanGenerico<Experiencia> implements Serializable{

    @EJB private IExperienciaDAO ejb;
    
    
    @Override
    public AbstractDAO<Experiencia> getEjb() {
        return ejb;
    }

    @Override
    public Experiencia getNuevo() {
        return new Experiencia();
    }

    
}
