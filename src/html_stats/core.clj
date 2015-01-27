(ns html-stats.core
  (:require [clojure.java.io :as io]
            [net.cgrand.enlive-html :as html]))


(defn parse-html-file []
  (with-open [re (io/reader "test/html_stats/sample.html")]
    (html/html-resource re)))

(defn count-tags
  [node]
  )

(defn analyse
  [parsed-html]
  {:number-of-tags (count-tags parsed-html)
   :foo 99})

(defn -main
  "Reads an html file and gives you some stats."
  [x]
  (let [parsed-html (parse-html-file)
        stats (analyse parsed-html)]
    (clojure.pprint/pprint {:stats stats})))
