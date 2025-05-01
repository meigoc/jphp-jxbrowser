# jxbrowser-wrapper-jphp

Обёртка над [JxBrowser 6.24.3](https://www.teamdev.com/jxbrowser) для использования в проектах на JPHP через JPPM.

## Описание

Пакет позволяет быстро интегрировать компонент браузера JxBrowser в ваши GUI-приложения на JPHP. После установки через JPPM достаточно создать форму и добавить в неё `UXJXBrowser` — обёртку над JxBrowser.

## Требования 
- JPPM  OR DevelNext 16
- Java 8+  

## Как использовать?
```php
<?php
// Создаём форму
$form = new \php\gui\UXForm(); //<----- пример под jphp(jppm)
$form->title = 'JXBrowser test';
$form->show();

// Создаём и настраиваем браузер
$browserJX = new \php\gui\jxbrowser\UXJXBrowser();
$browserJX->engine->url     = 'https://html5test.com/';
$browserJX->size            = [800, 600];
$browserJX->leftAnchor      = 0;
$browserJX->topAnchor       = 0;
$browserJX->rightAnchor     = 0;
$browserJX->bottomAnchor    = 0;

// Добавляем браузер в форму
$form->add($browserJX);
</code>
```
