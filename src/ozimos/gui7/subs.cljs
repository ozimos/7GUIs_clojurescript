(ns ozimos.gui7.subs
    (:require
     [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::counter
 (fn [db]
   (:counter db)))