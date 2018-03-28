(ns vvv
   (:gen-class) (:require [clojure.data.json :as json])
  (:require [clojure.java.io :as set]))
(def a(hash-set  ))
(def b(hash-set :a :b))
(try (cond
       (and (empty? a) (empty? b))(println "Both r empty")
       (empty? a) ((println b)(println "data in b"))
       (empty? b)( (println a)(println "data in a"))
       :else (do(println "data in both a and b")(println a b))
       )
     (catch Exception e (println (str " " (.getMessage e)))))

