<?php
namespace php\gui\jxbrowser\engine\settings;

final class JXBrowserSettings {

    /**
     * @var string
     */
    public $acceptLanguage;

    /**
     * @var string
     * @readonly
     */
    public $dataDir;

    /**
    * @var string
    */
    public $сacheDataDir;

    /**
    * @var string
    */
    public $memoryDir;

    /**
    * Устанавливает, как будет отображаться браузер. УСТАНОВИМ МОЖНО ДО ИНИЦИАЛИЗАЦИИ UXJXBrowser!
    * @var bool
    */
    public $useLightweightRendering;


     /**
      * $dataDir -> папка где будет распакова браузер
      * @param string $dataDir КЭШ
      * @param string $acceptLanguage
      */
    public function __construct( string $dataDir,  string $acceptLanguage = null)
    {
    }


}