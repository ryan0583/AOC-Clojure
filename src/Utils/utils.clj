(ns Utils.utils)

(defn readlines [filename]
  (clojure.string/split-lines (slurp filename))
  )


