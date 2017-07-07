package com.presentation;

import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 主屏
        setContentView(new MainGLSurfaceView(this));



        // 副屏显示
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.present_layout, null);
        PresentationDisplay present_display = createPresentDisplay();
        if (present_display != null) present_display.showView(view);
    }

    private PresentationDisplay createPresentDisplay() {
        DisplayManager display_mgr = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        Display[] displays = display_mgr.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);

        if (displays != null && displays.length > 0) {
            PresentationDisplay present_display = new PresentationDisplay(getApplicationContext(), displays[0]);
            present_display.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);

            return present_display;
        }

        return null;
    }
}
