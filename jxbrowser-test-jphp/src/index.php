<?php

use php\gui\UXApplication;

UXApplication::launch(function () {
    
    teamDev\jxbrowser\hack\JXBrowserHack::hack(); // Initialize JXBrowser Hack
    $form = new \php\gui\UXForm();
    $form->title = 'JXBrowser test';
    $form->show();

    $browserJX = new \php\gui\jxbrowser\UXJXBrowser();
    $browserJX->engine->url = 'https://html5test.co/';
    $browserJX->size = [800, 600];
    $browserJX->rightAnchor = 0;
    $browserJX->bottomAnchor = 0;
    $browserJX->leftAnchor = 0;
    $browserJX->topAnchor = 0;

    $form->add($browserJX);


});