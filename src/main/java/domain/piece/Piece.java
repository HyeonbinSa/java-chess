package domain.piece;

import domain.Player;
import domain.directions.Direction;
import domain.directions.DirectionsGenerator;
import domain.position.Column;
import domain.position.Position;
import domain.position.Row;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Piece {

    private final Player player;
    private final PieceSymbol pieceSymbol;
    private Map<Direction, List<Position>> availableMovePosition;

    public Piece(final Player player, final PieceSymbol pieceSymbol,
        DirectionsGenerator directionsGenerator) {
        this.player = player;
        this.pieceSymbol = pieceSymbol;
        this.availableMovePosition = initAvailablePosition(directionsGenerator.generate());
    }

    abstract List<Position> calculateAvailablePosition(final Position source,
        final Direction direction);

    private Map<Direction, List<Position>> initAvailablePosition(List<Direction> directions) {
        Map<Direction, List<Position>> availableMovePosition = new HashMap<>();
        directions.forEach(direction -> availableMovePosition.put(direction, null));
        return availableMovePosition;
    }

    public boolean isAvailableMove(Position source, Position target) {
        generateAvailablePosition(source);
        return availableMovePosition.values().stream()
            .filter(Objects::nonNull)
            .filter(value -> value.contains(target))
            .findFirst()
            .orElse(null) != null;
    }

    public List<Position> getAvailablePositions(Position target) {
        return availableMovePosition.values().stream()
            .filter(Objects::nonNull)
            .filter(value -> value.contains(target))
            .findFirst()
            .orElse(new ArrayList<>());
    }

    private void generateAvailablePosition(Position source) {
        for (Direction direction : availableMovePosition.keySet()) {
            availableMovePosition.put(direction, calculateAvailablePosition(source, direction));
        }
    }

    protected boolean checkOverRange(final int row, final int column) {
        return Row.isRowRange(row) && Column.isColumnRange(column);
    }

    public boolean isSamePlayer(Player player) {
        return this.player == player;
    }

    public boolean isSamePlayer(Piece comparePiece) {
        return comparePiece.isSamePlayer(player);
    }

    public String symbol() {
        return pieceSymbol.symbol(player);
    }

    public Player getPlayer() {
        return player;
    }
}
