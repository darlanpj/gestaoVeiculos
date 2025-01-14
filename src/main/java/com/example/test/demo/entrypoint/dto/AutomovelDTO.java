package com.example.test.demo.entrypoint.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class AutomovelDTO {

    private String marca;
    private String modelo;
    private BigDecimal valor;

    private LocalDate dataCadastro;

    public AutomovelDTO() {

    }

    public AutomovelDTO(String marca, String modelo, BigDecimal valor, LocalDate dataCadastro) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "AutomovelDTO{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", valor=" + valor +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
}
