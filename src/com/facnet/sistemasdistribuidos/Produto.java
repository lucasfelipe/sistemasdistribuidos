package com.facnet.sistemasdistribuidos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produtos database table.
 * 
 */
@Entity
@Table(name="produtos")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String categoria;

	private String descricao;

	private String nome;

	private int quantidade;

	public Produto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}