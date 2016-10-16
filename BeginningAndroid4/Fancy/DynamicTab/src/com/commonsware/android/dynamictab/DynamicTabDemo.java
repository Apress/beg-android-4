/***
	Copyright (c) 2008-2011 CommonsWare, LLC
	
	Licensed under the Apache License, Version 2.0 (the "License"); you may
	not use this file except in compliance with the License. You may obtain
	a copy of the License at
		http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package com.commonsware.android.dynamictab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TabHost;

public class DynamicTabDemo extends Activity {
	private TabHost tabs=null;
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);

		tabs=(TabHost)findViewById(R.id.tabhost);
		tabs.setup();
		
		TabHost.TabSpec spec=tabs.newTabSpec("buttontab");
		
		spec.setContent(R.id.buttontab);
		spec.setIndicator("Button");
		tabs.addTab(spec);
	}
	
	public void addTab(View v) {
		TabHost.TabSpec spec=tabs.newTabSpec("tag1");
		
		spec.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				return(new AnalogClock(DynamicTabDemo.this));
			}
		});
		
		spec.setIndicator("Clock");
		tabs.addTab(spec);
	}
}
