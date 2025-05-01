package org.develnext.jphp.ext.jxbrowser.gui;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.scene.Node;


import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.develnext.jphp.ext.javafx.classes.layout.UXStackPane;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import org.omg.CORBA.PUBLIC_MEMBER;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import java.util.UUID;

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
    public void __construct(){
        BrowserContext context = new BrowserContext(
                new BrowserContextParams("tmp/browser/" + UUID.randomUUID())
        );

        engine = new Browser(context);
        __wrappedObject = new BrowserView(engine);

    }

    @Reflection.Getter
    public Browser getEngine(){return engine;}



}