package br.edu.pos.confrov.service;

import br.edu.pos.confrov.entity.Modelo;

public interface IModeloService {

	public Modelo criaModelo(Modelo marca);

	public Modelo findByDescricao(String descricao);

}