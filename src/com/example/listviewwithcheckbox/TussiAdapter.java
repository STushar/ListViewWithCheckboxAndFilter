package com.example.listviewwithcheckbox;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

public class TussiAdapter extends BaseAdapter {
	

	 
	public static final String TAG = "TUSSI";
	// ArrayList<SingleRow> list;
	private ArrayList<SingleRow> mOriginalValues = new ArrayList<SingleRow>(); // Original
																				// Values
	private ArrayList<SingleRow> mDisplayedValues = new ArrayList<SingleRow>();
	private ArrayList<SingleRow> tempFilter = new ArrayList<SingleRow>();
	
	Context context;

	// private LayoutInflater inflater;

	TussiAdapter(Context c, ArrayList<SingleRow> list) {

		this.context = c;
		this.mOriginalValues.addAll(list);
		this.mDisplayedValues.addAll(list);
		// inflater = LayoutInflater.from(c);

	}

	private class viewHolder {
		LinearLayout llcontainer;
		CheckBox mycheckbox;
		TextView mytitle;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		viewHolder holder = null;
		SingleRow temp = mDisplayedValues.get(position);

		if (convertView == null) {

			LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.single_row, parent, false);
			holder = new viewHolder();
			// holder.llcontainer = (LinearLayout)
			// convertView.findViewById(R.id.llcontainer);

			holder.mycheckbox = (CheckBox) convertView.findViewById(R.id.checkBox1);
			holder.mytitle = (TextView) convertView.findViewById(R.id.textView1);

			holder.mycheckbox.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					boolean checked = ((CheckBox) v).isChecked();

					SingleRow sr = (SingleRow) v.getTag();
					if (sr == null) {

						Log.d(TAG, "sr is null");
					} else {
 
						Toast.makeText(context, sr.getTitle(), Toast.LENGTH_LONG).show();
					}
					// SingleRow sr = mDisplayedValues.get(position);
					
					// SingleRow sr = mDisplayedValues.get(position);
					if (checked) {
						Log.d("TUSSI", "In if body");
						sr.setSelected(true);
						tempFilter.add(sr);
					} else {
						Log.d("TUSSI", "In else body");
						sr.setSelected(false);
						tempFilter.remove(sr);
					}

					Log.d("TUSSI", "In checkbox listener");
					
					// temp.setSelected(cb.isChecked());
				}
			});

			holder.mycheckbox.setTag(temp);
			convertView.setTag(holder);
		}

		else {

			//return convertView;
			holder = (viewHolder) convertView.getTag();
			holder.mycheckbox.setTag(temp);
		}

		Boolean chkbox = temp.isSelected();
		String title = temp.getTitle();
		Log.d("TUSSI", "1");
		holder.mycheckbox.setChecked(chkbox);
		Log.d("TUSSI", "2");
		holder.mytitle.setText(title);
		Log.d("TUSSI", "3");
		// mycheckbox.setChecked(temp.checkbox);
		// mytitle.setText(temp.title);

		if (tempFilter.size() == 2) {
			
			if (!holder.mycheckbox.isChecked()) {
				holder.mycheckbox.setVisibility(View.INVISIBLE);
			}
			else{
				holder.mycheckbox.setVisibility(View.VISIBLE);
			}
			
		}
		else{
			
			if(!chkbox)
			{
				holder.mycheckbox.setVisibility(View.VISIBLE);
			}
		}
		
		
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDisplayedValues.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mDisplayedValues.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void showFilterItems() {
		Log.d(TAG, "In showFilterItems method");
		ArrayList<SingleRow> filteredData = tempFilter;
		if(filteredData.isEmpty())
		{
			Log.d(TAG, "filteredData is null");
			Toast.makeText(context, "No Item has been selected", Toast.LENGTH_LONG).show();
			mDisplayedValues = mOriginalValues;
			notifyDataSetChanged(); 
		}
		else{
		mDisplayedValues = filteredData;
		notifyDataSetChanged(); 
		}
		
		
	}

	public void showFullList() {
		
		Log.d(TAG, "In  showFullList method");
		mDisplayedValues = mOriginalValues;
		notifyDataSetChanged();
		
	}

	
}