package org.cats;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class LaunchActivity extends Activity {
	private final static int LAUNCH_TIME = 3000; // miliseconds
	private MediaPlayer launchSong;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch);
		launchSong = MediaPlayer.create(LaunchActivity.this, R.raw.background);
		launchSong.start();

		Thread timer = new Thread() {
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
		timer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		launchSong.release();
		finish();
	}
}