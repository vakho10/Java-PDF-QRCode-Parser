package ge.vakho.pdf_qr_reader.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

public class QRDecoder {

  public static Result decode(InputStream imageInputStream) throws IOException, NotFoundException, ChecksumException, FormatException {
    BufferedImage bufferedImage = ImageIO.read(imageInputStream);
    return decodeBufferedImage(bufferedImage);
  }

  public static Result decodeBufferedImage(BufferedImage bufferedImage) throws NotFoundException, ChecksumException, FormatException {
    LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

    QRCodeReader qrCodeReader = new QRCodeReader();
    return qrCodeReader.decode(bitmap);
  }
}
