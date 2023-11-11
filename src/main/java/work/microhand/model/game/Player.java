package work.microhand.model.game;

/**
 * @author SanseYooyea
 */
public enum Player {
    /**
     * 白棋
     */
    WHITE('X'),
    /**
     * 黑棋
     */
    BLACK('O');

    private char pieceSymbol;

    Player(char pieceSymbol) {
        this.pieceSymbol = pieceSymbol;
    }

    public char getPieceSymbol() {
        return pieceSymbol;
    }
}
