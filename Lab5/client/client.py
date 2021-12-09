#!/usr/bin/env python3

# Импортируем системную библиотеку Python.
# Она используется для загрузки файла 'index.html' с сервера.
# Ничего особенного устанавливать не нужно, эта библиотека устанавливается вместе с Python.

import urllib.request
import time

# Эта переменная содержит запрос к 'http://localhost:1234/'.
# Возможно, сейчас вы задаётесь вопросом о том, что такое 'http://localhost:1234'.
# localhost указывает на то, что программа работает с локальным сервером.
# 1234 - это номер порта, который вам предлагалось запомнить при настройке серверного кода.
for _ in range(100):
    fp = urllib.request.urlopen("http://localhost:1234/")

    # 'encodedContent' соответствует закодированному ответу сервера ('index.html').
    # 'decodedContent' соответствует раскодированному ответу сервера (тут будет то, что мы хотим вывести на экран).

    encodedContent = fp.read()
    decodedContent = encodedContent.decode("utf8")

    # Выводим содержимое файла, полученного с сервера ('index.html').

    print(decodedContent)

    # Закрываем соединение с сервером.

    fp.close()
    time.sleep(60)
