<?php


namespace develnext\bundle\jxbrowserlinuxdependence;


use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;

class JXBrowserLinuxDependence extends AbstractJarBundle{
    function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);
    }
    function onRemove(Project $project, AbstractBundle $owner = null){
        parent::onRemove($project, $owner);
    }

    public function onRegister(IdeLibraryBundleResource $resource)
    {
        parent::onRegister($resource);
    }
}