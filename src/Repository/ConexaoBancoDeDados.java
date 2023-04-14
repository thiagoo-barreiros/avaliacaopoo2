package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoBancoDeDados {

	public Connection conexao;
	private String URL_Bancodedados;
	private String usuario;
	private String senha;

	public ConexaoBancoDeDados() {

		URL_Bancodedados = "jdbc:mysql://localhost:3306/avaliacao1";
		usuario = "root";
		senha = "admin";

	}

	public void IniciarConexao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL_Bancodedados, usuario, senha);
			System.out.println("Conexao realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao acessar o Banco de Dados!");
		}
	}

	public void EncerrarConexao() throws SQLException {

		if (conexao != null)
			conexao.close();

	}

	public Connection getConexao() {
		return conexao;
	}

	public String InserirDados(Aluno ObjetoAluno) throws SQLException {

		IniciarConexao();

		if (conexao != null) {

			PreparedStatement psInsert = conexao.prepareStatement(
					"INSERT INTO aluno(nome,endereco,Telefone,cpf,tiposanguineo,contatoemergencia,telefoneemergencia,curso,fatorrh) VALUES (?,?,?,?,?,?,?,?,?)");
			psInsert.setString(1, ObjetoAluno.getNome());
			psInsert.setString(2, ObjetoAluno.getEndereco());
			psInsert.setString(3, ObjetoAluno.getTelefone());
			psInsert.setString(4, ObjetoAluno.getCpf());
			psInsert.setString(5, ObjetoAluno.getTiposanguineo());
			psInsert.setString(6, ObjetoAluno.getContatoemergencia());
			psInsert.setString(7, ObjetoAluno.getTelefoneemergencia());
			psInsert.setString(8, ObjetoAluno.getCurso());
			psInsert.setString(9, ObjetoAluno.getFatorRh());
			psInsert.execute();

			EncerrarConexao();

			return "Cadastro Realizado Com Sucesso!";

		} else
			return "Erro! Inserção não realizada";

	}

	public String AlterarDados(Aluno ObjetoAluno, int id) throws SQLException {

		IniciarConexao();

		if (conexao != null) {

			PreparedStatement comandoUpdate = conexao.prepareStatement(
					"UPDATE aluno SET nome = ?,endereco = ?,Telefone = ?,cpf = ?,tiposanguineo = ?,contatoemergencia = ?,telefoneemergencia = ?,curso = ?, fatorrh = ? WHERE id = ?");
			comandoUpdate.setString(1, ObjetoAluno.getNome());
			comandoUpdate.setString(2, ObjetoAluno.getEndereco());
			comandoUpdate.setString(3, ObjetoAluno.getTelefone());
			comandoUpdate.setString(4, ObjetoAluno.getCpf());
			comandoUpdate.setString(5, ObjetoAluno.getTiposanguineo());
			comandoUpdate.setString(6, ObjetoAluno.getContatoemergencia());
			comandoUpdate.setString(7, ObjetoAluno.getTelefoneemergencia());
			comandoUpdate.setString(8, ObjetoAluno.getCurso());
			comandoUpdate.setString(9, ObjetoAluno.getFatorRh());
			comandoUpdate.setInt(10, id);
			comandoUpdate.execute();

			EncerrarConexao();

			return "Alteração Realizada Com Sucesso!";
		} else
			return "Erro! Alteração Não Realizada!";
	}

	public String RemoverDados(int id) throws SQLException {

		IniciarConexao();

		if (conexao != null) {

			PreparedStatement comandoUpdate = conexao.prepareStatement("DELETE FROM aluno WHERE id= ?");
			comandoUpdate.setInt(1, id);
			comandoUpdate.execute();

			EncerrarConexao();

			return "Remoção Realizada com Sucesso!";
		} else
			return "Erro! Alteração Não Realizada!";

	}

	public ArrayList<String> Relatorio() throws SQLException {

		IniciarConexao();

		ArrayList<String> relatorioBancoDeDados = new ArrayList<String>();

		if (conexao != null) {

			Statement comandoConsulta = conexao.createStatement();
			ResultSet resultadoConsultaBD = comandoConsulta.executeQuery("SELECT * FROM aluno");

			String resultado;
			String id;
			String nome;
			String endereco;
			String Telefone;
			String cpf;
			String tiposanguineo;
			String contatoemergencia;
			String telefoneemergencia;
			String curso;
			String fatorRh;
			while (resultadoConsultaBD.next()) {

				id = resultadoConsultaBD.getString("id");
				nome = resultadoConsultaBD.getString("nome");
				endereco = resultadoConsultaBD.getString("endereco");
				Telefone = resultadoConsultaBD.getString("Telefone");
				cpf = resultadoConsultaBD.getString("cpf");
				tiposanguineo = resultadoConsultaBD.getString("tiposanguineo");
				contatoemergencia = resultadoConsultaBD.getString("contatoemergencia");
				telefoneemergencia = resultadoConsultaBD.getString("telefoneemergencia");
				curso = resultadoConsultaBD.getString("curso");
				fatorRh = resultadoConsultaBD.getString("fatorRh");

				resultado = "# ID: " + id + "\nNome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + Telefone
						+ "\nCPF: " + cpf + "\nTipo Sanguineo: " + tiposanguineo + fatorRh + "\nCurso: " + curso
						+ "\nContato Emergencial: " + contatoemergencia + "\nTelefone: " + telefoneemergencia;

				relatorioBancoDeDados.add(resultado);

			}

			EncerrarConexao();
			return relatorioBancoDeDados;

		}

		return null;

	}

	public Aluno SearchById(int id) throws SQLException {

		IniciarConexao();

		
		if (conexao != null) {

			PreparedStatement searchById = conexao.prepareStatement("SELECT * FROM aluno where id = ?");
			searchById.setInt(1, id);
			searchById.execute();

			EncerrarConexao();

			return (Aluno) searchById;
		}
		return (Aluno) SearchById(0);
	

	}

}
