(ns eight-queen
  (:require [clojure.string :as s]))

(defn permutations [s]
  (lazy-seq
   (if (next s)
     (for [head s
           tail (permutations (disj s head))]
       (cons head tail))
     [s])))

(defn conflict? [x y board]
  (->> (map-indexed vector (take y board))
       (some (fn [[y1 x1]]
               (or
                (= (- x1 y1) (- x y))
                (= (+ x1 y1) (+ x y)))))))

(defn check? [board]
  (->> (map-indexed vector board)
       (every? (fn [[y x]] (not (conflict? x y board))))))

(defn queen [n]
  (->> (permutations (set (range n)))
       (some #(when (check? %) %))))

(defn display-queen [n]
  (let [board (atom (vec (repeat n (vec (repeat n ".")))))
        queens (map-indexed vector (queen n))]
    (doseq [coordinate queens]
      (reset! board (assoc-in @board coordinate "Q")))
    (println (s/join "\n" (map #(s/join " " %) @board)))))

(display-queen 8)
