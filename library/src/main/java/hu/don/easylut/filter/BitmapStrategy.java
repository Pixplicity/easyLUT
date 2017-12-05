package hu.don.easylut.filter;


import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import hu.don.easylut.lutimage.LUTImage;

public abstract class BitmapStrategy {

    enum Type {
        APPLY_ON_ORIGINAL_BITMAP, CREATING_NEW_BITMAP
    }

    public interface LutProgressListener {

        void onProgress(float progress);

    }

    public final Bitmap applyLut(@NonNull Bitmap src, @NonNull LUTImage lutImage,
                                 @Nullable LutProgressListener listener) {
        prepare(src);

        long cur = 0;
        long last = 0;
        long total = src.getHeight() * src.getWidth();
        long diff = total / 100;
        for (int y = 0; y < src.getHeight(); y++) {
            for (int x = 0; x < src.getWidth(); x++) {
                int pixel = getPixel(src, x, y);

                int colorPixelOnLut = lutImage.getColorPixelOnLut(pixel);
                setPixel(src, x, y, colorPixelOnLut);
                if (listener != null) {
                    cur++;
                    if (cur > last + diff) {
                        last = cur;
                        listener.onProgress((float) cur / (float) total);
                    }
                }
            }
        }

        return getResult(src);
    }

    protected abstract void prepare(@NonNull Bitmap src);

    protected abstract int getPixel(@NonNull Bitmap src, int x, int y);

    protected abstract void setPixel(@NonNull Bitmap src, int x, int y, int pixel);

    protected abstract Bitmap getResult(Bitmap src);

}
