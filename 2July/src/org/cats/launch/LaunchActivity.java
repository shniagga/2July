package org.cats.launch;

import org.cats.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class LaunchActivity extends Activity {
	private final static int LAUNCH_TIME = 5000; // miliseconds
	private MediaPlayer launchSong;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch_layout);
		launchSong = MediaPlayer.create(LaunchActivity.this, R.raw.background);
		View launchView = this.findViewById(android.R.id.content).getRootView();
		launchSong.start();

		Thread sleeper = new Thread() {
			public void run() {
				try {
					sleep(LAUNCH_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent dashboardMenuActivity = new Intent(
							"org.cats.dashboard.DASHBOARDDESINGACTIVITY");
					startActivity(dashboardMenuActivity);
				}
			}
		};
		Thread progressBar = new Thread(new LaunchProgressBarDialog(launchView,
				LAUNCH_TIME));
		sleeper.start();
		progressBar.start();

	}

	@Override
	protected void onPause() {
		super.onPause();
		launchSong.release();
		finish();
	}
}