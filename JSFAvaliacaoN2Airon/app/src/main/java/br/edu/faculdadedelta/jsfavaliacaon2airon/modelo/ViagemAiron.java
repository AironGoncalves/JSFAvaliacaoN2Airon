package br.edu.faculdadedelta.jsfavaliacaon2airon.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ViagemAiron implements Serializable {

    private Long id;
    private String motorista;
    private String categoria;
    private String destino;
    private String distancia;
    private double valorKm;
    private Date dataCorrida;

    public ViagemAiron() {
    }

    public ViagemAiron(Long id, String motorista, String categoria, String destino, String distancia, double valorKm, Date dataCorrida) {
        this.id = id;
        this.motorista = motorista;
        this.categoria = categoria;
        this.destino = destino;
        this.distancia = distancia;
        this.valorKm = valorKm;
        this.dataCorrida = dataCorrida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public double getValorKm() {
        return valorKm;
    }

    public void setValorKm(double valorKm) {
        this.valorKm = valorKm;
    }

    public Date getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(Date dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViagemAiron that = (ViagemAiron) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
