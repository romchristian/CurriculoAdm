/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import py.com.palermo.curriculoadm.entities.Area;
import py.com.palermo.curriculoadm.entities.Curriculo;
import py.com.palermo.curriculoadm.entities.Empresa;
import py.com.palermo.curriculoadm.entities.EstadoCivil;
import py.com.palermo.curriculoadm.entities.EstadoNivelAcademico;
import py.com.palermo.curriculoadm.entities.Nacionalidad;
import py.com.palermo.curriculoadm.entities.NivelAcademico;
import py.com.palermo.curriculoadm.entities.Sexo;
import py.com.palermo.curriculoadm.entities.TipoDocumento;
import py.com.palermo.curriculoadm.sesionbeans.interfaces.ICurriculoDAO;

/**
 *
 * @author christian.romero
 */
@Named
@SessionScoped
public class CurriculoFilter implements Serializable {

    @EJB
    private ICurriculoDAO dao;

    //actual seleccionado
    private Curriculo actual;

    //Filtros
    private Integer rangoEdad1 = 20;
    private Integer rangoEdad2 = 35;

    private NivelAcademico nivelAcademico;
    private EstadoNivelAcademico estadoNivelAcademico;
    private EstadoCivil estadoCivil;

    private Nacionalidad nacionalidad;
    private String sexo;
    private Empresa empresa;
    private Area area;
    private TipoDocumento tipoDocumento;

    private String tieneHijos;
    private String nombre;

    //Resultado
    private List<Curriculo> resultado;

    //Getter y Setter
    public Curriculo getActual() {
        return actual;
    }

    public void setActual(Curriculo actual) {
        this.actual = actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRangoEdad1() {
        return rangoEdad1;
    }

    public void setRangoEdad1(Integer rangoEdad1) {
        this.rangoEdad1 = rangoEdad1;
    }

    public Integer getRangoEdad2() {
        return rangoEdad2;
    }

    public void setRangoEdad2(Integer rangoEdad2) {
        this.rangoEdad2 = rangoEdad2;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public EstadoNivelAcademico getEstadoNivelAcademico() {
        return estadoNivelAcademico;
    }

    public void setEstadoNivelAcademico(EstadoNivelAcademico estadoNivelAcademico) {
        this.estadoNivelAcademico = estadoNivelAcademico;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(String tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<Curriculo> getResultado() {
        return resultado;
    }

    public void setResultado(List<Curriculo> resultado) {
        this.resultado = resultado;
    }

    private String filtroNombre() {
        String R = "";
        if (nombre != null && nombre.length() > 0) {
            R = " AND nombres like '%" + nombre + "%' ";
        }

        return R;
    }

    //Métodos para el filtro
    private String filtroEdad() {
        String R = "";
        if (rangoEdad1 != null && rangoEdad2 != null) {
            R = " AND date_part('year',age(fechanacimiento)) between " + rangoEdad1 + " and " + rangoEdad2 + " ";
        }

        return R;
    }

    private String filtroEstadoCivil() {
        String R = "";
        if (estadoCivil != null) {
            R = " AND estadocivil_id = " + estadoCivil.getId() + " ";
        }

        return R;
    }

    private String filtroEmpresa() {
        String R = "";
        if (empresa != null) {
            R = " AND empresa_id = " + empresa.getId() + " ";
        }

        return R;
    }

    private String filtroArea() {
        String R = "";
        if (area != null) {
            R = " AND area_id = " + area.getId() + " ";
        }

        return R;
    }

    private String filtroNivelAcademico() {
        String R = "";
        if (nivelAcademico != null) {
            R = " AND nivelacademico_id = " + nivelAcademico.getId() + " ";
        }

        return R;
    }

    private String filtroEstadoNivelAcademico() {
        String R = "";
        if (estadoNivelAcademico != null) {
            R = " AND estadonivelacademico_id = " + estadoNivelAcademico.getId() + " ";
        }

        return R;
    }

    private String filtroNacionalidad() {
        String R = "";
        if (nacionalidad != null) {
            R = " AND nacionalidad_id = " + nacionalidad.getId() + " ";
        }

        return R;
    }

    private String filtroSexo() {
        String R = "";
        if (sexo != null && sexo.length() > 0) {
            R = " AND sexo = '" + sexo + "' ";
        }

        return R;
    }

    private String filtroTieneHijos() {
        String R = "";
        if (tieneHijos != null) {
            switch (tieneHijos) {
                case "CON HIJOS":
                    R = " AND cantidadHijos > 0 ";
                    break;
                case "SIN HIJOS":
                    R = " AND (cantidadHijos = 0  OR cantidadHijos is null) ";
                    break;
            }
        }
        return R;
    }

    private String construyeFiltro() {
        StringBuilder sb = new StringBuilder(" WHERE 1 = 1 ");
        sb.append(filtroNombre());
        sb.append(filtroEdad());
        sb.append(filtroArea());
        sb.append(filtroEmpresa());
        sb.append(filtroEstadoCivil());
        sb.append(filtroNivelAcademico());
        sb.append(filtroEstadoNivelAcademico());
        sb.append(filtroNacionalidad());
        sb.append(filtroTieneHijos());
        sb.append(filtroSexo());

        return sb.toString();
    }

    public void busca() {
        resultado = dao.findAllFilter(construyeFiltro());
    }

}
