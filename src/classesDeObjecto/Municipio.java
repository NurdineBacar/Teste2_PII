package classesDeObjecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import bd.Bd;

public class Municipio {
	private int codigo;
	private String nomeMunicipio,descricao, provincia;
	private int quantidadeR,quantidadeVotos;
	
	
	
	
	
	public Municipio(String nomeMunicipio, String descricao, String provincia, int quantidadeR) {
		this.codigo=this.setCodigo();
		this.nomeMunicipio = nomeMunicipio;
		this.descricao = descricao;
		this.provincia = provincia;
		this.quantidadeR = quantidadeR;
		this.quantidadeVotos=0;
	}



	public Municipio(int codigo, String nomeMunicipio, String descricao, String provincia, int quantidadeR,
			int quantidadeVotos) {
		
		this.codigo = codigo;
		this.nomeMunicipio = nomeMunicipio;
		this.descricao = descricao;
		this.provincia = provincia;
		this.quantidadeR = quantidadeR;
		this.quantidadeVotos = quantidadeVotos;
	}



	public int getCodigo() {
		return codigo;
	}
	public int setCodigo() {
		ArrayList<Municipio> listaMunicipio= Bd.lerMunicipios();
		int codigo=0;
		for(int i=0;i<listaMunicipio.size();i++) {
			if(codigo==listaMunicipio.get(i).getCodigo()) {
				codigo++;
			}
		}			
		return this.codigo=codigo ;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}



	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}



	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}



	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}



	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public int getQuantidadeR() {
		return quantidadeR;
	}
	public void setQuantidadeR(int quantidadeR) {
		this.quantidadeR = quantidadeR;
	}
	
	public String toString1() {
		return codigo+";"+nomeMunicipio+";"+descricao+";"+provincia+";"+quantidadeR+";"+quantidadeVotos;
	}
	public String toString2() {
		return nomeMunicipio;
	}
	
}
