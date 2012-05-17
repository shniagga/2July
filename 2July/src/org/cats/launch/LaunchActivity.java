package org.cats.launch;

import org.cats.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class LaunchActivity extends Activity {
	private final static int LAUNCH_TIME = 7000; // miliseconds
	private LaunchProgressBarView progressBarView;
	private MediaPlayer launchSong;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch_layout);
		progressBarView = (LaunchProgressBarView) findViewById(R.id.launch_progress_bar);
		progressBarView.setValue(0);
		launchSong = MediaPlayer.create(LaunchActivity.this, R.raw.background);
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
		sleeper.start();

	}

	@Override
	protected void onPause() {
		super.onPause();
		launchSong.release();
		finish();
	}
}