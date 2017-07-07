# PresentationDisplay 双屏显示

MainActivity中：
MainActivity.java
## 主屏

```Java
setContentView(new MainGLSurfaceView(this));
```
## 副屏显示
```Java
PresentationDisplay present_display = createPresentDisplay();
if (present_display != null) present_display.showView();
```
## 创建副屏display
```Java
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
```
## 副屏Glsurfaceview
PresentationDisplay.java
```Java
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
```
