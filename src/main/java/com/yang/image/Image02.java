package com.yang.image;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.yang.util.QrCodeUtil;

/**
 * Image02.
 *
 * @author Yang 2020-06-04 18:40
 */
public class Image02 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Image02.pdf"));
        document.open();
        BufferedImage qrCode = QrCodeUtil.createImage("http://tourgroup-port.staging.12301e.com/mobile/detail/OVd19PV5pZ", false);
        Image image = Image.getInstance(qrCode,null, false);
        image.setIndentationLeft(100f);
        document.add(image);
        document.close();
    }
}
