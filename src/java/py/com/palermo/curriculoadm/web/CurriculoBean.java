/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Curriculo;
import py.com.palermo.curriculoadm.generico.AbstractDAO;
import py.com.palermo.curriculoadm.generico.BeanGenerico;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICurriculoDAO;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class CurriculoBean extends BeanGenerico<Curriculo> implements Serializable {

    @EJB
    private ICurriculoDAO ejb;
    private String diaNac;
    private String mesNac;
    private String anioNac;

    @Override
    public AbstractDAO<Curriculo> getEjb() {
        return ejb;
    }

    @Override
    public Curriculo getNuevo() {
        return new Curriculo();
    }

    public String getDiaNac() {
        return diaNac;
    }

    public void setDiaNac(String diaNac) {
        this.diaNac = diaNac;
    }

    public String getMesNac() {
        return mesNac;
    }

    public void setMesNac(String mesNac) {
        this.mesNac = mesNac;
    }

    public String getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(String anioNac) {
        this.anioNac = anioNac;
    }

    public SelectItem[] getSelectItemsDias() {
        SelectItem[] items = new SelectItem[32];
        items[0] = new SelectItem("", "--");
        for (int i = 1; i < 32; i++) {
            items[i] = new SelectItem("" + i, "" + i);
        }
        return items;
    }

    public SelectItem[] getSelectItemsAnios() {
        SelectItem[] items = new SelectItem[41];
        items[0] = new SelectItem("", "--");
        for (int i = 1960; i < 2000; i++) {
            items[i] = new SelectItem("" + i, "" + i);
        }
        return items;
    }

    public SelectItem[] getSelectItemsMes() {
        SelectItem[] items = new SelectItem[13];
        items[0] = new SelectItem("", "--");
        items[1] = new SelectItem("Enero", "Enero");
        items[2] = new SelectItem("Febrero", "Febrero");
        items[3] = new SelectItem("Marzo", "Marzo");
        items[4] = new SelectItem("Abril", "Abril");
        items[5] = new SelectItem("Mayo", "Mayo");
        items[6] = new SelectItem("Junio", "Junio");
        items[7] = new SelectItem("Julio", "Julio");
        items[8] = new SelectItem("Agosto", "Agosto");
        items[9] = new SelectItem("Septiembre", "Septiembre");
        items[10] = new SelectItem("Octubre", "Octubre");
        items[11] = new SelectItem("Noviembre", "Noviembre");
        items[12] = new SelectItem("Diciembre", "Diciembre");

        return items;
    }

}
