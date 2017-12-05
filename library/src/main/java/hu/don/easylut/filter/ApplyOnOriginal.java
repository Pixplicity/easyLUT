package hu.don.easylut.filter;


import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class ApplyOnOriginal extends BitmapStrategy {


    @Override
    protected void prepare(@NonNull Bitmap src) {
        // Nothing to do
    }

    @Override
    protected int getPixel(@NonNull Bitmap src, int x, int y) {
        return src.getPixel(x, y);
    }

    @Override
    protected void setPixel(@NonNull Bitmap src, int x, int y, int pixel) {
        src.setPixel(x, y, pixel);
    }

    @Override
    protected Bitmap getResult(Bitmap src) {
        return src;
    }

}
