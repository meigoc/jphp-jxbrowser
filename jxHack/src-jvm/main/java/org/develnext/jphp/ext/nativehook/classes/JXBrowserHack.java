package org.develnext.jphp.ext.nativehook.classes;

import org.develnext.jphp.ext.nativehook.JXHackExtension;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;
import potato.jx.crack.JxBrowserHackUtil;
import potato.jx.crack.JxVersion;

@Namespace(JXHackExtension.NS)
@Name("JXBrowserHack")
public final class JXBrowserHack extends BaseObject{

    public JXBrowserHack(Environment env){
        super(env);
    }
    private JXBrowserHack(ClassEntity entity){
        super(entity);
    }
    public JXBrowserHack(Environment env, ClassEntity clazz){
        super(env, clazz);
    }

    @Signature
    public static void hack()
    {
        JxBrowserHackUtil.hack(JxVersion.V6_24);
    }

}