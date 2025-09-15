package jogo;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import jogo.Dado;
import jogo.Jogador;
import jogo.Jogo;

public class JogoTest {

		Jogador jogador = mock(Jogador.class);
		Dado dadinho1 = mock(Dado.class);
		Dado dadinho2 = mock(Dado.class);

        @Test
        public boolean lancarReturnTrue() {
            when(jogador.lancar(dadinho1, dadinho2)).thenReturn(7);
            boolean result1 = jogo();
            when(jogador.lancar(dadinho1, dadinho2)).thenReturn(11);
            boolean result2 = jogo();
            if(result1 && result2){
                return True;
            } else {
                return False;
            }
        }

        @Test
        public boolean lancarReturnFalse(){
            when(jogador.lancar(dadinho1, dadinho2)).thenReturn(2);
            boolean result1 = jogo();
            when(jogador.lancar(dadinho1, dadinho2)).thenReturn(3);
            boolean result2 = jogo();
            when(jogador.lancar(dadinho1, dadinho2)).thenReturn(12);
            boolean result3 = jogo();
            if(!result1 && !result2 && !result3){
                return True;
            } else {
                return False;
            }
        }
}
