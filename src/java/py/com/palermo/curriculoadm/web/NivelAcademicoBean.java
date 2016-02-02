/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.NivelAcademico;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.INivelAcademicoDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class NivelAcademicoBean extends BeanGenerico<NivelAcademico> implements Serializable{

    @EJB private INivelAcademicoDAO ejb;
    
    
    @Override
    public AbstractDAO<NivelAcademico> getEjb() {
        return ejb;
    }

    @Override
    public NivelAcademico getNuevo() {
        return new NivelAcademico();
    }

    
}
