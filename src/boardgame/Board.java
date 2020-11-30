package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: é necessário que haja pelo menos 1 linha e 1 coluna.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("A posição não existe.");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Você não pode colocar uma peça por cima da outra. Posição: " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists (Position pos) {
		return positionExists(pos.getRow(), pos.getColumn());
	}
	
	public boolean thereIsAPiece(Position pos) {
		if (!positionExists(pos)) {
			throw new BoardException("A posição não existe.");
		}
		return piece(pos) != null;
	}
}
