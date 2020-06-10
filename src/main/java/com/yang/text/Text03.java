package com.yang.text;


import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Text02.
 * 一个简单的中文输出实例，设置字体，所在位置等
 * @author Yang 2020-06-04 16:07
 */
public class Text03 {

    public static void main(String[] args) throws Exception {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,new FileOutputStream("/Users/yangquan/Desktop/itext-pdf/Text03.pdf"));
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 16, Font.NORMAL);
        document.add(new Paragraph("Hello world"));
        document.add(new Paragraph("这里是中国"));
        Paragraph paragraph = new Paragraph("这里是中国",fontChinese);
        // 居中显示
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        document.close();
    }
}
