/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Localidad;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Localidad.class)
public class LocalidadConverter extends ConverterGenerico<Localidad> {

    @Override
    public String getBeanName() {
        return "localidadBean";
    }
}
