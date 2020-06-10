package com.yang.image;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Image01.
 *
 * @author Yang 2020-06-04 18:25
 */
public class Image01 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Image01.pdf"));
        document.open();
        Image image = Image.getInstance("/Users/yangquan/Desktop/itext-pdf/qrCode.jpg");
        image.setIndentationLeft(100f);
        document.add(image);
        document.close();
    }
}
