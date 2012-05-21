package org.cats.dashboard.activity;

import org.cats.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);

		Button btn_newsfeed = (Button) findViewById(R.id.btn_news_feed);
		Button btn_friends = (Button) findViewById(R.id.btn_friends);
		Button btn_messages = (Button) findViewById(R.id.btn_messages);
		Button btn_places = (Button) findViewById(R.id.btn_places);

		btn_newsfeed.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("Hello");
			}
		});

		btn_friends.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("Hello");
			}
		});

		btn_messages.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("Hello");
			}
		});

		btn_places.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("Hello");
			}
		});
	}
}
