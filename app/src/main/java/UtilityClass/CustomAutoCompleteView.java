package UtilityClass;

import android.content.Context;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

import java.util.HashMap;

/**
 * Created by rishi on 3/4/18.
 */

public class CustomAutoCompleteView extends AppCompatAutoCompleteTextView{

    public CustomAutoCompleteView(Context context) {
        super(context);
    }

    public CustomAutoCompleteView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected CharSequence convertSelectionToString(Object selectedItem) {

        HashMap<String, String> hm = (HashMap<String, String>) selectedItem;
        return hm.get("bname");
    }
/*


    public CustomAutoCompleteView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    */
/*
    *   Method to disable AutoCompleteTextView filter
    *//*

    @Override
    protected void performFiltering(final CharSequence text, final int keyCode) {
        String filterText = "";
        super.performFiltering(filterText, keyCode);
    }

*/

}
