package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JTextArea;
import javax.swing.JTextField;


import model.Disciplina;


public class DisciplinaController implements ActionListener  {

	private JTextField tfidDiciplina;
	private JTextField tfnomeDiciplina;
	private JTextField tfDWDiciplina;
	private JTextField tfCHDiciplina;
	private JTextField tfCDCDiciplina;
	private JTextArea taLsitadisciplina;
	
	public DisciplinaController(JTextField tfidDiciplina, JTextField tfnomeDiciplina, JTextField tfDWDiciplina,
			JTextField tfCHDiciplina, JTextField tfCDCDiciplina, JTextArea taLsitadisciplina) {
		super();
		this.tfidDiciplina = tfidDiciplina;
		this.tfnomeDiciplina = tfnomeDiciplina;
		this.tfDWDiciplina = tfDWDiciplina;
		this.tfCHDiciplina = tfCHDiciplina;
		this.tfCDCDiciplina = tfCDCDiciplina;
		this.taLsitadisciplina = taLsitadisciplina;
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
		Disciplina disciplina = new Disciplina();
		disciplina.idDiciplina = tfidDiciplina.getText();
		
		disciplina = buscadisciplina (disciplina);
		if (disciplina.nomeDiciplina != null) {
			taLsitadisciplina.setText("Diciplina - "+disciplina.nomeDiciplina+" - ID: "+disciplina.idDiciplina+" - Dia da Semana: "+disciplina.DWDiciplina+" - Carga horaria: "+disciplina.CHDiciplina+" - Codigo: "+disciplina.CDCDiciplina);
		}else {
			taLsitadisciplina.setText("Diciplina Não Encotrado");
			
		}
	
	}

	private Disciplina buscadisciplina(Disciplina disciplina) throws IOException {
		
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File arq = new File (path,"Disciplina.csv");
		
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetlinha =linha.split(";");
				if (vetlinha[0].equals(disciplina.idDiciplina)) {
					disciplina.nomeDiciplina= vetlinha[1];
					disciplina.DWDiciplina = vetlinha[2];
					disciplina.CHDiciplina = vetlinha[3];
					disciplina.CDCDiciplina = vetlinha[4];
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return disciplina;
		
	}

	private void cadastro() throws IOException {
		Disciplina disciplina = new Disciplina();
		disciplina.idDiciplina    = tfidDiciplina.getText();
		disciplina.nomeDiciplina  = tfnomeDiciplina.getText();  
		disciplina.DWDiciplina    = tfDWDiciplina.getText();    
		disciplina.CHDiciplina    = tfCHDiciplina.getText();    
		disciplina.CDCDiciplina   = tfCDCDiciplina.getText(); 

		
		cadastradisciplina(disciplina.toString());
		tfidDiciplina.setText("");
		tfnomeDiciplina.setText("");
		tfDWDiciplina.setText("");
		tfCHDiciplina.setText("");
		tfCDCDiciplina.setText("");
		
	}

	private void cadastradisciplina(String csvDisciplina) throws IOException  {
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		File arq = new File (path,"Disciplina.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq,existe);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvDisciplina+"\r,\n"); 
		pw.flush();
		pw.close();
		fw.close();
		
		
	}
	
	
	
}
