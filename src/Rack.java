import java.io.Serializable;

/**
 * The Rack class.
 *
 * @author Ejeh Leslie 101161386
 * @version 1.0
 */
public class Rack implements Serializable {

    private Tile[] tiles;
    private static final int MAX_RACK_SIZE = 7;

    /**
     * Create and initialize the Rack.
     */

    public Rack() {
        this.tiles = new Tile[MAX_RACK_SIZE];
    }

    /**
     * takes a tile from the bag and fills the rack up
     * @param bag The Bag to be processed.
     * @return true if the bag was filled , false otherwise.
     */
    public boolean fillRack(Bag bag){
        boolean filled=true;
        for(int i=0;i<MAX_RACK_SIZE;i++){
            if(tiles[i]==null){
                tiles[i]=bag.drawTile();
                filled=!(tiles[i]==null);

            }
        }
        return filled;
    }
    /**
     * checks the bag and true  if the amount of tile to be exhanged was succesful
     * @param bag and an array of int.
     * @return true if the tile was exchanged succesfully , false otherwise.
     */
    public boolean exchangeTiles(Bag bag, int[] index){
        for(int i : index) {
            if(bag.isEmpty())
                tiles[i] = bag.swapTile(tiles[i]);
        }
        return true;
    }
    /**
     * returns the array of  tile on the rack
     * @return an array of tile
     */
    public Tile[] getTiles(){
        return tiles;
    }

    /**
     * Set the array of tiles of the rack. // for test purposes.
     * @param tiles the array of tiles
     */
    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }

    /**
     * returns the tiles letters and points as string
     * @return String of the tiles letters and points
     */
    public String toString(){
        StringBuilder lettersAndPoints= new StringBuilder("| ");
        for(Tile t : tiles){
            if(t != null){
                lettersAndPoints.append(t).append(" | ");
            }
        }
        return lettersAndPoints.toString();
    }

    /**
     * removes a tile from the rack
     * @param tile to remove a tile
     */
    public void removeTile(Tile tile) {
        for(int i = 0; i < MAX_RACK_SIZE; i++) {
            if(tiles[i] == tile) {
                tiles[i] = null;
            }
        }
    }

    public static Rack getCopyRack(Rack rack) {
        Rack copyRack = new Rack();
        Tile[] tiles = new Tile[MAX_RACK_SIZE];
        for(int i = 0; i < MAX_RACK_SIZE; i++)
            tiles[i] = Tile.getCopyTile(rack.getTiles()[i]);
        copyRack.setTiles(tiles);
        return copyRack;
    }
}
