/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.EstadoNivelAcademico;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IEstadoNivelAcademicoDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class EstadoNivelAcademicoBean extends BeanGenerico<EstadoNivelAcademico> implements Serializable{

    @EJB private IEstadoNivelAcademicoDAO ejb;
    
    
    @Override
    public AbstractDAO<EstadoNivelAcademico> getEjb() {
        return ejb;
    }

    @Override
    public EstadoNivelAcademico getNuevo() {
        return new EstadoNivelAcademico();
    }

    
}
