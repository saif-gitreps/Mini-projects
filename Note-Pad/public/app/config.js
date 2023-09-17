const cancelButton = document.getElementById("cancel-li");
const selectButton = document.getElementById("select-li");
const selectAllButton = document.getElementById("select-all-li");
const checkBox = document.querySelectorAll(".display-checkbox");

selectButton.addEventListener("click", () => {
   cancelButton.style.display = "block";
   selectButton.style.display = "none";
   selectAllButton.style.display = "block";
   for (let item of checkBox) {
      item.style.display = "block";
   }
});

cancelButton.addEventListener("click", () => {
   cancelButton.style.display = "none";
   selectButton.style.display = "block";
   selectAllButton.style.display = "none";
   for (let item of checkBox) {
      item.style.display = "none";
   }
   for (let item of checkBox) {
      if (item.checked == true) {
         item.checked = false;
      }
   }
});

selectAllButton.addEventListener("click", () => {
   for (let item of checkBox) {
      if (item.checked != true) {
         item.checked = true;
      }
   }
});
