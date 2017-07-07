package com.presentation;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;


/**
 * Created by mansion on 2017/7/7.
 */

public class PresentationDisplay extends Presentation
{
    private GLSurfaceView   gl_view_;
    private Display display_;
    private View view_;

    public PresentationDisplay(Context outerContext, Display display)
    {
        super(outerContext, display);
        display_ = display;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view_);
    }

    public void showView(View view)
    {
        view_ = view;

        this.show();
    }


    public void hideView()
    {
        this.hide();
    }
}
