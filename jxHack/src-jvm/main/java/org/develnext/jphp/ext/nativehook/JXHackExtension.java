package org.develnext.jphp.ext.nativehook;


import org.develnext.jphp.ext.nativehook.classes.JXBrowserHack;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class JXHackExtension extends Extension{
	public static final String NS = "teamDev\\jxbrowser\\hack";

	@Override
	public Status getStatus(){
		return Status.EXPERIMENTAL;
	}

	@Override
	public void onRegister(CompileScope scope){
		registerClass(scope, JXBrowserHack.class);
	}
}