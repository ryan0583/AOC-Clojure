(ns Day3.day3
  (:require [Utils.utils :as utils]))

(def lines (->> (utils/readlines "resources/Day3/Input.txt")
                (map #(seq %))))

(def maxX (count (first lines)))
(def maxY (count lines))

(defn isTree [x y]
  (->> (mod x maxX)
       (nth (nth lines y))
       (= \#))
  )

(defn checkTrees [yStep xStep]
  (for [point (range (int (Math/floor (/ maxY yStep))))
        :let [y (* point yStep) ]
        :let [x (* point xStep)]
        :when (isTree x y)] {:x x :y y}))

(println (count (checkTrees 1 3)))

(def totalTrees (for [slope ['(1 1) '(1 3) '(1 5) '(1 7) '(2 1)]]
                  (count (checkTrees (first slope) (second slope)))
                  )
  )

(println (->> totalTrees(reduce *)))