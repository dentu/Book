package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

@WebServlet("/checkcode")
public class CheckServlet extends HttpServlet {
	private static int WIDTH = 60; // 验证码图片宽度
	private static int HEIGHT = 20; // 验证码图片高度

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//servlet输出图片
		resp.setContentType("image/jpeg");//输出格式为图片格式
		//resp.setContentType("text/html;charset=utf-8");//输出格式为HTML文本
		ServletOutputStream sos = resp.getOutputStream();//这个才能输出二进制数据
//		PrintWriter out=resp.getWriter();//不能使用，因为它只能输出文本
		// 设置浏览器不要缓存此图片
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		// 创建内存图象并获得其图形上下文
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 产生随机的认证码
		char[] rands = generateCheckCode();

		String checkcode=new String(rands);
		//找到公共单元session
		HttpSession session=req.getSession();
		//存放共享数据
		session.setAttribute("checkcode", checkcode);

		
		// 产生图像
		drawBackground(g);
		drawRands(g, rands);
		// 结束图像的绘制过程，完成图像
		g.dispose();
		// 将图像输出到客户端
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", bos);
		byte[] buf = bos.toByteArray();//将图片转换为二进制的数组
		resp.setContentLength(buf.length);//设置传送数据的长度
		// 下面的语句也可写成：bos.writeTo(sos);
		sos.write(buf);//输出到浏览器
		bos.close();
		sos.close();

	}

	// 生成一个4字符的验证码
	private char[] generateCheckCode() {
		// 定义验证码的字符表
		String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
		char[] rands = new char[4];
		for (int i = 0; i < 4; i++) {
			int rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}

	private void drawRands(Graphics g, char[] rands) {
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
		// 在不同的高度上输出验证码的每个字符
		g.drawString("" + rands[0], 1, 17);
		g.drawString("" + rands[1], 16, 15);
		g.drawString("" + rands[2], 31, 18);
		g.drawString("" + rands[3], 46, 16);
		System.out.println(rands);
	}

	private void drawBackground(Graphics g) {
		// 画背景
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// 随机产生120个干扰点
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * WIDTH);
			int y = (int) (Math.random() * HEIGHT);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, 1, 0);
		}
	}
}
