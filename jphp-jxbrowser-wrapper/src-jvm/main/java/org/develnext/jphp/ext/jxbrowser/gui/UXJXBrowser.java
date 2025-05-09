package org.develnext.jphp.ext.jxbrowser.gui;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;


import org.develnext.jphp.ext.javafx.classes.layout.UXStackPane;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Namespace(JXBrowserExtension.NS)
@Reflection.Name("UXJXBrowser")

public class UXJXBrowser extends UXStackPane<BrowserView> {
    public UXJXBrowser(Environment env, BrowserView wrappedObject) {
        super(env, wrappedObject);
    }
    public UXJXBrowser(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    protected Browser engine;

    public BrowserView getWrappedObject(){
        return (BrowserView)super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct(BrowserContextParams jxBrowserSettings){
        BrowserContext context = new BrowserContext(jxBrowserSettings);

        engine = new Browser(context);
        __wrappedObject = new BrowserView(engine);

    }

    @Reflection.Getter
    public Browser getEngine(){return engine;}



}