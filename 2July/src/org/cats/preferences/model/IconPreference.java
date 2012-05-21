package org.cats.preferences.model;

import org.cats.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class IconPreference extends Preference {
	private Drawable icon;

    public IconPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayoutResource(R.layout.preference_icon);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.IconPreference, defStyle, 0);
        icon = a.getDrawable(R.styleable.IconPreference_icon);
    }

    @Override
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        if (imageView != null && icon != null) {
            imageView.setImageDrawable(icon);
        }
    }

    public void setIcon(Drawable drawable) {
        if ((drawable == null && icon != null) || (drawable != null && !drawable.equals(icon))) {
            icon = drawable;
            notifyChanged();
        }
    }

    public Drawable getIcon() {
        return icon;
    }
}
