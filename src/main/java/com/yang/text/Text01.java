package com.yang.text;


import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text01.
 * 设置pdf页面大小，左右边距
 *
 * @author Yang 2020-06-04 16:04
 */
public class Text01 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);

        // 设置页面200*800， 单位是用户显示单元
//        Rectangle pageSize = new Rectangle(200f, 800f);
//         页边距，顺序是左右上下
//        Document document1 = new Document(pageSize, 20f, 20f, 20f, 20f);
//
//         定义A4页面大小
//        Rectangle rectanglePageSize = new Rectangle(PageSize.A4);
//        Document document2 = new Document(rectanglePageSize, 50, 50, 50, 50);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text01.pdf"));
        document.open();
        document.add(new Paragraph("Hello World!"));
        document.close();
    }
}
