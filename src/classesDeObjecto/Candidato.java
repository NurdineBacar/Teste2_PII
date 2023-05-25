package classesDeObjecto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;

import bd.Bd;

public class Candidato {
	private int codigo;
	private String nome,bi,historico,municipio;
	private int numeroDeVotos;
	
	public Candidato(String nome, String bi, String historico,String municipio) {
		this.codigo = this.setCodigo();
		this.nome = nome;
		this.bi = bi;
		this.historico = historico;
		this.municipio=municipio;
		this.numeroDeVotos = 0;
	}

	
	public Candidato(int codigo, String nome, String bi, String historico,String municipio, int numeroDeVotos) {
		this.codigo = codigo;
		this.nome = nome;
		this.bi = bi;
		this.historico = historico;
		this.municipio=municipio;
		this.numeroDeVotos = numeroDeVotos;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public int setCodigo() {
	ArrayList<Candidato> listaCandidato= Bd.lerCandidato();
	int codigo=0;
	for(int i=0;i<listaCandidato.size();i++) {
		if(codigo==listaCandidato.get(i).getCodigo()) {
			codigo++;
		}
	}
		
	return this.codigo=codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public int getNumeroDeVotos() {
		return numeroDeVotos;
	}

	public void setNumeroDeVotos(int numeroDeVotos) {
		this.numeroDeVotos = numeroDeVotos;
	}
	
	public String toString1() {
		return codigo+";"+nome+";"+bi+";"+historico+";"+municipio+";"+numeroDeVotos;
	}
	
	public String toString2() {
		return nome+";"+bi+";"+historico+";"+numeroDeVotos;
	}
	public String toString3() {
		return nome;
	}
	
	public static void registoCandidato(String nome,String bi,String historico,String municipio) {
		try {
			FileWriter file= new FileWriter("candidatos.txt",true);
			BufferedWriter write= new BufferedWriter(file);
			
			Candidato candidato = new Candidato(nome, bi, historico,municipio);
			write.write(candidato.toString1());
			write.newLine();
			write.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
