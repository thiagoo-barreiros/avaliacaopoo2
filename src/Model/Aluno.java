package Model;
public class Aluno {

	private int id;
	private String nome;
	private String endereco;
	private String Telefone;
	private String cpf;
	private String tiposanguineo;
	private String contatoemergencia;
	private String telefoneemergencia;
	private String curso;
	private String fatorRh;
	
	public Aluno() {
		
	}

	public Aluno(String nome, String endereco, String Telefone, String cpf, String tiposanguineo,
			String contatoemergencia, String telefoneemergencia, String curso, String fatorRh) {

		this.nome = nome;
		this.endereco = endereco;
		this.Telefone = Telefone;
		this.cpf = cpf;
		this.tiposanguineo = tiposanguineo;
		this.contatoemergencia = contatoemergencia;
		this.telefoneemergencia = telefoneemergencia;
		this.curso = curso;
		this.fatorRh = fatorRh;

	}
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTiposanguineo() {
		return tiposanguineo;
	}

	public void setTiposanguineo(String tiposanguineo) {
		this.tiposanguineo = tiposanguineo;
	}

	public String getContatoemergencia() {
		return contatoemergencia;
	}

	public void setContatoemergencia(String contatoemergencia) {
		this.contatoemergencia = contatoemergencia;
	}

	public String getTelefoneemergencia() {
		return telefoneemergencia;
	}

	public void setTelefoneemergencia(String telefoneemergencia) {
		this.telefoneemergencia = telefoneemergencia;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFatorRh() {
		return fatorRh;
	}

	public void setFatorRh(String fatorRh) {
		this.fatorRh = fatorRh;
	}

	public int getId() {
		return id;
	}

}
