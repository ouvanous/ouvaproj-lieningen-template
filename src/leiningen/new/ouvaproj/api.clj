(ns {{name}}.api
  (:use compojure.core)
  (:require [liberator.core :refer [resource defresource]]))











;- ----------------------------------------------------------------------------
;- 

; (defresource get-rdfa 
;   [uri]
;   :available-media-types ["text/turtle" "application/json" "application/rdf+xml"]
;   :exists? (not (nil? uri))
;   :handle-ok 
;     #(let [media-type (get-in % [:representation :media-type])]
;       (condp = media-type 
;         "text/turtle" (get-rdfa-for uri :turtle)
;         "application/json" (get-rdfa-for uri :json)
;         "application/rdf+xml" (get-rdfa-for uri :xml)))
;   :handle-not-acceptable get-available-media-types)
