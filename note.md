- 单元格隐藏边框
```$xslt
PdfPCell cell = new PdfPCell(new Phrase(“disableBorderSide”));
上边框: 1, 下边框: 2, 左边框: 4, 右边框: 8, 需要隐藏的边框就把对应的值相加
cell.disableBorderSide(x);

1、隐藏上边框
cell.disableBorderSide(1);
2、隐藏下边框
cell.disableBorderSide(2);
3、隐藏上、下边框
cell.disableBorderSide(3);

4、隐藏左边框
cell.disableBorderSide(4);
5、隐藏右边框
cell.disableBorderSide(8);
6、隐藏左、右边框
cell.disableBorderSide(12);

其他类推。。。
```
