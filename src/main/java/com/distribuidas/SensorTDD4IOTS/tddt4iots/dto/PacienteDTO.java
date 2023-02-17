package com.distribuidas.SensorTDD4IOTS.tddt4iots.dto;

public class PacienteDTO {
    private String id;
    private String altura;
    private String peso;
    private String gruposanguineo;
    private String audio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGruposanguineo() {
        return gruposanguineo;
    }

    public void setGruposanguineo(String gruposanguineo) {
        this.gruposanguineo = gruposanguineo;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) { this.audio = audio; }
}
