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

package com.commonsware.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LaunchDemo extends Activity {
	private EditText lat;
	private EditText lon;
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		
		lat=(EditText)findViewById(R.id.lat);
		lon=(EditText)findViewById(R.id.lon);
	}
	
	public void showMe(View v) {
		String _lat=lat.getText().toString();
		String _lon=lon.getText().toString();
		Uri uri=Uri.parse("geo:"+_lat+","+_lon);
		
		startActivity(new Intent(Intent.ACTION_VIEW, uri));
	}
}