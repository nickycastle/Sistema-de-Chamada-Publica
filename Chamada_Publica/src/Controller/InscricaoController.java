package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Inscricao;


public class InscricaoController implements ActionListener {

	private JTextField tfcdpinsc;
	private JTextField tfcddinsc;
	private JTextField tfcpfinsc;
	private JTextArea taListainsc;
	
	
	public InscricaoController(JTextField tfcdpinsc, JTextField tfcddinsc, JTextField tfcpfinsc,
			JTextArea taListainsc) {
		super();
		this.tfcdpinsc = tfcdpinsc;
		this.tfcddinsc = tfcddinsc;
		this.tfcpfinsc = tfcpfinsc;
		this.taListainsc = taListainsc;
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
				buscar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}


	private void buscar() throws IOException {
		Inscricao inscricao = new Inscricao();
		inscricao.cdpinsc = tfcdpinsc.getText();
		inscricao = buscainscricao(inscricao);
		
		if (inscricao.cdpinsc != null) {
			taListainsc.setText("Processo: "+inscricao.cdpinsc+" - Inscricão: "+inscricao.cddinsc+" - CPF: "+inscricao.cpfinsc);
		} else {
			taListainsc.setText("Inscricão não encontrada");
		}
		
		
	}


	private Inscricao buscainscricao(Inscricao inscricao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File arq = new File (path,"Isncricao.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetlinha =linha.split(";");
				if (vetlinha[0].equals(inscricao.cdpinsc)) {
					inscricao.cddinsc = vetlinha[1];
					inscricao.cpfinsc = vetlinha[2];
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
			}
		return inscricao;
	}


	private void cadastro() throws IOException {
	Inscricao inscricao = new Inscricao();
	inscricao.cddinsc = tfcddinsc.getText();
	inscricao.cdpinsc = tfcdpinsc.getText();
	inscricao.cpfinsc = tfcpfinsc.getText();
	
	cadastraincricao(inscricao.toString());
	tfcddinsc.setText("");
	tfcdpinsc.setText("");
	tfcpfinsc.setText("");
		
	}


	private void cadastraincricao(String csvInscricao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		File arq = new File (path,"Isncricao.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq,existe);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvInscricao+"\r,\n"); 
		pw.flush();
		pw.close();
		fw.close();
	}
	
	
	
	
	
}
