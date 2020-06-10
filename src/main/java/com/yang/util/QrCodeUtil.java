package com.yang.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.misc.BASE64Encoder;

/**
 * QrCodeUtil.
 *
 * @author Yang 2020-06-04 10:36
 */
public class QrCodeUtil {

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    /**
     * 二维码尺寸.
     */
    private static final int QRCODE_SIZE = 300;


    /**
     * 二维码的的base64格式.
     *
     * @param content      content.
     * @param needCompress 压缩
     * @return base64
     * @throws Exception e
     */
    public static String encode(String content, boolean needCompress) throws Exception {
        BufferedImage image = QrCodeUtil.createImage(content, needCompress);

        //输出流
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, FORMAT_NAME, stream);
        byte[] bytes = stream.toByteArray();

        BASE64Encoder encoder = new BASE64Encoder();
        String imageBase64 = encoder.encodeBuffer(bytes).trim();
        return ("data:image/jpg;base64," + imageBase64).replaceAll("[\\s*\t\n\r]", "");
    }

    /**
     * 生成二维码并写入指定位置.
     *
     * @param content      content
     * @param qrCodePath   生成文件的路径-全路径
     * @param needCompress 压缩
     * @throws Exception e
     */
    private static void encode(String content, String qrCodePath, boolean needCompress) throws Exception {
        BufferedImage image = QrCodeUtil.createImage(content, needCompress);
        ImageIO.write(image, FORMAT_NAME, new File(qrCodePath));
    }


    /**
     * 实际生成二维码的方法.
     *
     * @param content      二维码内容
     * @param needCompress 压缩
     * @return bufferedImage
     * @throws Exception e
     */
    public static BufferedImage createImage(String content, boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }

    /**
     * 通过二维码全路径解析内容
     *
     * @param qrCodePath qrCodePath
     * @return 二维码内容
     * @throws Exception e
     */
    public static String decode(String qrCodePath) throws Exception {
        return QrCodeUtil.decode(new File(qrCodePath));
    }

    /**
     * 通过二维码解析内容.
     *
     * @param file file
     * @return 解析出来的内容
     * @throws Exception e
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource
                source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        return result.getText();
    }

}
