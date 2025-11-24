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

    private final File arquivo;

    public ProfessorController(JTextField tfnomeprof, JTextField tfCPFprof, JTextField tfpontuacaoprof,
                               JTextField tfareaprof, JTextArea taListaprof) {

        this.tfnomeprof = tfnomeprof;
        this.tfCPFprof = tfCPFprof;
        this.tfpontuacaoprof = tfpontuacaoprof;
        this.tfareaprof = tfareaprof;
        this.taListaprof = taListaprof;

        String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();

        arquivo = new File(dir, "Professor.csv");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case "Cadastrar":
                    cadastrar();
                    break;

                case "B":
                    buscar();
                    break;

                case "Deletar":
                    deletar();
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // ============================================================
    // CADASTRAR
    // ============================================================
    private void cadastrar() throws IOException {
        Professor p = new Professor();
        p.nomeprof = tfnomeprof.getText();
        p.CPFprof = tfCPFprof.getText();
        p.pontuacaoprof = tfpontuacaoprof.getText();
        p.areaprof = tfareaprof.getText();

        try (FileWriter fw = new FileWriter(arquivo, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(p.toString());
        }

        limparCampos();
    }

    // ============================================================
    // BUSCAR PELO CPF
    // ============================================================
    private void buscar() throws IOException {

        String cpf = tfCPFprof.getText();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                if (dados[1].equals(cpf)) {
                    taListaprof.setText(
                        "Nome: " + dados[0] +
                        " | CPF: " + dados[1] +
                        " | Pontuação: " + dados[2] +
                        " | Área: " + dados[3]
                    );
                    return;
                }
            }
        }

        taListaprof.setText("Professor não encontrado!");
    }

    // ============================================================
    // DELETAR
    // ============================================================
    private void deletar() throws IOException {

        String cpf = tfCPFprof.getText();
        File temp = new File(arquivo.getParent(), "Professor_temp.csv");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             PrintWriter pw = new PrintWriter(new FileWriter(temp))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                if (dados[1].equals(cpf)) {
                    encontrado = true;
                    continue; // NÃO COPIA ESTA LINHA
                }

                pw.println(linha);
            }
        }

        arquivo.delete();
        temp.renameTo(arquivo);

        if (encontrado)
            taListaprof.setText("Professor removido com sucesso!");
        else
            taListaprof.setText("Professor não encontrado para deletar.");
    }

    // ============================================================
    private void limparCampos() {
        tfnomeprof.setText("");
        tfCPFprof.setText("");
        tfpontuacaoprof.setText("");
        tfareaprof.setText("");
    }
}
