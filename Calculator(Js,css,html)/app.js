//buttons
const ACbutton = document.getElementById("AC-button");
const EqualButton = document.getElementById("equal-button");
const inputField = document.querySelector("input");

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
      default:
         return -404;
   }
}
function isOp(a) {
   if (a == "+" || a == "/" || a == "-" || a == "*") {
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
         while (i < eq.size() && isNum(eq[i])) {
            //checking for digits more than ones
            //we dont have to worry about next operand
            //cuz it is separated by ' ' || ','
            num = num * 10 + (eq[i] - 48);
            i++;
         }
         //the while loop becomes false only if there
         //exists empty spaces or operator.
         //if we dont decrement by 1, the operator
         //Or empty spaces will be ingored.
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
}

//event listeners;
ACbutton.addEventListener("click", clearInput);
