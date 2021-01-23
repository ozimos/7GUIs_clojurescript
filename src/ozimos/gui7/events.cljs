(ns ozimos.gui7.events
    (:require
     [re-frame.core :as re-frame]
     [ozimos.gui7.db :as db]
     [day8.re-frame.tracing :refer-macros [fn-traced]]
     ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re-frame/reg-event-db ::inc-counter (fn-traced [db [_ _]]
                                                (update db :counter inc)))