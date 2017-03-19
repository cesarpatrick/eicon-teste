package br.com.eicon.teste.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pedidos")
public class RequestListBean {
	List<RequestBean> pedido;

	public List<RequestBean> getPedido() {
		return pedido;
	}

	public void setPedido(List<RequestBean> pedido) {
		this.pedido = pedido;
	}
}
