(ns spring-repl.nrepl
  (:require
    [nrepl.server :refer [start-server stop-server]]
    [cider.nrepl :refer [cider-nrepl-handler]]
    [clojure.tools.logging :as log]))

(def repl-server (atom nil))

(defn spring-repl-port [] (if-let [p (System/getProperty "springReplPort")] (Integer/parseInt p) 8000))

(defn start-repl []
  (log/info "Starting nrepl server on " (spring-repl-port))
  (reset! repl-server (start-server :port (spring-repl-port) :bind "0.0.0.0" :handler cider-nrepl-handler)))
