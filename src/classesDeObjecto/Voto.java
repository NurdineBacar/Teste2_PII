package classesDeObjecto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bd.Bd;

public class Voto {
	private String voto,data;
	
	
	
	public static void registarVoto(int codigo, String voto) {
		try {
			ArrayList<Candidato> candidatos= Bd.lerCandidato();
			for(int i=0;i<candidatos.size();i++) {
				if(codigo==candidatos.get(i).getCodigo() && voto.equalsIgnoreCase("voto")) {
					int soma=candidatos.get(i).getNumeroDeVotos()+1;
					candidatos.get(i).setNumeroDeVotos(soma);
				}
				
			FileWriter file= new FileWriter("candidatos.txt");
			BufferedWriter write= new BufferedWriter(file);
			
			for(Candidato candidato: candidatos) {
				write.write(candidato.toString1());
				write.newLine();
			}
			write.close();
			file.close();
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void votoBranco(String municipio)
	{
		try {
			ArrayList<Municipio> candidatos= Bd.lerMunicipios();
			for(int i=0;i<candidatos.size();i++) {
				if(municipio.equalsIgnoreCase(candidatos.get(i).getNomeMunicipio())) {
					int soma=candidatos.get(i).getQuantidadeVotos()+1;
					candidatos.get(i).setQuantidadeVotos(i);
					int sub= candidatos.get(i).getQuantidadeR()-1;
					candidatos.get(i).setQuantidadeR(sub);
					break;
				}}
				
			FileWriter file= new FileWriter("municipios.txt");
			BufferedWriter write= new BufferedWriter(file);
			
			for(Municipio candidato: candidatos) {
				write.write(candidato.toString1());
				write.newLine();
			}
			write.close();
			file.close();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
