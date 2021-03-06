package pdf;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import model.Car;
import model.Rent;
import model.User;


public class GenerowaniePdf {
  private static String FILE = "c:/Users/Adrian/projektISZ/Wyklad/umowa.pdf";
  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.NORMAL, BaseColor.RED);
  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
      Font.BOLD);
  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);

  public void generujUmowe(Car wypozyczanySamochod,User klient, Rent Wypozyczenie) {
    
      Car wypozyczanySamochod1=wypozyczanySamochod;
      User klient1=klient;
      Rent Wypozyczenie1=Wypozyczenie;
      
      try {
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      addTitlePage(document,wypozyczanySamochod1,klient1,Wypozyczenie1);
    //  addContent(document);
      document.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void addMetaData(Document document) {
    document.addTitle("My first PDF");
    document.addSubject("Using iText");
    document.addKeywords("Java, PDF, iText");
    document.addAuthor("Lars Vogel");
    document.addCreator("Lars Vogel");
  }

  private static void addTitlePage(Document document,Car wypozyczanySamochod,User klient, Rent Wypozyczenie)
      throws DocumentException {
    Paragraph preface = new Paragraph();
    addEmptyLine(preface, 1);
    preface.add(new Paragraph("                        UMOWA WYNAJMU SAMOCHODU", catFont));
    addEmptyLine(preface, 1);
    addEmptyLine(preface, 3);
    preface.add(new Paragraph("Umowa zawarta miedzy "+klient.getImie()+" "+klient.getNazwisko() +" a firma AUTO RENT w dniu "+new Date(),
        smallBold));
    addEmptyLine(preface, 8);
    preface.add(new Paragraph(" Przedmiotem uzyczenia czyni sie samochod "+wypozyczanySamochod.getModel() +" "+wypozyczanySamochod.getMarka() +" z rocznika "+wypozyczanySamochod.getRocznik()  +" i typie nadwozia "+wypozyczanySamochod.getTypNadwozia() +" ."
            + "Okres trwa od "+Wypozyczenie.getDataWypozyczenia()+" - do "+Wypozyczenie.getDataZwrotu()+"  .Uzyczajacy oswiadcza ze samochod jest w dobrym stanie technicznym oraz posiada"
            + " kolo zapasowe, gasnice oraz trojkat ratunkowy. Cena wynajmu wynosi "+Wypozyczenie.getDoZaplaty()+" zl w przypadku opoznien beda naliczane odsetki (z podpisanym dokumentem nalezy zglosic sie po odbior pojazdu)",
        smallBold));
    addEmptyLine(preface, 16);
    preface.add(new Paragraph("Numer dowodu, data oraz podpis klienta",
        smallBold));
    addEmptyLine(preface, 1);
    preface.add(new Paragraph("..................................................................",
        smallBold));
    document.add(preface);
    // Start a new page
    document.newPage();
  }

  private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
} 