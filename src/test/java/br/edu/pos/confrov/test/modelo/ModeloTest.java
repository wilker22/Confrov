package br.edu.pos.confrov.test.modelo;

import org.junit.Assert;
import org.junit.Test;

import br.edu.pos.confrov.dao.IModeloService;
import br.edu.pos.confrov.dao.impl.ModeloServiceImpl;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;

public class ModeloTest {

	@Test
	public void test() {

		IMarcaService marcaService = new MarcaServiceImpl();
		
		// Cria o Modelo
		Modelo modelo = new Modelo();
		modelo.setDescricao("Corolla");
		// parametros de busca
		Marca marca = new Marca();
		marca.setDescricao("Toyota");
		// Busca a marca a ser inserida
		Marca marca2 = marcaService.findByDescricao(marca);
		// Verifica se a Marca desse modelo existe no banco de dados
		Assert.assertEquals("Toyota", marca2.getDescricao());
		if(marca2!=null){
			modelo.setMarca(marca2);
		}
		
		// Persiste no Banco
		IModeloService modeloService = new ModeloServiceImpl();
		Modelo modelo2 = modeloService.criaModelo(modelo);

		// faz a verificação
//		Assert.assertEquals("Toyota", m2.getDescricao());

	}

}