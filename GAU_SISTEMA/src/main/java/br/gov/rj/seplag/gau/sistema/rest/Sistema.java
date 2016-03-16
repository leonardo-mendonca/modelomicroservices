package br.gov.rj.seplag.gau.sistema.rest;

public class Sistema {

	private long id;
	
	private String nome;

	private TipoSistema tipoSistema;

	private StatusSistema statusSistema;
	
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoSistema getTipoSistema() {
		return tipoSistema;
	}

	public void setTipoSistema(TipoSistema tipoSistema) {
		this.tipoSistema = tipoSistema;
	}

	public StatusSistema getStatusSistema() {
		return statusSistema;
	}

	public void setStatusSistema(StatusSistema statusSistema) {
		this.statusSistema = statusSistema;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
