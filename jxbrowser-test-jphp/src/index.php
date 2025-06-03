<?php

use php\gui\UXApplication;
use php\gui\jxbrowser\engine\settings\JXBrowserSettings;
use php\gui\jxbrowser\UXJXBrowser;
use php\gui\UXMenuItem;


$url = 'https://music.yandex.ru/';

function createItemReload(UXJXBrowser $browser) : \php\gui\UXMenuItem
{
    $menuItem = new UXMenuItem();
    $menuItem->text = 'Перезагрузить страницу';
    $menuItem->on("Action", function (\php\gui\event\UXEvent $event)use($browser) {
        $browser->engine->reload();
        $browser->contextMenuManager->addContextMenuItem(createItemPutUpStarGit($browser->engine));

    });

    return $menuItem;
}

function createItemPutUpStarGit(\php\gui\jxbrowser\engine\JXBrowserEngine $engine)
{
    $menuItem = new UXMenuItem();
    $menuItem->text = 'Поставить звезду на GitHub';
    $menuItem->on("Action", function (\php\gui\event\UXEvent $event)use($engine) {
        browse('https://github.com/EvoDevelopers-inc/jphp-jxbrowser');
    });

    return $menuItem;
}

function createItemAddZoom(\php\gui\jxbrowser\engine\JXBrowserEngine $engine)
{
    $menuItem = new UXMenuItem();
    $menuItem->text = 'Увеличивает zoom +1';
    $menuItem->on("Action", function (\php\gui\event\UXEvent $event)use($engine) {
        $engine->zoom = $engine->zoom + 1;
    });

    return $menuItem;
}

function createItemMinusZoom(\php\gui\jxbrowser\engine\JXBrowserEngine $engine)
{
    $menuItem = new UXMenuItem();
    $menuItem->text = 'Уменьшает zoom -1';
    $menuItem->on("Action", function (\php\gui\event\UXEvent $event)use($engine) {
        $engine->zoom = $engine->zoom - 1;
    });

    return $menuItem;
}

function addAllItemsMenu(UXJXBrowser $browserJX)
{
    $browserJX->contextMenuManager->addContextMenuItem(createItemReload($browserJX));
    $browserJX->contextMenuManager->addContextMenuItem(createItemAddZoom($browserJX->engine));
    $browserJX->contextMenuManager->addContextMenuItem(createItemMinusZoom($browserJX->engine));
}

function addEvents(UXJXBrowser $browserJX)
{
    $iDoShow = 0;
    $iShow = 0;

    $browserJX->contextMenuManager->setOnDoShowContextMenu(function ()use(&$iDoShow){
        $iDoShow++;
        var_dump("DO SHOW EVENTS CLICK CONTEXT MENU OPEN: ". $iDoShow);
    });

    $browserJX->contextMenuManager->setOnShowContextMenu(function ()use(&$iShow){
        $iShow++;
        var_dump("SHOW EVENTS CLICK CONTEXT MENU OPEN: ".$iShow);
    });

}

UXApplication::launch(function ()use(&$url) {
    
    teamDev\jxbrowser\hack\JXBrowserHack::hack(); // Initialize JXBrowser Hack
    $form = new \php\gui\UXForm();
    $form->title = 'JXBrowser test';
    $form->show();


    $settingsBrowserJX = new JXBrowserSettings("/tmp/browser/".time());

    $browserJX = new UXJXBrowser();

    $browserJX->initBrowser($settingsBrowserJX);
    $browserJX->engine->url = $url;
    $browserJX->size = [800, 600];
    $browserJX->rightAnchor = 0;
    $browserJX->bottomAnchor = 0;
    $browserJX->leftAnchor = 0;
    $browserJX->topAnchor = 30;

    addAllItemsMenu($browserJX); // NEW API
    addEvents($browserJX);

    $form->add($browserJX);

    $searchEdit = new \php\gui\UXTextField();
    $searchEdit->leftAnchor = 0;
    $searchEdit->rightAnchor = 0;
    $searchEdit->height = 30;
    $searchEdit->text = $url;
    $searchEdit->on("KeyDown", function (\php\gui\event\UXKeyEvent $event)use($searchEdit, $browserJX) {

        if ($event->codeName == 'Enter'){
            $url = $searchEdit->text;
            $browserJX->engine->url = $url;
        }
    });
    $form->add($searchEdit);

});


