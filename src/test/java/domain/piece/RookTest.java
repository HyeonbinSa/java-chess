package domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Player;
import domain.position.Column;
import domain.position.Position;
import domain.position.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RookTest {

    @Test
    @DisplayName("Rook 은 상하좌우로 이동할 수 있다.")
    void moveRookUpDownRightLeft() {
        Piece piece = new Rook(Player.WHITE);
        Position source = new Position(Row.TWO, Column.B);
        Position target = new Position(Row.THREE, Column.B);

        assertThat(piece.isAvailableMove(source, target)).isEqualTo(true);
    }

    @Test
    @DisplayName("Rook은 Target을 상하좌우로 움직일 수 있다.")
    void moveRookUpDownRightLeftTarget() {
        Piece piece = new Rook(Player.WHITE);
        Position source = new Position(Row.TWO, Column.B);
        Position target = new Position(Row.SEVEN, Column.B);

        assertThat(piece.isAvailableMove(source, target)).isEqualTo(true);
    }
}
