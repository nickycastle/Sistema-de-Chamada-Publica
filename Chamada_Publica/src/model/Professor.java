package model;

public class Professor {
	
	public String nomeprof;
	public String CPFprof;
	public String pontuacaoprof;
	public String areaprof;
	
	
	@Override
	public String toString() {
		return nomeprof + ";" + CPFprof + ";" + pontuacaoprof + ";" + areaprof;
	}
	
	

}
