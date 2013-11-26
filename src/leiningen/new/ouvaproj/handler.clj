(ns {{name}}.handler
  (:use compojure.core
        org.httpkit.server)
  (:require [liberator.core :refer [resource defresource]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [{{name}}.views :as views])
  (:gen-class))







;- ----------------------------------------------------------------------------
;- 

(defresource index 
  :available-media-types ["text/html"]
  :handle-ok (views/index))




;- ----------------------------------------------------------------------------
;- 

(defroutes app-routes
  (GET "/" [] index)
  (route/resources "/")
  (route/not-found "Not Found"))





;- ----------------------------------------------------------------------------
;- 

(def app
  (handler/site app-routes))





;- ----------------------------------------------------------------------------
;- 

(defn -main [& args]
  (run-server app {:port {{port}}}))