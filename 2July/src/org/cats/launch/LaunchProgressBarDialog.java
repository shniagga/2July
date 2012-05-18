package org.cats.launch;

import android.app.ProgressDialog;
import android.os.Handler;
import android.view.View;

public class LaunchProgressBarDialog implements Runnable {
	private final static int MAX_PERCENT = 100;
	private final static int ONE_SECOND = 1000;
	private final int LAUNCH_TIME;
	private ProgressDialog progressBar;
	private int progressBarStatus;
	private Handler progressBarHandler;

	public LaunchProgressBarDialog(View view, int launchTime) {
		LAUNCH_TIME = launchTime;
		progressBar = new ProgressDialog(view.getContext());
		progressBar.setCancelable(true);
		progressBar.setMessage("Game downloading...");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.show();
		progressBarStatus = 0;
		progressBarHandler = new Handler();
	}

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
				Thread.sleep(ONE_SECOND);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progressBar.dismiss();
		}

	}

}
