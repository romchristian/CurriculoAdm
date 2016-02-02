/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.curriculoadm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import py.com.palermo.curriculoadm.generico.Auditable;

/**
 *
 * @author christian.romero
 */
@Entity
public class Curriculo implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    @ManyToOne
    private TipoDocumento tipoDocumento;
    private String documento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    @ManyToOne
    private EstadoCivil estadoCivil;
    private boolean tieneHijos;
    private Integer cantidadHijos;
    private String direccion;
    private String telefonos;
    private String email;

    @ManyToOne
    private Area area;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private NivelAcademico nivelAcademico;
    @ManyToOne
    private EstadoNivelAcademico estadoNivelAcademico;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReferenciaLaboral> referenciasLaborales;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReferenciaPersonal> refereciasPersonales;

    @Enumerated(EnumType.STRING)
    private EstadoCurriculo estadoCurriculo;

    @OneToMany(mappedBy = "curriculo")
    private List<Comentario> comentarios;

    private Integer rating;
    private String adjunto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(boolean tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    public Integer getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(Integer cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public List<ReferenciaLaboral> getReferenciasLaborales() {
        return referenciasLaborales;
    }

    public void setReferenciasLaborales(List<ReferenciaLaboral> referenciasLaborales) {
        this.referenciasLaborales = referenciasLaborales;
    }

    public List<ReferenciaPersonal> getRefereciasPersonales() {
        return refereciasPersonales;
    }

    public void setRefereciasPersonales(List<ReferenciaPersonal> refereciasPersonales) {
        this.refereciasPersonales = refereciasPersonales;
    }

    public EstadoCurriculo getEstadoCurriculo() {
        return estadoCurriculo;
    }

    public void setEstadoCurriculo(EstadoCurriculo estadoCurriculo) {
        this.estadoCurriculo = estadoCurriculo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curriculo)) {
            return false;
        }
        Curriculo other = (Curriculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.curriculoadm.entities.Curriculo[ id=" + id + " ]";
    }

}