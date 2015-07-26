package com.example.listviewwithcheckbox;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView listV;
	Button bttnChecked;
	Button bttnAll;
	String[] titles;
	
	TussiAdapter adapter;
	
	ArrayList<SingleRow> list;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        Resources res = getResources();	
		 list = new ArrayList<SingleRow>();
		 
		 titles = res.getStringArray(R.array.title);
		// String[] checkboxes = res.getStringArray(R.array.checkbox);
		 
		 for (int i = 0; i < 10; i++) {
			 
			 list.add(new SingleRow(titles[i], false));
			 
			
		}
        
        listV = (ListView) findViewById(R.id.listView1);
        bttnChecked = (Button) findViewById(R.id.button1);
        bttnAll = (Button) findViewById(R.id.button2);
        adapter = new TussiAdapter(this, list);
        listV.setAdapter(adapter);
        
        
        listV.setOnItemClickListener(new OnItemClickListener() {
        	   public void onItemClick(AdapterView<?> parent, View view,
        	     int position, long id) {
        	    // When clicked, show a toast with the TextView text
        	    SingleRow sr = (SingleRow) parent.getItemAtPosition(position);
        	    Toast.makeText(getApplicationContext(),
        	      "Clicked on Row: " + sr.getTitle(), 
        	      Toast.LENGTH_LONG).show();
        	   }
        	  });
        
       
        
        
    }   
    
    
    public void showFilteredItems(View v)
	{
		//Toast.makeText(, "Clicked on Row: ",Toast.LENGTH_LONG).show();
		  Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
		  adapter.showFilterItems();
	}
    
    public void showAll(View v)
    {
    	adapter.showFullList();
    }
	
    
}




