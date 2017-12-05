package hu.don.easylut.filter;


import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class CreatingNewBitmap extends BitmapStrategy {

    private int[] pix;
    private int width;
    private int height;

    public void prepare(@NonNull Bitmap src) {
        width = src.getWidth();
        height = src.getHeight();
        pix = new int[width * height];
        src.getPixels(pix, 0, width, 0, 0, width, height);
    }

    @Override
    protected int getPixel(@NonNull Bitmap src, int x, int y) {
        return pix[y * width + x];
    }

    @Override
    protected void setPixel(@NonNull Bitmap src, int x, int y, int pixel) {
        pix[y * width + x] = pixel;
    }

    @Override
    protected Bitmap getResult(Bitmap src) {
        // Generate the new bitmap
        Bitmap bm = Bitmap.createBitmap(width, height, src.getConfig());
        // Set the pixels
        bm.setPixels(pix, 0, width, 0, 0, width, height);
        // Clear the pixel array, we don't need it any more
        pix = null;
        // Return the result
        return bm;
    }

}
