package domain.chessgame;

import domain.Player;
import domain.Score;
import domain.Status;
import domain.piece.Piece;
import domain.position.Position;

public class ChessGame {

    private final ChessBoard chessBoard;
    private Player currentPlayer;

    public ChessGame(final ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.currentPlayer = Player.WHITE;
    }
    public ChessGame(final ChessBoard chessBoard, Player player) {
        this.chessBoard = chessBoard;
        this.currentPlayer = player;
    }
    public void move(final Position source, final Position target) {
        validateTurn(source);
        chessBoard.move(source, target);
        changeTurn();
    }

    public Status status() {
        Score score = new Score(chessBoard);
        double whiteScore = score.white();
        double blackScore = score.black();
        return new Status(whiteScore, blackScore);
    }

    private void validateTurn(final Position source) {
        Piece sourcePiece = chessBoard.findPiece(source);
        if (sourcePiece != null && !sourcePiece.isSamePlayer(currentPlayer)) {
            throw new IllegalArgumentException("[ERROR] 상대방의 기물을 움직일 수 없습니다.");
        }
    }

    private void changeTurn() {
        if (currentPlayer == Player.WHITE) {
            this.currentPlayer = Player.BLACK;
            return;
        }
        this.currentPlayer = Player.WHITE;
    }

    public boolean isFinished() {
        return chessBoard.isKingOnlyOne();
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
