//buttons
const ACbutton = document.getElementById("AC-button");
const equalButton = document.getElementById("equal-sign");
const inputField = document.querySelector("input");
const buttonBody = document.getElementById("button-body");
let displayExpression = "";

//creation of stack
class Stack {
   constructor() {
      this.stack = [];
   }
   push(item) {
      this.stack.push(item);
   }
   pop() {
      if (this.stack.length == 0) return;
      this.stack.pop();
   }
   top() {
      return this.stack[this.stack.length - 1];
   }
   empty() {
      return this.stack.length == 0;
   }
}
//arithmetic functions
function isValid(s) {
   let stacc = new Stack();
   for (let i = 0; i < s.length; i++) {
      if (s[i] != "(" || s[i] != ")") {
         continue;
      }
      if (s[i] == "(") {
         stacc.push(s[i]);
      } else {
         if (!stacc.empty()) {
            if (s[i] == ")" && stacc.top() == "(") {
               stacc.pop();
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }
   return stacc.empty() ? true : false;
}
function result(op, a, b) {
   switch (op) {
      case "+":
         return a + b;
      case "-":
         return a - b;
      case "/":
         return a / b;
      case "*":
         return a * b;
      case "^":
         return Math.pow(a, b);
      default:
         return -404;
   }
}
function isOp(a) {
   if (a == "+" || a == "/" || a == "-" || a == "*" || a == "^") {
      return 1;
   }
   return 0;
}

function isNum(a) {
   if (a >= "0" && a <= "9") {
      return 1;
   }
   if (a >= "A" && a <= "Z") {
      return 1;
   }
   if (a >= "a" && a <= "z") {
      return 1;
   }
   return 0;
}
function precedent(a) {
   let prec;
   if (a == "-" || a == "+") {
      return 1;
   }
   if (a == "/" || a == "*") {
      return 2;
   }
   if (a == "^") {
      return 3;
   }
   return prec;
}

function infixToPost(exp) {
   let op = new Stack();
   let all = "";
   for (let i = 0; i < exp.length; i++) {
      if (exp[i] == " " || exp[i] == ",") {
         continue;
      }
      if (isNum(exp[i])) {
         while (isNum(exp[i]) && i < exp.size()) {
            all = all + exp[i];
            i++;
         }
         i--;
         all = all + " ";
      } else if (isOp(exp[i])) {
         while (!op.empty() && precedent(exp[i]) <= precedent(op.top())) {
            all = all + op.top() + " ";
            op.pop();
         }
         op.push(exp[i]);
      } else if (exp[i] == "(") {
         op.push(exp[i]);
      } else if (exp[i] == ")") {
         while (!op.empty() && op.top() != "(") {
            all = all + op.top() + " ";
            op.pop();
         }
         op.pop();
      }
   }
   while (!op.empty()) {
      all = all + op.top() + " ";
      op.pop();
   }
   return all;
}
function PostfixEvaluate(eq) {
   let op1, op2, res;
   let a = new Stack();
   for (let i = 0; i < eq.length; i++) {
      if (eq[i] == " " || eq[i] == ",") {
         continue;
      }
      if (isNum(eq[i])) {
         let num = 0;
         while (i < eq.length && isNum(eq[i])) {
            num = num * 10 + (eq[i] - 48);
            i++;
         }
         i--;
         a.push(num);
      } else if (isOp(eq[i])) {
         op2 = a.top();
         a.pop();
         op1 = a.top();
         a.pop();
         res = result(eq[i], op1, op2);
         a.push(res);
      }
   }
   return a.top();
}
//callback-functions
function clearInput(event) {
   inputField.value = "";
   displayExpression = "";
}
function grabDisplayExpression(event) {
   if (event.target.tagName !== "LI" || event.target.dataset.a == "AC" || event.target.dataset.a == "=") {
      return;
   }
   let buttonPressed = event.target.dataset.a;
   displayExpression += buttonPressed;
   inputField.value = displayExpression;
}
function findAns(event) {
   if (displayExpression.length > 1 && displayExpression[0] == "0") {
      inputField.value = "Invalid expression";
      return;
   }
   console.log(displayExpression);
   if (isValid(displayExpression) == false) {
      console.log(isValid(displayExpression));
      console.log(displayExpression);
      inputField.value = "Invalid expression";
      return;
   }
}

//event listeners;
ACbutton.addEventListener("click", clearInput);
buttonBody.addEventListener("click", grabDisplayExpression);
equalButton.addEventListener("click", findAns);
