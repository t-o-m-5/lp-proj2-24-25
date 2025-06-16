{};;

{ #fst=1, #snd = 2};;

{ #fst=1, #snd = 2}.#fst;;

{ #fst=1, #snd = 2}.#snd;;

type Person = struct{#name:int, #age: int};
let p0 = {#name = 1, #age = 2};
p0.#name + p0.#age;;

type Person = struct{ #name:int, #age: int };
let p0:Person = {#name = 1, #age = 2};
p0.#name + p0.#age;;

type Person = struct{ #name:int, #age: int };
let p0:Person = {#name = 1, #age = 2, #more = 42};
p0.#name + p0.#age;;

type MPair = struct { #fst: ref<int>, #snd:ref<int>};
let p1 = { #fst = box(1), #snd = box(2)};
p1.#fst := !(p1.#snd);
p1.#snd := !(p1.#snd) + 1;
!(p1.#fst) + !(p1.#snd)
;;

();;

type ICounter = struct { #inc: () -> int, #get : () -> int };
let c:int -> ICounter =
    fn n:int => { let v = box(n);
                { #inc = fn _:() => { v := !v + 1 }, 
                  #get = fn _:() => { !v } }};
let cv = c(0);
cv.#inc(());
cv.#inc(());
cv.#get(());;

type ICounter = struct { #inc: () -> int, #get : () -> int };
let newcounter:int -> ICounter =
    fn n:int =>
        { let v = box(n);
            { 
                #inc = fn _:() => { v := !v + 1 }, 
                #get = fn _:() => { !v }
            }
        };
let c0 = newcounter(0);
    c0.#inc(); 
    c0.#inc();
    c0.#get()
;;

type ICounter = struct { #inc: () -> int, #get : () -> int };
type IIncView = struct { #inc: () -> int };
let newcounter:int -> ICounter =
    fn n:int =>
        { let v = box(n);
            { 
                #inc = fn _:() => { v := !v + 1 }, 
                #get = fn _:() => { !v }
            }
        };
let c0 = newcounter(0);
let client = fn r: IIncView  =>
            { r.#inc(); r.#inc(); r.#inc() };
    client (c0);
    c0.#get()
;;

