(ns ozimos.gui7.core
    (:require
     [reagent.core :as reagent]
     [re-frame.core :as re-frame]
     [ozimos.gui7.events :as events]
     [ozimos.gui7.views :as views]
     [ozimos.gui7.config :as config]
     ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))


(comment
  
  (js/alert "Hello There"))
