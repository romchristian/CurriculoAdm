/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Experiencia;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Experiencia.class)
public class ExperienciaConverter extends ConverterGenerico<Experiencia> {

    @Override
    public String getBeanName() {
        return "experienciaBean";
    }
}
