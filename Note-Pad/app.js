//importing files
const fs = require("fs");
const express = require("express");
const path = require("path");
const app = express();

//initiating middleware functions.
app.use(express.urlencoded({ extended: false }));
app.use(express.static("public"));

//enabling templating engines.
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

//Home page request handling.
app.get("/home", (request, response) => {
   const filePath = path.join(__dirname, "note-data", "data.json");
   const fileData = fs.readFileSync(filePath);
   const existingData = JSON.parse(fileData);
   response.render("index", { noteStored: existingData });
});

//Deletion of Notes handling.
app.post("/deleting", (request, response) => {
   const requestData = request.body.indexNumber;
   console.log(typeof requestData);
   const filePath = path.join(__dirname, "note-data", "data.json");
   const fileData = fs.readFileSync(filePath);
   const existingData = JSON.parse(fileData);

   if (typeof requestData == "string") {
      let index = 0;
      for (let item of existingData) {
         if (requestData == item.title) {
            existingData.splice(index, 1);
         }
         index++;
      }
      fs.writeFileSync(filePath, JSON.stringify(existingData));
      response.redirect("/home");
   }
   for (let deleteTitle of requestData) {
      let index = 0;
      for (let item of existingData) {
         if (deleteTitle == item.title) {
            existingData.splice(index, 1);
         }
         index++;
      }
   }
   fs.writeFileSync(filePath, JSON.stringify(existingData));
   response.redirect("/home");
});

//Storage/Addition of notes handling.
app.post("/note", (request, response) => {
   const requestData = request.body;

   const filePath = path.join(__dirname, "note-data", "data.json");
   const fileData = fs.readFileSync(filePath);
   const existingData = JSON.parse(fileData);

   existingData.push(requestData);
   fs.writeFileSync(filePath, JSON.stringify(existingData));
   response.redirect("/home");
});

//initiating local server.
app.listen(3000, () => {
   console.log("note-pad server initiating");
});
