package org.cats.preferences.activity;

import org.cats.R;
import org.cats.preferences.model.IconPreference;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		Resources res = getResources();

		IconPreference notify = (IconPreference) findPreference("Notifications");
		IconPreference app = (IconPreference) findPreference("Application");

		Drawable notifyIcon = res
				.getDrawable(R.drawable.preferences_ic_setting_app);
		Drawable appIcon = res
				.getDrawable(R.drawable.preferences_ic_setting_notify);

		notify.setIcon(notifyIcon);
		app.setIcon(appIcon);

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
