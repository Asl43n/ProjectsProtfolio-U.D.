# Süheyl Aslan: Projekte

Informatikstudent (B.Sc. Medieninformatik, Berliner Hochschule für Technik, Abschluss voraussichtlich Anfang 2027) mit Schwerpunkt auf Webentwicklung, Visualisierung und Datenanalyse. Hier sammle ich ausgewählte Studienprojekte.

**Technologien:** JavaScript, TypeScript, Java, Python, SQL, HTML/CSS (SCSS), WebGL, Git, Linux, Windows

---

## Projekte

### Raytracer in Java
`ComputerGrafik/`

Teamprojekt (2 Personen) im Modul Computergrafik, entstanden schrittweise über mehrere Aufgabenblätter (`a01` bis `a08`).

- Szenengraph mit Kugeln, Zylindern, Ebenen und Gruppen von Objekten
- Lochkamera, diffuse und spiegelnde bzw. transparente Materialien, globale Beleuchtung
- Beschleunigung durch Hüllkörperhierarchien (Bounding Boxes) und paralleles Rendering mit mehreren Threads
- Benchmark der Rechenzeit in Abhängigkeit von der Threadanzahl, ausgewertet mit einem kleinen Python-Skript

Den aktuellen Stand findest du in `ComputerGrafik/codetemplate 8`. Die früheren Ordner sind Zwischenstände der Aufgabenblätter. Das Paket `cgtools` (Vektoren, Matrizen, Farben, Bildausgabe) wurde vom Lehrstuhl gestellt und ist nicht von mir.

**Technologien:** Java, Multithreading, Unit-Tests, Python (Auswertung)

### Datenanalyse: Preis, Bewertung und Genres von Computerspielen
`DataScienceProject/`

Projekt im Modul Data Science. Fragestellung: Wie haben sich Genres, Preise und Bewertungen erfolgreicher PC-Spiele zwischen 2012 und 2023 entwickelt?

- **Datenerhebung:** Web Scraping von Metacritic, OpenCritic und Steam mit `requests` und `BeautifulSoup`, Speicherung als CSV
- **Aufbereitung:** Bereinigung von Preisen (Währungen, Dezimalzeichen), Zusammenführen mehrerer Jahre, Zuordnung von Untergenres zu Hauptgenres mit `pandas`
- **Auswertung:** Genre-Häufigkeiten, Genre-Trends über die Jahre, Zusammenhang von Preis und Bewertung (Scatterplot), Preisentwicklung (Boxplot), dargestellt mit `matplotlib` und `seaborn`
- **Ergebnisse:** Action, Adventure und RPG nehmen über die Jahre zu. Es gibt keine starke Korrelation zwischen Preis und Bewertung. Die Preise der Top-Spiele sind gestiegen.

Notebook: [`FinalProject.ipynb`](DataScienceProject/FinalProject.ipynb)

**Technologien:** Python, pandas, matplotlib, seaborn, BeautifulSoup

### Frontend-Design: Basketball-Webseite
`ForntendDesign Modul/`

Webseite zum Thema Basketball, umgesetzt im Modul Frontend Design.

- Aufbau mit HTML5 und strukturiertem SCSS (Variablen, Mixins, Reset, Media Queries)
- Responsives Layout mit Flexbox
- Interaktive Elemente mit JavaScript

**Technologien:** HTML, CSS/SCSS, JavaScript

### JavaScript- und TypeScript-Übungen
`JavaScript_Projects/`

Kleine Übungsprojekte zur Vertiefung der Sprachgrundlagen: eine Filmverwaltung (JavaScript, auf der Lernplattform Coddy) sowie eine Inventar- und eine Aufgabenverwaltung in TypeScript.

---

## Aktuelle Arbeit: Bachelorarbeit mit der Charité

Webbasierte vierdimensionale anatomische Annotation (FATA) zur Erfassung und Visualisierung von Tumoren und Therapieverläufen, in Kooperation mit der Charité – Universitätsmedizin Berlin.

- Erweiterung eines Annotationswerkzeugs um Tiefenerfassung und zeitliche Verlaufsdarstellung
- Versioniertes, validierbares JSON-Format (JSON Schema) mit Mapping auf HL7 FHIR/mCODE
- Automatisierte Tests und Usability-Evaluation

Der Code ist nicht öffentlich.

---

## Kontakt

- E-Mail: aslan.sohel@yahoo.com
- LinkedIn: [Süheyl Aslan](https://www.linkedin.com/in/s%C3%BCheyl-aslan-36b308324/)