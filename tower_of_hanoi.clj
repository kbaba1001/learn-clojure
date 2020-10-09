;; 【問題】N段のハノイの塔を解くプログラムを作成してください。ハノイの塔のルールは次のとおりです。
;; 
;; * 3本の杭と、中央に穴の開いた大きさの異なる複数の円盤があります。
;; * 最初はすべての円盤が左端の杭に小さいものが上になるように順に積み重ねられています
;; * 円盤を一回に一枚ずつどれかの杭に移動させることができるが、小さな円盤の上に大きな円盤を乗せることはできません
;; * すべての円盤を上記のルールに従って右端の杭に移動してください
;; 
;; プログラムでは杭を左からA, B, Cとし、円盤を小さい方から1,2,3,...として表現します。円盤を移動するたびに次のように杭と円盤の状態を表示してください。
;; 
;; 入力: n (任意の自然数。ひとまず3, 5, 10 の場合で動けば良しとします)
;; 出力例 (n = 3 の例):
;; A: 3 2 1
;; B:
;; C: 
;; ------
;; A: 3 2 
;; B:
;; C: 1
;; ------
;; A: 3
;; B: 2
;; C: 1
;; ------
;; A: 3
;; B: 2 1
;; C: 
;; ------
;; A: 
;; B: 2 1
;; C: 3
;; ------
;; A: 1
;; B: 2
;; C: 3
;; ------
;; A: 1
;; B: 
;; C: 3 2
;; ------
;; A: 
;; B: 
;; C: 3 2 1
;; 
;; n = 1
;; ------
;; A: 1
;; B:
;; C:
;; ------
;; A:
;; B:
;; C: 1
;; 
;; n = 2
;; ------
;; A: 2 1
;; B:
;; C:
;; ------
;; A: 2
;; B:
;; C: 1
;; (A -> C)
;; ------
;; A: 
;; B: 2
;; C: 1
;; (A -> B)
;; ------
;; A: 1
;; B: 2
;; C: 
;; (C -> A)
;; ------
;; A: 1
;; B: 
;; C: 2
;; (B -> C)
;; ------
;; A: 
;; B: 
;; C: 2 1
;; (A -> C)

(defn hanoi
  ([n] (hanoi n (vec (reverse (range 1 (inc n)))) [] []))
  ([n a b c]
   (println "A: " a "\nB: " b "\nC: " c "\n---------")
   (let [va (vec a)
         vb (vec b)
         vc (vec c)]
     (when-not (= (count vc) n)
    ;;  a = 2, b = 0, c = 1
       ;; TODO nil を 0 にするアプローチダメそう
       (if (< ((fnil identity 0) (last vc)) (last va))
         (hanoi n (take (dec (count va)) va) vb (conj vc (last va)))
         (if (< ((fnil identity 0) (last vb)) (last va))
           (hanoi n (take (dec (count va)) va) (conj vb (last va)) vc)
           (if (< ((fnil identity 0) (last va)) (last vc))
             (hanoi n (conj va (last vc)) vb (take (dec (count vc)) vc))
             (when (< ((fnil identity 0) (last vc)) (last vb))
               (hanoi n va (take (dec (count vb)) vb) (conj vc (last vb)))))))))))

(hanoi 2)
