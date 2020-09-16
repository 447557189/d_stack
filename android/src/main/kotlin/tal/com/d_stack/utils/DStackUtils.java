package tal.com.d_stack.utils;

import android.app.Activity;

import java.lang.reflect.Field;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import tal.com.d_stack.DStack;

/**
 * 框架常用工具类
 * 包括获取flutterView示例和重新attach引擎功能
 */
public class DStackUtils {

    /**
     * 通过传入的FlutterActivity获取对应的FlutterView
     */
    public static FlutterView getFlutterView(Activity activity) {
        if (activity == null) {
            return null;
        }
        FlutterActivity flutterActivity = null;
        FlutterView flutterView = null;
        if (activity instanceof FlutterActivity) {
            flutterActivity = (FlutterActivity) activity;
        }
        if (flutterActivity == null) {
            return null;
        }
        try {
            Field fieldDelegate = (flutterActivity).getClass().getSuperclass().getDeclaredField("delegate");
            fieldDelegate.setAccessible(true);
            Object objectDelegate = fieldDelegate.get(flutterActivity);
            Field flutterViewDelegate = objectDelegate.getClass().getDeclaredField("flutterView");
            flutterViewDelegate.setAccessible(true);
            flutterView = (FlutterView) flutterViewDelegate.get(objectDelegate);
        } catch (Exception e) {
            DLog.logE(e.getMessage());
        } finally {
            return flutterView;
        }
    }

    /**
     * 重新绑定当前flutterView对应的flutter引擎
     */
    public static void resetAttachEngine(FlutterView flutterView) {
        if (flutterView == null) {
            return;
        }
        FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(DStack.ENGINE_ID);
        if (flutterEngine == null) {
            return;
        }
        flutterView.detachFromFlutterEngine();
        flutterView.attachToFlutterEngine(flutterEngine);
    }
}