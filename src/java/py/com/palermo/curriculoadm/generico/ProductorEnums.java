/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.generico;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Estado;
import py.com.palermo.curriculoadm.entities.EstadoCurriculo;
import py.com.palermo.curriculoadm.entities.Sexo;

/**
 *
 * @author christian
 */
@Named
@ApplicationScoped
public class ProductorEnums implements Serializable {

    public SelectItem[] obtEstados() {
        SelectItem[] R = new SelectItem[Estado.values().length];
        Estado[] lista = Estado.values();
        for (int i = 0; i < lista.length; i++) {
            Estado e = lista[i];
            R[i] = new SelectItem(e, e.toString());
        }
        return R;
    }

    public SelectItem[] obtEstadosCurriculo() {
        SelectItem[] R = new SelectItem[EstadoCurriculo.values().length];
        EstadoCurriculo[] lista = EstadoCurriculo.values();
        for (int i = 0; i < lista.length; i++) {
            EstadoCurriculo e = lista[i];
            R[i] = new SelectItem(e, e.toString());
        }
        return R;
    }
    
    
    public SelectItem[] obtSexo() {
        SelectItem[] R = new SelectItem[Sexo.values().length];
        Sexo[] lista = Sexo.values();
        for (int i = 0; i < lista.length; i++) {
            Sexo e = lista[i];
            R[i] = new SelectItem(e, e.toString());
        }
        return R;
    }

}
