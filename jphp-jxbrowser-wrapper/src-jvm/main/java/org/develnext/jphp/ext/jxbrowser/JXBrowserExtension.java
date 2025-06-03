package org.develnext.jphp.ext.jxbrowser;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.scene.control.ContextMenu;
import org.develnext.jphp.ext.javafx.classes.UXContextMenu;
import org.develnext.jphp.ext.jxbrowser.engine.JXBrowserEngine;
import org.develnext.jphp.ext.jxbrowser.engine.settings.JXBrowserSettings;
import org.develnext.jphp.ext.jxbrowser.gui.UXJXBrowser;
import org.develnext.jphp.ext.jxbrowser.gui.menu.CustomContextMenu;
import org.develnext.jphp.ext.jxbrowser.gui.menu.JXBrowserContextMenuManager;
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
        registerWrapperClass(scope, ContextMenu.class, CustomContextMenu.class);
        registerClass(scope, JXBrowserSettings.class, JXBrowserContextMenuManager.class);

    }
}