(ns code-katas-1.core)

(defn filter-odd [numeros]
  ; Escribir una funcion que retorne solamente los numero impares de una secuencia
  (filter odd? numeros) 
  )

(defn nil-key [clave mapa]
 ;;Escribir una funcion que dada una clave y un mapa devuelce true, solamente si el mapa contiene una entrada con esa clave, y su valor es nil
 (if (and (nil? (get mapa clave)) (contains? mapa clave)) true false)
 )

(defn range [start end]
   ;;Escribir una funcion que cree una lista de enteros en un rango dado.
   ;;Restricciones: range
  (when (distinct? start end) (do (cons  start (range (+ start 1) end)))) 
  )
 

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  )

(defn max-value [& args]
  ;;Escribir una funcion que reciba un numero variable de parametros y retorne el que tenga el valor mayor
  ;;Restricciones: max y max-key"
  (first(sort > args))
  )

(defn split-two [length secuencia]
  ;;Escribir una funcion que parta una secuencia en dos partes
  ;;Restricciones: split-at
  (vec (cons (vec(take length secuencia)) (cons (vec(drop length secuencia)) ())))
  )

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  )

(defn retrieve-caps [text]
  ;;Funcion que reciba un string y devuelva un nuevo string conteniendo solamente las mayusculas."
 (clojure.string/join "" (filter #(java.lang.Character/isUpperCase %) text))
  )

(defn find-truth [& xs]
  ;;Escribir una funcion que tome un numero variable de booleans, y devuelva true
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
