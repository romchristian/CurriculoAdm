/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Grupo;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Grupo.class)
public class GrupoConverter extends ConverterGenerico<Grupo> {

    @Override
    public String getBeanName() {
        return "grupoBean";
    }
}
