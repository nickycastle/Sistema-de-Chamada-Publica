package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Curso;

public class CursoController implements ActionListener {
	
	private JTextField tfidcurso;
	private JTextField tfnomecurso;
	private JTextField tfareacurso;
	private JTextArea  taCursoLista;
	
	public CursoController(JTextField tfidcurso, JTextField tfnomecurso, JTextField tfareacurso,
			JTextArea taCursoLista) {
		super();
		this.tfidcurso = tfidcurso;
		this.tfnomecurso = tfnomecurso;
		this.tfareacurso = tfareacurso;
		this.taCursoLista = taCursoLista;
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

	private void cadastro() throws IOException {
		Curso curso = new Curso();
		curso.idcurso   = tfidcurso.getText(); 
		curso.nomecurso = tfnomecurso.getText();
		curso.areacurso = tfareacurso.getText();
		
		cadastracurso(curso.toString());
		tfidcurso.setText("");
		tfnomecurso.setText("");
		tfareacurso.setText("");
	}

	private void cadastracurso(String csvCurso) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		File arq = new File (path,"Curso.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq,existe);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvCurso+"\r,\n"); 
		pw.flush();
		pw.close();
		fw.close();
		
		
	}

	private void busca() throws IOException {
		Curso curso = new Curso();
		curso.idcurso   = tfidcurso.getText(); 
		
		curso = buscacurso(curso);
		if (curso.nomecurso != null) {
			taCursoLista.setText("Curso: "+curso.nomecurso+" - ID: "+curso.idcurso+" - Area de Conhecimento: "+curso.areacurso);
		} else {
			taCursoLista.setText("Curso não Encontrado");
		}
	}

	private Curso buscacurso(Curso curso) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File arq = new File (path,"Curso.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetlinha =linha.split(";");
			if (vetlinha[0].equals(curso.idcurso)) {
				curso.nomecurso = vetlinha[1];
				curso.areacurso = vetlinha[2];
					}
			
				linha = buffer.readLine();
				}
			buffer.close();
			isr.close();
			fis.close();	
		}
		return curso;
	}
	
	
	

}
