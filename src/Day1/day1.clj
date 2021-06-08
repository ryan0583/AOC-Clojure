(ns Day1.day1 (:require [Utils.utils :as utils]))

(def lines (map #(Integer/parseInt %) (utils/readlines "resources/Day1/Input.txt")))

(doseq [i lines]
  (doseq [j lines]
    (if (= 2020 (+ i j))
      (def result1 (* i j))
      )
    )
  )

(print "part 1: ")
(println result1)


(doseq [i lines]
  (doseq [j lines]
    (doseq [k lines]
      (if (= 2020 (+ i j k))
        (def result2 (* i j k))
        )
      )
    )
  )

(print "part 2: ")
(println result2)