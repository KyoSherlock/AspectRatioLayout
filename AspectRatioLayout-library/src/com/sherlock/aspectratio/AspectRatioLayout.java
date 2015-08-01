package com.sherlock.aspectratio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class AspectRatioLayout extends FrameLayout {
	private static final int MODE_MEASURE_INIT = -1;
	private static final int MODE_MEASURE_WIDTH_FIRST = 0;
	private static final int MODE_MEASURE_HEIGHT_FIRST = 1;
	// height / width
	private float mWidthHeightAspectRatio = 0;
	// width is exact value;
	private int mMeasuredMode = MODE_MEASURE_INIT;

	public AspectRatioLayout(Context context) {
		super(context);
		this.init(context, null);
	}

	public AspectRatioLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.init(context, attrs);
	}

	public AspectRatioLayout(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.init(context, attrs);
	}

	@TargetApi(21)
	public AspectRatioLayout(Context context, AttributeSet attrs,
			int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		this.init(context, attrs);
	}

	private void init(Context c, AttributeSet attrs) {
		if (attrs != null) {
			TypedArray a = c.obtainStyledAttributes(attrs,
					R.styleable.AspectRatioLayout);
			mWidthHeightAspectRatio = a.getFloat(
					R.styleable.AspectRatioLayout_widthHeightRatio, 0);
			a.recycle();
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);

		if (mWidthHeightAspectRatio <= 0) {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			return;
		}

		if (mMeasuredMode == MODE_MEASURE_WIDTH_FIRST) {
			if (width == 0) {
				height = 0;
			} else {
				height = (int) (width / mWidthHeightAspectRatio);
			}
			super.onMeasure(
					MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
					MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
		} else if (mMeasuredMode == MODE_MEASURE_HEIGHT_FIRST) {
			width = (int) (height * mWidthHeightAspectRatio);
			super.onMeasure(
					MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
					MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
		}
	}

	public void setWidthHeightRatio(float ratio) {
		mWidthHeightAspectRatio = ratio;
		this.requestLayout();
	}

	@Override
	public void setLayoutParams(android.view.ViewGroup.LayoutParams params) {
		if (params.width != LayoutParams.WRAP_CONTENT
				&& params.height == LayoutParams.WRAP_CONTENT) {
			mMeasuredMode = MODE_MEASURE_WIDTH_FIRST;
		} else if (params.height != LayoutParams.WRAP_CONTENT
				&& params.width == LayoutParams.WRAP_CONTENT) {
			mMeasuredMode = MODE_MEASURE_HEIGHT_FIRST;
		} else {
			throw new IllegalArgumentException(
					"You must set a exact value to width/height, and set WRAP_CONTENT to another");
		}
		super.setLayoutParams(params);
	}
}