package org.cats.launch;

import org.cats.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class LaunchActivity extends Activity {
	private final static int LAUNCH_TIME = 5000; // miliseconds
	private final static int MAX_PERCENT = 100;
	private final static int QUARTER_SECOND = 250;
	private MediaPlayer launchSong;
	private ProgressDialog progressBar;
	private int progressBarStatus;
	private Handler progressBarHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch_layout);
		createComponents();
		createMusicThread().start();
		createProgressThread().start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		launchSong.release();
		finish();
	}

	private void createComponents() {
		launchSong = MediaPlayer.create(LaunchActivity.this, R.raw.background);
		launchSong.start();

		View launchView = this.findViewById(android.R.id.content).getRootView();
		progressBar = new ProgressDialog(launchView.getContext());
		progressBar.setCancelable(true);
		progressBar.setMessage("Game downloading...");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.show();
		progressBarStatus = 0;
		progressBarHandler = new Handler();
	}

	private Thread createMusicThread() {
		Thread sleeper = new Thread() {
			@Override
			public void run() {
				try {
					sleep(LAUNCH_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		return sleeper;
	}

	private Thread createProgressThread() {
		Thread progress = new Thread() {
			@Override
			public void run() {
				while (progressBarStatus < MAX_PERCENT) {
					progressBarStatus++;
					try {
						Thread.sleep(LAUNCH_TIME / 100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progressBarHandler.post(new Runnable() {
						public void run() {
							progressBar.setProgress(progressBarStatus);
						}
					});
				}
				if (progressBarStatus == MAX_PERCENT) {
					try {
						Thread.sleep(QUARTER_SECOND);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						progressBar.dismiss();
						Intent dashboardMenuActivity = new Intent(
								"org.cats.dashboard.DASHBOARDDESINGACTIVITY");
						startActivity(dashboardMenuActivity);
					}

				}
			}
		};
		return progress;
	}
}