package br.edu.pos.confrov.dao.impl;

import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;

public interface IModeloDAO {

	public Modelo criaModelo(Modelo modelo, Dba dba);

	public Modelo findByDescricao(String descricao);

}
