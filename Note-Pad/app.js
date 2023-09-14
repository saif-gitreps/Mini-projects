const express = require("express");

const app = express();

app.get("/", (request, response) => {
   response.send("hi");
});

app.listen(3000);
