;; https://en.wikipedia.org/wiki/Insertion_sort

;; ヒープソート?
;; (defn insertion-sort [coll]
;;   (reduce
;;    (fn [r x]
;;      (let [{left true right false} (group-by #(> x %) r)]
;;        (concat left right)))
;;    coll
;;    coll))

(defn insert [n coll]
  (cond
    (empty? coll) (list n)
    (> (first coll) n) (conj coll n)
    :else (conj (insert n (next coll)) (first coll))))

(defn insertion-sort [coll]
  (loop [list coll
         result ()]
    (if (empty? list)
      result
      (recur (next list) (insert (first list) result)))))

(println (insertion-sort [8 3 1 5 2 1]))
