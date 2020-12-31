(ns leetcode-clojure.n0100.lc-0001)

;; https://leetcode.com/problems/add-two-numbers/

(defn vec-to-num [coll]
  (loop [c (reverse coll)
         result 0]
    (if (seq c)
      (recur (rest c) (+ (* 10 result) (first c)))
      result)))

(defn num-to-vec [num]
  (loop [n num
         result []]
    (if (< n 10)
      (conj result n)
      (recur (quot n 10) (conj result (mod n 10))))))

(defn lc-0002 [coll1 coll2]
  (num-to-vec (+ (vec-to-num coll1)
                 (vec-to-num coll2))))

(comment
  (lc-0002 [2,4,3] [5,6,4])
;; => [7 0 8]
  (lc-0002 [9,9,9,9,9,9,9] [9,9,9,9])
;; => [8 9 9 9 0 0 0 1]
  )
