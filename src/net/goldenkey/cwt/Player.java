package net.goldenkey.cwt;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player extends Rectangle{
	
	private int pDir;
	
	public double moveSpeed = 1.8;
	
	public static int[][] pImgDown = {{0, 0}, {1, 0}, {2, 0}};
	public static int[][] pImgLeft = {{0, 1}, {1, 1}, {2, 1}};
	public static int[][] pImgRight = {{0, 2}, {1, 2}, {2, 2}};
	public static int[][] pImgUp = {{0, 3}, {1, 3}, {2, 3}};
	
	public static boolean isMoving = false;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	
	public int aniFrame = 0;
	public int aniTime = 10;
	public int aniDelta = 0;
		
	public Player(String name){
		width = 32;
		height = 32;
		setBounds((Core.pixel.width / 2) - (width / 2), (Core.pixel.height / 2) - (height / 2), width, height);
	}
	
	public void tick(double delta){
		
		aniDelta ++;
		
		if(aniDelta >= aniTime){
			aniFrame ++;
			aniDelta = 0;
			if(aniFrame > 2){
				aniFrame = 0;
			}
		}
		
		if(up){
			Core.oY -= moveSpeed * delta;
			pDir = 1;
		}
		
		if(down){
			Core.oY += moveSpeed * delta;
			pDir = 2;
		}
		
		if(left){
			Core.oX -= moveSpeed * delta;
			pDir = 3;
		}
		
		if(right){
			Core.oX += moveSpeed * delta;
			pDir = 4;
		}
		
	}
	
	
	
	
	public void render(Graphics g){
		
		if(pDir == 2 && Player.isMoving == false){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgDown[0][0] * Tile.size, pImgDown[0][1] * Tile.size, pImgDown[0][0] * Tile.size + Tile.size, pImgDown[0][1] * Tile.size + Tile.size, null);

		}if(pDir == 1 && Player.isMoving == false){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgUp[0][0] * Tile.size, pImgUp[0][1] * Tile.size, pImgUp[0][0] * Tile.size + Tile.size, pImgUp[0][1] * Tile.size + Tile.size, null);

		}if(pDir == 3 && Player.isMoving == false){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgLeft[0][0] * Tile.size, pImgLeft[0][1] * Tile.size, pImgLeft[0][0] * Tile.size + Tile.size, pImgLeft[0][1] * Tile.size + Tile.size, null);

		}if(pDir == 4 && Player.isMoving == false){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgRight[0][0] * Tile.size, pImgRight[0][1] * Tile.size, pImgRight[0][0] * Tile.size + Tile.size, pImgRight[0][1] * Tile.size + Tile.size, null);

		}
		
		if(down){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgDown[aniFrame][0] * Tile.size, pImgDown[aniFrame][1] * Tile.size, pImgDown[aniFrame][0] * Tile.size + Tile.size, pImgDown[aniFrame][1] * Tile.size + Tile.size, null);
		}else if(up){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgUp[aniFrame][0] * Tile.size, pImgUp[aniFrame][1] * Tile.size, pImgUp[aniFrame][0] * Tile.size + Tile.size, pImgUp[aniFrame][1] * Tile.size + Tile.size, null);
		}else if(left){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgLeft[aniFrame][0] * Tile.size, pImgLeft[aniFrame][1] * Tile.size, pImgLeft[aniFrame][0] * Tile.size + Tile.size, pImgLeft[aniFrame][1] * Tile.size + Tile.size, null);
		}else if(right){
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgRight[aniFrame][0] * Tile.size, pImgRight[aniFrame][1] * Tile.size, pImgRight[aniFrame][0] * Tile.size + Tile.size, pImgRight[aniFrame][1] * Tile.size + Tile.size, null);
		}
		

		
	}
	
	
}


	

