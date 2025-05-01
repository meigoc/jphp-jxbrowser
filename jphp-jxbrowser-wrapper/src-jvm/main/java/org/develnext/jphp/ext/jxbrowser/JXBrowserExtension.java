package org.develnext.jphp.ext.jxbrowser;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import org.develnext.jphp.ext.jxbrowser.engine.JXBrowserEngine;
import org.develnext.jphp.ext.jxbrowser.gui.UXJXBrowser;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class JXBrowserExtension extends Extension {
    public static final String NS = "php\\gui\\jxbrowser";
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }
    
    @Override
    public void onRegister(CompileScope scope){
        registerWrapperClass(scope, BrowserView.class, UXJXBrowser.class);
        registerWrapperClass(scope, Browser.class, JXBrowserEngine.class);
    }

    @Override
    public String[] getPackageNames(){
        return new String[]{"gui", "jxbrowser"};
    }
}