package com.facnet.sistemasdistribuidosdao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.facnet.sistemasdistribuidos.Produto;
import com.facnet.sistemasdistribuidosdao.ProdutoDAO;

public class ProdutoDAOImpl extends BaseJPADAO implements ProdutoDAO {

	@Override
	public List<Produto> fetchAll() {
		TypedQuery<Produto> query = getEntityManager().createNamedQuery(
				"Produto.findAll", Produto.class);
		List<Produto> produtos = query.getResultList();
		closeEntityManager();
		return produtos;
	}

	@Override
	public Produto fetch(int id) {
		Produto produto = getEntityManager().find(Produto.class, id);
		closeEntityManager();
		return produto;
	}

	@Override
	public Produto create(Produto produto) {
		EntityTransaction transaction = getEntityManager().getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}

		getEntityManager().persist(produto);
		transaction.commit();
		closeEntityManager();

		return produto;
	}

	@Override
	public boolean delete(int id) {

		if (id == 0) {
			return false;
		}

		Produto produto = fetch(id);

		if (produto == null) {
			return false;
		}

		EntityTransaction transaction = getEntityManager().getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}

		getEntityManager().remove(getEntityManager().merge(produto));

		transaction.commit();
		closeEntityManager();

		return true;
	}

	@Override
	public Produto update(Produto produto) {

		if (produto == null || produto.getId() == 0) {
			return null;
		}

		EntityTransaction transaction = getEntityManager().getTransaction();

		Produto produtoUpdate = getEntityManager().find(Produto.class,
				produto.getId());
		if (!transaction.isActive()) {
			transaction.begin();
		}

		produtoUpdate.setCategoria(produto.getCategoria());
		produtoUpdate.setDescricao(produto.getDescricao());
		produtoUpdate.setNome(produto.getNome());
		produtoUpdate.setQuantidade(produto.getQuantidade());

		transaction.commit();
		closeEntityManager();

		return produto;
	}

}
