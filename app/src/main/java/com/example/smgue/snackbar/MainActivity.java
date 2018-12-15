package com.example.smgue.snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {

    private FrameLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.myLayout);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        toolbar.setTitle("Basic Components");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.simple_snackbar:
                        showSimpleSnackBar();
                        break;
                    case R.id.snackbar_action_callback:
                        showSnackBarActionCallBack();
                        break;
                    case R.id.custom_snackbar:
                        showSnackBarWithColoredText();
                        break;
                }
                return true;
            }
        });
    }


    /*Simple SnackBar */
    public void showSimpleSnackBar(){
        Snackbar.make(rootLayout, "Simple Snack Bar Example", Snackbar.LENGTH_LONG).show();
    }

    /*SnackBar with action*/
    public void showSnackBarActionCallBack(){

        Snackbar snackbar = Snackbar.make(rootLayout, "File Deleted Successfully", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(rootLayout, "File Recovered Successfully", Snackbar.LENGTH_SHORT).show();
            }
        });

        snackbar.show();
    }

    public void showSnackBarWithColoredText(){

    }
}