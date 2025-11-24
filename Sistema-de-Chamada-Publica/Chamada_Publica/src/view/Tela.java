package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CursoController;
import Controller.DisciplinaController;
import Controller.InscricaoController;
import Controller.ProfessorController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField tfDisciplinaId;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDW;
	private JTextField TfDisciplinasCH;
	private JTextField tfDisciplinaCDC;

	private JTextField tfCursoID;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;

	private JTextField tfProfessorNome;
	private JTextField tfProfessorCPF;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontuacao;

	private JTextField tfInscricaoCdp;
	private JTextField tfInscricaoCdd;
	private JTextField tfInscricaoCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Tela frame = new Tela();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Sistema de Contratação");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 626, 433);
		contentPane.add(tabbedPane);

		//----------------------------------------------------------------------
		// TAB DISCIPLINAS
		//----------------------------------------------------------------------
		JPanel TabDiciplinas = new JPanel();
		tabbedPane.addTab("Disciplinas", null, TabDiciplinas, "Visualização de Disciplinas");
		TabDiciplinas.setLayout(null);

		JLabel lblDisciplinaId = new JLabel("ID");
		lblDisciplinaId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaId.setBounds(0, 51, 25, 24);
		TabDiciplinas.add(lblDisciplinaId);

		JLabel lblDisciplinaNome = new JLabel("Nome");
		lblDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaNome.setBounds(0, 90, 45, 13);
		TabDiciplinas.add(lblDisciplinaNome);

		JLabel lblDisciplinaDW = new JLabel("Dia da Semana");
		lblDisciplinaDW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaDW.setBounds(0, 121, 102, 13);
		TabDiciplinas.add(lblDisciplinaDW);

		JLabel lblDisciplinaCH = new JLabel("Carga Horária");
		lblDisciplinaCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaCH.setBounds(297, 51, 86, 24);
		TabDiciplinas.add(lblDisciplinaCH);

		JLabel lblDisciplinaidCDC = new JLabel("Código do curso");
		lblDisciplinaidCDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaidCDC.setBounds(297, 84, 108, 24);
		TabDiciplinas.add(lblDisciplinaidCDC);

		tfDisciplinaId = new JTextField();
		tfDisciplinaId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaId.setBounds(124, 50, 108, 28);
		TabDiciplinas.add(tfDisciplinaId);

		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaNome.setBounds(124, 83, 108, 28);
		TabDiciplinas.add(tfDisciplinaNome);

		tfDisciplinaDW = new JTextField();
		tfDisciplinaDW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaDW.setBounds(124, 116, 108, 28);
		TabDiciplinas.add(tfDisciplinaDW);

		TfDisciplinasCH = new JTextField();
		TfDisciplinasCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TfDisciplinasCH.setBounds(415, 50, 108, 28);
		TabDiciplinas.add(TfDisciplinasCH);

		tfDisciplinaCDC = new JTextField();
		tfDisciplinaCDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaCDC.setBounds(415, 85, 108, 28);
		TabDiciplinas.add(tfDisciplinaCDC);

		JButton btnDisciplinaCadastrar = new JButton("Cadastrar");
		btnDisciplinaCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDisciplinaCadastrar.setBounds(124, 165, 108, 28);
		TabDiciplinas.add(btnDisciplinaCadastrar);

		JButton btnDisciplinaDel = new JButton("Deletar");
		btnDisciplinaDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDisciplinaDel.setBounds(415, 165, 108, 28);
		TabDiciplinas.add(btnDisciplinaDel);

		JButton btnDisciplinaBuscar = new JButton("B");
		btnDisciplinaBuscar.setToolTipText("Buscar");
		btnDisciplinaBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDisciplinaBuscar.setBounds(242, 51, 45, 21);
		TabDiciplinas.add(btnDisciplinaBuscar);

		JScrollPane scrollPaneDisciplina = new JScrollPane();
		scrollPaneDisciplina.setBounds(10, 210, 601, 186);
		TabDiciplinas.add(scrollPaneDisciplina);

		JTextArea taDisciplinaLista = new JTextArea();
		scrollPaneDisciplina.setViewportView(taDisciplinaLista);

		//----------------------------------------------------------------------
		// TAB CURSO
		//----------------------------------------------------------------------
		JPanel TabCurso = new JPanel();
		tabbedPane.addTab("Curso", null, TabCurso, "Visualização de Curso");
		TabCurso.setLayout(null);

		JLabel lblCursoId = new JLabel("ID");
		lblCursoId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoId.setBounds(0, 60, 45, 13);
		TabCurso.add(lblCursoId);

		tfCursoID = new JTextField();
		tfCursoID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoID.setBounds(93, 55, 108, 28);
		TabCurso.add(tfCursoID);

		JLabel lblCursoNome = new JLabel("Nome");
		lblCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoNome.setBounds(0, 104, 45, 13);
		TabCurso.add(lblCursoNome);

		tfCursoNome = new JTextField();
		tfCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoNome.setBounds(93, 93, 108, 28);
		TabCurso.add(tfCursoNome);

		JLabel lblCursoArea = new JLabel("Área de Conhecimento");
		lblCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoArea.setBounds(278, 60, 142, 13);
		TabCurso.add(lblCursoArea);

		tfCursoArea = new JTextField();
		tfCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoArea.setBounds(443, 55, 108, 28);
		TabCurso.add(tfCursoArea);

		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCursoCadastrar.setBounds(93, 160, 108, 28);
		TabCurso.add(btnCursoCadastrar);

		JButton btnCursoDeleta = new JButton("Remover");
		btnCursoDeleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCursoDeleta.setBounds(443, 160, 108, 28);
		TabCurso.add(btnCursoDeleta);

		JButton btnCursoBuscar = new JButton("B");
		btnCursoBuscar.setToolTipText("Buscar");
		btnCursoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCursoBuscar.setBounds(212, 56, 45, 25);
		TabCurso.add(btnCursoBuscar);

		JScrollPane scrollPaneCurso = new JScrollPane();
		scrollPaneCurso.setBounds(10, 208, 601, 188);
		TabCurso.add(scrollPaneCurso);

		JTextArea taCursoLista = new JTextArea();
		scrollPaneCurso.setViewportView(taCursoLista);

		//----------------------------------------------------------------------
		// TAB PROFESSOR
		//----------------------------------------------------------------------
		JPanel TabProfessor = new JPanel();
		tabbedPane.addTab("Professor", null, TabProfessor, "Visualização Professor");
		TabProfessor.setLayout(null);

		JLabel lblProfessorNome = new JLabel("Nome");
		lblProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorNome.setBounds(0, 60, 45, 13);
		TabProfessor.add(lblProfessorNome);

		tfProfessorNome = new JTextField();
		tfProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorNome.setBounds(55, 54, 155, 30);
		TabProfessor.add(tfProfessorNome);

		JLabel lblProfessorCPF = new JLabel("CPF");
		lblProfessorCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorCPF.setBounds(0, 128, 45, 13);
		TabProfessor.add(lblProfessorCPF);

		tfProfessorCPF = new JTextField();
		tfProfessorCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorCPF.setBounds(55, 122, 155, 30);
		TabProfessor.add(tfProfessorCPF);

		JLabel lblProfessorArea = new JLabel("Área de Conhecimento");
		lblProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorArea.setBounds(270, 60, 142, 13);
		TabProfessor.add(lblProfessorArea);

		tfProfessorArea = new JTextField();
		tfProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorArea.setBounds(422, 54, 155, 30);
		TabProfessor.add(tfProfessorArea);

		JLabel lblProfessorPontuacao = new JLabel("Pontuação");
		lblProfessorPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorPontuacao.setBounds(270, 128, 72, 13);
		TabProfessor.add(lblProfessorPontuacao);

		tfProfessorPontuacao = new JTextField();
		tfProfessorPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorPontuacao.setBounds(422, 122, 155, 30);
		TabProfessor.add(tfProfessorPontuacao);

		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorCadastrar.setBounds(55, 175, 155, 30);
		TabProfessor.add(btnProfessorCadastrar);

		JButton btnProfessorDeleta = new JButton("Deletar");
		btnProfessorDeleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorDeleta.setBounds(422, 175, 155, 30);
		TabProfessor.add(btnProfessorDeleta);

		JButton btnProfessorBuscar = new JButton("B");
		btnProfessorBuscar.setToolTipText("Buscar");
		btnProfessorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorBuscar.setBounds(215, 122, 45, 30);
		TabProfessor.add(btnProfessorBuscar);

		JScrollPane scrollPaneProfessor = new JScrollPane();
		scrollPaneProfessor.setBounds(10, 229, 601, 167);
		TabProfessor.add(scrollPaneProfessor);

		JTextArea taProfessorLista = new JTextArea();
		scrollPaneProfessor.setViewportView(taProfessorLista);

		//----------------------------------------------------------------------
		// TAB INSCRIÇÃO
		//----------------------------------------------------------------------
		JPanel TabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, TabInscricao, "Visualizar Inscrição");
		TabInscricao.setLayout(null);

		JLabel lblInscricaoCdp = new JLabel("Código do Processo");
		lblInscricaoCdp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCdp.setBounds(0, 60, 125, 24);
		TabInscricao.add(lblInscricaoCdp);

		tfInscricaoCdp = new JTextField();
		tfInscricaoCdp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCdp.setBounds(145, 60, 125, 30);
		TabInscricao.add(tfInscricaoCdp);

		JLabel lblInscricaoCdd = new JLabel("Código da Disciplina");
		lblInscricaoCdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCdd.setBounds(0, 120, 145, 24);
		TabInscricao.add(lblInscricaoCdd);

		tfInscricaoCdd = new JTextField();
		tfInscricaoCdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCdd.setBounds(145, 120, 125, 30);
		TabInscricao.add(tfInscricaoCdd);

		JLabel lblInscricaoCPF = new JLabel("CPF do Professor");
		lblInscricaoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCPF.setBounds(345, 60, 125, 24);
		TabInscricao.add(lblInscricaoCPF);

		tfInscricaoCPF = new JTextField();
		tfInscricaoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCPF.setBounds(465, 60, 125, 30);
		TabInscricao.add(tfInscricaoCPF);

		JButton btnInscricaoCadastrar = new JButton("Cadastrar");
		btnInscricaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInscricaoCadastrar.setBounds(145, 170, 125, 30);
		TabInscricao.add(btnInscricaoCadastrar);

		JButton btnInscricaoDeleta = new JButton("Deletar");
		btnInscricaoDeleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInscricaoDeleta.setBounds(465, 170, 125, 30);
		TabInscricao.add(btnInscricaoDeleta);

		JButton btnInscricaoBuscar = new JButton("B");
		btnInscricaoBuscar.setToolTipText("Buscar");
		btnInscricaoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInscricaoBuscar.setBounds(273, 60, 45, 30);
		TabInscricao.add(btnInscricaoBuscar);

		JScrollPane scrollPaneInscricao = new JScrollPane();
		scrollPaneInscricao.setBounds(10, 225, 601, 171);
		TabInscricao.add(scrollPaneInscricao);

		JTextArea taInscricaoLista = new JTextArea();
		scrollPaneInscricao.setViewportView(taInscricaoLista);

		//----------------------------------------------------------------------
		// CONTROLLERS — CRIAR ANTES DOS ACTIONLISTENERS
		//----------------------------------------------------------------------

		DisciplinaController dCont = new DisciplinaController(
				tfDisciplinaId, tfDisciplinaNome, tfDisciplinaDW,
				TfDisciplinasCH, tfDisciplinaCDC, taDisciplinaLista
		);

		CursoController cCont = new CursoController(
				tfCursoID, tfCursoNome, tfCursoArea, taCursoLista
		);

		ProfessorController pCont = new ProfessorController(
				tfProfessorNome, tfProfessorCPF, tfProfessorPontuacao,
				tfProfessorArea, taProfessorLista
		);

		InscricaoController iCont = new InscricaoController(
				tfInscricaoCdp, tfInscricaoCdd, tfInscricaoCPF, taInscricaoLista
		);

		//----------------------------------------------------------------------
		// ACTION LISTENERS
		//----------------------------------------------------------------------
		btnDisciplinaCadastrar.addActionListener(dCont);
		btnDisciplinaBuscar.addActionListener(dCont);
		btnDisciplinaDel.addActionListener(dCont);

		btnCursoCadastrar.addActionListener(cCont);
		btnCursoBuscar.addActionListener(cCont);
		btnCursoDeleta.addActionListener(cCont);

		btnProfessorCadastrar.addActionListener(pCont);
		btnProfessorBuscar.addActionListener(pCont);
		btnProfessorDeleta.addActionListener(pCont);

		btnInscricaoCadastrar.addActionListener(iCont);
		btnInscricaoBuscar.addActionListener(iCont);
		btnInscricaoDeleta.addActionListener(iCont);
	}
}
