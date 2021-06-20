package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma entre dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a divis�o entre dois n�meros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divis�o por zero com try/catch")
	@Test
	public void testDivisaoPorZero() {
		try {
			calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa a divis�o por zero com assert")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	
	//********************** A partir desse ponto c�digo realizado para o exerc�cio **********************//
	@DisplayName("Testa a multiplica��o entre dois n�meros.")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int mult = calc.multiplicacao(5, 8);
		Assertions.assertEquals(40, mult);
	}
	
	@DisplayName("Testa o somat�rio de  0 at� um n�mero")
	@Test
	public void testSomatoriaInitialZero() {
		int somatorio = calc.somatoria(5);
		Assertions.assertEquals(15, somatorio);
	}
	
	@DisplayName("Testa se um n�mero � positivo")
	@Test
	public void testEhPositivoTrue() {
		boolean positivo = calc.ehPositivo(4);
		Assertions.assertEquals(true, positivo);
	}
	
	@DisplayName("Testa se um n�mero � negativo")
	@Test
	public void testEhPositivoFalse() {
		boolean positivo = calc.ehPositivo(-2);
		Assertions.assertEquals(false, positivo);
	}
	
	@DisplayName("Testa se a = b; a = 10 e b= 10")
	@Test
	public void testComparaNumerosIguais() {
		int iguais = calc.compara(10,10);
		Assertions.assertEquals(0, iguais);
	}
	
	@DisplayName("Testa se a > b; a = 10 e b = 5")
	@Test
	public void testComparaNumeroMaiorQueOutro() {
		int maior = calc.compara(10,5);
		Assertions.assertEquals(1, maior);
	}
	
	@DisplayName("Testa se a < b; a = 10 e b = 25")
	@Test
	public void testComparaNumeroMenorQueOutro() {
		int menor = calc.compara(10,25);
		Assertions.assertEquals(-1, menor);
	}

}
