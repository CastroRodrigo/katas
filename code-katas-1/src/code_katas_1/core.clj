(ns code-katas-1.core)

<<<<<<< HEAD
(defn filter-odd [numeros]
  ;;Funcion que retorne solamente los numero impares de una secuencia
  (filter odd? numeros) 
  )

(defn nil-key [clave mapa]
 ;;Funcion que dada una clave y un mapa devuelce true, solamente si el mapa contiene una entrada con esa clave, y su valor es nil
 (if (and (nil? (get mapa clave)) (contains? mapa clave)) true false)
 )

(defn range [start end]
   ;;Escribir una funcion que cree una lista de enteros en un rango dado.
   ;;Restricciones: range
  (when (distinct? start end) (do (cons  start (range (+ start 1) end)))) 
  )
 

(defn compress-sequence
  ;;Funcion que elimine los duplicados consecutivos de una secuencia"
  [secuencia]
  (if (string? secuencia) 
    (do (apply str (map first (partition-by identity secuencia)))) 
    (do (map first (partition-by identity secuencia)) ) )
  )

(defn max-value [& args]
  ;;Funcion que reciba un numero variable de parametros y retorne el que tenga el valor mayor
  ;;Restricciones: max y max-key"
  (first(sort > args))
  )

(defn split-two [length secuencia]
  ;;Escribir una funcion que parta una secuencia en dos partes
  ;;Restricciones: split-at
  (vec (cons (vec(take length secuencia)) (cons (vec(drop length secuencia)) ())))
  )

(defn inter-two [s1 s2]
  ;;Funcion que reciba dos secuencias y retorne el primero de cada una,
  ;; luego el segundo de cada una, luego el tercero, etc.
  ;; Restricciones: interleave"
  (mapcat vector s1 s2) 
 )

(defn retrieve-caps [text]
  ;;Funcion que reciba un string y devuelva un nuevo string conteniendo solamente las mayusculas."
 (clojure.string/join "" (filter #(java.lang.Character/isUpperCase %) text))
  )

(defn find-truth [& xs]
  ;;Funcion que tome un numero variable de booleans, y devuelva true
  ;;solamente si alguno de los parametros son true, pero no todos son true. En otro
  ;;caso debera retornar false
  (if (some true? xs) true false)
  )

(defn zip-map [k v]
  ;;Funcion que reciba un vector de claves y un vector de valores, y
  ;;construya un mapa a partir de ellos.
  ;;Restricciones: zipmap"
  (into {} (map vector k v))  
  )
=======
(defn filter-odd
  "Escribir una funcion que retorne solamente los numeros impares de
   una secuencia"
  [s]
  (filter odd? s))

(defn nil-key
  "Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil"
  [k m]
  (and (contains? m k) (nil? (get m k))))

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  (if (= start end)
    '()
    (cons start (range (+ start 1) end))))

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  (reduce (fn [x, y] (if (= (last x) y)
                       x
                       (conj x y)))
          []
          s))

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args]
  (first (sort > args))
  ;o (reduce #(if (> %1 %2) %1 %2) args)
  )

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  [(take length s) (drop length s)])

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  (when (and (seq s1) (seq s2))
    (cons (first s1)
          (cons (first s2) (inter-two (rest s1) (rest s2))))))

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  (apply str (filter #(Character/isUpperCase %) text)))

(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  (and (some true? xs) (some false? xs)))

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  (reduce #(assoc %1 (%2 0) (%2 1)) {} (map vector k v)))
>>>>>>> 87520df46e8ed648cbcb69a2af7e7da0f9895d35
