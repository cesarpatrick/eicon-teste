package br.com.eicon.teste.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pedidos")
public class ResponseListBean {
	List<ResponseBean> pedido;

	public List<ResponseBean> getPedido() {
		return pedido;
	}

	public void setPedido(List<ResponseBean> pedido) {
		this.pedido = pedido;
	}
}
