(ns leetcode-clojure.n0100.lc-0003)

;; https://leetcode.com/problems/longest-substring-without-repeating-characters/

;; solution #1
(defn no-repeating? [s]
  (let [chars (seq s)]
    (= (count chars) (count (set chars)))))

(defn lc-0003 [s]
  (if (empty? s)
    0
    (->> (let [len (inc (count s))]
           (for [x (range len)
                 y (range len)
                 :when (< x y)
                 :let [sub (subs s x y)]
                 :when (no-repeating? sub)]
             sub))
         (map count)
         (apply max))))

(comment
(lc-0003 "abcabcbb")
;; => 3
(lc-0003 "bbbbb")
;; => 1
(lc-0003 "pwwkew")
;; => 3
(lc-0003 "")
;; => 0
  )

;; solution #2
(defn lc-0003b [s]
  (loop [i (seq s) m #{} r 0 t i]
    (let [x (first i)]
      (cond
        (or (empty? i) (< (+ (count m) (count i)) r)) r
        (m x) (let [[a b] (split-with (partial not= x) t)
                    c (conj a x)
                    d (rest b)]
                (recur i (apply disj m c) r d))
        :else (recur (rest i) (conj m x) (max r (inc (count m))) t)))))

(comment
  (lc-0003b "abcabcbb")
  ;; => 3
  (lc-0003b "bbbbb")
  ;; => 1
  (lc-0003b "pwwkew")
  ;; => 3
  (lc-0003b "")
  ;; => 0
  )