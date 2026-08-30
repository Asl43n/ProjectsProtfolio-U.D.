
// Warten auf das vollständige Laden des Dokuments

document.addEventListener('DOMContentLoaded', function() {
    // GSAP-Plugin für Smooth Scrolling auf allen Anker-Links, die mit "#" beginnen
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault(); // Verhindert das Standard-Scroll-Verhalten
            let target = document.querySelector(this.getAttribute('href')); // Ziel des Anker-Links
            gsap.to(window, {duration: 1, scrollTo: target}); // Animate to the target with GSAP
        });
    });
    // GSAP-Plugin für Bildanimationen beim Scrollen initialisieren
    gsap.registerPlugin(ScrollTrigger);

    // Animation für jedes Bild auf der Seite
    document.querySelectorAll('img').forEach(img => {
        gsap.from(img, {
            scrollTrigger: img, // Start der Animation, wenn das Bild in den Viewport kommt
            duration: 1.5, // Dauer der Animation
            opacity: 0, // Startet mit einer Opazität von 0 (unsichtbar)
            x: -100, // Startposition 100px links von der Endposition
            ease: 'power1.out', // Easing-Funktion für die Animation
        });
    });
})

// Funktion, die bei jedem Scroll-Ereignis aufgerufen wird
window.onscroll = function() {
    var winScroll = document.body.scrollTop || document.documentElement.scrollTop; // Aktuelle Scroll-Position
    var height = document.documentElement.scrollHeight - document.documentElement.clientHeight; // Gesamte Scroll-Höhe
    var scrolled = (winScroll / height) * 100; // Berechnung des Scroll-Fortschritts in Prozent
    document.getElementById("scrollBar").style.width = scrolled + "%"; // Anpassen der Breite der Scrollbar entsprechend dem Scroll-Fortschritt
};

//Newsletter Formular
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("newsletter-form");
    const messageDiv = document.getElementById("form-message");

    form.addEventListener("submit", (event) => {
        event.preventDefault(); // Verhindert das Neuladen der Seite

        const firstname = document.getElementById("firstname").value.trim();
        const lastname = document.getElementById("lastname").value.trim();
        const email = document.getElementById("email").value.trim();

        if (!validateName(firstname) || !validateName(lastname)) {
            showMessage("Bitte gib einen gültigen Vor- und Nachnamen ein.", "red");
            return;
        }

        if (!validateEmail(email)) {
            showMessage("Bitte gib eine gültige E-Mail-Adresse ein.", "red");
            return;
        }

        showMessage(`Danke für deine Anmeldung, ${firstname}!`, "green");
        form.reset();
    });

    function validateName(name) {
        return name.length >= 2 && /^[A-Za-zÀ-ÿ\s'-]+$/.test(name);
    }

    function validateEmail(email) {
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }

    function showMessage(message, color) {
        messageDiv.textContent = message;
        messageDiv.style.color = color;
        messageDiv.setAttribute("role", "alert"); // Barrierefreie Meldung
    }
});

// Dark Mode
document.addEventListener("DOMContentLoaded", () => {
    const themeToggle = document.getElementById("theme-toggle");
    if (!themeToggle) return;

    // Setze den initialen Zustand basierend auf LocalStorage
    if (localStorage.getItem("theme") === "dark") {
        document.body.classList.add("dark-mode");
        themeToggle.textContent = "🌙 Dunkler Modus";
    }

    themeToggle.addEventListener("click", () => {
        document.body.classList.toggle("dark-mode");

        if (document.body.classList.contains("dark-mode")) {
            localStorage.setItem("theme", "dark");
            themeToggle.textContent = "🌙 Dunkler Modus";
        } else {
            localStorage.setItem("theme", "light");
            themeToggle.textContent = "🌞 Heller Modus";
        }
    });
});



//Scroll to Top
document.addEventListener("DOMContentLoaded", () => {
    const scrollTopFooterBtn = document.getElementById("scroll-top-footer");

    if (!scrollTopFooterBtn) return; // Falls der Button nicht existiert, beende die Funktion

    scrollTopFooterBtn.addEventListener("click", () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth"
        });
    });
});
