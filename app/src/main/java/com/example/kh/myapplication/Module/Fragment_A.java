package com.example.kh.myapplication.Module;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kh.myapplication.R;

/**
 * Created by kh on 5/9/2017.
 */

public class Fragment_A extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("a","attach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("a","Start");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("a","Resumme");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("a","Pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("a","Stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("a","Destoy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("a","Detach");
    }
}
