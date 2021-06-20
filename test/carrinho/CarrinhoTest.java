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
	
	@DisplayName("Testa a inclus�o de um item no carrinho.")
	@Test
	public void testAddItem()  throws ProdutoNaoEncontradoException{
		carrinho.addItem(new Produto("Livro b�sico", 10.0));
		assertEquals(1, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testa soma do valor total dos itens do carrinho.")
	@Test
	public void testGetValorTotal() {
		carrinho.addItem(new Produto("Livro b�sico", 10.0));
		carrinho.addItem(new Produto("Pacote de canetas", 7.0));
		carrinho.addItem(new Produto("L�pis", 2.0));
		carrinho.addItem(new Produto("Pacote de borrachas", 3.0));
		
		assertEquals(22.00, carrinho.getValorTotal());
	}
	
	@DisplayName("Testa a remo��o com sucesso de um item do carrinho.")
	@Test
	public void testRemoveItemSucess()  throws ProdutoNaoEncontradoException{
		// proporcionando cen�rio em que h� um item no m�nimo no carrinho 
		carrinho.addItem(new Produto("Livro b�sico", 10.0));
		
		//c�digo do teste
		Produto removableItem = new Produto("Livro b�sico", 10.00);
		carrinho.removeItem(removableItem);
		assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testa a Exception ao tentar remover um item que n�o existe no carrinho.")
	@Test
	public void testRemoveItemFailed()  throws ProdutoNaoEncontradoException{
		// proporcionando cen�rio em que h� um item no m�nimo no carrinho 
		carrinho.addItem(new Produto("Livro b�sico", 10.0));
		
		Produto removableItem = new Produto("Livro avan�ado", 30.00);
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(removableItem));	
	}
	
	
	@DisplayName("Testa a remo��o de todos os itens de um carrinho.")
	@Test
	public void testEsvazia()  {
		// proporcionando cen�rio em que h� um item no m�nimo no carrinho 
		carrinho.addItem(new Produto("Livro b�sico", 10.0));
		
		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
		
	}

}
