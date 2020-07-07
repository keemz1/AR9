package com.mp.ar9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/*DAY*/0);
        setContentView(R.layout.activity_info);

        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.arialogo_about)
                .addItem(new Element().setTitle("ARIA v.1.0"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("akeemyawdie@gmail.com")
                .addPlayStore("com.mp.ar9")
                .addGitHub("sample")
                .addInstagram("sample")
                .create();
        setContentView(aboutPage);
    }

    private void simulateDayNight(int currentSetting) {
        int DAY = 0;
        int NIGHT = 0;
        int FOLLOW_SYSTEM = 3;
        int currentNightmode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightmode != Configuration.UI_MODE_NIGHT_NO){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else if (currentSetting == NIGHT && currentNightmode != Configuration.UI_MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else if (currentSetting == FOLLOW_SYSTEM){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }

    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        @SuppressLint({"StringFormatInvalid","LocalSuppress"})
        final String copyrights = String.format(getString(R.string.app_name), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.arialogo_about);
        copyRightsElement.setAutoApplyIconTint(true);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoActivity.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }
}
