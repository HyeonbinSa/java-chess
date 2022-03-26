package domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Player;
import domain.position.Column;
import domain.position.Position;
import domain.position.Row;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BishopTest {

    @Test
    @DisplayName("Bishop 은 대각선으로 이동할 수 있다.")
    void moveBishopDiagonally() {
        Piece piece = new Bishop(Player.WHITE);
        Position source = new Position(Row.TWO, Column.B);
        Position target = new Position(Row.THREE, Column.C);

        assertThat(piece.isAvailableMove(source, target)).isEqualTo(true);
    }
}
