package org.libertas;

import java.util.LinkedList;

public class PessoaDao {
	private static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	public void inserir(Pessoa p) {
		lista.add(p);
	}
	public LinkedList<Pessoa> listar() {
		return lista;
	}
}
