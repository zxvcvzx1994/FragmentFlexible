package com.example.kh.myapplication;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.kh.myapplication.Module.Fragment_A;
import com.example.kh.myapplication.Module.Fragment_B;

public class MainActivity extends AppCompatActivity {
    android.app.FragmentManager manager  ;
    FragmentTransaction transaction;
    Fragment_A fragment_a =null;
    Fragment_B  fragment_b  =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void process(View view) {
        switch (view.getId()) {
            case R.id.btnAddA:
                manager = getFragmentManager();
                 fragment_a = new Fragment_A();
                 transaction = manager.beginTransaction();
                transaction.add(R.id.group, fragment_a, "A");
                transaction.commit();
                break;
            case R.id.btnAddB:
                manager  =getFragmentManager();
                 fragment_b = new Fragment_B();
                 transaction = manager.beginTransaction();
                transaction.add(R.id.group, fragment_b, "B");
                transaction.commit();

                break;
            case R.id.btnRemoveA:
            try {
                 fragment_a = (Fragment_A) manager.findFragmentByTag("A");

            }catch (Exception e)
            {
                transaction= null;
            }
            manager = getFragmentManager();
                transaction = manager.beginTransaction();

                if (fragment_a != null) {
                    transaction.remove(fragment_a);
                    transaction.commit();
                    Toast.makeText(this, "The Fragment A was removed", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "The Fragment A was not Add before", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnRemoveB:
                try{
                    fragment_b  = (Fragment_B) manager.findFragmentByTag("B");

                }catch (Exception e){
                    transaction=null;
                }
                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                if(fragment_b!=null){
                    transaction.remove(fragment_b);
                    transaction.commit();

                    Toast.makeText(this, "The Fragment B is removed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "The Fragment B was not Add before", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnReplaceB:

                fragment_b  =new Fragment_B();
                try {
                    fragment_a = (Fragment_A) manager.findFragmentByTag("A");
                }catch (Exception e){

                }
                    transaction = manager.beginTransaction();


                        Fragment_B condition;

                             condition = (Fragment_B) manager.findFragmentByTag("B");


                        if(condition==null) {
                            transaction.replace(R.id.group, fragment_b, "B");

                            transaction.commit();
                        }else{
                            Toast.makeText(this, "Fragment B is existed", Toast.LENGTH_SHORT).show();
                        }



                break;
            case R.id.btnReplaceA:
                try {
                    fragment_b = (Fragment_B) manager.findFragmentByTag("B");
                }catch (Exception e){

                }
                    fragment_a = new Fragment_A();
                    transaction = manager.beginTransaction();

                        Fragment_A condition1  = (Fragment_A) manager.findFragmentByTag("A");
                        if(condition1==null) {
                            transaction.replace(R.id.group, fragment_a, "A");

                            transaction.commit();
                        }else{
                            Toast.makeText(this, "Fragment A is existed", Toast.LENGTH_SHORT).show();
                        }


                break;
            case R.id.btnAttach:
                fragment_a  = (Fragment_A) manager.findFragmentByTag("A");
                transaction  = manager.beginTransaction();
                if(fragment_a!=null){
                    transaction.attach(fragment_a);
                    transaction.commit();
                }
                break;
            case R.id.btnDeTach:
                fragment_a = (Fragment_A) manager.findFragmentByTag("A");
                transaction  =manager.beginTransaction();
                if(fragment_a!=null){
                    transaction.detach(fragment_a);
                    transaction.commit();
                }
                break;
        }
    }

}
