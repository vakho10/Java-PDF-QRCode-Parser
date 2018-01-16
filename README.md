# Java-PDF-QRCode-Parser
Parses QR Code from PDF using Google's zxing library and PDFBox API.

## Where should I look?
Well, everything is self-explanatory. By only looking at the main you'll get the picture:
```java
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
```
