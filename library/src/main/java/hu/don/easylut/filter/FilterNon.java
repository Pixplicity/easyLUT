package hu.don.easylut.filter;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class FilterNon extends Filter {

    @Override
    public Bitmap apply(Bitmap source, BitmapStrategy.LutProgressListener listener) {
        return source;
    }

    @Override
    public void apply(ImageView imageView, BitmapStrategy.LutProgressListener listener) {
    }

}
