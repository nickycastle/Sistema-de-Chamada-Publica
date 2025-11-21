package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Professor;

public class ProfessorController implements ActionListener {
	
	private JTextField tfnomeprof; 
	private JTextField tfCPFprof;
	private JTextField tfpontuacaoprof;
	private JTextField tfareaprof;
	private JTextArea taListaprof;
	
	public ProfessorController(JTextField tfnomeprof, JTextField tfCPFprof, JTextField tfpontuacaoprof,
			JTextField tfareaprof, JTextArea taListaprof) {
		super();
		this.tfnomeprof = tfnomeprof;
		this.tfCPFprof = tfCPFprof;
		this.tfpontuacaoprof = tfpontuacaoprof;
		this.tfareaprof = tfareaprof;
		this.taListaprof = taListaprof;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar")) {
			try {
				cadastro();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("B")) {
			try {
				busca();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	private void busca() throws IOException {
		Professor professor = new Professor();
		professor.CPFprof = tfCPFprof.getText();
		
		professor = buscaprofessor(professor);
		if (professor.nomeprof != null) {
			taListaprof.setText("CPF: "+professor.CPFprof+ " - Nome: "+professor.nomeprof+" - Area de conhecimento:"+professor.areaprof+" - Pontuação:"+professor.pontuacaoprof);
		} else {
			taListaprof.setText("Professor não encontrado");
		}
		
	
	}

	private Professor buscaprofessor(Professor professor) throws IOException {
	    String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
	    File arq = new File(path, "Professor.csv");
	    
	    if (arq.exists() && arq.isFile()) {
	        try (FileInputStream fis = new FileInputStream(arq);
	             InputStreamReader isr = new InputStreamReader(fis);
	             BufferedReader buffer = new BufferedReader(isr)) {
	            
	            String linha;
	            while ((linha = buffer.readLine()) != null) {
	               
	                linha = linha.trim();
	                if (linha.isEmpty() || linha.equals(",")) { 
	                    continue;
	                }
	                
	               
	                if (linha.endsWith(",")) {
	                    linha = linha.substring(0, linha.length() - 1);
	                }
	                
	                String[] vetlinha = linha.split(";");
	                
	               
	                if (vetlinha.length >= 2) {
	                    if (vetlinha[1].equals(professor.CPFprof)) {
	                        professor.nomeprof = vetlinha[0];
	                        professor.areaprof = vetlinha.length > 2 ? vetlinha[2] : "";
	                        professor.pontuacaoprof = vetlinha.length > 3 ? vetlinha[3] : "";
	                        return professor; 
	                    }
	                }
	            }
	        }
	    }
	    
	    
	    professor.nomeprof = null;
	    professor.areaprof = null;
	    professor.pontuacaoprof = null;
	    return professor;
	}

	private void cadastro() throws IOException {
		Professor professor = new Professor();
		professor.nomeprof = tfnomeprof.getText();
		professor.areaprof = tfareaprof.getText();
		professor.CPFprof = tfCPFprof.getText();
		professor.pontuacaoprof = tfpontuacaoprof.getText();
		
		cadastroProfessor(professor.toString());
		
		tfnomeprof.setText("");
		tfareaprof.setText("");
		tfCPFprof.setText("");
		tfpontuacaoprof.setText("");
	}

	private void cadastroProfessor(String csvProfessor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File (path,"Professor.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq,existe);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvProfessor+"\r,\n"); 
		pw.flush();
		pw.close();
		fw.close();
		
	}

	
	
}
