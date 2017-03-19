package br.com.eicon.teste.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.teste.bean.RequestBean;
import br.com.eicon.teste.bean.RequestListBean;
import br.com.eicon.teste.bean.ResponseBean;
import br.com.eicon.teste.bean.ResponseListBean;
import br.com.eicon.teste.model.Pedido;
import br.com.eicon.teste.repository.ClienteRepository;
import br.com.eicon.teste.repository.PedidoRepository;
import br.com.eicon.teste.util.Util;

@Service
public class PedidoService {

	private static final Integer QUANTIDADE_PEDIDO_VALOR_INEXISTENTE = 1; 

	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public PedidoService(PedidoRepository pedidoRepository,ClienteRepository clienteRepository){
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
	}

	public ResponseListBean cadastrar(RequestListBean bean){
		ResponseListBean retorno = new ResponseListBean();
		List<ResponseBean> listBean = new ArrayList<>();

		if(bean != null && !bean.getPedido().isEmpty()){

			if(bean.getPedido().size() > 10){
				ResponseBean erroBean = new ResponseBean();
				erroBean.setMensagem("Erro: A lista possui mais de 10 pedidos.");
				listBean.add(erroBean);
				retorno.setPedido(listBean);
				return retorno;
			}
				
			for (RequestBean request : bean.getPedido()) {

				ResponseBean response = new ResponseBean();
				if(pedidoRepository.findOne(request.getNumeroControle()) != null){
					response.setMensagem("Erro: Numero de controle do pedido " + request.getNumeroControle() +" já cadastrado.");
					listBean.add(response);
				}else{

					Pedido pedido = new Pedido();

					pedido.setId(request.getNumeroControle());
					pedido.setCliente(clienteRepository.findOne(request.getCodigoCliente()));
					pedido.setNome(request.getNome());
					pedido.setValorUnitario(request.getValor());

					if(request.getData() != null && !request.getData().isEmpty()){
						pedido.setData(Util.converterStringParaDate(request.getData()));
					}else{
						pedido.setData(Util.limparHoraMin(new Date()));
					}

					if(request.getQuantidade() != null){
						pedido.setQuantidade(request.getQuantidade());

						Double valorTotal = request.getQuantidade() * request.getValor();
						if(request.getQuantidade() > 5 && request.getQuantidade() < 10){
							pedido.setValorTotal(valorTotal - ((valorTotal*5)/100));
						}else if(request.getQuantidade() >= 10){
							pedido.setValorTotal(valorTotal - ((valorTotal*10)/100));
						}else{
							pedido.setValorTotal(valorTotal);
						}	
					}else{
						pedido.setQuantidade(QUANTIDADE_PEDIDO_VALOR_INEXISTENTE);
						pedido.setValorTotal(request.getValor());
					}
					response = new ResponseBean(pedidoRepository.save(pedido));
					response.setMensagem("Sucesso: Cadastro realizado com sucesso.");
					listBean.add(response);
				}
			}
		}

		retorno.setPedido(listBean);
		return retorno;
	}

	public ResponseListBean listarPedidos(){
		List<Pedido> pedidos = pedidoRepository.findAll();
		ResponseListBean retorno = new ResponseListBean();

		List<ResponseBean> list = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			ResponseBean bean = new ResponseBean(pedido);
			list.add(bean);
		}

		retorno.setPedido(list);
		return retorno;
	}

	public ResponseBean obterPedidoByNumeroControle(Integer numeroControle){
		Pedido pedido = pedidoRepository.findOne(numeroControle);
		ResponseBean retorno = new ResponseBean();

		if(pedido != null){
			retorno = new ResponseBean(pedido);
			retorno.setMensagem("Sucesso: Pedido encontrado.");
		}else{
			retorno.setMensagem("Erro: Pedido não encontrado.");
		}

		return retorno;
	}

	public ResponseListBean listarPedidosByData(String data){
		List<Pedido> pedidos = pedidoRepository.findPedidoByDataOrderById(Util.converterStringParaDate(data));		
		ResponseListBean retorno = new ResponseListBean();

		List<ResponseBean> list = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			ResponseBean bean = new ResponseBean(pedido);
			list.add(bean);
		}

		retorno.setPedido(list);
		return retorno;
	}
	
}
