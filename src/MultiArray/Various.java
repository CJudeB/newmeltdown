package MultiArray;

import java.util.Scanner;

import java.util.*;


public class Various {


   /* private static MapOutput MapValue(Scanner s) {
        System.out.println("define length of y axis");
        int rowVal = s.nextInt();

        System.out.println("define length of x axis");
        int colVal= s.nextInt();

        int[][] map = new int[rowVal][colVal];
        MapOutput mVal = new MapOutput(rowVal, colVal, map);
        return mVal;

    }*/


    private static MapOutput DisplayOutput(){

        final int rowVal= 5;
        final int colVal= 5;
       // final int[][] map;

        final int[][] map = new int[rowVal][colVal];
        MapOutput mVal = new MapOutput(rowVal, colVal, map);
        return mVal;

    }

    public static class MapOutput {

        private final int mapRows;
        private final int mapColumns;
        private final int[][] map;


        public MapOutput(int mapRows, int mapColumns, int[][] map) {
            this.mapRows = mapRows;
            this.mapColumns = mapColumns;
            this.map = map;
        }

        public int getMRow() {
            return mapRows;
        }

        public int getMCol() {
            return mapColumns;
        }

        public int[][] getMap() {
            return map;
        }


        private static void createGrid(MapOutput mapOutput) {
            int rowVal = mapOutput.getMRow();
            int colVal = mapOutput.getMCol();
            int[][] map = mapOutput.getMap();

            int iterate = 0;
            for (int x = 0; x < rowVal; x++) {
                for (int y = 0; y < colVal; y++) {
                    map[x][y] = iterate;
                    iterate++;
                }
            }
        }
    }


    private static void renderGrid( MapOutput mapOutput )
    {
        int row = mapOutput.getMRow();
        int col = mapOutput.getMCol();
        int[][] map = mapOutput.getMap();


        for ( int v = 0; v < row; v++ )
        {
            for ( int x = 0; x < col; x++ )
            {
                System.out.printf( "%-2d", map[v][x] );
                System.out.print( "-" );
            }
            System.out.println( "" );
        }
    }

    private static void moveVal( Scanner s, MapOutput mapOutput)
    {
        System.out.println( "Select a place to travel to on the map" );
        int traverseTile = s.nextInt();
        updateMap( mapOutput, traverseTile );
    }

    private static void updateMap( MapOutput mapOutput, int steppedTile )
    {
        int rows = mapOutput.getMRow();
        int columns = mapOutput.getMCol();
        int[][] map = mapOutput.getMap();

        for ( int q = 0; q < rows; q++ )
        {
            for ( int x = 0; x < columns; x++ )
            {
                if ( map[q][x] == steppedTile )
                {
                    map[q][x] = 0;
                }
            }
        }
    }



    public static void main( String[] args )
    {
       Scanner s = new Scanner( System.in );
        MapOutput mapOutput = DisplayOutput();

        MapOutput.createGrid( mapOutput );
        renderGrid( mapOutput );
        System.out.println();
        System.out.println( "You Start At 0" );

        moveVal( s, mapOutput );
        renderGrid( mapOutput );
        System.out.println();

        moveVal( s, mapOutput );
        renderGrid( mapOutput );
    }


    }


