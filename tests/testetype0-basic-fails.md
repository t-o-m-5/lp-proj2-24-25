let x = 1;
let y = true;
(x>3 && x>y);;

let x = 1;
let y = (x > 2);
-(2*x>5/2 && y);;

let x = 1;
let y = (x > 2);
if (y) { 1 } else { x > 1 };;

let f = fn g:int->bool,z:int => { g (z) };
f (fn z:int => { z*2 }) (7)
;;

let x:bool = 2; x;;
