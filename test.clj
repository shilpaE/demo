(ns subcode.code
  (require [clojure.set :as set])
  (require [clojure.data.json :as json])
  (require [clojure.java.io :as io] [clojure.edn :as edn])
  
  (:gen-class :main true
              :name subcode.code
              :methods [#^{:static true} [codding [String String] String]])
  
  (:import (java.lang String))
  (:require [clojure.string :as str]))

(defn codding [x y]
 (((def all-rec (json/read-str (slurp x)))
      
      (def sss (into #{}
                     (for [ x (get all-rec "measures")] 
                       (clojure.string/replace (get x "fullyQualifiedName") #"/" "."))))
      
      (def z(clojure.string/replace (slurp  y) #"#synapse.clinical.programs.ProgramDef" " "))
      (def w (clojure.edn/read-string (str " " z " ")))
      (def aaa(into #{} (for [y (get w :measures)] 
                          (clojure.string/replace (get y :name) #"/" "."))))
      
      (def out1( clojure.set/difference aaa sss))
      (def out2( clojure.set/difference sss aaa))
      ;;(spit "result.txt" out1 :append true)
    ;;(spit "result.txt" out2 :append true)
    (with-open [w (clojure.java.io/writer "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\result.txt" :append true)]
        (.write w (str out1))
        (.write w (str out2))))
 ;;(str "hello")
  (println out2)
 )

(codding "C:\\Users\\se056529\\Documents\\choc1.json" "C:\\Users\\se056529\\Downloads\\app-rules-5.0.0\\algorithms\\registry-programs\\cernerstandard.adolescentwellness.clinical.program_ruleset_description.edn")
(defn -codding [x y]
  (codding x y))

(defn -main[])
