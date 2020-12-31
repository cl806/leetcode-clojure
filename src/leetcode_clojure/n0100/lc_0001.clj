(ns leetcode-clojure.n0100.lc-0001)

;; https://leetcode.com/problems/two-sum/

(defn lc-0001 [coll tgt]
  (let [len (count coll)]
    (first (for [x (range len)
                 y (range len)
                 :let [a (coll x)
                       b (coll y)]
                 :when (and (= tgt (+ a b)) (< x y))]
             [x y]))))

(comment 
(lc-0001 [2 7 11 15] 9)
;; => [0 1]
(lc-0001 [3 2 4] 6)
;; => [1 2]
(lc-0001 [3 3] 6)
;; => [0 1]
  )
