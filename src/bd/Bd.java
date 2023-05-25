package bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classesDeObjecto.Candidato;
import classesDeObjecto.Municipio;

public class Bd {
	
	public static ArrayList<Candidato> lerCandidato(){
		ArrayList<Candidato> listacandidato= new ArrayList<>();
		try {
			FileReader file= new FileReader("candidatos.txt");
			BufferedReader read= new BufferedReader(file);
			
			String []elem;
			String linha=read.readLine();
			
			while(linha!=null) {
				elem= linha.split(";");
				int  codigo= Integer.parseInt(elem[0]);
				String nome=elem[1];
				String bi=elem[2];
				String historico=elem[3];
				String municipio= elem[4];
				int qtdVotos= Integer.parseInt(elem[5]);
				
				listacandidato.add(new Candidato(codigo, nome, bi, historico,municipio, qtdVotos));
				linha= read.readLine();
			}
		} catch (FileNotFoundException e) {
			
		}catch (IndexOutOfBoundsException e) {
			
		}catch (Exception e) {
			
		}
		
		return listacandidato;
	}
	
	public static ArrayList<Municipio> lerMunicipios(){
		ArrayList<Municipio> listaMunicipios= new ArrayList<>();
		try {
			FileReader file= new FileReader("municipios.txt");
			BufferedReader read= new BufferedReader(file);
			
			String []elem;
			String linha=read.readLine();
			while(linha!=null) {
				elem= linha.split(";");
				int  codigo= Integer.parseInt(elem[0]);
				String nome=elem[1];
				String descrica=elem[2];
				String provincia=elem[3];
				int qtdR= Integer.parseInt(elem[4]);
				int qtdV= Integer.parseInt(elem[5]);
				
				listaMunicipios.add(new Municipio(codigo, nome, descrica, provincia, qtdR, qtdV));
				linha= read.readLine();
			}
		} catch (FileNotFoundException e) {

		}catch (IndexOutOfBoundsException e) {
//			JOptionPane.showMessageDialog(null, "Erro na Indexacao");
		}catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERRO");
		}
		
		return listaMunicipios;
	}
	
	public static String[] listarCandidatos() {
		ArrayList<Candidato> listaCandidatos= Bd.lerCandidato();
		String [] lista= new String[listaCandidatos.size()];
		for(int i=0;i<lista.length;i++) {
			lista[i]=listaCandidatos.get(i).toString3();
		}	
		return lista;
	}
	
	public static String[] listarCandidatosFiltro(String municipio) {
		ArrayList<Candidato> listaCandidatos= Bd.lerCandidato();
		String [] lista= new String[listaCandidatos.size()];
		for(int i=0;i<lista.length;i++) {
			if(municipio.equals(listaCandidatos.get(i).getMunicipio())) {
				lista[i]=listaCandidatos.get(i).toString3();
			}
		}	
		return lista;
	}
	
	public static String[] listarMunicipio() {
		ArrayList<Municipio> listaMunicipios= Bd.lerMunicipios();
		String [] lista= new String[listaMunicipios.size()];
		for(int i=0;i<lista.length;i++) {
			lista[i]=listaMunicipios.get(i).toString2();
		}	
		return lista;
	}
	
	public static String[][] tabelaCandidato(){
		ArrayList<Candidato> listaC= Bd.lerCandidato();
		String [][] tabela= new String [listaC.size()][5];
		try {
			for(int i=0;i<tabela.length;i++) {
				tabela[i][0]=listaC.get(i).getCodigo()+"";
				tabela[i][1]=listaC.get(i).getNome();
				tabela[i][2]=listaC.get(i).getBi();
				tabela[i][3]=listaC.get(i).getHistorico();
				tabela[i][4]=listaC.get(i).getNumeroDeVotos()+"";
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return tabela;
		
	}
			
	public static String[][] tabelaMunicipio(){
		ArrayList<Municipio> listaC= Bd.lerMunicipios();
		String [][] tabela= new String [listaC.size()][6];
		try {
			for(int i=0;i<tabela.length;i++) {
				tabela[i][0]=listaC.get(i).getCodigo()+"";
				tabela[i][1]=listaC.get(i).getNomeMunicipio();
				tabela[i][2]=listaC.get(i).getDescricao();
				tabela[i][3]=listaC.get(i).getProvincia();
				tabela[i][4]=listaC.get(i).getQuantidadeR()+"";
				tabela[i][5]=listaC.get(i).getQuantidadeVotos()+"";
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return tabela;
		
	}
			
	public static void main(String[] args) {
		Bd.lerCandidato();
	}
}
