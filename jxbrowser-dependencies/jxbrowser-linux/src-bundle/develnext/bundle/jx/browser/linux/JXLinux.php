<?php

namespace develnext\bundle\jx\browser\linux;

use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;
use ide\library\IdeLibraryBundleResource;
use ide\project\Project;
use ide\forms\MessageBoxForm;
use ide\Logger;

/**
 * Class JXLinux
 * @package develnext\bundle\jx\browser\linux
 */
class JXLinux extends AbstractJarBundle
{
    /**
     * @param Project $project
     * @param AbstractBundle|null $owner
     */
    public function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);

        $this->logLegalWarning();
        $this->showLicenseWarning();

    }

    /**
     * @param Project $project
     * @param AbstractBundle|null $owner
     */
    public function onRemove(Project $project, AbstractBundle $owner = null){
        parent::onRemove($project, $owner);
    }

    /**
     * @param IdeLibraryBundleResource $resource
     */
    public function onRegister(IdeLibraryBundleResource $resource)
    {
        parent::onRegister($resource);
    }

    protected function showLicenseWarning() {
        $msg = new MessageBoxForm(
            "Linux зависимости JXBrowser требуют лицензии\n\n" .
            "Этот компонент содержит специфичные для Linux библиотеки JXBrowser\n" .
            "Использование без лицензии нарушает соглашение TeamDev",
            ['Продолжить на свой риск', 'Прекратить установку']
        );

        if ($msg->showDialog() && $msg->getResultIndex() == 1) {
            exit;
        }
    }

    protected function logLegalWarning() {
        var_dump("JXBrowser Linux Dependencies - LEGAL NOTICE: " .
            "Linux-specific dependencies for JXBrowser. Requires valid license. " .
            "By using this you agree to JXBrowser License Agreement. " .
            "Details: https://teamdev.com/jxbrowser");
    }
}
