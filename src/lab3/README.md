## Zadanie 1.

Proszę utworzyć program który obliczy średnią arytmetyczną liczb całkowitych przekazanych przez użytkownika.

Nazwa Klasy: `ArithmeticMean`

Uwaga:

Proszę zapoznać się z metodami klasy `Integer`.

Nie potrzeba wprowadzać jawnej obsługi błędów.

Wykorzystujemy dzielenie całkowite.

Warto przypomnieć sobie użycie operatora trójargumentowego i z niego skorzystać.

Tekst powinien wyglądać tak jak poniżej dla wywołania: `java ArithmeticMean`

```
Brak argumentów programu.
```
---
W przypadku wywołania: `java ArithmeticMean -313`

```
Przekazano tylko jedną wartość: -313
```
---
W przypadku wywołania: `java ArithmeticMean 2 3 5 2`

```
Średnia arytmetyczna liczb: 2, 3, 5, 2 wynosi 3
```
---
Zaś w przypadku: `java ArithmeticMean 2 3 5 3`

```
Średnia arytmetyczna liczb: 2, 3, 5, 3 wynosi 3, reszta: 1
```


## Zadanie 2.

Proszę w oparciu o poprzedni program napisać nowy który wyliczy sumę oraz średnią arytmetyczną liczb zmiennoprzecinkowych przekazanych przez użytkownika. Przy wypisywaniu liczb stosujemy zaokrąglenie do 3 miejsca po przecinku a przy wypisywaniu średniej do 4 miejsca.

Nazwa Klasy: `FloatArithmeticMean

Uwaga:

Proszę zapoznać się z metodami klasy `Float` oraz `String` oraz metodami podobnymi do `println` (`print`, `printf`).

Użyj tych, które wydadzą Ci się właściwe.

Nie potrzeba wprowadzać jawnej obsługi błędów.

Tekst powinien wyglądać tak jak poniżej dla wywołania: `java FloatArithmeticMean`
```
Brak argumentów programu.
```
---
Zaś tak w tym przypadku: `java FloatArithmeticMean 2 3.1234 25.2339 12.5 100`

```
     2.000

     3.123

    25.234

    12.500

   100.000

----------

   142.857
   
Średnia arytmetyczna: 28.5715
```


## Zadanie 3.

Utwórz stosowną klasę (konstruktor, pola), która będzie przechowywać informację o utworzonych obiektach klasy, a każdy obiekt będzie zawierał swój unikalny (kolejny) numer oraz informację o czasie kiedy obiekt został utworzony w ms. (W celu uzyskania czasu w ms skorzystaj z metod dostępnych w klasie System).

Następnie w tej samej klasie zrealizuj testowanie wprowadzonej funkcjonalności.

Nie wprowadzamy żadnych dodatkowych struktur danych jak tablice, zbiory, czy listy.

Program powinien pobrać z linii poleceń liczbę obiektów które mają zostać utworzone.

Nazwa Klasy: `TestClass`

Uwaga:

Nie potrzeba wprowadzać jawnej obsługi błędów.

Pola tylko prywatne a konstruktor ma być bezparametrowy.

Wypisywanie danych dot. obiektu można zrobić w konstruktorze, jednak znacznie lepiej będzie zrobić w metodzie main zaś w klasie `TestClass` przeciążyć metodę `toString()`.

Jeśli potrzebny dostęp do pól to stosujemy metody (tzw. getter/setter)

Tekst powinien wyglądać tak jak poniżej dla wywołania: `java TestClass`

```
Brak argumentów programu.
```
---
Zaś inaczej w tym przypadku: `java TestClass 3`
```
1. [1665566655857]
2. [1665566655858]
3. [1665566655858]

Liczba obiektów: 3
```
