package model;

public class Curso {

	public String idcurso;
	public String nomecurso;
	public String areacurso;

	public Curso() {}

	public Curso(String idcurso, String nomecurso, String areacurso) {
		this.idcurso = idcurso;
		this.nomecurso = nomecurso;
		this.areacurso = areacurso;
	}

	// usado para gravar no CSV (sem ; final)
	public String toCSV() {
		return (idcurso == null ? "" : idcurso.trim()) + ";" +
				(nomecurso == null ? "" : nomecurso.trim()) + ";" +
				(areacurso == null ? "" : areacurso.trim());
	}

	// representação para exibir no JTextArea
	@Override
	public String toString() {
		return idcurso + " - " + nomecurso + " - " + areacurso;
	}
}
