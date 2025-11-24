package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

import model.Curso;

public class CursoController implements ActionListener {

	private final JTextField tfId;
	private final JTextField tfNome;
	private final JTextField tfArea;
	private final JTextArea taLista;

	private final String dirPath = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
	private final File arquivo = new File(dirPath, "Curso.csv");

	public CursoController(JTextField tfId, JTextField tfNome, JTextField tfArea, JTextArea taLista) {
		this.tfId = tfId;
		this.tfNome = tfNome;
		this.tfArea = tfArea;
		this.taLista = taLista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		try {
			switch (cmd) {
				case "Cadastrar": cadastrar(); break;
				case "Buscar":
				case "B": buscar(); break;
				case "Atualizar": atualizar(); break;
				case "Remover": remover(); break;
				case "Listar": listarViaFila(); break;
				default: break;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro de I/O: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ----------------- helpers -----------------
	private void garantirDiretorio() {
		File d = new File(dirPath);
		if (!d.exists()) d.mkdir();
	}

	// ----------------- CADASTRAR -----------------
	private void cadastrar() throws IOException {
		String id = tfId.getText().trim();
		String nome = tfNome.getText().trim();
		String area = tfArea.getText().trim();

		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ID do curso é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		garantirDiretorio();
		try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, true))) {
			Curso c = new Curso(id, nome, area);
			pw.println(c.toCSV());
		}

		limparCampos();
		JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
	}

	// ----------------- BUSCAR (usa fila para percorrer) -----------------
	private Queue<Curso> carregarFila() throws IOException {
		Queue<Curso> fila = new java.util.LinkedList<>();
		if (!arquivo.exists()) return fila;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				if (linha.trim().isEmpty()) continue;
				String[] v = linha.split(";");
				String id = v.length >= 1 ? v[0].trim() : "";
				String nome = v.length >= 2 ? v[1].trim() : "";
				String area = v.length >= 3 ? v[2].trim() : "";
				fila.add(new Curso(id, nome, area));
			}
		}
		return fila;
	}

	private void buscar() throws IOException {
		String id = tfId.getText().trim();
		String nome = tfNome.getText().trim();
		String area = tfArea.getText().trim();

		if (id.isEmpty() && nome.isEmpty() && area.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha um campo para buscar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		Queue<Curso> fila = carregarFila();
		boolean achou = false;
		while (!fila.isEmpty()) {
			Curso c = fila.poll();
			if ((!id.isEmpty() && c.idcurso.equals(id)) ||
					(!nome.isEmpty() && c.nomecurso.equalsIgnoreCase(nome)) ||
					(!area.isEmpty() && c.areacurso.equalsIgnoreCase(area))) {

				tfId.setText(c.idcurso);
				tfNome.setText(c.nomecurso);
				tfArea.setText(c.areacurso);
				taLista.setText(c.toString());
				achou = true;
				break;
			}
		}

		if (!achou) {
			taLista.setText("Nenhum curso encontrado.");
		}
	}

	// ----------------- ATUALIZAR (LinkedList) -----------------
	private LinkedList<Curso> carregarLista() throws IOException {
		LinkedList<Curso> lista = new LinkedList<>();
		if (!arquivo.exists()) return lista;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				if (linha.trim().isEmpty()) continue;
				String[] v = linha.split(";");
				String id = v.length >= 1 ? v[0].trim() : "";
				String nome = v.length >= 2 ? v[1].trim() : "";
				String area = v.length >= 3 ? v[2].trim() : "";
				lista.add(new Curso(id, nome, area));
			}
		}
		return lista;
	}

	private void salvarLista(LinkedList<Curso> lista) throws IOException {
		garantirDiretorio();
		try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, false))) {
			for (Curso c : lista) {
				pw.println(c.toCSV());
			}
		}
	}

	private void atualizar() throws IOException {
		String id = tfId.getText().trim();
		if (id.isEmpty()) { JOptionPane.showMessageDialog(null, "Informe o ID do curso para atualizar!"); return; }

		LinkedList<Curso> lista = carregarLista();
		boolean achou = false;
		for (Curso c : lista) {
			if (c.idcurso.equals(id)) {
				String novoNome = tfNome.getText().trim();
				String novaArea = tfArea.getText().trim();
				if (!novoNome.isEmpty()) c.nomecurso = novoNome;
				if (!novaArea.isEmpty()) c.areacurso = novaArea;
				achou = true;
				break;
			}
		}

		if (!achou) {
			JOptionPane.showMessageDialog(null, "Curso não encontrado!");
			return;
		}

		salvarLista(lista);
		JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
		listarViaFila();
	}

	// ----------------- REMOVER (LinkedList) -----------------
	private void remover() throws IOException {
		String id = tfId.getText().trim();
		if (id.isEmpty()) { JOptionPane.showMessageDialog(null, "Informe o ID do curso para remover!"); return; }

		LinkedList<Curso> lista = carregarLista();
		boolean removido = lista.removeIf(c -> c.idcurso.equals(id));

		if (!removido) {
			JOptionPane.showMessageDialog(null, "Curso não encontrado!");
			return;
		}

		salvarLista(lista);
		JOptionPane.showMessageDialog(null, "Curso removido com sucesso!");
		limparCampos();
		listarViaFila();
	}

	// ----------------- LISTAR (FILA) -----------------
	private void listarViaFila() throws IOException {
		Queue<Curso> fila = carregarFila();
		StringBuilder sb = new StringBuilder("Cursos (fila):\n");
		while (!fila.isEmpty()) {
			sb.append(fila.poll().toString()).append("\n");
		}
		taLista.setText(sb.toString());
	}

	private void limparCampos() {
		tfId.setText("");
		tfNome.setText("");
		tfArea.setText("");
	}
}
