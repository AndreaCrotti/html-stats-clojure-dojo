(ns html-stats.core
  (:require [clojure.java.io :as io]
            [net.cgrand.enlive-html :as html]
            [clojure.zip :as z]))


(defn parse-html-file []
  (with-open [re (io/reader "test/html_stats/sample.html")]
    (html/html-resource re)))

(defn has-children [node] (and (map? node) (contains? node :content)))

(defn analyse
  [parsed-html]
  {:number-of-tags (frequencies (remove nil? (map :tag (tree-seq has-children :content {:content parsed-html}))))
   :foo 99})

(defn -main
  "Reads an html file and gives you some stats."
  [& args]
  (let [parsed-html (parse-html-file)
        stats (analyse parsed-html)]
    (clojure.pprint/pprint {:stats stats})))
