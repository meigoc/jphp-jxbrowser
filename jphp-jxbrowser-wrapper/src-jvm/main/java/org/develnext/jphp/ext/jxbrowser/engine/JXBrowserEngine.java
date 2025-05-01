package org.develnext.jphp.ext.jxbrowser.engine;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.scene.Node;


import javafx.scene.layout.StackPane;
import org.develnext.jphp.ext.javafx.classes.layout.UXStackPane;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.UUID;

@Reflection.Namespace(JXBrowserExtension.NS + "\\engine")
@Reflection.Name("JXBrowserEngine")
public class JXBrowserEngine extends BaseWrapper<Browser>{

    public JXBrowserEngine(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
    public JXBrowserEngine(Environment env, Browser wrappedObject) {
        super(env, wrappedObject);
    }

    public Browser getWrappedObject(){
        return super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new Browser();
    }

    @Reflection.Getter
    public String getUrl()
    {
        return __wrappedObject.getURL();
    }

    @Reflection.Setter
    public void setUrl(String urlSet)
    {
        __wrappedObject.loadURL(urlSet);
    }

}