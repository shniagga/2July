package org.cats.launch;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class LaunchProgressBarView extends TextView {
	private int maxValue = 100;

	public LaunchProgressBarView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public LaunchProgressBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LaunchProgressBarView(Context context) {
		super(context);
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public synchronized void setValue(int value) {
		this.setText(String.valueOf(value));
		LayerDrawable background = (LayerDrawable) this.getBackground();
		ClipDrawable barValue = (ClipDrawable) background.getDrawable(1);
		int newClipLevel = (int) (value * 10000 / maxValue);
		barValue.setLevel(newClipLevel);
		drawableStateChanged();
	}

}
