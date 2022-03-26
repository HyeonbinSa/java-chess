package domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Player;
import domain.position.Rank;
import domain.position.File;
import domain.position.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PawnTest {

    @ParameterizedTest
    @MethodSource("blackPawnTarget")
    @DisplayName("BlackPawn 은 현재 위치에서 아래로 한 칸 또는 대각선(아래)으로 한칸 이동할 수 있다.")
    void moveBlackPawnMove(Position target) {
        Piece piece = new BlackPawn(Player.BLACK);
        Position source = Position.of(File.B, Rank.SEVEN);

        assertThat(piece.isAvailableMove(source, target)).isEqualTo(true);
    }

    private static Stream<Position> blackPawnTarget() {
        return Stream.of(
            Position.of(File.A, Rank.SIX),
            Position.of(File.B, Rank.SIX),
            Position.of(File.C, Rank.SIX)
        );
    }

    @ParameterizedTest
    @MethodSource("whitePawnTarget")
    @DisplayName("WhitePawn 은 현재 위치에서 위로 한 칸 또는 대각선(위)으로 한칸 이동할 수 있다.")
    void moveWhitePawnMove(Position target) {
        Piece piece = new WhitePawn(Player.WHITE);
        Position source = Position.of(File.B, Rank.TWO);

        assertThat(piece.isAvailableMove(source, target)).isEqualTo(true);
    }

    private static Stream<Position> whitePawnTarget() {
        return Stream.of(
            Position.of(File.A, Rank.THREE),
            Position.of(File.B, Rank.THREE),
            Position.of(File.C, Rank.THREE)
        );
    }
}
