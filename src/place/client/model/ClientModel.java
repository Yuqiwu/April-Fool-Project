package place.client.model;

import java.util.Observable;
import place.PlaceBoard;
import place.PlaceException;
import place.PlaceTile;


/**
 * This is the model section of the client.
 * This class represents the controller part of a model-view-controller
 * triumvirate, in that part of its purpose is to be the Observable
 * for the Client to observe
 *
 * @author Yu Qi Wu
 * @author Eve Cho
 */
public class ClientModel extends Observable {
    /**
     * The board
     */
    private PlaceBoard board;
    /**
     * The dimension of the board
     */
    private int DIM;

    /**
     * Constructor
     */
    public ClientModel(){
        // constructor
    }

    /**
     * This initialize the model
     * @param board the board
     * @throws PlaceException
     */
    public void initialize(PlaceBoard board) throws PlaceException{
        this.board = board;
        this.DIM = this.board.DIM;
    }

    /**
     * Get the dimension of the board
     * @return the dimension of the board
     */
    public int getDIM(){ return this.DIM; }

    /**
     * Get the board
     * @return the board
     */
    public PlaceBoard getBoard(){ return this.board;}

    /**
     * Get the specific tile of the board
     * @param row the row
     * @param col the col
     * @return the tile
     */
    public PlaceTile getTile(int row, int col){
        return this.board.getTile(row, col);
    }

    /**
     * Change the tile of the board, then notify
     * its observers
     * @param tile the tile
     */
    public void tileChanged(PlaceTile tile){
        this.board.setTile(tile);

        super.setChanged();
        super.notifyObservers(tile);
    }
}
