package map;

import main.CSVFileIO;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TileManager {

    CSVFileIO csvFileIO = new CSVFileIO();
    GamePanel gamePanel;
    Tile[][] tiles;

    public TileManager(GamePanel gp){

        this.gamePanel = gp;
        tiles = new Tile[31][28];

        try {
            ArrayList<String[]> mapRep = csvFileIO.readCSV("src/map/map.txt");

            for(String[] lignes : mapRep){
                for(String elt : lignes){
                    System.out.print(elt);
                }
                System.out.println();
            }

            System.out.println(mapRep.size());

            for(int i=0; i < mapRep.size(); i++){
                for(int j=0; j < mapRep.get(i).length; j++){

                    tiles[i][j] = new Tile();

                    switch (Integer.parseInt(mapRep.get(i)[j].trim())){
                        case 1 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/1.png"));
                        case 2 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/2.png"));
                        case 3 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/3.png"));
                        case 4 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/4.png"));
                        case 5 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/5.png"));
                        case 6 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/6.png"));
                        case 7 -> {
                            tiles[i][j].image = ImageIO.read(new File("src/assets/Map/7.png"));
                            tiles[i][j].collision = false;
                        }
                        case 8 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/8.png"));
                        case 9 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/9.png"));
                        case 10 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/10.png"));
                        case 11 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/11.png"));
                        case 12 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/12.png"));
                        case 13 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/13.png"));
                        case 14 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/14.png"));
                        case 15 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/15.png"));
                        case 16 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/16.png"));
                        case 17 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/17.png"));
                        case 18 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/18.png"));
                        case 19 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/19.png"));
                        case 20 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/20.png"));
                        case 21 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/21.png"));
                        case 22 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/22.png"));
                        case 23 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/23.png"));
                        case 24 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/24.png"));
                        case 25 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/25.png"));
                        case 26 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/26.png"));
                        case 27 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/27.png"));
                        case 28 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/28.png"));
                        case 29 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/29.png"));
                        case 30 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/30.png"));
                        case 31 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/31.png"));
                        case 32 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/32.png"));
                        case 33 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/33.png"));
                        case 34 -> tiles[i][j].image = ImageIO.read(new File("src/assets/Map/34.png"));
                        case 35 -> {
                            tiles[i][j].image = ImageIO.read(new File("src/assets/Map/35.png"));
                            tiles[i][j].collision = false;
                        }
                        case 36 -> {
                            tiles[i][j].image = ImageIO.read(new File("src/assets/Map/36.png"));
                            tiles[i][j].collision = false;
                        }
                        case 40 -> {
                            tiles[i][j].image = ImageIO.read(new File("src/assets/Map/40.png"));
                            tiles[i][j].collision = false;
                        }
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void drawmap(Graphics2D g2){

        for(int i=0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                g2.drawImage(tiles[i][j].image,
                        j*gamePanel.tileSize, i* gamePanel.tileSize,
                        gamePanel.tileSize, gamePanel.tileSize,
                        null);
            }
        }

    }

}
