package tiroconarco.harold.tesisporyecto;

public class CheckDia {

    private Integer id;
    private String numeroDia;
    private String checkDia;

    public CheckDia() {
    }

    public CheckDia(Integer id, String numeroDia, String checkDia) {
        this.id = id;
        this.numeroDia = numeroDia;
        this.checkDia = checkDia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(String numeroDia) {
        this.numeroDia = numeroDia;
    }

    public String getCheckDia() {
        return checkDia;
    }

    public void setCheckDia(String checkDia) {
        this.checkDia = checkDia;
    }
}
