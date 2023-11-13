/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author MANH TRUONG
 */
public class imagehelper {
    public static Image resize(Image originalImage, int targetWidth, int targetHeight){//cho phép điều chỉnh kích thước hình ảnh
        Image resultImage;
        resultImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultImage;
    }
    
    public static byte[] toByteArray(java.awt.Image img, String type) throws IOException{//chuyển hình ảnh thành byte
        BufferedImage bimage = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bimage.createGraphics();//có thể vẽ hình ảnh 
        g2d.drawImage(img, 0,0, null);
        g2d.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        byte[] imageInbyte = baos.toByteArray();
        return imageInbyte;
    }
    
    public static java.awt.Image createImageFromByteArray(byte[] data, String type) throws IOException{//chuyển data về image
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        java.awt.Image img = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), java.awt.Image.SCALE_SMOOTH);
        return img;
    }

    static Image createImageFromByteArray(int row, String jpg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
