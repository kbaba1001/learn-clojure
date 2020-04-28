(def init-numbers (zipmap (range 10) (repeat 10 false)))

(defn sqrt-seq [n]
  (map-indexed (fn [idx itm] [idx itm]) (map read-string (re-seq #"\d" (format "%10.20f" (Math/sqrt n))))))

(defn counter [n]
  (let [numbers (atom init-numbers)]
    (last (for [[index item] (sqrt-seq n)
                :while (not-every? true? (vals @numbers))]
            (do
              (swap! numbers assoc item true)
              index)))))

(loop [n 2]
  (if (= (counter n) 10)
    n
    (recur (inc n))))
; (apply min-key counter (range 100))
