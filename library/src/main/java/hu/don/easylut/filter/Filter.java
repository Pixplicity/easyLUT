package hu.don.easylut.filter;

import android.graphics.Bitmap;
import android.widget.ImageView;

public abstract class Filter {

    public Bitmap apply(Bitmap src) {
        return apply(src, null);
    }

    public void apply(ImageView imageView) {
        apply(imageView, null);
    }

    public abstract Bitmap apply(Bitmap src, BitmapStrategy.LutProgressListener listener);

    public abstract void apply(ImageView imageView, BitmapStrategy.LutProgressListener listener);

}
