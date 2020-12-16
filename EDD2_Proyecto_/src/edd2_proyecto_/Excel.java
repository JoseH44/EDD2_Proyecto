/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_proyecto_;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
/**
 *
 * @author Workstation DSY
 */
public class Excel {

    public Excel() {
    }
    

    public void ExportToExcel(Metadata metadata, String name, JTable table) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Estructura de Datos");
        int registros = table.getModel().getRowCount();
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", metadata.getCampos().toArray());
        for (int i = 0; i < registros; i++) {
            ArrayList Registro = new ArrayList();
            for (int j = 0; j < metadata.getCampos().size(); j++) {
                Registro.add(table.getValueAt(i, j));
            }
            data.put(Integer.toString(i + 2), Registro.toArray());
        }

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } // cell.setIte((String)obj);
                else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }

            }
        }
        try {
            //Write the workbook in file system
            File filer = new File(name += ".xlsx");
            filer.delete();
            filer.createNewFile();
            FileOutputStream out = new FileOutputStream(filer);
            workbook.write(out);
            out.close();
            System.out.println(name + " written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
