package org.cats.menu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.cats.menu.service.MenuItemFactory;
import org.cats.R;

import android.app.Activity;
import android.content.Intent;

public class MenuItemFactoryImpl implements MenuItemFactory {
	private final static Map<Integer, Intent> intentMap = new HashMap<Integer, Intent>();

	public MenuItemFactoryImpl() {
		intentMap.put(R.id.aboutUs, new Intent());
		intentMap.put(R.id.preferences, new Intent(
				"org.cats.menu.activity.PREFERENCEACTIVITY"));
		intentMap.put(R.id.exit, null);
	}

	@Override
	public void launchItemIntent(int id, Activity activity) {
		Intent resultIntent = intentMap.get(id);
		if (resultIntent != null) {
			activity.startActivity(resultIntent);
		} else {
			activity.finish();
		}

	}

}
