/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.generico.ConverterGenerico;

/**
 *
 * @author christian
 */
@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter extends ConverterGenerico<Empresa> {

    @Override
    public String getBeanName() {
        return "empresaBean";
    }
}
