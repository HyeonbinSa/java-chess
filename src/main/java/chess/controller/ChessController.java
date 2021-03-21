package chess.controller;

import chess.domain.Game;
import chess.domain.position.Position;
import chess.view.InputView;
import chess.view.OutputView;

public class ChessController {
    public void run() {
        OutputView.printStartMessage();
        if (InputView.willNotPlayGame()) {
            return;
        }

        Game game = new Game();
        game.display();
        while (game.isNotEnd()) {
            String[] inputString = InputView.requestInput();
            if ("move".equals(inputString[0])) {
                String from = inputString[1];
                String to = inputString[2];
                game.move(Position.from(from), Position.from(to));
            }
            game.display();
        }
        OutputView.printScore(game.score());
    }
}
