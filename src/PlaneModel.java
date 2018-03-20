
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class PlaneModel {
	double x;
	double y;
	int width;
	int height;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean live=true;
	int speed = 5;
	Image img;

	public PlaneModel(double x, double y, int width, int height, String path) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = UtilClass.getImage(path);
	}

	public PlaneModel() {
		// TODO Auto-generated constructor stub
	}

	// 画飞机
	void paintStar(Graphics g){
		if(live){
		g.drawImage(img, (int)x,(int) y,width,height,  null);
		}
	}

	// 飞机8个方向移动
	public void move() {
		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
	}
	// 飞机移动
	// public void move(KeyEvent e){
	// switch (e.getKeyCode()) {
	// case 37: //left
	// x-=speed;
	// break;
	// case 38: //up
	// y-=speed;
	// break;
	// case 39: //right
	// x+=speed;
	// break;
	// case 40: //down
	// y+=speed;
	// break;
	//
	//
	// }
	// }

	public void AddDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			left = true;
			break;
		case 38:
			up = true;
			break;
		case 39:
			right = true;
			break;
		case 40:
			down = true;
			break;

		default:
			break;
		}
	}

	public void subDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			left = false;
			break;
		case 38:
			up = false;
			break;
		case 39:
			right = false;
			break;
		case 40:
			down = false;
			break;

		}
	}

	public Rectangle getRectangle() {
		Rectangle rectangle = new Rectangle((int) (x), (int)( y), width-10, height-10);
		return rectangle;
	}

}
