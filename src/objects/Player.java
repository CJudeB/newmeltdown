package objects;


public class Player extends Definer{

        private Tile tile;
        private Player player; //The current location of the player

        public Player(String vName, String vDescribe, Tile vTile) {
            super(vName, vDescribe);
            this.tile = vTile;
        }

    public void setTile(Tile vTile) {
                this.tile = vTile;
            }
            public Tile getTile() {
                return this.tile;
            }
        }


