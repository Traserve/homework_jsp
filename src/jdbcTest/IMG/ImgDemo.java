package jdbcTest.IMG;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;



/**
 * 动态生成图片
 * @author cxf
 *
 */
public class ImgDemo {
    public static void main(String[] args) throws IOException {
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		VerifyCode.output(bi, new FileOutputStream("/home/online/1.jpg"));
		System.out.println(vc.getText());
	}
}
