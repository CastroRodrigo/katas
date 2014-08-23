(ns code-katas-1.core)

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
  (when (or (not(empty? s1)) (not(empty? s2))) 
    (do (cons (first s1) (cons (first s2) (inter-two (rest s1) (rest s2))))))
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

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  )
