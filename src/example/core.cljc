(ns example.core
  (:require [example.lazy :refer [require-lazy]]
            #?(:cljs [cljs.loader :as loader])
            [rum.core :as rum]
            [react]))

(require-lazy '[example.components :refer [alert]])

(defn suspense [{:keys [fallback]} child]
  #?(:clj child
     :cljs (react/createElement react/Suspense
             #js {:fallback fallback}
             child)))

(rum/defc root []
  (suspense {:fallback "Hello!"}
    (alert "ARGUMENT")))

#?(:cljs (loader/set-loaded! :core))

#?(:cljs
    (rum/mount (root) (.getElementById js/document "root")))
