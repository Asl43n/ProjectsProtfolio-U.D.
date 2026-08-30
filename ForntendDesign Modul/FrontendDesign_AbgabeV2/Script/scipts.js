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
