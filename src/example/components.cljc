(ns example.components
  (:require [rum.core :as rum]
            #?(:cljs [cljs.loader :as loader])))

(rum/defc alert [arg]
  [:h1 arg])

#?(:cljs (loader/set-loaded! :components))
