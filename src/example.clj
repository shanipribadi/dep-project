(ns example
  (:require [clojure.tools.logging :as log]
            [clojure.tools.logging.impl]))

(defn divide [x y]
  (log/info "dividing" x "by" y)
  (try
    (log/spyf "result: %s" (/ x y)) ; yields the result
    (catch Exception ex
      (log/error ex "There was an error in calculation"))))

(intern 'clojure.tools.logging '*logger-factory* (clojure.tools.logging.impl/log4j2-factory))
