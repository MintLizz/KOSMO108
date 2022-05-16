package a.b.c.com.kosmo.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public abstract class ThumnailImg {
	
	public static void thumnailFun(String uploadPath, String filename) {
		
		System.out.println("	ThumnailFun 의 thumnailFun에 들어옴!	>>> : ");
		System.out.println("	uploadPath 는 ?	>>> : " + uploadPath);
		System.out.println("	filename 은 ?	>>> : " + filename);
		
		File file = null;
		
		try {
			
			ParameterBlock pb = new ParameterBlock();
			pb.add(uploadPath + "\\" + filename);
			
			RenderedOp rOp = JAI.create("fileload", pb);
			BufferedImage bi = rOp.getAsBufferedImage();
			
			// 썸네일 배경크기화 썸네일색상
			BufferedImage thumb = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = thumb.createGraphics();
			
			// 썸네일 위치, 썸네이을 크기 
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 50, 50);
			g.drawImage(bi,0,0,50,50,null);
						
			file = new File(uploadPath + "\\sm_" + filename);
			ImageIO.write(thumb,"jpg",file);
			System.out.println("uploadPath/" + file.getName());
			
		}catch (Exception e) {
			
			System.out.println("	ThumnailImg 의 thumnailFun() 의 오류가 나옴!	>>> : " + e.getMessage());
			
		}
		
		
	}

}





