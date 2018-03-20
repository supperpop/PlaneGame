
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class UtilClass extends Frame {
	ArrayList bulletList = new ArrayList();
	// 设置外框并启动线程
	public void StartLaunch() {
		setLocation(200, 200);
		setSize(Constant.width, Constant.height);
		setVisible(true);
		GameThread gThread = new GameThread();
		gThread.start();
		

		WindowListener wl = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(wl);
		//添加子弹
		for(int i=0;i<100;i++){
			BulletModel bullet=new BulletModel();
			bulletList.add(bullet);
		}
	}

	// 创造一个获取图片方法
	public static Image getImage(String path) {
		URL url = UtilClass.class.getClassLoader().getResource(path);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}

	// 设置线程
	public class GameThread extends Thread {
		@Override
		public void run() {
			while (true) {
				repaint();

				try {
					sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//设置双缓冲
	private Image offScreenImage=null;
	public void update(Graphics g){
		if(offScreenImage==null)
			offScreenImage =this.createImage(Constant.width,Constant.height);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
			
		
		
	}

}