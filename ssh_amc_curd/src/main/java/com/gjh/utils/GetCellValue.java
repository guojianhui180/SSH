package com.gjh.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class GetCellValue {
    public static Object getVale(XSSFCell cell){
        if (cell.getCellTypeEnum().equals(CellType._NONE)) {
            return " ";
        } else if (cell.getCellTypeEnum().equals(CellType.BLANK)) {
            return " ";
        } else if (cell.getCellTypeEnum().equals(CellType.BOOLEAN)) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellTypeEnum().equals(CellType.ERROR)) {
            return "Error_Cell";
        } else if (cell.getCellTypeEnum().equals(CellType.FORMULA)) {
            return cell.getCellFormula();
        } else if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
            return cell.getNumericCellValue();
        } else if (cell.getCellTypeEnum().equals(CellType.STRING)) {
            return cell.getStringCellValue();
        } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
            return cell.getDateCellValue();
        } else if (cell.equals(null)) {
            return " ";
        } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
            java.util.Date date = cell.getDateCellValue();
            return (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-"
                    + date.getDate();
        }
        return null;
    }
}
