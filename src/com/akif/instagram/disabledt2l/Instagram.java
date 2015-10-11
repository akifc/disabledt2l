package com.akif.instagram.disabledt2l; 

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import android.view.MotionEvent;


public class Instagram implements IXposedHookLoadPackage {
	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		if (lpparam.packageName.equals("com.instagram.android")) {
			try {
				findAndHookMethod("com.instagram.feed.ui.a.r", lpparam.classLoader, "onDoubleTap", MotionEvent.class, XC_MethodReplacement.returnConstant(true));
		    } catch (Throwable t) { XposedBridge.log(t); }  
			}
		};
}