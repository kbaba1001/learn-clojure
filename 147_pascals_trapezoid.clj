;; (= (second (__ [2 3 2])) [2 5 5 2])
;; (= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])

;;  [2 3 2]
;; [2 5 5 2]

(second
 ((fn xxx [arr]
    (iterate
     (fn yyy [a]
       a)
     arr))

  [2 3 2]))
