(ns Day1.day1
  (:require [clojure.math.combinatorics :as combo])
  (:require [Utils.utils :as utils]))

(def lines (map #(Integer/parseInt %) (utils/readlines "resources/Day1/Input.txt")))

(defn findRemainder [val] (- 2020 val))

(defn remainderInList [val] (some #(= (findRemainder val) %) lines))

(defn pairSumRemainderInList [pair] (remainderInList (+ (nth pair 0) (nth pair 1))))

(def result1
  (first
    (filter
      #(remainderInList %)
      lines
      )
    )
  )

(print "part 1: ")
(println (* result1 (- 2020 result1)))

(def result2
  (first
    (filter
      #(pairSumRemainderInList %)
      (combo/combinations lines 2)
      )
    )
  )

(def val1 (nth result2 0))
(def val2 (nth result2 1))

(print "part 2: ")
(println (* val1 val2 (- 2020 val1 val2)))