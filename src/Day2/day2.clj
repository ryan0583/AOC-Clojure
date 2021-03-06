(ns Day2.day2
  (:require [Utils.utils :as utils])
(:require [clojure.string :as stringFn]))

(def lines (utils/readlines "resources/Day2/Input.txt"))

(defn parseMin [line] (Integer/parseInt (subs line 0 (stringFn/index-of line "-"))))
(defn parseMax [line]  (Integer/parseInt (subs line (inc (stringFn/index-of line "-")) (stringFn/index-of line " "))))
(defn parseLetter [line] (first (seq (subs line (inc (stringFn/index-of line " ")) (stringFn/index-of line ":")))))
(defn parsePassword [line] (seq (subs line (+ 2 (stringFn/index-of line ": ")))))
(defn parseLine [line] {:min (parseMin line)
                        :max (parseMax line)
                        :letter (parseLetter line)
                        :password (parsePassword line)})

(defn countLetter [letter password]
  (->> password
       (filter #(= letter %))
       (count)
       )
  )

(defn checkValid [letter min max password]
  (<= min (countLetter letter password) max))

(def parsed
  (->> lines
       (map #(parseLine %))
       )
  )

(defn validCount [validFn]
  (count
    (filter
      #(validFn (:letter %)
                   (:min %)
                   (:max %)
                   (:password %)
                   )
      parsed
      )
    ))

(print "Part 1: ")
(println (validCount checkValid))

(defn match [letter pos password] (->> letter(= (nth password (dec pos)))))

(defn singleMatch [letter min max password] (->> (match letter max password)(or (match letter min password))))

(defn bothMatch [letter min max password] (->> (match letter max password)(and (match letter min password))))

(defn checkValid2 [letter min max password]
  (->> (not (bothMatch letter min max password))
      (and (singleMatch letter min max password))
      )
  )

(print "Part 2: ")
(println (validCount checkValid2))

