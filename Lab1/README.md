## Нужно написать два shell файла:


1. #### Shell файл, который принимает на вход три параметра: 
* ссылку на удаленный репозиторий,
* имя ветки 1,
* имя ветки 2. 

На выходе формирует TXT файл со списком файлов которые отличаются между ветками.


2. #### Написать shell файл, который принимает на вход три параметра START|STOP|STATUS. 
* START запускает его в фоне и выдает PID процесса, 
* STATUS выдает состояние - запущен/нет, 
* STOP - останавливает PID

Сам shell мониторит свободную память в ОС каждые 10 минут, и записывает выходной результат в виде csv файла в формате: 
* timestamp;
*  all_memory;
* free_memory;%usaged