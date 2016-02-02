/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Grupo;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IGrupoDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class GrupoBean extends BeanGenerico<Grupo> implements Serializable{

    @EJB private IGrupoDAO ejb;
    
    
    @Override
    public AbstractDAO<Grupo> getEjb() {
        return ejb;
    }

    @Override
    public Grupo getNuevo() {
        return new Grupo();
    }

    
}
