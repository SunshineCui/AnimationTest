package com.example.billy.animationtest;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

import com.example.billy.animationtest.databinding.ActivityMain1Binding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintSet constraintSet1;
    private ConstraintSet constraintSet2;
    ConstraintLayout constraintLayout;
    boolean old = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main1);
        constraintLayout = (ConstraintLayout) binding.getRoot();
        constraintSet1 = new ConstraintSet();
//        constraintSet1.clone(constraintLayout);
        constraintSet1.clone(this,R.layout.activity_main3);
        constraintSet2 = new ConstraintSet();
        constraintSet2.clone(this,R.layout.activity_main2);
        binding.setOnClick(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        if (old = !old){
            constraintSet1.applyTo(constraintLayout);
        }else{
            constraintSet2.applyTo(constraintLayout);
        }
    }
}
