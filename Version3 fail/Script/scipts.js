//Newsletter Formular
    document.addEventListener("DOMContentLoaded", () => {
        const form = document.getElementById("newsletter-form");
        const messageDiv = document.getElementById("form-message");

        form.addEventListener("submit", (event) => {
            event.preventDefault(); // Verhindert das Neuladen der Seite

            const emailInput = document.getElementById("email").value;

            if (validateEmail(emailInput)) {
                messageDiv.textContent = "Danke für deine Anmeldung!";
                messageDiv.style.color = "green";
                messageDiv.setAttribute("role", "alert");// Erfolgsmeldung barrierefrei
                form.reset();
            } else {
                messageDiv.textContent = "Bitte gib eine gültige E-Mail-Adresse ein.";
                messageDiv.style.color = "red";
                messageDiv.setAttribute("role", "alert");// Fehlermeldung barrierefrei

            }
        });

        function validateEmail(email) {
            const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return regex.test(email);
        }
    });


//Scroll Animation CSS
    document.addEventListener("DOMContentLoaded", () => {
        const fadeElements = document.querySelectorAll(".fade-in");

        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.intersectionRatio > 0.3) { // Nur wenn mehr als 50% sichtbar sind
                    entry.target.classList.add("show");
                }
            });
        }, {
            threshold: 0.3 // Schwellenwert 50%
        });

        //Logging für Debugging
        fadeElements.forEach(el => {
            observer.observe(el);
            console.log("Beobachtet:", el); // Debugging
        });
    });



//Menüpunkt beim Scrollen hervorzuheben
    document.addEventListener("scroll", () => {
        const sections = document.querySelectorAll("section, article");
        const navLinks = document.querySelectorAll(".main-nav ul li a");
        let current = "";

        sections.forEach((section) => {
            const sectionTop = section.offsetTop;
            if (pageYOffset >= sectionTop - 60) {
                current = section.getAttribute("id");
            }
        });

        navLinks.forEach((link) => {
            link.classList.remove("active");
            if (link.getAttribute("href").includes(current)) {
                link.classList.add("active");
            }
        });
    });


//Light/Dark modus
const themeToggle = document.getElementById("theme-toggle");

themeToggle.addEventListener("click", () => {
    document.body.classList.toggle("dark-mode");

    // Aktualisiere den Button-Text
    themeToggle.textContent = document.body.classList.contains("dark-mode") 
        ? "🌙 Dunkler Modus" 
        : "🌞 Heller Modus";
});


//Scroll to Top
    const scrollTopFooterBtn = document.getElementById("scroll-top-footer");

    scrollTopFooterBtn.addEventListener("click", () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth"
        });
    });


//Dynamisch NBA Liga Tabbelle
    const nbaTeams = [
        { team: "Boston Celtics", wins: 45, losses: 20 },
        { team: "Los Angeles Lakers", wins: 42, losses: 22 },
        { team: "Golden State Warriors", wins: 40, losses: 25 },
    ];
    
    const tableBody = document.getElementById("nba-teams");
    nbaTeams.forEach(team => {
        const row = `<tr><td>${team.team}</td><td>${team.wins}</td><td>${team.losses}</td></tr>`;
        tableBody.innerHTML += row;
    });

//Quizz
    document.querySelectorAll(".quiz-answer").forEach(button => {
        button.addEventListener("click", () => {
            const isCorrect = button.getAttribute("data-correct") === "true";
            document.getElementById("quiz-feedback").textContent = isCorrect ? "Richtig! Wilt Chamberlain erzielte 100 Punkte in einem Spiel." : "Falsch! Versuch es noch einmal.";
        });
    });