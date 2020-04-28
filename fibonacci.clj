(def fib-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+ a b)))))
   0 1))

(defn fibonacci [n]
  (take 1 (drop n fib-seq)))

(fibonacci 5)
