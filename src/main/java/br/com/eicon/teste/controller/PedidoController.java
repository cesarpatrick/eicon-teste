package br.com.eicon.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.teste.bean.RequestListBean;
import br.com.eicon.teste.bean.ResponseBean;
import br.com.eicon.teste.bean.ResponseListBean;
import br.com.eicon.teste.service.PedidoService;

@RestController
@RequestMapping(value = "/api/service")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@RequestMapping(value = "/json/pedido", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseListBean cadastrarJson(@RequestBody RequestListBean pedidos) {
		return pedidoService.cadastrar(pedidos);
	}
	
	@RequestMapping(value = "/json/listPedido", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseListBean listarPedidosJson() {
		return pedidoService.listarPedidos();
	}
	
	@RequestMapping(value = "/json/pedido/{numeroControle}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseBean pedidoJson(@PathVariable Integer numeroControle) {
		return pedidoService.obterPedidoByNumeroControle(numeroControle);
	}
	
	@RequestMapping(value = "/json/pedido/data/{data}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseListBean listarPedidosJson(@PathVariable String data) {
		return pedidoService.listarPedidosByData(data);
	}
	
	@RequestMapping(value = "/xml/pedido", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ResponseListBean cadastrarXml(@RequestBody RequestListBean pedidos) {
		return pedidoService.cadastrar(pedidos);
	}
	
	@RequestMapping(value = "/xml/listPedido", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ResponseListBean listarPedidosXml() {
		return pedidoService.listarPedidos();
	}
	
	@RequestMapping(value = "/xml/pedido/{numeroControle}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ResponseBean pedidoXml(@PathVariable Integer numeroControle) {
		return pedidoService.obterPedidoByNumeroControle(numeroControle);
	}
	
	@RequestMapping(value = "/xml/pedido/data/{data}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ResponseListBean listarPedidosXml(@PathVariable String data) {
		return pedidoService.listarPedidosByData(data);
	}
}
