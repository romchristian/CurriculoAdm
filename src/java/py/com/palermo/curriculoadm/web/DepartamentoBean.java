/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Departamento;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IDepartamentoDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class DepartamentoBean extends BeanGenerico<Departamento> implements Serializable{

    @EJB private IDepartamentoDAO ejb;
    
    
    @Override
    public AbstractDAO<Departamento> getEjb() {
        return ejb;
    }

    @Override
    public Departamento getNuevo() {
        return new Departamento();
    }

    
}
