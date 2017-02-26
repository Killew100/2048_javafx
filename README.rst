Kirjeldus
===========

Mängu nimi on **2048**, tegemist on samanimelise telefonimängu analoogiga. Mängus tuleb kokku saada võimalikult suur number, mida saab moodustada 2 astmete kokkuliitmisel. Mäng toimub 4x4 - 8x8 laual, kus ruutude kokkulohistamise teel tuleb saada kokku võimalikult suur number.
Iga kokkuliidetud numbri eest saab punkte, mille eest on võimalik osta abivahendeid, nt: 1 käik tagasi, bloki ära kustutamine jne.
Aja olemasolul püütakse implementeerida ka multiplayer.

Funktsionaalsus
---------------

- blokid ilmuvad ruudustikku
- blokke saab liigutada paremale, vasakule üles ja alla.
- sarnased blokid ühtivad ja muutuvad suuremaks numbriks
- punktiskoori lugemine
- combod, kui mitmel järjestikusel korral saadakse ühtivad blokid.
- abivahendite kasutamine
- mäng saab läbi kui ühtegi käiku pole rohkem võimalik teha.
- Edetabel
- seaded



Ekraanivaated
-------------

**Esileht**

Kuvatakse nupud "Uus mäng", "Edetabel", "Seaded", "Juhis". Igaüks viib erinevasse vaatesse - vt järgmisi vaateid.

**Juhis**

Kuvatakse mängujuhis. Ekraanil on nupp "Tagasi", mis viib esilehele.

**Edetabel**

Kuvatakse parimad punktisummad. Kuna erinevate seadetega on mängutulemus arvatavasti erinev (vajab katsetamist), siis iga seadete komplekti jaoks on erinev edetabel. Lehe ülaosas on valik seadete komplektist. Kui valida mõni komplekt, avatakse vastavatele seadetele vastavad punktisummad.

Edetabelit on võimalik ka tühjendada.

Nupp "Tagasi" viib esilehele.

**Seaded**

Saab määrata erinevaid seadeid.

Seaded:
- mängulaua suurus: valik näiteks 4x4, 5x5, 6x6, 7x7, 8x8
- mängumood: valik kas singleplayer või multiplayer

Võimalik, et mitme valiku asemel on üks valik "raskusaste", kus on valikud "lihtne", "keskmine" ja "raske". Vastavalt valitud raskusastmele muutuvad teised seaded.

Nupp "Tagasi" viib esilehele.

**Mäng**

Mängu põhivaade on selline, kus kuvatakse ruudustik, kuhu iga käigu järel ilmuvad blokid. Kui vajutatakse nuppu, kas parem, vasak, üles või alla, siis liigutatakse kõiki blokke vastavas suunas, kui sellist käiku pole võimalik sooritada, siis ei liigutata ühtegi blokki. Mäng saab läbi kui ühtegi käiku pole võimalik teha.

Ekraani ülaosas näidatakse punktisummat ja abivahendeid.

Mängu lõppedes näidatakse punktisummat. Kui punktisumma on piisav, et edetabelisse jõuda, küsitakse kasutajalt nimi. Kui nimi on sisestatud, näidatakse kasutajale edetabelit.

Plaan
--------

- 5. nädal: UI mockup
- 6. nädal: ruudustiku funktsionaalsus, blokkide tekitamine.
- 7. nädal: Blokkide liigutamise mehaanika, blokkide ühtimine sobivuse korral.
- 8. nädal: mängu lõppemine käikude puudumisel, JavaFX UI esileht, seaded, abivahendid
- 9. nädal: JavaFX UI mängu vaade, ruudustiku kuvamine
- 10. nädal: Mängu UI ja loogika sidumine
- 11. nädal: edetabel, efektid
- 12. nädal: boonus/varu/bugfix

Punktisoov
----------

10 punkti
