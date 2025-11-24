package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

import model.Disciplina;

public class DisciplinaController implements ActionListener {

    private final JTextField tfId;
    private final JTextField tfNome;
    private final JTextField tfDiaSemana;
    private final JTextField tfCargaHoraria;
    private final JTextField tfCodigo;
    private final JTextArea taLista;

    private final String dirPath = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
    private final File arquivo = new File(dirPath, "Disciplina.csv");

    public DisciplinaController(JTextField tfId, JTextField tfNome, JTextField tfDiaSemana,
                                JTextField tfCargaHoraria, JTextField tfCodigo, JTextArea taLista) {

        this.tfId = tfId;
        this.tfNome = tfNome;
        this.tfDiaSemana = tfDiaSemana;
        this.tfCargaHoraria = tfCargaHoraria;
        this.tfCodigo = tfCodigo;
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
                case "Deletar": remover(); break;
                case "Listar": listarViaFila(); break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de I/O: " + ex.getMessage());
        }
    }

    // ---------------------------------------------------------
    private void garantirDiretorio() {
        File d = new File(dirPath);
        if (!d.exists()) d.mkdir();
    }

    // ---------------------------------------------------------
    // ------------  C A D A S T R A R -------------------------
    // ---------------------------------------------------------
    private void cadastrar() throws IOException {

        String id = tfId.getText().trim();
        String nome = tfNome.getText().trim();
        String dia = tfDiaSemana.getText().trim();
        String ch = tfCargaHoraria.getText().trim();
        String codigo = tfCodigo.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID é obrigatório.");
            return;
        }

        garantirDiretorio();

        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, true))) {
            Disciplina d = new Disciplina(id, nome, dia, ch, codigo);
            pw.println(d.toCSV());
        }

        limparCampos();

        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
    }

    // ---------------------------------------------------------
    // ------------  C A R R E G A R  F I L A ------------------
    // ---------------------------------------------------------
    private Queue<Disciplina> carregarFila() throws IOException {
        Queue<Disciplina> fila = new LinkedList<>();

        if (!arquivo.exists()) return fila;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {

                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] v = linha.split(";");

                if (v.length < 5) continue; // evita erro

                Disciplina d = new Disciplina(
                        v[0].trim(),
                        v[1].trim(),
                        v[2].trim(),
                        v[3].trim(),
                        v[4].trim()
                );

                fila.add(d);
            }
        }
        return fila;
    }

    // ---------------------------------------------------------
    // ---------------------- BUSCAR ---------------------------
    // ---------------------------------------------------------
    private void buscar() throws IOException {

        String id = tfId.getText().trim();
        String nome = tfNome.getText().trim();
        String dia = tfDiaSemana.getText().trim();
        String codigo = tfCodigo.getText().trim();

        if (id.isEmpty() && nome.isEmpty() && dia.isEmpty() && codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha pelo menos um campo para buscar.");
            return;
        }

        Queue<Disciplina> fila = carregarFila();
        boolean achou = false;

        while (!fila.isEmpty()) {
            Disciplina d = fila.poll();

            if ((!id.isEmpty() && d.idDiciplina.equals(id)) ||
                (!nome.isEmpty() && d.nomeDiciplina.equalsIgnoreCase(nome)) ||
                (!dia.isEmpty() && d.DWDiciplina.equalsIgnoreCase(dia)) ||
                (!codigo.isEmpty() && d.CDCDiciplina.equalsIgnoreCase(codigo))) {

                preencherCampos(d);
                taLista.setText(d.toString());
                achou = true;
                break;
            }
        }

        if (!achou) {
            taLista.setText("Nenhuma disciplina encontrada.");
        }
    }

    private void preencherCampos(Disciplina d) {
        tfId.setText(d.idDiciplina);
        tfNome.setText(d.nomeDiciplina);
        tfDiaSemana.setText(d.DWDiciplina);
        tfCargaHoraria.setText(d.CHDiciplina);
        tfCodigo.setText(d.CDCDiciplina);
    }

    // ---------------------------------------------------------
    // --------- CARREGAR LISTA (LinkedList p/ CRUD) -----------
    // ---------------------------------------------------------
    private LinkedList<Disciplina> carregarLista() throws IOException {
        LinkedList<Disciplina> lista = new LinkedList<>();

        if (!arquivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {

                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] v = linha.split(";");
                if (v.length < 5) continue;

                lista.add(new Disciplina(
                        v[0].trim(),
                        v[1].trim(),
                        v[2].trim(),
                        v[3].trim(),
                        v[4].trim()
                ));
            }
        }
        return lista;
    }

    private void salvarLista(LinkedList<Disciplina> lista) throws IOException {

        garantirDiretorio();

        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, false))) {
            for (Disciplina d : lista) {
                pw.println(d.toCSV());
            }
        }
    }

    // ---------------------------------------------------------
    // -------------------- ATUALIZAR --------------------------
    // ---------------------------------------------------------
    private void atualizar() throws IOException {

        String id = tfId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um ID para atualizar.");
            return;
        }

        LinkedList<Disciplina> lista = carregarLista();
        boolean achou = false;

        for (Disciplina d : lista) {
            if (d.idDiciplina.equals(id)) {
                d.nomeDiciplina = tfNome.getText().trim();
                d.DWDiciplina = tfDiaSemana.getText().trim();
                d.CHDiciplina = tfCargaHoraria.getText().trim();
                d.CDCDiciplina = tfCodigo.getText().trim();
                achou = true;
                break;
            }
        }

        if (!achou) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!");
            return;
        }

        salvarLista(lista);

        JOptionPane.showMessageDialog(null, "Disciplina atualizada!");
        listarViaFila();
    }

    // ---------------------------------------------------------
    // --------------------- REMOVER ---------------------------
    // ---------------------------------------------------------
    private void remover() throws IOException {

        String id = tfId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o ID para remover.");
            return;
        }

        LinkedList<Disciplina> lista = carregarLista();

        boolean removido = lista.removeIf(d -> d.idDiciplina.equals(id));

        if (!removido) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!");
            return;
        }

        salvarLista(lista);
        limparCampos();
        JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso!");

        listarViaFila();
    }

    // ---------------------------------------------------------
    // ------------------- LISTAR FILA -------------------------
    // ---------------------------------------------------------
    private void listarViaFila() throws IOException {

        Queue<Disciplina> fila = carregarFila();
        StringBuilder sb = new StringBuilder("Disciplinas:\n");

        while (!fila.isEmpty()) {
            sb.append(fila.poll().toString()).append("\n");
        }

        taLista.setText(sb.toString());
    }

    // ---------------------------------------------------------
    private void limparCampos() {
        tfId.setText("");
        tfNome.setText("");
        tfDiaSemana.setText("");
        tfCargaHoraria.setText("");
        tfCodigo.setText("");
    }
}
