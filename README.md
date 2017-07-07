# PresentationDisplay 双屏显示

MainActivity中：

##主屏

```Java
setContentView(new MainGLSurfaceView(this));
```
##副屏显示
```Java
PresentationDisplay present_display = createPresentDisplay();
if (present_display != null) present_display.showView();
```
##创建副屏display
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
