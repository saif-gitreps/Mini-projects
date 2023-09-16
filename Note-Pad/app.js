const fs = require("fs");
const express = require("express");
const path = require("path");

const app = express();
app.use(express.urlencoded({ extended: false }));

app.get("/home", (request, response) => {
   const filePath = path.join(__dirname, "views", "index.html");
   response.sendFile(filePath);
});
app.post("/note", (request, response) => {
   const requestData = request.body;

   console.log(requestData);

   const filePath = path.join(__dirname, "note-data", "data.json");
   const fileData = fs.readFileSync(filePath);
   const existingData = JSON.parse(fileData);

   existingData.push(requestData);
   fs.writeFileSync(filePath, JSON.stringify(existingData));
   response.redirect("/home");
});

app.listen(3000);
