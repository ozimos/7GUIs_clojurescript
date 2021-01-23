(ns ozimos.gui7.views
    (:require
     [re-frame.core :as re-frame]
     [re-com.core :as re-com]
     [ozimos.gui7.subs :as subs]
     [ozimos.gui7.events :as ev]
     ))

(defn title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :label (str "Hello from " @name)
     :level :level1]))

(defn count-button []
 [re-com/button :label "Count"
  :class "btn btn-primary"
  :on-click (fn [e] 
              (.preventDefault e)
              (re-frame/dispatch [::ev/inc-counter]))] )

(defn count-display []
  (let [v @(re-frame/subscribe [::subs/counter])]
    [:p {:style {:text-align "center" :width "50px" :font-size "20px" :margin "0 50px"}} v]))

(defn app [] 
  [re-com/h-box 
   :children [[count-display]
              [count-button]
              ]])

(defn main-panel []
  [re-com/v-box
   :height "100%"
   :children [[title]
              [app]
              ]])
