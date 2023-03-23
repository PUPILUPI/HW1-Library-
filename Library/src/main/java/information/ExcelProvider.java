
package information;

import books.RussianBookFactory;
import books.EnglishBookFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import users.Builder;


    public class ExcelProvider {
        private File file;
        private XSSFWorkbook wb;
    public ExcelProvider(String path){
            setFile(path);     
    }

    private void setFile(String path) {
            this.file = new File(path);
    }
    public void loadFile() {
            try{
                wb = new XSSFWorkbook(file);
            } catch (IOException ex) {
                Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void run(Integer i){
        loadFile();
        if (i.equals(0))readSheets();
        else readSheets2();
        close();
        
    }
    private void readSheets() {
        loop(0, Builder.femaleNames,Builder.maleNames);

        loop(1, Builder.femaleSurnames,Builder.maleSurnames);

        loop(2, Builder.femaleTSurnames,Builder.maleTSurnames);

        for (int i=0; i<=wb.getSheetAt(wb.getNumberOfSheets()-1).getLastRowNum(); i++){
            Builder.secondNames.add(wb.getSheetAt(wb.getNumberOfSheets()-1).getRow(i).getCell(0).getStringCellValue());
        }

    }
    private void readSheets2(){
        
        loop(0,RussianBookFactory.name , RussianBookFactory.type);
        for (Integer i=2; i<5; i++){
            for (int k=0; k<=wb.getSheetAt(0).getLastRowNum(); k++){
                if(wb.getSheetAt(0).getRow(k).getCell(i)==null){
                    break;
                }       
                if (i==2){
                    RussianBookFactory.adj.add(wb.getSheetAt(0).getRow(k).getCell(i).getStringCellValue());
                }
                if(i==3){
                    RussianBookFactory.noun.add(wb.getSheetAt(0).getRow(k).getCell(i).getStringCellValue());
                }
                if(i==4){
                    RussianBookFactory.whom.add(wb.getSheetAt(0).getRow(k).getCell(i).getStringCellValue());
                }
                    
            }         
        }

        for (Integer i=5; i<8; i++){
            for (int k=0; k<=wb.getSheetAt(0).getLastRowNum(); k++){
                if(wb.getSheetAt(0).getRow(k).getCell(i)==null){
                    break;
                }       
                if (i.equals(5)){
                    EnglishBookFactory.name.add(wb.getSheetAt(0).getRow(k).getCell(i).getStringCellValue());
                }
                if(i.equals(6)){
                    EnglishBookFactory.university.add(wb.getSheetAt(0).getRow(k).getCell(i).getStringCellValue());
                }
                if(i.equals(7)){
                    EnglishBookFactory.author.add(wb.getSheetAt(0).getRow(k).getCell(i).getStringCellValue());
                }
                    
            }         
        }
        
    }

    private void close() {
        try {
            wb.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void loop(int k, ArrayList<String> listF, ArrayList<String> listM ){
        for (int i=0; i<2; i++){
                for (int j=0; j<=wb.getSheetAt(k).getLastRowNum(); j++){
                    if(wb.getSheetAt(k).getRow(j).getCell(i)==null){
                        break;
                    }
                    if (i==0){
                        listM.add(wb.getSheetAt(k).getRow(j).getCell(i).getStringCellValue());
                        
                    }
                    if(i==1){
                        listF.add(wb.getSheetAt(k).getRow(j).getCell(i).getStringCellValue());
                    }
                    
                }  
        }
    }
    
}
