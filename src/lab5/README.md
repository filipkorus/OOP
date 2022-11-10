## Zadanie 1.

Po zapoznaniu się z klasą `Scanner` napisz program, który narysuje kwadrat-jak na zrzucie ekranu poniżej.

Nazwa Klasy: `DrawSquare`

**Uwaga**:

Proszę wprowadzić jawną obsługę błędów (łapanie wyjątków) oraz sprawdzanie sensowności przekazanej wartości (rozmiar ujemny lub równy zero)

Dla boku o długości: 5

```
#####
#   #
#   #
#   #
#####
```


## Zadanie 2.

Napisz program, który narysuje trójkąt równoboczny o przekazanej wartości-jak na zrzucie ekranu poniżej.

Nazwa Klasy: `DrawTriangle`

**Uwaga**:

Proszę wprowadzić jawną obsługę błędów (łapanie wyjątków) oraz sprawdzanie sensowności przekazanej wartości (rozmiar jest mniejszy od dwóch)

Dla wysokości o długości: 4
```
   #
  ###
 #####
#######
```


## Zadanie 3.

Po zapoznaniu się z klasą Properties napisz program, który sprawdzi, czy istnieje plik ustawień. Jeśli nie istnieje, to go utworzy. Jeśli istnieje to sprawdzi wartość stosownych kluczy: wartość_minimum, wartość_maximum, procent, powtórzeń_minimum i powtórzeń_maximum.

Proszę zapoznać się z klasą `Random` i metodą `nextInt(int)`;

Program wyświetla losowe czynnikami z zakresu: `[wartość_minimum, wartość_maximum]`, zaś użytkownik powinien wprowadzić poprawną wartość iloczynu. Przykład poniżej.

` 9 * 7 = `

Nazwa Klasy: `MultiplicationTable`

**Uwaga**:

Proszę przyjąć, że domyślny zakres wartości czynników jest od 1 (wartość_minimum) do 10 (wartość_maximum). Osoba dostanie nie mniej niż 10 pytań (powtórzeń_minimum) i jeśli uzyska 70% (procent) poprawnych odpowiedzi to program się zakończy. Jeśli liczba poprawnych odpowiedzi jest mniejsza, to program działa dalej aż do uzyskania 70%, lecz zadań nie będzie więcej niż 25 (powtórzeń_maximum).

Program na zakończenie wyświetla stosowne podsumowanie w szczególności procent poprawnych odpowiedzi.
