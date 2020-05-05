(def countries ["brazil" "croatia" "mexico" "cameroon" "spain" "netherlands" "chile" "australia" "colombia" "greece" "cote d'lvoire" "japan" "uruguay" "costa rica" "england" "italy" "switzerland" "ecuador" "france" "honduras" "argentina" "bosnia and herzegovina" "iran" "nigeria" "germany" "portugal" "ghana" "usa" "belgium" "algeria" "russia" "korea republic"])

(defn shiritori [c cs count]
  (let [next-cs (filter (fn [x] (= (first x) (last c))) cs)]
    (if (empty? next-cs)
      count
      (apply max (for [next-c next-cs]
                   (shiritori next-c (disj (set cs) next-c) (inc count)))))))

(apply max (map #(shiritori % countries 1) countries))
