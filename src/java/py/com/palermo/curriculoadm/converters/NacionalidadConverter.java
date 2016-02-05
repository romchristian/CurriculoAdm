/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Nacionalidad;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Nacionalidad.class)
public class NacionalidadConverter extends ConverterGenerico<Nacionalidad> {

    @Override
    public String getBeanName() {
        return "nacionalidadBean";
    }
}
