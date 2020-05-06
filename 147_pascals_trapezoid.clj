;; 4 clojure  http://www.4clojure.com/problem/147
;; (= (second (__ [2 3 2])) [2 5 5 2])
;; (= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
;; (= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])
;; (= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))

(fn [arr] (iterate #(mapv (fn [[a b]] (+' a b)) (partition 2 1 (cons 0 (conj % 0)))) arr))
