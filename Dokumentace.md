**Dokumentace k projektu Překladač morseovky**

**Překladač Morseovy abecedy**

**Dovednosti této aplikace**

- Přeložení z textu na Morseův kód
- Přeložení Morseova kódu na text
- Přeložení Morseova kódu na zvukový kód

**úvod**

Tato aplikace je vytvořená v prostředí IntelliJ IDEA za použití Javy a GUI. Aplikace slouží k přeložení Morseovy abecedy do textu či z textu do Morseovy abecedy, také obsahuje možnost přehrání zvuku Morseovy kódu. Aplikace má uživatelské rozhraní vytvořené pomocí knihovny Swing.

**Použití aplikace**

Po spuštění aplikace se zobrazí hlavní uživatelské rozhraní, v jehož horní oblasti se zobrazí nadpis „Překladač Morseovy abecedy“. Hlavní oblastí jsou textové pole s nadpisem „Text:“ a „Morseova abeceda:“ a také samozřejmě tlačítka „Přeložit zpět“ a  „Spusť morseovku“. Do pole, které se nachází pod nadpisem „Text:“ se nachází textové pole do kterého lze psát,  tato část podporuje háčky a čárky.  Pole nacházející se pod nadpisem „Morseova abeceda:“ je textové pole ve kterém se nachází výsledný Morseův kód, který lze kopírovat. Při kliknutí na tlačítko „Spusť morseovku“, které se nachází v dolní části aplikace, aplikace přeloží Morseovu abecedu do zvukového kódu. V aplikaci je také možnost překládání Morseova kódu zpět do textu, které se nachází také na dolní části aplikace vedle tlačítka „Spusť morseovku“.  Právě toto tlačítko „Přeložit zpět“ zobrazí nové uživatelské rozhraní ve kterém se nachází pouze textové pole „Morseova abeceda:“ do kterého lze psát a textové pole „Text:“ ve kterém je zobrazen přeložený Morseův kód do textu. Ovšem v téhle části aplikace nelze překládat Morseův kód s čárkami a háčky. 

**Požadavky na zprovoznění projektu**

IntelliJ IDEA – IntelliJ IDEA 2020 nebo novější

JDK – veze JDK 8 nebo novější

Knihovna Swing – standartní součást JDK

Knihovna javax.sound.sampled – standartní součást JDK.

Petr Fojtík. Nela Slezáková
