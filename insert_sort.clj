(defn insert-sort [arr]
  (loop [result [] remain arr]
    (let [min-v (apply min remain)
          new-result (conj result min-v)
          new-remain (apply vector (disj (set remain) min-v))]
      (if (empty? new-remain)
        new-result
        (recur new-result new-remain)))))

(insert-sort [8, 5, 4, 1, 9, 6, 7, 3, 2])
