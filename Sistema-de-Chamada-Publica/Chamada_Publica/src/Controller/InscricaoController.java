package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Inscricao;

public class InscricaoController implements ActionListener {

    private JTextField tfcdpinsc;
    private JTextField tfcddinsc;
    private JTextField tfcpfinsc;
    private JTextArea taListainsc;

    private final File arquivo;

    public InscricaoController(JTextField tfcdpinsc, JTextField tfcddinsc,
                               JTextField tfcpfinsc, JTextArea taListainsc) {

        this.tfcdpinsc = tfcdpinsc;
        this.tfcddinsc = tfcddinsc;
        this.tfcpfinsc = tfcpfinsc;
        this.taListainsc = taListainsc;

        String path = System.getProperty("user.home") + File.separator + "Sistema Cadastro";
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();

        arquivo = new File(path, "Inscricao.csv");
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ============================================================
    // CADASTRAR
    // ============================================================

    private void cadastrar() throws IOException {

        Inscricao i = new Inscricao();
        i.cdpinsc = tfcdpinsc.getText();
        i.cddinsc = tfcddinsc.getText();
        i.cpfinsc = tfcpfinsc.getText();

        FileWriter fw = new FileWriter(arquivo, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(i.toString());  // sem vírgulas!
        pw.close();

        tfcdpinsc.setText("");
        tfcddinsc.setText("");
        tfcpfinsc.setText("");

        taListainsc.setText("Inscrição cadastrada!");
    }

    // ============================================================
    // BUSCAR (fila)
    // ============================================================

    private void buscar() throws IOException {

        Queue<Inscricao> fila = carregarFila();

        String codigoBusca = tfcdpinsc.getText();
        boolean achou = false;

        for (Inscricao i : fila) {
            if (i.cdpinsc.equals(codigoBusca)) {
                taListainsc.setText(
                    "Processo: " + i.cdpinsc +
                    " | Disciplina: " + i.cddinsc +
                    " | CPF: " + i.cpfinsc
                );
                achou = true;
                break;
            }
        }

        if (!achou) {
            taListainsc.setText("Inscrição não encontrada.");
        }
    }

    private Queue<Inscricao> carregarFila() throws IOException {

        Queue<Inscricao> fila = new LinkedList<>();

        if (!arquivo.exists()) return fila;

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = br.readLine()) != null) {

            if (linha.trim().isEmpty()) continue;

            String[] v = linha.split(";");

            // evita erro de índice
            if (v.length < 3) continue;

            Inscricao i = new Inscricao();
            i.cdpinsc = v[0];
            i.cddinsc = v[1];
            i.cpfinsc = v[2];

            fila.add(i);
        }

        br.close();
        return fila;
    }

    // ============================================================
    // DELETAR
    // ============================================================

    private void deletar() throws IOException {

        if (!arquivo.exists()) {
            taListainsc.setText("Nenhuma inscrição cadastrada.");
            return;
        }

        String cod = tfcdpinsc.getText();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        boolean achou = false;

        while ((linha = br.readLine()) != null) {

            if (linha.trim().isEmpty()) continue;

            String[] v = linha.split(";");

            if (!v[0].equals(cod)) {
                sb.append(linha).append("\n");
            } else {
                achou = true;
            }
        }
        br.close();

        FileWriter fw = new FileWriter(arquivo, false); // reescreve tudo
        fw.write(sb.toString());
        fw.close();

        if (achou)
            taListainsc.setText("Inscrição removida!");
        else
            taListainsc.setText("Inscrição não encontrada.");
    }
}
