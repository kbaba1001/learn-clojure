(def n 10)
(def steps 4)

(defn move [a b]
  (if (> a b)
    0
    (if (= a b)
      1
      (apply + (for [da (range 1 (inc steps))
                     db (range 1 (inc steps))]
                 (move (+ a da) (- b db)))))))

(move 0 n)
