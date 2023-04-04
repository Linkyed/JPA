package teste.umpramuitos;

import info.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {
	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();
		
		Produto produto = new Produto("PC", 4000.0);
		Pedido pedido = new Pedido();
		ItemPedido itempedido = new ItemPedido(pedido, produto, 10);
		dao.abrirTransacao().incluir(produto).incluir(pedido).incluir(itempedido).fecharTransacao();
		dao.fechar();
		}
}
