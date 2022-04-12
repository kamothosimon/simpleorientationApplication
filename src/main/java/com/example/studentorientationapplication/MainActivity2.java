package com.example.studentorientationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        list.add("Library");
        list.add("Admin Block");
        list.add("Innovation centre");
        list.add("Engineering complex(EC)");
        list.add("Tuition Blocks(TB)");
        list.add("Academic Block");
        list.add("Engineering Workshop");
        list.add("Cafeteria");
        list.add("Student Centre");
        list.add("Hostels");
        list.add("Graduation Square");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    //clicked library
                    startActivity(new Intent(MainActivity2.this,libraryact.class));
                }
                else if(i==1){
                    startActivity(new Intent(MainActivity2.this,adminblocks.class));
                    //clicked admin
                }
                else if(i==2){
                    startActivity(new Intent(MainActivity2.this,innovationcentre.class));
                }  else if(i==3){
                    startActivity(new Intent(MainActivity2.this,Engineeringcomplex.class));
                }  else if(i==4){
                    startActivity(new Intent(MainActivity2.this,TutionBlock.class));
                }  else if(i==5){
                    startActivity(new Intent(MainActivity2.this,AcademicBlock.class));
                }  else if(i==6){
                    startActivity(new Intent(MainActivity2.this,Enginneringworkshop.class));
                }  else if(i==7){
                    startActivity(new Intent(MainActivity2.this,cafeteria.class));
                }  else if(i==8){
                    startActivity(new Intent(MainActivity2.this,studentcentre.class));
                } else if(i==9){
                    startActivity(new Intent(MainActivity2.this,Hostels.class));
                } else if(i==10){
                    startActivity(new Intent(MainActivity2.this,GraduationSquare.class));
                }
            }
        });
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                Toast.makeText(getApplicationContext(),"wait a little",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    adapter.getFilter().filter(query);

                }else{
                    Toast.makeText(MainActivity2.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}