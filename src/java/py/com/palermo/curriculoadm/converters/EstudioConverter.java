/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Estudio;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Estudio.class)
public class EstudioConverter extends ConverterGenerico<Estudio> {

    @Override
    public String getBeanName() {
        return "estudioBean";
    }
}
