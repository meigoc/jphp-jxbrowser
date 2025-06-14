package org.develnext.jphp.ext.jxbrowser.engine;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.scene.Node;


import javafx.scene.layout.StackPane;
import org.develnext.jphp.ext.javafx.classes.layout.UXStackPane;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.DoubleMemory;
import php.runtime.memory.StringMemory;
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

    @Reflection.Setter
    public void setZoom(double zoomLvl)
    {
        __wrappedObject.setZoomLevel(zoomLvl);
    }

    @Reflection.Getter
    public double getZoom()
    {
        return  __wrappedObject.getZoomLevel();
    }



    @Reflection.Signature
    public void loadHtml(String html, int i)
    {
        __wrappedObject.loadHTML(i, html);
    }

    @Reflection.Signature
    public void loadHtml(String html)
    {
        __wrappedObject.loadHTML(html);
    }

    @Reflection.Signature
    public void executeJavaScript(String js)
    {
        __wrappedObject.executeJavaScript(js);
    }

    @Reflection.Signature
    public Memory executeJavaScriptAndReturnValue(String js)
    {
        JSValue value = __wrappedObject.executeJavaScriptAndReturnValue(js);
        if (value.isString()){return new StringMemory(value.getStringValue());}
        else if (value.isNumber()){return new DoubleMemory(value.getNumberValue());}
        else if (value.isBoolean()){return value.getBooleanValue() ? Memory.TRUE : Memory.FALSE;}
        else if (value.isNull()){return Memory.NULL;}
        else {throw new IllegalStateException("unsupported or unwrapped return value");}
    }

    @Reflection.Signature
    public void executeJavaScript(long i, String js)
    {
        __wrappedObject.executeJavaScript(i, js);
    }
    @Reflection.Signature
    public void reload() {
        __wrappedObject.reload();
    }

    @Reflection.Signature
    public void reload(boolean ignoreCache) {
        __wrappedObject.reloadIgnoringCache();
    }

    @Reflection.Signature
    public void stop() {
        __wrappedObject.stop();
    }

    @Reflection.Signature
    public void dispose() {
        __wrappedObject.dispose();
    }

    @Reflection.Signature
    public boolean canGoBack() {
        return __wrappedObject.canGoBack();
    }

    @Reflection.Signature
    public boolean canGoForward() {
        return __wrappedObject.canGoForward();
    }

    @Reflection.Signature
    public void goBack() {
        __wrappedObject.goBack();
    }

    @Reflection.Signature
    public void goForward() {
        __wrappedObject.goForward();
    }

    @Reflection.Getter
    public String getTitle() {
        return __wrappedObject.getTitle();
    }

    @Reflection.Getter
    public String getHtml() {
        return __wrappedObject.getHTML();
    }

    @Reflection.Signature
    public void print() {
        __wrappedObject.print();
    }

    @Reflection.Setter
    public void setUserAgent(String userAgent) {
        __wrappedObject.setUserAgent(userAgent);
    }

    @Reflection.Getter
    public String getUserAgent() {
        return __wrappedObject.getUserAgent();
    }

    @Reflection.Signature
    public boolean isLoading() {
        return __wrappedObject.isLoading();
    }

    @Reflection.Signature
    public void setAudioMuted(boolean muted) {
        __wrappedObject.setAudioMuted(muted);
    }

    @Reflection.Signature
    public boolean isAudioMuted() {
        return __wrappedObject.isAudioMuted();
    }



}