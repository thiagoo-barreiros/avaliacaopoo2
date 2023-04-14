package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import Model.Aluno;
import Repository.AlunoRepository;
import Repository.ConexaoBancoDeDados;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class InterfaceGrafica extends JFrame implements ActionListener {

	private JButton botaoInserir;
	private JButton botaoRemover;
	private JButton botaoAlterar;
	private JButton botaoPesquisar;

	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JLabel lblTipoSanguineo;
	private JLabel lblContatoEmergencia;
	private JLabel lblTelefoneEmergencia;
	private JLabel lblCurso;
	private JLabel lblFatorRh;
	private JLabel lblId;
	private JLabel lblResultadoPesquisa;

	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtContatoEmergencia;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtTelefoneEmergencia;
	private JComboBox comboTipoSanguineo;
	private JComboBox comboFatorRh;
	private JComboBox comboCurso;

	private final String[] tipoTipoSanguineo = { "A", "B", "AB", "O" };
	private final String[] tipoFatorRh = { "+", "-" };
	private final String[] tipoCurso = { "Direito", "Ciência da Computação", "Sistemas De Informação", "Medicina",
			"Psicologia", "Nutrição" };

	private JTextArea listaPesquisaBancoDeDados;
	private JScrollPane scrollPesquisaBancoDeDados;

	private Container ctn;

//	private AlunoRepository _alunoRepository ;
//	private Aluno _aluno;

	public InterfaceGrafica() {
		// _conexaoBancoDeDados = conexaoBancoDeDados;
		// _aluno = aluno;
		// _alunoRepository = alunoRepository;

		setSize(900, 900);
		setTitle("Tela Inicial");

		ctn = getContentPane();
		ctn.setLayout(null);

		txtId = new JTextField();
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		txtContatoEmergencia = new JTextField();
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			txtTelefoneEmergencia = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		comboTipoSanguineo = new JComboBox(tipoTipoSanguineo);
		comboFatorRh = new JComboBox(tipoFatorRh);
		comboCurso = new JComboBox(tipoCurso);

		botaoInserir = new JButton("Inserir");
		botaoRemover = new JButton("Remover");
		botaoAlterar = new JButton("Alterar");
		botaoPesquisar = new JButton("Pesquisar");

		lblNome = new JLabel("Nome");
		lblEndereco = new JLabel("Endereco");
		lblTelefone = new JLabel("Telefone");
		lblCpf = new JLabel("CPF");
		lblTipoSanguineo = new JLabel("Tipo Sanguíneo");
		lblContatoEmergencia = new JLabel("Contato de Emergência");
		lblTelefoneEmergencia = new JLabel("Telefone");
		lblCurso = new JLabel("Curso");
		lblFatorRh = new JLabel("Fator RH");
		lblId = new JLabel("ID");
		lblResultadoPesquisa = new JLabel("Resultado da Pesquisa no Banco de Dados");

		listaPesquisaBancoDeDados = new JTextArea();
		scrollPesquisaBancoDeDados = new JScrollPane(listaPesquisaBancoDeDados);

		// COLUNA - LINHA - COMPRIMENTO - ALTURA

		botaoInserir.setBounds(10, 725, 90, 40);
		botaoRemover.setBounds(102, 790, 90, 40);
		botaoAlterar.setBounds(10, 790, 90, 40);
		botaoPesquisar.setBounds(102, 725, 95, 40);

		lblResultadoPesquisa.setBounds(530, 5, 300, 20);
		scrollPesquisaBancoDeDados.setBounds(480, 25, 380, 600);

		lblId.setBounds(200, 790, 90, 40);
		txtId.setBounds(230, 800, 90, 20);

		lblNome.setBounds(1, -5, 95, 40);
		lblEndereco.setBounds(1, 70, 95, 40);
		lblTelefone.setBounds(1, 145, 95, 40);
		lblCpf.setBounds(1, 220, 95, 40);
		lblTipoSanguineo.setBounds(1, 295, 95, 40);
		lblCurso.setBounds(1, 370, 95, 40);
		lblContatoEmergencia.setBounds(1, 445, 133, 40);
		lblTelefoneEmergencia.setBounds(1, 520, 95, 40);
		lblFatorRh.setBounds(300, 295, 95, 40);

		txtNome.setBounds(200, 5, 200, 20);
		txtEndereco.setBounds(200, 80, 200, 20);
		txtTelefone.setBounds(200, 155, 200, 20);
		txtCpf.setBounds(200, 230, 200, 20);
		comboTipoSanguineo.setBounds(200, 305, 95, 20);
		comboFatorRh.setBounds(355, 305, 95, 20);
		comboCurso.setBounds(200, 380, 200, 20);
		txtContatoEmergencia.setBounds(200, 455, 200, 20);
		txtTelefoneEmergencia.setBounds(200, 530, 200, 20);

		// lblid .setBounds(102, 725, 95, 40);
		// lblResultadoPesquisa.setBounds(102, 725, 95, 40);

		ctn.add(botaoInserir);
		ctn.add(botaoRemover);
		ctn.add(botaoAlterar);
		ctn.add(botaoPesquisar);
		ctn.add(lblNome);
		ctn.add(lblEndereco);
		ctn.add(lblTelefone);
		ctn.add(lblCpf);
		ctn.add(lblTipoSanguineo);
		ctn.add(lblCurso);
		ctn.add(lblContatoEmergencia);
		ctn.add(lblTelefoneEmergencia);
		ctn.add(lblFatorRh);
		ctn.add(txtNome);
		ctn.add(txtEndereco);
		ctn.add(txtTelefone);
		ctn.add(txtCpf);
		ctn.add(comboCurso);
		ctn.add(txtContatoEmergencia);
		ctn.add(txtTelefoneEmergencia);
		ctn.add(comboTipoSanguineo);
		ctn.add(comboFatorRh);
		ctn.add(lblId);
		ctn.add(txtId);
		ctn.add(lblResultadoPesquisa);
		ctn.add(scrollPesquisaBancoDeDados);

//limpar o layout para configurar os componentes nos lugares corretos

//Configurar a área ("retângulo") do label e da caixa de texto
		// lbNome.setBounds(0, 0, 100, 25);
		// txtNome.setBounds(150, 0, 200, 25);
		// lblCPF.setBounds(0, 50, 100, 25);
		// txtCPF.setBounds(150, 50, 200, 25);
		// lblTipo.setBounds(0, 100, 200, 25);
		// btnOK.setBounds(150, 150, 100, 100);
		// cmbTipo.setBounds(150, 100, 200, 25);
//Adicionar o Label e a caixa de texto No Container
		// ctn.add(lbNome);
		// ctn.add(txtNome);
		// ctn.add(lblCPF);
		// ctn.add(txtCPF);
		// ctn.add(lblTipo);
		// ctn.add(cmbTipo);
		// ctn.add(btnOK);
		// nesse ponto vamos inserir o tratamento do evento
//		btnOK.addActionListener(this);
//deixar a janela visivel

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		botaoInserir.addActionListener(this);
		botaoRemover.addActionListener(this);
		botaoAlterar.addActionListener(this);
		botaoPesquisar.addActionListener(this);

	}

	private boolean validaCampos() {

		String[] campos = { txtNome.getText(), txtEndereco.getText(), txtContatoEmergencia.getText(),
				txtTelefone.getText(), txtCpf.getText(), txtTelefoneEmergencia.getText(),
				comboTipoSanguineo.getSelectedItem().toString(), comboFatorRh.getSelectedItem().toString(),
				comboCurso.getSelectedItem().toString() };
		boolean camposValidos = false;

		for (int i = 0; i < campos.length; i++) {

			String textoTratado = "";
			textoTratado = campos[i].replace('(', ' ');
			textoTratado = textoTratado.replace(')', ' ');
			textoTratado = textoTratado.replace('-', ' ');
			textoTratado = textoTratado.replace('.', ' ').trim();
			

			//campos[i].length() == 0
			if (textoTratado.length() == 0) {
				camposValidos = false;
				break;
			} else
				camposValidos = true;
		}

		return camposValidos;
	}

	// implementação dos metodos do evento
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Inserir")) {

			Aluno objetoAluno = new Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(),
					txtCpf.getText(), comboTipoSanguineo.getSelectedItem().toString(), txtContatoEmergencia.getText(),
					txtTelefoneEmergencia.getText(), comboCurso.getSelectedItem().toString(),
					comboFatorRh.getSelectedItem().toString());

			try {
				if (validaCampos() == false) {
					JOptionPane.showMessageDialog(this, "Favor Preencher Todos Os Campos!");
				} else {
					ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
					objBancoDeDados.InserirDados(objetoAluno);
					JOptionPane.showMessageDialog(this, "Cadastro Realizado Com Sucesso!");

				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		if (e.getActionCommand().equals("Remover")) {

			Aluno objetoAluno = new Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(),
					txtCpf.getText(), comboTipoSanguineo.getSelectedItem().toString(), txtContatoEmergencia.getText(),
					txtTelefoneEmergencia.getText(), comboCurso.getSelectedItem().toString(),
					comboFatorRh.getSelectedItem().toString());

			try {
				ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
				int id = Integer.parseInt(txtId.getText());
				if (objBancoDeDados.SearchById(id) == null)
					throw null;

				objBancoDeDados.RemoverDados(id);
				JOptionPane.showMessageDialog(this, "Cadastro Removido Com Sucesso!");

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Cadastro Não Encontrado!");
				e2.printStackTrace();
			}

		}

		if (e.getActionCommand().equals("Alterar")) {

			Aluno objetoAluno = new Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(),
					txtCpf.getText(), comboTipoSanguineo.getSelectedItem().toString(), txtContatoEmergencia.getText(),
					txtTelefoneEmergencia.getText(), comboCurso.getSelectedItem().toString(),
					comboFatorRh.getSelectedItem().toString());

			try {
				ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
				int id = Integer.parseInt(txtId.getText());
				if (objBancoDeDados.SearchById(id) == null)
					throw null;

				objBancoDeDados.AlterarDados(objetoAluno, id);
				JOptionPane.showMessageDialog(this, "Cadastro Alterado Com Sucesso!");

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Cadastro Não Encontrado!");
				e2.printStackTrace();
			}

		}

		if (e.getActionCommand().equals("Pesquisar")) {

			try {
				ConexaoBancoDeDados objBancoDeDados = new ConexaoBancoDeDados();
				ArrayList<String> relatorioBancoDeDados = objBancoDeDados.Relatorio();

				listaPesquisaBancoDeDados.setText("");
				for (String texto : relatorioBancoDeDados) {
					listaPesquisaBancoDeDados.append(texto + "\n\n");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}

}
