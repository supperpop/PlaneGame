import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BulletModel {
	double x = Constant.width / 2;
	double y = Constant.height / 2;
	int speed = 8;
	double degree = Math.random() * Math.PI * 2;
	int width = 5;
	int height = 5;

	public BulletModel() {
		
	}

	public void print(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int)x,(int) y, width, height);
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		if(x<0 ||x>Constant.width-width){
			degree=Math.PI-degree;
		}
		if(y<30 ||y>Constant.height-height){
			degree=-degree;
		}
	}
	public Rectangle getRectangle(){
		Rectangle rectangle =new Rectangle((int)(x),(int) (y), width-2, height-2);
		return rectangle;
	}
	
}
