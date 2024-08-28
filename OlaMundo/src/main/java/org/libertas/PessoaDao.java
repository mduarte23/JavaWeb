package org.libertas;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class PessoaDao {
	//private static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	public void inserir(Pessoa p) {
		//lista.add(p);
		//abre a conexao com o bd
		Conexao con = new Conexao();
		
		try {
			String sql = "INSERT INTO pessoa (nome, telefone, email, cidade)"
					+ " VALUES (?,?,?,?)";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1,  p.getNome());
			prep.setString(2,  p.getTelefone());
			prep.setString(3,  p.getEmail());
			prep.setString(4,  p.getCidade());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//fecha a conexao com o banco de dados 
		con.desconecta();
	}
	public LinkedList<Pessoa> listar() {
		//return lista;
		LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa";
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pessoa p = new Pessoa();
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
				
	}
}
