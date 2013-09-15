package br.edu.pos.confrov.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.service.ICategoriaService;
import br.edu.pos.confrov.service.impl.CategoriaServiceImpl;

@ManagedBean(name="categoria")
public class CategoriaList implements Serializable {

	//	private static final Logger log = Logger.getLogger(CategoriaList.class);

	private static final long serialVersionUID = 1L;

	private Categoria categoria;
	private List<Categoria> listaCategoria;

	ICategoriaService categoriaService = new CategoriaServiceImpl();

	@PostConstruct
	public void init(){
		setListaCategoria(new ArrayList<Categoria>());
		buscaCategorias();
		categoria = new Categoria();
	}

	private void buscaCategorias() {
		setListaCategoria(categoriaService.findByAll());
	}

	public String salvar(){

		Categoria categoriaPeristida = categoriaService.findByDescricao(categoria.getDescricao());
		if(categoriaPeristida == null){
			categoria = categoriaService.criaCategoria(categoria);
			buscaCategorias();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Categoria Salva","" )); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ops! Categoria", "Já existe uma categoria com essa Descricão: "+categoria.getDescricao()));  
		}

		return "";
	}


	public void editar(){

	}
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}


}
