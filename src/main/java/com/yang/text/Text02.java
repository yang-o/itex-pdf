package com.yang.text;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text02.
 * 设置PDF页面的北京颜色，文档属性
 * @author Yang 2020-06-04 16:07
 */
public class Text02 {

    public static void main(String[] args) throws Exception {
        // 定义一个A4大小的矩形组件
        Rectangle rectangle = new Rectangle(PageSize.A4);
        // 设置背景色为浅灰色
        rectangle.setBackgroundColor(BaseColor.LIGHT_GRAY);
        // 设置border类型为box(四周都有)
        rectangle.setBorder(Rectangle.BOX);
        // 设置border颜色为深灰色
        rectangle.setBorderColor(BaseColor.DARK_GRAY);
        // 设置border宽度为5
        rectangle.setBorderWidth(5);

        Document document = new Document(rectangle);

        PdfWriter.getInstance(document,new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text02.pdf"));
        document.addTitle("标题");
        document.addAuthor("作者");
        document.addCreationDate();
        document.addCreator("创建者");
        document.addSubject("Subject");
        document.addKeywords("KeyWords");
        document.addHeader("Expires","0");
        document.open();
        document.add(new Paragraph("Hello World!"));

        document.close();
    }
}
