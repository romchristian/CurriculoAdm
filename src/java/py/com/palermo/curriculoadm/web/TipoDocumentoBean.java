/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;


import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.TipoDocumento;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ITipoDocumentoDAO;



/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class TipoDocumentoBean extends BeanGenerico<TipoDocumento> implements Serializable{

    @EJB private ITipoDocumentoDAO ejb;
    
    
    @Override
    public AbstractDAO<TipoDocumento> getEjb() {
        return ejb;
    }

    @Override
    public TipoDocumento getNuevo() {
        return new TipoDocumento();
    }

    
}
