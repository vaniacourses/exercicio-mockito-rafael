import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jogo.Dado;
import jogo.Jogador;
import jogo.Jogo;

import org.junit.jupiter.api.Test;

public class JogoTest {

	@Test
	public void testVitoriaNoPrimeiroTurnoCom7() {
		// Arrange
		Jogador jogadorMock = mock(Jogador.class);
		Dado dado1Mock = mock(Dado.class);
		Dado dado2Mock = mock(Dado.class);

		when(jogadorMock.lancar(dado1Mock, dado2Mock)).thenReturn(7);

		Jogo jogo = new Jogo(jogadorMock, dado1Mock, dado2Mock);

		// Act
		boolean resultado = jogo.jogo();

		// Assert
		assertTrue(resultado);
	}

	@Test
	public void testDerrotaNoPrimeiroTurnoCom2() {
		Jogador jogadorMock = mock(Jogador.class);
		Dado dado1Mock = mock(Dado.class);
		Dado dado2Mock = mock(Dado.class);

		when(jogadorMock.lancar(dado1Mock, dado2Mock)).thenReturn(2);

		Jogo jogo = new Jogo(jogadorMock, dado1Mock, dado2Mock);

		boolean resultado = jogo.jogo();

		assertFalse(resultado);
	}

	@Test
	public void testVitoriaNoSegundoTurno() {
		Jogador jogadorMock = mock(Jogador.class);
		Dado dado1Mock = mock(Dado.class);
		Dado dado2Mock = mock(Dado.class);

		// Primeiro turno: 5
		// Segundo turno: 3, 4, 5 (vitória)
		when(jogadorMock.lancar(dado1Mock, dado2Mock)).thenReturn(5, 3, 4, 5);

		Jogo jogo = new Jogo(jogadorMock, dado1Mock, dado2Mock);

		boolean resultado = jogo.jogo();

		assertTrue(resultado);
	}

	@Test
	public void testDerrotaNoSegundoTurnoCom7() {
		Jogador jogadorMock = mock(Jogador.class);
		Dado dado1Mock = mock(Dado.class);
		Dado dado2Mock = mock(Dado.class);

		// Primeiro turno: 6
		// Segundo turno: 4, 7 (derrota)
		when(jogadorMock.lancar(dado1Mock, dado2Mock)).thenReturn(6, 4, 7);

		Jogo jogo = new Jogo(jogadorMock, dado1Mock, dado2Mock);

		boolean resultado = jogo.jogo();

		assertFalse(resultado);
	}
}
