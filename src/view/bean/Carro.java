/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author MaryR
 */
@Entity
@Table(name = "carro", catalog = "carro", schema = "")
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c")
    , @NamedQuery(name = "Carro.findById", query = "SELECT c FROM Carro c WHERE c.id = :id")
    , @NamedQuery(name = "Carro.findByPlaca", query = "SELECT c FROM Carro c WHERE c.placa = :placa")
    , @NamedQuery(name = "Carro.findByDataCarro", query = "SELECT c FROM Carro c WHERE c.dataCarro = :dataCarro")
    , @NamedQuery(name = "Carro.findByCor", query = "SELECT c FROM Carro c WHERE c.cor = :cor")
    , @NamedQuery(name = "Carro.findByMarca", query = "SELECT c FROM Carro c WHERE c.marca = :marca")
    , @NamedQuery(name = "Carro.findByModelo", query = "SELECT c FROM Carro c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Carro.findByChassi", query = "SELECT c FROM Carro c WHERE c.chassi = :chassi")
    , @NamedQuery(name = "Carro.findByProprietario", query = "SELECT c FROM Carro c WHERE c.proprietario = :proprietario")
    , @NamedQuery(name = "Carro.findByDataCompra", query = "SELECT c FROM Carro c WHERE c.dataCompra = :dataCompra")})
public class Carro implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "placa")
    private String placa;
    @Column(name = "dataCarro")
    @Temporal(TemporalType.DATE)
    private Date dataCarro;
    @Column(name = "cor")
    private String cor;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "chassi")
    private String chassi;
    @Column(name = "proprietario")
    private String proprietario;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        String oldPlaca = this.placa;
        this.placa = placa;
        changeSupport.firePropertyChange("placa", oldPlaca, placa);
    }

    public Date getDataCarro() {
        return dataCarro;
    }

    public void setDataCarro(Date dataCarro) {
        Date oldDataCarro = this.dataCarro;
        this.dataCarro = dataCarro;
        changeSupport.firePropertyChange("dataCarro", oldDataCarro, dataCarro);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        String oldCor = this.cor;
        this.cor = cor;
        changeSupport.firePropertyChange("cor", oldCor, cor);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        String oldChassi = this.chassi;
        this.chassi = chassi;
        changeSupport.firePropertyChange("chassi", oldChassi, chassi);
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        String oldProprietario = this.proprietario;
        this.proprietario = proprietario;
        changeSupport.firePropertyChange("proprietario", oldProprietario, proprietario);
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        Date oldDataCompra = this.dataCompra;
        this.dataCompra = dataCompra;
        changeSupport.firePropertyChange("dataCompra", oldDataCompra, dataCompra);
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
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.bean.Carro[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
