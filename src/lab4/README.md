## Zadanie 1.

Po zapoznaniu się z klasami do obsługi strumieni wejścia i wyjścia (w szczególności `FileReader`) wykonaj program który zliczy liczbę wierszy, w którego pliku nazwa została przekazana w linii poleceń.

Nazwa Klasy: `LineCounter`

Uwaga:

Proszę wprowadzić jawną obsługę błędów (łapanie wyjątków).

Tekst powinien wyglądać tak jak poniżej dla wywołania: `java LineCounter`

```
Brak argumentów programu.
```
---
Zaś inaczej w tym przypadku: `java LineCounter abc.txt`
```
Liczba wierszy w pliku abc.txt wynosi: 127
```


## Zadanie 2.

Proszę na podstawie poprzedniego programu napisać nowy, który tym razem odbierze informacje o pliku korzystając z klasy: `JOptionPane`.

Nazwa Klasy: `LineCounterPane`


## Zadanie 3.

Utwórz program, który będzie kopiował dany plik. W przypadku braku parametrów lub błędnych nazw plików wyświetli stosowny komunikat.

Nazwa Klasy: `FileCopy`

Uwaga:

Proszę wprowadzić jawną obsługę błędów (łapanie wyjątków).

Tekst powinien wyglądać tak jak poniżej dla wywołania: `java FileCopy`
```
Brak argumentów programu.
Użycie: java FileCopy source_file destination
```
---
Zaś inaczej w tym przypadku: `java FileCopy abc.txt cde.txt`

Jeśli kopiowanie powiodło się, to nie pojawia się żaden tekst na konsoli.

Jeśli miejscem docelowym jest katalog to w nim utworzymy kopię naszego pliku.

Plik niekoniecznie jest tekstowy.

Inne możliwe komunikaty:

- Plik abc.txt nie istnieje.

- Plik abc.txt jest katalogiem.

- Brak dostępu do pliku abc.txt

- Nie można nadpisać pliku cde.txt

- Brak wymaganych uprawnień do zapisu pliku cde.txt

- Brak wymaganych uprawnień do katalogu cde.txt


## Zadanie 4.

Proszę rozwinąć zadanie 1 o dodanie opcji.

W zależności od opcji program będzie zliczał nie tylko wiersze, ale i słowa oraz znaki.

Nazwa Klasy: `WordCounter`

Uwaga:

Proszę wprowadzić jawną obsługę błędów (łapanie wyjątków).

Tekst powinien wyglądać tak jak poniżej dla wywołania: `java WordCounter`

```
Brak argumentów programu.
```
---
W przypadku: `java WordCounter abc.txt`
```
wierszy: 127
znaków: 23452
słów: 567
```
---
W przypadku: `java WordCounter -lc abc.txt`
```
wierszy: 127
znaków: 23452
```
---
W przypadku: `java WordCounter -l -c abc.txt`
```
wierszy: 127
znaków: 23452
```
---
W przypadku: `java WordCounter -lcw abc.txt`
```
wierszy: 127
znaków: 23452
słów: 567
```
---
W przypadku: `java WordCounter -cl -w abc.txt`
```
wierszy: 127
znaków: 23452
słów: 567
```
---
W przypadku: `java WordCounter abc.txt -l -w -c`
```
wierszy: 127
znaków: 23452
słów: 567
```
---
W przypadku: `java WordCounter abc.txt -w -c`
```
znaków: 23452
słów: 567
```
---
W przypadku: `java WordCounter abc.txt -wc`
```
znaków: 23452
słów: 567
```
---
W przypadku: `java WordCounter abc.txt -cw`
```
znaków: 23452
słów: 567
```


## Zadanie 5.

Proszę rozwinąć zadanie 3 o dodanie możliwości kopiowania danego URL.

W zależności od opcji program będzie zliczał nie tylko wiersze, ale i słowa oraz znaki.

Nazwa Klasy: `FileAndURLCopy`

Uwaga:

Proszę wprowadzić jawną obsługę błędów (łapanie wyjątków).

Wspieramy wszystkie poprzednie komunikaty, przy czym dodajemy możliwość wywołania:

`java FileCopy http://www.agh.edu.pl/index.html`

`java FileCopy http://www.agh.edu.pl`

W powyższych przypadkach zapisujemy plik pod odpwiednią nazwą w obecnym katalogu.

Rozszerzamy komunikaty o:

- Podany adres: 'http://www.agh.edu.pl' jest nieprawidłowy.
- Brak dostępu do 'http://www.agh.edu.pl'.
- Brak połączenia sieciowego.

Można dodać własne komunikaty (timeout).