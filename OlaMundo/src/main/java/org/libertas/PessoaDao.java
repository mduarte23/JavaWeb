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
			String sql = "INSERT INTO pessoa (nome, telefone, email, cidade, endereco, cep)"
					+ " VALUES (?,?,?,?,?,?)";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1,  p.getNome());
			prep.setString(2,  p.getTelefone());
			prep.setString(3,  p.getEmail());
			prep.setString(4,  p.getCidade());
			prep.setString(5,  p.getEndereco());
			prep.setString(6,  p.getCep());
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
			String sql = "SELECT * FROM pessoa ORDER BY nome";
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pessoa p = new Pessoa();
				p.setIdpessoa(res.getInt("idpessoa"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				p.setEndereco(res.getString("endereco"));
				p.setCep(res.getString("cep"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	
	public void alterar(Pessoa p) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE pessoa SET"
					+" nome = ?, telefone = ?," 
					+ "email = ? , cidade = ?,"
					+ "endereco = ? , cep = ?"
					+ "WHERE idpessoa = ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCidade());
			prep.setString(5, p.getEndereco());
			prep.setString(6, p.getCep());
			prep.setInt(7, p.getIdpessoa());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void excluir(Pessoa p) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM pessoa"
					+ " WHERE idpessoa = ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setInt(1, p.getIdpessoa());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public Pessoa consultar(int id) {
		Pessoa p = new Pessoa();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa WHERE idPessoa = "+ id;
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				p.setIdpessoa(res.getInt("idpessoa"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				p.setEndereco(res.getString("endereco"));
				p.setCep(res.getString("cep"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return p;
	}
}
