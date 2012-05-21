package org.cats.dashboard.activity;

import org.cats.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent aboutUsIntent = new Intent();
			startActivity(aboutUsIntent);
			break;
		case R.id.preferences:
			Intent preferencesIntent = new Intent(
					"org.cats.preferences.activity.PREFERENCEACTIVITY");
			startActivity(preferencesIntent);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}
}
