package br.ufg.inf.muralufg.activity;

import android.app.ActivityManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.ufg.inf.muralufg.R;

public abstract class AbstractBaseActivity extends AppCompatActivity {

    private static Toolbar toolbar;

    public static Toolbar getToolbar() {
        return toolbar;
    }

    public static void setToolbar(Toolbar toolbar) {
        AbstractBaseActivity.toolbar = toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContentView();

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(getToolbar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getApplicationContext().getResources().getColor(R.color.ColorUFGDark));

            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(getString(R.string.app_name), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), getResources().getColor(R.color.ColorUFG));
            this.setTaskDescription(taskDescription);
        }
    }

    protected abstract void setActivityContentView();
}
