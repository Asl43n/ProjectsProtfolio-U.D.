// 🏀 Verbesserte Scroll-Funktion für Basketball-Seite
function smoothScroll(target, duration) {
    if (target === '#' || target === '') {
        window.scrollTo({ top: 0, behavior: 'smooth' });
        return;
    }

    const targetElement = document.querySelector(target);
    if (!targetElement) {
        console.warn(`⚠️ Ziel-Element "${target}" nicht gefunden.`);
        return;
    }

    const targetPosition = targetElement.getBoundingClientRect().top + window.pageYOffset;
    const startPosition = window.pageYOffset;
    const distance = targetPosition - startPosition;
    let startTime = null;

    function animation(currentTime) {
        if (startTime === null) startTime = currentTime;
        const timeElapsed = currentTime - startTime;
        const run = ease(timeElapsed, startPosition, distance, duration);
        window.scrollTo(0, run);
        if (timeElapsed < duration) requestAnimationFrame(animation);
    }

    function ease(t, b, c, d) {
        t /= d / 2;
        if (t < 1) return c / 2 * t * t + b;
        t--;
        return -c / 2 * (t * (t - 2) - 1) + b;
    }

    requestAnimationFrame(animation);
}

// 🏀 Logo klickt zur Startseite
document.addEventListener('DOMContentLoaded', function () {
    const logo = document.querySelector('a.logo');
    if (logo) {
        logo.addEventListener('click', function (event) {
            event.preventDefault();
            smoothScroll('#', 1000);
        });
    }
});

// 🏀 Smooth Scroll für Navigation (angepasste Links)
document.querySelectorAll('.navigation a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (event) {
        event.preventDefault();
        const target = this.getAttribute('href');
        smoothScroll(target, 1000);
    });
});

// 🏀 Aktives Menü-Item hervorheben
document.querySelectorAll('.navigation a').forEach(anchor => {
    anchor.addEventListener('click', function () {
        document.querySelectorAll('.navigation a').forEach(a => a.classList.remove('active'));
        this.classList.add('active');
    });
});

// 🏀 Feedback-Formular-Validierung (angepasst auf Basketball-Thema)
document.querySelector('.feedback-form').addEventListener('submit', function (event) {
    const requiredFields = ['favorite-player', 'favorite-team'];
    let isValid = true;

    requiredFields.forEach(field => {
        const input = document.getElementById(field);
        if (input.value.trim() === '') {
            isValid = false;
            input.classList.add('error');
        } else {
            input.classList.remove('error');
        }
    });

    if (!isValid) {
        alert('Bitte fülle alle Felder aus.');
        event.preventDefault();
    }
});

// 🏀 Mobile Menü-Funktion
document.addEventListener("DOMContentLoaded", function () {
    const menuToggle = document.getElementById("menu-toggle");
    const navigation = document.querySelector(".navigation");

    menuToggle.addEventListener("click", function () {
        navigation.classList.toggle("active");
    });

    document.addEventListener("click", function (event) {
        if (!menuToggle.contains(event.target) && !navigation.contains(event.target)) {
            navigation.classList.remove("active");
        }
    });
});

// 🏀 Interaktive Header-Animation für Basketball-Seiten
document.addEventListener('DOMContentLoaded', function() {
    const sections = ['geschichte', 'regeln', 'legenden', 'stadien', 'ligen'];
    
    sections.forEach(section => {
        const link = document.querySelector(`nav a[href="#${section}"]`);
        const title = document.getElementById(`${section}-title`);
        
        if (link && title) {
            link.addEventListener('click', function(e) {
                e.preventDefault();
                document.getElementById(section).scrollIntoView({ behavior: 'smooth' });

                title.style.animation = 'none';
                title.offsetHeight;
                title.style.animation = null;
                title.classList.add('animate');

                setTimeout(() => {
                    title.classList.remove('animate');
                }, 3000);
            });
        }
    });
});

// 🏀 Feedback-Formular mit Erfolgsnachricht
document.addEventListener('DOMContentLoaded', function() {
    const feedbackForm = document.querySelector('.feedback-form');
    const responseMessageContainer = document.createElement('div');
    responseMessageContainer.style.textAlign = 'center';
    responseMessageContainer.style.marginTop = '20px';
    responseMessageContainer.style.fontSize = '16px';
    responseMessageContainer.style.color = 'green';

    feedbackForm.addEventListener('submit', function(event) {
        event.preventDefault();
        responseMessageContainer.textContent = "🏀 Vielen Dank für dein Feedback!";
        feedbackForm.appendChild(responseMessageContainer);
    });
});
