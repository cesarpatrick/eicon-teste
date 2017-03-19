package br.com.eicon.teste.bean;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.eicon.teste.model.Pedido;
import br.com.eicon.teste.util.Util;

@XmlRootElement(name="pedido")
public class RequestBean {
	
	private Integer numeroControle;
	private String data;	
	private String nome;	
	private Double valor;	
	private Integer quantidade;	
	private Integer codigoCliente;
	
	public RequestBean(){
		
	}
	
	public RequestBean(Pedido pedido){
		this.numeroControle = pedido.getId();
		this.data = Util.converterDateParaString(pedido.getData());
		this.nome = pedido.getNome();
		this.valor = pedido.getValorUnitario();
		this.quantidade = pedido.getQuantidade();
		this.codigoCliente = pedido.getCliente().getId();
	}

	public Integer getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Integer numeroControle) {
		this.numeroControle = numeroControle;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
