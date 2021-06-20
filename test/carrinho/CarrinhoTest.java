package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {
	
	private Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@DisplayName("Testa a inclusão de um item no carrinho.")
	@Test
	public void testAddItem()  throws ProdutoNaoEncontradoException{
		carrinho.addItem(new Produto("Livro básico", 10.0));
		assertEquals(1, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testa soma do valor total dos itens do carrinho.")
	@Test
	public void testGetValorTotal() {
		carrinho.addItem(new Produto("Livro básico", 10.0));
		carrinho.addItem(new Produto("Pacote de canetas", 7.0));
		carrinho.addItem(new Produto("Lápis", 2.0));
		carrinho.addItem(new Produto("Pacote de borrachas", 3.0));
		
		assertEquals(22.00, carrinho.getValorTotal());
	}
	
	@DisplayName("Testa a remoção com sucesso de um item do carrinho.")
	@Test
	public void testRemoveItemSucess()  throws ProdutoNaoEncontradoException{
		// proporcionando cenário em que há um item no mínimo no carrinho 
		carrinho.addItem(new Produto("Livro básico", 10.0));
		
		//código do teste
		Produto removableItem = new Produto("Livro básico", 10.00);
		carrinho.removeItem(removableItem);
		assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testa a Exception ao tentar remover um item que não existe no carrinho.")
	@Test
	public void testRemoveItemFailed()  throws ProdutoNaoEncontradoException{
		// proporcionando cenário em que há um item no mínimo no carrinho 
		carrinho.addItem(new Produto("Livro básico", 10.0));
		
		Produto removableItem = new Produto("Livro avançado", 30.00);
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(removableItem));	
	}
	
	
	@DisplayName("Testa a remoção de todos os itens de um carrinho.")
	@Test
	public void testEsvazia()  {
		// proporcionando cenário em que há um item no mínimo no carrinho 
		carrinho.addItem(new Produto("Livro básico", 10.0));
		
		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
		
	}

}
