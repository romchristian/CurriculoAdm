/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Grupo;
import py.com.palermo.curriculoadm.entities.Usuario;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.generico.Credencial;
import py.com.palermo.curriculoadm.generico.JsfUtil;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.IUsuarioDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class UsuarioBean extends BeanGenerico<Usuario> implements Serializable {

    @Inject
    private Credencial credencial;

    @EJB
    private IUsuarioDAO ejb;
    private String password1;
    private String password2;
    private List<Grupo> grupos;

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public AbstractDAO<Usuario> getEjb() {
        return ejb;
    }

    @Override
    public Usuario getNuevo() {
        return new Usuario();
    }

    @Override
    public String create() {
        if (ejb.find(getActual().getUsername()) != null) {
            JsfUtil.addErrorMessage("El usuario ya existe!");
            return null;
        }

        System.out.println("Pass 1 :" + password1);
        System.out.println("Pass 2 :" + password2);

        if (password1 == null || password2 == null || password1.compareTo(password2) != 0) {
            JsfUtil.addErrorMessage("No coinciden los passwords!");
            return null;
        }

        getActual().setPassword(password1);

        return super.create(); //To change body of generated methods, choose Tools | Templates.
    }

    public String cambiarClave() {
        if (password1 == null || password2 == null || password1.compareTo(password2) != 0) {
            JsfUtil.addErrorMessage("No coinciden los passwords!");
            return null;
        }

        setActual(credencial.getUsuario());
        getActual().setPassword(password1);
        edit();
        JsfUtil.addSuccessMessage("Se actualizó correctamente!");
        return "/main/curriculo/listado";
    }
}
