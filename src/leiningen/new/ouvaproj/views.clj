(ns {{name}}.views
  (:use hiccup.core
        hiccup.page))









;- ----------------------------------------------------------------------------
;- 

(defn layout
  [& content]
  (html
    (doctype :html5)
    [:head 
      [:title "{{name}}"]
      
      [:link {:href "http://fonts.googleapis.com/css?family=Roboto:300,400" 
              :rel "stylesheet"}]
      [:link {:href "http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,100" 
              :rel "stylesheet"}]

      (include-css  "/bower_components/semantic/build/packaged/css/semantic.css"
                    "/css/style.css")
      
      (include-js "/bower_components/jquery/jquery.js"
                  "/bower_components/underscore/underscore.js"
                  "/bower_components/angular/angular.js"
                  "/bower_components/angular-route/angular-route.js"
                  "/bower_components/semantic/build/packaged/javascript/semantic.js"
                  "/js/app.js")]
    [:body.body  {"ng-app" "app"} content]))








;- ----------------------------------------------------------------------------
;- 

(defn index 
  []
  (layout 
    [:div.page.ng-view ""]))
