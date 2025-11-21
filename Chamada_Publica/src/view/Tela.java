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
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


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
		
		JPanel TabDiciplinas = new JPanel();
		tabbedPane.addTab("Disciplinas", null, TabDiciplinas, "Vizaualização de Diciplinas");
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
		
		JLabel lblDisciplinaidCDC = new JLabel("Codigo do curso");
		lblDisciplinaidCDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaidCDC.setBounds(297, 84, 108, 24);
		TabDiciplinas.add(lblDisciplinaidCDC);
		
		tfDisciplinaId = new JTextField();
		tfDisciplinaId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaId.setBounds(124, 50, 108, 28);
		TabDiciplinas.add(tfDisciplinaId);
		tfDisciplinaId.setColumns(10);
		
		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaNome.setBounds(124, 83, 108, 28);
		TabDiciplinas.add(tfDisciplinaNome);
		tfDisciplinaNome.setColumns(10);
		
		tfDisciplinaDW = new JTextField();
		tfDisciplinaDW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaDW.setBounds(124, 116, 108, 28);
		TabDiciplinas.add(tfDisciplinaDW);
		tfDisciplinaDW.setColumns(10);
		
		TfDisciplinasCH = new JTextField();
		TfDisciplinasCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TfDisciplinasCH.setBounds(415, 50, 108, 28);
		TabDiciplinas.add(TfDisciplinasCH);
		TfDisciplinasCH.setColumns(10);
		
		tfDisciplinaCDC = new JTextField();
		tfDisciplinaCDC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDisciplinaCDC.setBounds(415, 85, 108, 28);
		TabDiciplinas.add(tfDisciplinaCDC);
		tfDisciplinaCDC.setColumns(10);
		
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
		
		JPanel TabCurso = new JPanel();
		tabbedPane.addTab("Curso", null, TabCurso, "Vizaulização de Curso");
		TabCurso.setLayout(null);
		
		JLabel lblCursoId = new JLabel("ID");
		lblCursoId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoId.setBounds(0, 60, 45, 13);
		TabCurso.add(lblCursoId);
		
		JLabel lblCursoNome = new JLabel("Nome");
		lblCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoNome.setBounds(0, 104, 45, 13);
		TabCurso.add(lblCursoNome);
		
		JLabel lblCursoArea = new JLabel("Area de Conhecimento");
		lblCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoArea.setBounds(278, 60, 142, 13);
		TabCurso.add(lblCursoArea);
		
		tfCursoID = new JTextField();
		tfCursoID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoID.setBounds(93, 55, 108, 28);
		TabCurso.add(tfCursoID);
		tfCursoID.setColumns(10);
		
		tfCursoNome = new JTextField();
		tfCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoNome.setBounds(93, 93, 108, 28);
		TabCurso.add(tfCursoNome);
		tfCursoNome.setColumns(10);
		
		tfCursoArea = new JTextField();
		tfCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCursoArea.setBounds(443, 55, 108, 28);
		TabCurso.add(tfCursoArea);
		tfCursoArea.setColumns(10);
		
		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCursoCadastrar.setBounds(93, 160, 108, 28);
		TabCurso.add(btnCursoCadastrar);
		
		JButton btnCursoDeleta = new JButton("Deleta");
		btnCursoDeleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCursoDeleta.setBounds(443, 160, 108, 28);
		TabCurso.add(btnCursoDeleta);
		
		JButton btnCursoBuscar = new JButton("B");
		btnCursoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCursoBuscar.setToolTipText("Buscar");
		btnCursoBuscar.setBounds(212, 56, 45, 25);
		TabCurso.add(btnCursoBuscar);
		
		JScrollPane scrollPaneCurso = new JScrollPane();
		scrollPaneCurso.setBounds(10, 208, 601, 188);
		TabCurso.add(scrollPaneCurso);
		
		JTextArea taCursoLista = new JTextArea();
		scrollPaneCurso.setViewportView(taCursoLista);
		
		JPanel TabProfessor = new JPanel();
		tabbedPane.addTab("Professor", null, TabProfessor, "Vizualiza Professor");
		TabProfessor.setLayout(null);
		
		JLabel lblProfessorNome = new JLabel("Nome");
		lblProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorNome.setBounds(0, 60, 45, 13);
		TabProfessor.add(lblProfessorNome);
		
		JLabel lblProfessorCPF = new JLabel("CPF");
		lblProfessorCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorCPF.setBounds(0, 128, 45, 13);
		TabProfessor.add(lblProfessorCPF);
		
		JLabel lblProfessorArea = new JLabel("Area de Conhecimento");
		lblProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorArea.setBounds(270, 60, 142, 13);
		TabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorPontuacao = new JLabel("Pontuação");
		lblProfessorPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorPontuacao.setBounds(270, 128, 72, 13);
		TabProfessor.add(lblProfessorPontuacao);
		
		tfProfessorNome = new JTextField();
		tfProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorNome.setBounds(55, 54, 155, 30);
		TabProfessor.add(tfProfessorNome);
		tfProfessorNome.setColumns(10);
		
		tfProfessorCPF = new JTextField();
		tfProfessorCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorCPF.setBounds(55, 122, 155, 30);
		TabProfessor.add(tfProfessorCPF);
		tfProfessorCPF.setColumns(10);
		
		tfProfessorArea = new JTextField();
		tfProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorArea.setBounds(422, 54, 155, 30);
		TabProfessor.add(tfProfessorArea);
		tfProfessorArea.setColumns(10);
		
		tfProfessorPontuacao = new JTextField();
		tfProfessorPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProfessorPontuacao.setBounds(422, 122, 155, 30);
		TabProfessor.add(tfProfessorPontuacao);
		tfProfessorPontuacao.setColumns(10);
		
		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorCadastrar.setBounds(55, 175, 155, 30);
		TabProfessor.add(btnProfessorCadastrar);
		
		JButton btnProfessorDeleta = new JButton("Deleta");
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
		
		JPanel TabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, TabInscricao, "Vizualizar Inscrição");
		TabInscricao.setLayout(null);
		
		JLabel lblInscricaoCdp = new JLabel("Código do Processo");
		lblInscricaoCdp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCdp.setBounds(0, 60, 125, 24);
		TabInscricao.add(lblInscricaoCdp);
		
		JLabel lblInscricaoCdd = new JLabel("Código da Diciplina ");
		lblInscricaoCdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCdd.setBounds(0, 120, 145, 24);
		TabInscricao.add(lblInscricaoCdd);
		
		JLabel lblInscricaoCPF = new JLabel("CPF do Professor");
		lblInscricaoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCPF.setBounds(345, 60, 125, 24);
		TabInscricao.add(lblInscricaoCPF);
		
		tfInscricaoCdp = new JTextField();
		tfInscricaoCdp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCdp.setBounds(145, 60, 125, 30);
		TabInscricao.add(tfInscricaoCdp);
		tfInscricaoCdp.setColumns(10);
		
		tfInscricaoCdd = new JTextField();
		tfInscricaoCdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCdd.setBounds(145, 120, 125, 30);
		TabInscricao.add(tfInscricaoCdd);
		tfInscricaoCdd.setColumns(10);
		
		tfInscricaoCPF = new JTextField();
		tfInscricaoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfInscricaoCPF.setBounds(465, 60, 125, 30);
		TabInscricao.add(tfInscricaoCPF);
		tfInscricaoCPF.setColumns(10);
		
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
	
		
		DisciplinaController dCont = new DisciplinaController(tfDisciplinaId, tfDisciplinaNome, tfDisciplinaDW, TfDisciplinasCH, tfDisciplinaCDC, taDisciplinaLista);
		CursoController cCont = new CursoController (tfCursoID, tfCursoNome, tfCursoArea, taCursoLista);
		ProfessorController pCont = new ProfessorController(tfProfessorNome, tfProfessorCPF, tfProfessorPontuacao, tfProfessorArea, taProfessorLista);
		InscricaoController iCont = new InscricaoController(tfInscricaoCdp, tfInscricaoCdd, tfInscricaoCPF, taInscricaoLista);
		
		btnDisciplinaCadastrar.addActionListener(dCont);
		btnDisciplinaBuscar.addActionListener(dCont);
		
		
		btnCursoCadastrar.addActionListener(cCont);
		btnCursoBuscar.addActionListener(cCont);
		
		
		btnProfessorCadastrar.addActionListener(pCont);
		btnProfessorBuscar.addActionListener(pCont);
		
		
		btnInscricaoCadastrar.addActionListener(iCont);
		btnInscricaoBuscar.addActionListener(iCont);
		
		
		
	}
}
