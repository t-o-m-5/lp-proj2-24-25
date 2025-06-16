/* union types */

type Opt = union { #none:(), #some:int};
let l0:Opt = #none(());
l0;;

type Opt = union { #none:(), #some:int};
let l0:Opt = #some(2);
l0;;

type Opt = union { #none:(), #some:int};
let l0:Opt = #none(());
match l0 {
    #none(_) -> 1
|   #some(i) -> i    
};;

type Opt = union { #none:(), #some:int};
let l0:Opt = #some(42);
match l0 {
    #none(_) -> 1
|   #some(i) -> i    
};;

/* fails */
type Opt = union { #none:(), #some:int};
let l0:Opt = #some(42);
match l0 {
    #none(_) -> 1
|   #some(i) -> (i && true)  
};;

/* fails */
type Opt = union { #none:(), #some:int};
let l0:Opt = #some(42);
match l0 {
    #none(_) -> 1
|   #some(i) -> (i > 2)  
};;

/* fails */
type Opt = union { #none:(), #some:int};
let l0:Opt = #some(42);
match l0 {
    #none(_) -> 1
};;

/* fails */
type Opt = union { #none:(), #some:int};
let l0:Opt = #none(());
match l0 {
    #some(x) -> x + 1
};;

type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let r1 = #rect({ #h = 10, #v = 20 });
match r1 {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#v
}
;;

type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let pi = 3142;
let area = fn b:Blob => {
  match b {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#w
    }
};
let r1 = #rect({ #h = 10, #w = 20 });
area(r1);;

type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let pi = 3142;
let area = fn b:Blob => {
  match b {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#w
    }
};
let r1:Blob = #rect({ #h = 10, #w = 20 });
area(r1);;

/* fails */
type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let pi = 3142;
let area = fn b:union{ #circle: Circle } => {
  match b {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#w
    }
};
let r1:Blob = #rect({ #h = 10, #w = 20 });
area(r1);;

/* fails */
type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let pi = 3142;
let area = fn b:union{ #rect: Rectangle } => {
  match b {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#w
    }
};
let r1:Blob = #rect({ #h = 10, #w = 20 });
area(r1);;

type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let pi = 3142;
let area = fn b:union{ #rect: Rectangle } => {
  match b {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#w
    }
};
let r1 = #rect({ #h = 10, #w = 20 });
area(r1);;

type Circle = struct { #cx:int, #cy:int, #rad:int };
type Rectangle = struct { #h:int, #w:int };
type Blob = union { #circle: Circle, #rect: Rectangle };
let pi = 3; /*3.14*/
let area = fn b:Blob => {
  match b {
        #circle(c) -> let r = pi*c.#rad; (r*r)/2
    |   #rect(r) -> r.#h * r.#w
    }
};
let r1 = #circle({ #cx=0, #cy=0, #rad=2 });
area(r1);;
