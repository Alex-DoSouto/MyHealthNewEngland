const menu = document.querySelector("#mobile_menu")
const menuLinks = document.querySelector('.navbar_menu')
//const logo = document.querySelector('#logo')

//Display Mobile Menu
const mobileMenu = () => {
    menu.classList.toggle('is-active')
    menuLinks.classList.toggle('active')
}

menu?.addEventListener('click', mobileMenu);

// Show menu when scrolling
const highLightMenu = () => {
    const barz = document.querySelector('.highlight')
    const homeMenu = document.querySelector('#home_page')
    const infoMenu = document.querySelector('#info_page')
    const reviewMenu = document.querySelector('#reviews_page')
    let scrollScreen = window.scrollY

    // adds 'highlight' class to menu
    if (window.innerWidth > 960 && scrollScreen < 600) {
        homeMenu?.classList.add('highlight')
        infoMenu?.classList.remove('highlight')
        return
    } else if (window.innerWidth > 960 && scrollScreen < 1400) {
        infoMenu?.classList.add('highlight')
        homeMenu?.classList.remove('highlight')
        reviewMenu?.classList.remove('highlight')
        return
    } else if (window.innerWidth > 960 && scrollScreen < 2345) {
        reviewMenu?.classList.add('highlight')
        infoMenu?.classList.remove('highlight')
        homeMenu?.classList.remove('highlight')
        return
    }

    if ((barz && window.innerWidth < 960 && scrollScreen < 600) || barz) {
        elem.classList.remove('highlight');
      }
};

window.addEventListener('scroll', highLightMenu);
window.addEventListener('click', highLightMenu);

// Close modile Menu when clicking on a menu item
const hideMobileMenu = () => {
    const menuBars = document.querySelector('.is-active')
    if (window.innerWidth <= 768 && menuBars) {
        menu.classList.toggle('is-active')
        menuLinks.classList.toggle('active')
    }
};

menuLinks?.addEventListener('click', hideMobileMenu);
logo?.addEventListener('click', hideMobileMenu);



// for loop to generate options in dropout
/* let select = document.getElementById("selt");
let options = ["Massachusetts", "Rhode Island", "Florida", "Maine", "New York", "Virginia"];

for (var i = 0; i < options.length; i++) {
    var opt = options[i];
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    select.appendChild(el);
} */
//Used to give logout link functionality
