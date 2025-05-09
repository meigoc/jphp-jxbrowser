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
      * $dataDir -> папка где будет распакова браузер
      * @param string $dataDir КЭШ
      */
    public function __construct(String dataDir)
    {
    }

     /**
      * $dataDir -> папка где будет распакова браузер
      * @param string $dataDir КЭШ
      * @param string $acceptLanguage
      */
    public function __construct(String dataDir, String acceptLanguage)
    {
    }
}