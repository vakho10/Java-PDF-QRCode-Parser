package ge.vakho.pdf_qr_reader.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import com.google.zxing.Result;
import ge.vakho.pdf_qr_reader.utils.PDFUtils;

public class Main {

  public static void main(String[] args) {

    PDDocument document = null;
    try (InputStream is = Main.class.getResourceAsStream("/Sample-QR-Codes.pdf")) {

      // (1) Parse PDF document
      document = PDDocument.load(is);

      // (2) Get all the QR results from the document
      List<Result> results = PDFUtils.getQRResultsFromDocument(document);

      // (3) Process QR results
      for (Result result : results) {

        // XXX Don't uncomment this!
        // ImageIO.write(image, "PNG", new File(UUID.randomUUID().toString() + ".png"));

        System.out.println(result.getText()); // That's all.        
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // Oh, god...
      if (document != null) {
        try {
          document.close();
        } catch (IOException e) {
        }
      }
    }
  }
}
