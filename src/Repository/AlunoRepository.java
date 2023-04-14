package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AlunoRepository {
	
	private ConexaoBancoDeDados _conexaoBancoDeDados;
	
	public AlunoRepository(ConexaoBancoDeDados conexaoBancoDeDados) {
		_conexaoBancoDeDados = conexaoBancoDeDados;
		
	}
	
	public String InserirDados(Aluno ObjetoAluno) throws SQLException {

		_conexaoBancoDeDados.IniciarConexao();

		if (_conexaoBancoDeDados.getConexao() != null) {

			PreparedStatement psInsert = _conexaoBancoDeDados.getConexao().prepareStatement(
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

			_conexaoBancoDeDados.EncerrarConexao();

			return "Cadastro Realizado Com Sucesso!";

		} else
			return "Erro! Inserção não realizada";

	}

	public String AlterarDados(Aluno ObjetoAluno, int id) throws SQLException {

		_conexaoBancoDeDados.IniciarConexao();

		if (_conexaoBancoDeDados.getConexao() != null) {

			PreparedStatement comandoUpdate = _conexaoBancoDeDados.getConexao().prepareStatement(
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
			
			_conexaoBancoDeDados.EncerrarConexao();
			
			return "Alteração Realizada Com Sucesso!";
		}
		else return "Erro! Alteração Não Realizada!";
	}
	
	
	
		
		
	

}
