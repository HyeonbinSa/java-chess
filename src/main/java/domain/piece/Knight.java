package domain.piece;

import domain.Player;
import domain.position.Position;
import java.util.List;

public class Knight extends Piece {

    public Knight(final Player player) {
        super(player, PieceSymbol.Knight);
    }

    @Override
    public List<Position> availableMovePositions(Position currentPosition) {
        return null;
    }
}
