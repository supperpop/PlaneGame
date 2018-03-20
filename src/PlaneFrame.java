import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;

public class PlaneFrame extends UtilClass {
	PlaneModel bj = new PlaneModel(0, 0, Constant.width, Constant.height, "Img/beauty12.jpg");
	PlaneModel plane1 = new PlaneModel(200, 800, 30, 30, "Img/airport disk.png");
	BulletModel bullet = new BulletModel();
	Date startTime;
	Date endTime;
	Date nowTime;
	long start;
	long end;
	long now;
	String level;

	@Override
	public void paint(Graphics g) {
		bj.paintStar(g);
		plane1.paintStar(g);
		plane1.move();
		nowTime=new Date();
		now=nowTime.getTime();
		
		
		for(int i=0 ;i<100;i++){
		bullet =(BulletModel)bulletList.get(i);
			bullet.print(g);
			
			//检测飞机是否与子弹碰撞
			boolean touch;
			touch=bullet.getRectangle().intersects(plane1.getRectangle());
			if(touch){
				plane1.live=false;
				plane1.x=-1;
				plane1.y=-1;
				endTime =new Date();
				end=endTime.getTime();
			}
		}
		//飞机触碰子弹出现gameover字体
		if(!plane1.live){
			Charset(g, Color.white, 100, "GAME OVER", Constant.width/5, Constant.height/2);
			if((end-start)/1000<20){
				level="菜鸟~";
			}else if((end-start)/1000<60){
				level="不错~";
			}else if((end-start)/1000<90){
				level="大神！";
			}else{
				level="雄哥级别！！！";
			}
			Charset(g, Color.gray, 60, level+(end-start)/1000+"秒",Constant.width/3-30, Constant.height/2+50);
			
			

			
		}
		Charset(g, Color.BLACK, 20, "存活时间："+(now-start)/1000+"秒", 800, 55);
		
	}
	
	
		//屏幕出现字体方法
	public void Charset(Graphics g,Color color,int font_size,String content,int location_x,int location_y){
		g.setColor(color);
		Font font =new Font("大字", Font.BOLD, font_size);
		g.setFont(font);
		g.drawString(content, location_x, location_y);
	}
@Override
	public void StartLaunch() {
		super.StartLaunch();
		addKeyListener(new keyboard());
		//设置开始时间
		startTime =new Date();
		start=startTime.getTime();
	};

	// 设置键盘内部类，为了调用飞机成员变量
	class keyboard extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			plane1.AddDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane1.subDirection(e);

		}

	
			
		
	}
}
