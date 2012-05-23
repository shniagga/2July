package org.cats.menu.activity;

import org.cats.R;
import org.cats.menu.model.IconPreference;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity {
	private static final String SOUND_KEY = "sound";
	private static final String NOTIFICATION_KEY = "notifications";
	private static final String APPLICATION_KEY = "application";

	private static final String SOUND_ACTIVITY_NAME = "org.cats.menu.activity.SOUNDACTIVITY";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		Resources res = getResources();

		IconPreference sound = (IconPreference) findPreference(SOUND_KEY);
		IconPreference notify = (IconPreference) findPreference(NOTIFICATION_KEY);
		IconPreference app = (IconPreference) findPreference(APPLICATION_KEY);

		Drawable soundIcon = res.getDrawable(R.drawable.preferences_ic_sound);
		Drawable notifyIcon = res
				.getDrawable(R.drawable.preferences_ic_setting_app);
		Drawable appIcon = res
				.getDrawable(R.drawable.preferences_ic_setting_notify);

		sound.setIcon(soundIcon);
		notify.setIcon(notifyIcon);
		app.setIcon(appIcon);

		sound.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				Intent soundIntent = new Intent(SOUND_ACTIVITY_NAME);
				startActivity(soundIntent);
				return true;
			}
		});
		notify.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				System.out.println("Hello World");
				return true;
			}
		});
		app.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				System.out.println("Hello World");
				return true;
			}
		});
	}
}
