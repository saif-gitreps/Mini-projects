const listItemsArray = document.querySelectorAll("display-note ul li");
const navbar = document.querySelector("nav");
const deleteButton = document.getElementById("delete-button");
const selectButton = document.getElementById("select-button");
const selectAllButton = document.getElementById("select-all-button");
const checkBox = document.querySelectorAll(".display-checkbox");
console.dir(navbar);

if (listItemsArray.length != 0) {
   navbar.style.display = "none";
}

let toggleCounter = 0;
selectButton.addEventListener("click", () => {
   if (toggleCounter % 2 == 0) {
      deleteButton.style.display = "none";
      selectAllButton.style.display = "none";
      for (let item of checkBox) {
         item.style.display = "none";
      }
   } else {
      deleteButton.style.display = "block";
      selectAllButton.style.display = "block";
      for (let item of checkBox) {
         item.style.display = "block";
      }
   }
   toggleCounter++;
});
