# Football Team Manager – Használati útmutató

## 1. A program bemutatása

A Football Team Manager egy Java nyelven készült konzolos alkalmazás, amely focicsapatok és játékosok kezelésére szolgál.

A felhasználó csapatokat hozhat létre, játékosokat adhat hozzájuk, gólokat rögzíthet, valamint megtekintheti és módosíthatja a csapatok keretét.

A program a létrehozott adatokat fájlba menti, így azok a következő indításkor is rendelkezésre állnak.

## 2. A program elindítása

**Szükséges szoftverek:**
- Java 21
- IntelliJ IDEA vagy más Java-fejlesztőkörnyezet
- Maven

**Indítás IntelliJ IDEA-ban:**

1. Nyissuk meg a `football-team-manager` projektet.
2. Várjuk meg, amíg a Maven betölti a szükséges függőségeket.
3. Nyissuk meg a `src/main/java/footballmanager/Main.java` fájlt.
4. Kattintsunk a `main()` metódus melletti zöld futtatás ikonra.
5. Válasszuk a **Run 'Main.main()'** lehetőséget.

A program a konzolban indul el.

## 3. Főmenü

Indítás után az alábbi menü jelenik meg:

```text
===== FOOTBALL TEAM MANAGER =====
1. Uj csapat letrehozasa
2. Uj jatekos hozzaadasa
3. Csapatok listazasa
4. Jatekosok listazasa
5. Gol rogzitese
6. Jatekosok rendezese
7. Jatekos torlese
8. Kilepes
```

A menüpontok kiválasztásához írjuk be a megfelelő számot, majd nyomjuk meg az Enter billentyűt.

## 4. Új csapat létrehozása

Válasszuk az **1-es menüpontot**.

A program bekéri a csapat nevét.

**Példa:**

```text
Valasztas: 1
Add meg a csapat nevet: Arsenal
Csapat sikeresen letrehozva!
```

A csapat neve nem lehet üres, és nem tartalmazhat pontosvesszőt.

## 5. Új játékos hozzáadása

Válasszuk a **2-es menüpontot**.

A program először megjeleníti a rendelkezésre álló csapatokat.

Ezután meg kell adnunk:
- A kiválasztott csapat sorszámát.
- A játékos nevét.
- A játékos életkorát.
- A játékos típusát.

Két játékostípus közül választhatunk:

**1 – Mezőnyjátékos**

**2 – Kapus**

**Példa:**

```text
Valasztas: 2
Valassz csapatot:
1. Arsenal

Csapat sorszama: 1
Jatekos neve: Saka
Jatekos eletkora: 24

1. Mezonyjatekos
2. Kapus

Jatekos tipusa: 1
Jatekos sikeresen hozzaadva!
```

A játékos életkora 1 és 100 között lehet.

Hibás játékostípus vagy érvénytelen játékosadat esetén a program hibaüzenetet jelenít meg.

## 6. Csapatok listázása

Válasszuk a **3-as menüpontot**.

A program megjeleníti a létrehozott csapatok neveit.

## 7. Játékosok listázása

Válasszuk a **4-es menüpontot**.

A program minden csapat játékosait megjeleníti.

A játékosokról az alábbi információk láthatók:
- Név
- Életkor
- Gólszám
- Poszt

## 8. Gólok rögzítése

Válasszuk az **5-ös menüpontot**.

1. Válasszuk ki a csapatot.
2. Válasszuk ki a játékost.
3. Adjuk meg a rögzíteni kívánt gólok számát.

**Példa:**

```text
Hany golt szeretnel rogizteni? 3
Sikeresen rogzitettel 3 golt!
Saka osszes golja: 3
```

Egyszerre több gólt is hozzáadhatunk egy játékoshoz.

A megadott gólszámnak pozitív egész számnak kell lennie.

## 9. Játékosok rendezése

Válasszuk a **6-os menüpontot**.

A program minden csapat játékosait gólszám alapján, csökkenő sorrendbe rendezi.

**Példa:**

```text
Csapat: Arsenal
Saka - Golok: 8
Rice - Golok: 3
Raya - Golok: 0
```

A legtöbb gólt szerző játékos kerül a lista elejére.

## 10. Játékos törlése

Válasszuk a **7-es menüpontot**.

1. Válasszuk ki a csapatot.
2. Válasszuk ki a törölni kívánt játékost.
3. Adjuk meg a játékos sorszámát.

A program eltávolítja a kiválasztott játékost a csapatból.

A törlés az adatok következő mentésekor válik tartóssá.

## 11. Mentés és betöltés

A program a `teams.txt` fájlban tárolja a csapatok és játékosok adatait.

**Mentés:**

A 8-as menüpont kiválasztásakor a program automatikusan elmenti az aktuális adatokat.

**Betöltés:**

A program következő indításakor automatikusan megpróbálja visszatölteni a korábban mentett adatokat.

A mentett adatok között szerepelnek:
- A csapatok nevei.
- A játékosok nevei.
- A játékosok életkora.
- A játékosok posztja.
- A játékosok gólszáma.

A mentési fájl hiányában a program üres csapatlistával indul.

## 12. Hibakezelés

A program ellenőrzi a felhasználó által megadott adatokat.

Például hibaüzenet jelenik meg, ha:
- Nem létező csapatot választunk.
- Nem létező játékost választunk.
- Érvénytelen életkort adunk meg.
- Hibás játékostípus kerül megadásra.
- Negatív vagy nulla gólszámot próbálunk rögzíteni.

A játékosok adatainak ellenőrzésében a saját `InvalidPlayerException` kivételosztály is részt vesz.

## 13. Kilépés

A **8-as menüpont** kiválasztásával kiléphetünk a programból.

A program először megpróbálja elmenteni az adatokat, majd befejezi a működését.

## 14. Automatikus tesztelés

A projekt JUnit 5 teszteket tartalmaz.

A teljes tesztkészlet Maven segítségével futtatható:

```bash
mvn test
```

A tesztek ellenőrzik a játékoskezelést, a csapatkezelést, a Factory működését és a fájlmentést.

---

**Football Team Manager – Java OOP projektmunka**

Programozás 2 tantárgy