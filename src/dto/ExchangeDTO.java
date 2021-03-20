package dto;

public class ExchangeDTO {
    private String numCode;
    private String charCode;
    private String nominal;
    private String name;
    private String value;
    private String date;

    public ExchangeDTO(String numCode, String charCode, String nominal, String name, String value, String date) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return nominal + " Российских рублей = " + value + " " + name + " на " + date;
    }
}
