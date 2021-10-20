package tiroconarco.harold.tesisporyecto;

import java.io.Serializable;

public class DatosRonda implements Serializable {

    private Integer id;
    private String nombreArquero;
    private String nombreClub;
    private String nombreRonda;
    private String fecha;
    private Integer tipoRonda;
    private Integer tipoArco;

    public DatosRonda() {

    }

    public DatosRonda(Integer id, String nombreArquero, String nombreClub, String nombreRonda, String fecha, Integer tipoRonda, Integer tipoArco) {
        this.id = id;
        this.nombreArquero = nombreArquero;
        this.nombreClub = nombreClub;
        this.nombreRonda = nombreRonda;
        this.fecha = fecha;
        this.tipoRonda = tipoRonda;
        this.tipoArco = tipoArco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreArquero() {
        return nombreArquero;
    }

    public void setNombreArquero(String nombreArquero) {
        this.nombreArquero = nombreArquero;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public String getNombreRonda() {
        return nombreRonda;
    }

    public void setNombreRonda(String nombreRonda) {
        this.nombreRonda = nombreRonda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getTipoRonda() {
        return tipoRonda;
    }

    public void setTipoRonda(Integer tipoRonda) {
        this.tipoRonda = tipoRonda;
    }

    public Integer getTipoArco() {
        return tipoArco;
    }

    public void setTipoArco(Integer tipoArco) {
        this.tipoArco = tipoArco;
    }

}

