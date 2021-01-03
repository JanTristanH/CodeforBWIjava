# CodeforBWIjava


https://www.get-in-it.de/coding-challenge

## Begründung für den gewählten Algorithmus
Da die Problemstellung direkt an das Rucksackproblem erinnert, wurde als Anlehnung an dieses ein Algorithmus 
mit dynamischer Programmierung gewählt. Dieser sollte im vergleich zu greedy Lösungen die Teilprobleme besser Lösen.
Es werden bewusst die Laster nacheinander beladen.
Dies kann zwar dazu führen, dass die Kombination der optimalen Teillösungen nicht die optimale gesamtlösung darstellt,
 bietet jedoch eine gute Näherung und lässt ohne modifikation das Hinzufügen weiterer Laster zu.

## Ergebnis
Optimale Verteilung der Hardware (inkl. Gesamtnutzen) findet sich im Repository unter `resultIterative10.json`.
Diese Datei wurde aufgrund von Speicherplatz Limitierungen auf während der Berechnung auf 10 Gramm gerundet.
Eine genauere Berechnung kann erfolgen, indem in der Klasse Main Zeile 9 ein kommentiert wird.
Die beste von mir errechnete Ladeliste erreicht einen Gesamtwert von `73394`.
 
## Startanleitung
- Die zu verladenden Items und verfügbaren Trucks können im `data` Ordner verändert werden
- in der letzten pipeline im repository kann die vollständige jar als artefakt runter geladen werden.
- diese jar muss sich zum Zeitpunkt der Ausführung im selben verzeichnis befinden, wie der data Ordner mit den json Dateien für die Items und Trucks 
Alternativ kann auch:
-  mittels maven sollten die Lifecycle Methoden `clean` und `install` ausgeführt werden
    - (dies kann z.B. über die intellij IDE über den maven Reiter geschehen) 
    - in intellij kann es auch erforderlich sein über `Project Structure` die Project SDK auszuwählen (java 13 wurde zum Erstellen verwendet)
- Nun kann die Anwendung über die `Main` Klasse in `src/main/java/coding/challenge` gestated werden.
