(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
<<<<<<< HEAD
    
 
  )
=======
  (fn [& args]
    (let [r (f (first args))]
      (if (fn? r)
        (apply (unpartial r) (rest args))
        r))))
>>>>>>> 87520df46e8ed648cbcb69a2af7e7da0f9895d35


(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]
<<<<<<< HEAD
   (first(reduce clojure.set/intersection (map set seqs))) ;; no funciona con secuencias infinitas

  )
=======
  (letfn [(lazy-search [xs]
            (let [s (map first xs)
                  m (apply min s)]
              (if (apply = s)
                m
                (lazy-search (map #(if (= (first %) m) (rest %) %) xs)))))]
    (lazy-search seqs)))
>>>>>>> 87520df46e8ed648cbcb69a2af7e7da0f9895d35


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
<<<<<<< HEAD
  [predicado valor secuencia]
  (lazy-seq
    (if (empty? secuencia) () 
      (if (nil?(second secuencia))
        secuencia 
        (if (predicado (first secuencia) (second secuencia)) ;;pregunto si el predicado es true entre el primero y el segundo de la secuencia
         (do (cons (first secuencia) (cons valor (intercalar predicado valor (rest secuencia))))) ;; en caso de true concateno el primero con el valor parametro y la llamada recursiva del resto
         (do (cons (first secuencia) (intercalar predicado valor (rest secuencia)))))) ;; en caso falso concateno el primero de la secuencia con la llamada recursiva del resto
    )
  )
)
=======
  ;;  [predicado valor secuencia]
  [pred value col]
  (letfn [(looper [s head]
            (lazy-seq
             (if-let [sec (first s)]
               (if (pred head sec)
                 (cons head (cons value (looper (rest s) sec)))
                 (cons head (looper (rest s) sec)))
               (if head [head] []))))]
    (looper (rest col) (first col))))

>>>>>>> 87520df46e8ed648cbcb69a2af7e7da0f9895d35


(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
<<<<<<< HEAD
  [secuencia]
  (if (apply = secuencia)
    (do ((fn iguales [seq] (conj (conj [] (count seq)) (first seq))) secuencia))
     (if (apply distinct? secuencia)
       (do((fn distintos [seq]  (if (nil? (first seq))
                                  (do seq)
                                  (do (vec (flatten(cons (conj [1] (first seq)) (distintos (rest seq)))) ))   ))secuencia))
    
       (do (vec(flatten(vec(map tartamudeo (vec(map vec(partition-by identity secuencia))))))))
       )
   )
       ;; si llamo a la funcion (take 5 (iterate tartamudeo [secuencia])) funciona como los test. No pude implementarlo en el metodo porque me quede sin tiempo 

)
=======
  ;[secuencia]
  [s]
  (letfn [(pronuntiate [l]
            (apply concat (map (juxt count first) (partition-by identity l))))]
    (iterate pronuntiate (pronuntiate s))))
>>>>>>> 87520df46e8ed648cbcb69a2af7e7da0f9895d35
