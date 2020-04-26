(def rank {+ 0 - 0 * 1 / 2})

(defn converter [exp]
  (with-local-vars [result [] stack []]
    (letfn [(push [st v] (var-set st (conj @st v)))
            (-pop [st] (var-set st (pop @st)))]
      (doseq [a exp]
        (cond
          (number? a) (push result a)
          (= a "(") (push stack a)
          (= a ")") (do
                      (doseq [s (reverse @stack)
                              :when (not (= s "("))]
                        (push result s)
                        (-pop stack))
                      (-pop stack))
          :else (do
                  (doseq [s (reverse @stack)
                          :while (not (= s "("))
                          :when (>= (rank s) (rank a))]
                    (push result s)
                    (-pop stack))
                  (push stack a))))
      (concat @result (reverse @stack)))))

;; (println (converter [3 + 4]))
;; (println (converter [20 / 2 - 6 - 10 * 9]))
;; (println (converter ["(" 3 + 4 ")" * "(" 1 - 2 ")"]))

(defn calc [exp]
  (first
   (reduce
    (fn [r x]
      (if (number? x)
        (conj r x)
        (let [a (peek r)
              b (peek (pop r))]
          (conj (pop (pop r)) (x b a)))))
    []
    exp)))

(-> [3 + 4]
    converter
    calc
    println)
(-> [20 / 2 - 6 - 10 * 9]
    converter
    calc
    println)
