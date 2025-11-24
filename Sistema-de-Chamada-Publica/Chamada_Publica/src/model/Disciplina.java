package model;

public class Disciplina {

    public String idDiciplina;
    public String nomeDiciplina;
    public String DWDiciplina;
    public String CHDiciplina;
    public String CDCDiciplina;

    public Disciplina() {}

    public Disciplina(String id, String nome, String dw, String ch, String cdc) {
        this.idDiciplina = id;
        this.nomeDiciplina = nome;
        this.DWDiciplina = dw;
        this.CHDiciplina = ch;
        this.CDCDiciplina = cdc;
    }

    public String toCSV() {
        return idDiciplina + ";" + nomeDiciplina + ";" + DWDiciplina + ";" + CHDiciplina + ";" + CDCDiciplina;
    }

    @Override
    public String toString() {
        return "ID: " + idDiciplina +
                " | Nome: " + nomeDiciplina +
                " | Dia Semana: " + DWDiciplina +
                " | CH: " + CHDiciplina +
                " | Código: " + CDCDiciplina;
    }
}
