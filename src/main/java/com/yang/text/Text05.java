package com.yang.text;

import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text05.
 * 实现内部链接 失效
 * @author Yang 2020-06-04 16:43
 */
public class Text05 {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text05.pdf"));
        document.open();

        Paragraph paragraph = new Paragraph("Quick brown");
        Anchor foxReference = new Anchor("fox");
        // 设置点击什么实现跳转
        foxReference.setReference("#fox");
        paragraph.add(foxReference);
        paragraph.add("jumps over the lazy dog.");
        document.add(paragraph);

        // 新建一个页面
        document.newPage();

        Anchor foxName = new Anchor("This is the Fox.");
        foxName.setName("fox");
        // 必须和实现跳转的单词一样
        document.add(foxName);
        document.close();
    }
}
