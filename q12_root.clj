(zipmap (range 10) (repeat 10 false))

(defn sqrt-seq [n]
  (map-indexed (fn [idx itm] [idx itm]) (re-seq #"\d" (format "%10.20f" (Math/sqrt n)))))
; ([0 "1"]
;  [1 "4"]
;  [2 "1"]
;  [3 "4"]
;  [4 "2"]...

(for [x (sqrt-seq 2)]
  (println x))
