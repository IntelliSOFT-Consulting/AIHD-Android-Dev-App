package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Developed by Rodney on 23/11/2016.
 */

public class TextView_RobotoLight extends android.support.v7.widget.AppCompatTextView {

    public TextView_RobotoLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextView_RobotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextView_RobotoLight(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Light.ttf");
            setTypeface(tf);
        }
    }

}
