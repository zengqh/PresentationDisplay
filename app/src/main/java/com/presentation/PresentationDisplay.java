package com.presentation;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;


/**
 * Created by mansion on 2017/7/7.
 */

public class PresentationDisplay extends Presentation
{
    private GLSurfaceView   gl_view_;
    private Display display_;

    public PresentationDisplay(Context outerContext, Display display)
    {
        super(outerContext, display);
        display_ = display;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gl_view_ = new PresentGLSurfaceView(this.getContext());
        setContentView(gl_view_);
    }

    public void showView()
    {
        this.show();
    }


    public void hideView()
    {
        this.hide();
    }
}
