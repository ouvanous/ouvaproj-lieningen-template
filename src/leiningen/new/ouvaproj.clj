(ns leiningen.new.ouvaproj
  (:use [leiningen.new.templates :only [renderer sanitize year ->files]]
        [leinjacker.utils :only [lein-generation]])
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))


(defn binary [file]
  (io/input-stream (io/resource(str/join "/" ["leiningen" "new" "ouvaproj" file]))))


(defn ouvaproj
  "Create a new Liberator project"
  [name & port]
  (let [data {:name name
              :sanitized (sanitize name)
              :year (year)
              :port (first port)}
        render #((renderer "ouvaproj") % data)]
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project_lein.clj")]
             ["run.sh" (render "run.sh")]
             ["README.md"   (render "README.md")]
             ["src/{{sanitized}}/handler.clj"       (render "handler.clj")]
             ["src/{{sanitized}}/api.clj"           (render "api.clj")]
             ["src/{{sanitized}}/views.clj"         (render "views.clj")]
             ["test/{{sanitized}}/test/handler.clj" (render "handler_test.clj")]
             "resources/public"
             "resources/public/css"
             ["resources/public/css/styles.styl" (binary "styles.styl")]
             "resources/public/templates"
             "resources/public/js"
             ["resources/public/js/app.coffee" (binary "app.coffee")]
             ["resources/public/js/controllers.coffee" (binary "controllers.coffee")]
             ["resources/public/js/directives.coffee" (binary "directives.coffee")]
             ["resources/public/js/services.coffee" (binary "services.coffee")]
             "resources/public/images"
             "resources/public/bower_components"
             ["resources/public/bower_components/jquery/jquery.js" (binary "bower_components/jquery/jquery.js")]
             ["resources/public/bower_components/underscore/underscore.js" (binary "bower_components/underscore/underscore.js")]
             ["resources/public/bower_components/angular/angular.js" (binary "bower_components/angular/angular.js")]
             ["resources/public/bower_components/semantic/build/packaged/javascript/semantic.js" (binary "bower_components/semantic/build/packaged/javascript/semantic.js")]
             ["resources/public/bower_components/semantic/build/packaged/css/semantic.css" (binary "bower_components/semantic/build/packaged/css/semantic.css")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/basic.icons.eot" (binary "bower_components/semantic/build/packaged/fonts/basic.icons.eot")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/basic.icons.svg" (binary "bower_components/semantic/build/packaged/fonts/basic.icons.svg")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/basic.icons.ttf" (binary "bower_components/semantic/build/packaged/fonts/basic.icons.ttf")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/basic.icons.woff" (binary "bower_components/semantic/build/packaged/fonts/basic.icons.woff")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/icons.eot" (binary "bower_components/semantic/build/packaged/fonts/icons.eot")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/icons.otf" (binary "bower_components/semantic/build/packaged/fonts/icons.otf")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/icons.svg" (binary "bower_components/semantic/build/packaged/fonts/icons.svg")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/icons.ttf" (binary "bower_components/semantic/build/packaged/fonts/icons.ttf")]
             ["resources/public/bower_components/semantic/build/packaged/fonts/icons.woff" (binary "bower_components/semantic/build/packaged/fonts/icons.woff")])
(println (str "http-kit will use port " (:port data)))))
