/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.EstadoCivil;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = EstadoCivil.class)
public class EstadoCivilConverter extends ConverterGenerico<EstadoCivil> {

    @Override
    public String getBeanName() {
        return "estadoCivilBean";
    }
}
