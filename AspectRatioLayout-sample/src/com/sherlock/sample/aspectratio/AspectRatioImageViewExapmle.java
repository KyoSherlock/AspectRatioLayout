package com.sherlock.sample.aspectratio;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class AspectRatioImageViewExapmle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_aspectratio_imageview);

		ImageView img1 = (ImageView) this.findViewById(R.id.img1);
		ImageView img2 = (ImageView) this.findViewById(R.id.img2);
		ImageView img3 = (ImageView) this.findViewById(R.id.img3);
		ImageView img4 = (ImageView) this.findViewById(R.id.img4);

		Picasso.with(getApplicationContext())
				.load("http://abcnews.go.com/images/News/gty_brown_bear_dm_120611_wblog.jpg")
				.into(img1);
		Picasso.with(getApplicationContext())
				.load("http://abcnews.go.com/images/News/gty_brown_bear_dm_120611_wblog.jpg")
				.into(img2);
		Picasso.with(getApplicationContext())
				.load("http://abcnews.go.com/images/News/gty_brown_bear_dm_120611_wblog.jpg")
				.into(img3);
		Picasso.with(getApplicationContext())
				.load("http://abcnews.go.com/images/News/gty_brown_bear_dm_120611_wblog.jpg")
				.into(img4);
	}
}
