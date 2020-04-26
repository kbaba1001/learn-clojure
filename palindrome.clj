;; 10進数、2進数、8進数のいずれで表現しても回文数となる数のうち、10進数の10以上で最小の値を求めてください。

(defn palindrome [number]
  (let [str-number (str number)]
    (= str-number (apply str (reverse str-number)))))

(loop [x 11]
  (let [b (Integer/toString x 2)
        o (Integer/toString x 8)]
    (if (and (palindrome x) (palindrome b) (palindrome o))
      x
      (recur (+ x 2)))))
