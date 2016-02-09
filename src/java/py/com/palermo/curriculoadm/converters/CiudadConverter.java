/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Ciudad;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Ciudad.class)
public class CiudadConverter extends ConverterGenerico<Ciudad> {

    @Override
    public String getBeanName() {
        return "ciudadBean";
    }
}
