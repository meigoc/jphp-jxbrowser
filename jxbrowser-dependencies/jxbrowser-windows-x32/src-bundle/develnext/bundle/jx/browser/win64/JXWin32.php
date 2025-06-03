<?php

namespace develnext\bundle\jx\browser\win64;

use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;
use ide\library\IdeLibraryBundleResource;
use ide\project\Project;
use ide\forms\MessageBoxForm;
use ide\Logger;

/**
 * Class JXWin32
 * @package develnext\bundle\jx\browser\win32
 */
class JXWin32 extends AbstractJarBundle
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
            "WindowsX32 зависимости JXBrowser требуют лицензии\n\n" .
            "Используя этот компонент, вы подтверждаете что:\n" .
            "1. Имеете действующую лицензию JXBrowser\n" .
            "2. Используете компонент в соответствии с лицензионным соглашением\n" .
            "3. Осознаете юридические последствия нарушений",
            ['Я подтверждаю наличие лицензии', 'Отмена']
        );

        if ($msg->showDialog() && $msg->getResultIndex() == 1) {
            exit;
        }
    }

    protected function logLegalWarning() {
        var_dump("JXBrowser Windows32 Dependencies - LEGAL NOTICE: " .
            "This bundle provides only Windows-specific dependencies for JXBrowser. " .
            "You must have a valid JXBrowser license to use it in production. " .
            "More info: https://teamdev.com/jxbrowser-licence-agreement");
    }
}
