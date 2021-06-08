(ns Utils.utils (:require [clojure.java.io :as io]))

(defn readlines [filename]
  (with-open [rdr (io/reader filename)]
    (doall (line-seq rdr))))


