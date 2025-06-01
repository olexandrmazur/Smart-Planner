const current = document.querySelector('.current-active');
const hidden = document.querySelector('.choose-option');
const container = document.getElementsByClassName('container')[0]
const week = document.getElementsByClassName('week')[0]
let isDropped = false;
console.log(container)
current.addEventListener('click', () => {
    if (!isDropped) {
        hidden.classList.remove('unactive'); 
        isDropped = true;
    } else {
        hidden.classList.add('unactive'); 
        isDropped = false;
    }
});
hidden.addEventListener('click', () => {
    const temp = current.textContent;
    current.textContent = hidden.textContent;
    hidden.textContent = temp;
    hidden.classList.add('unactive');
    isDropped = false;
    week.classList.toggle('unactive')
    container.classList.toggle('unactive')
});


