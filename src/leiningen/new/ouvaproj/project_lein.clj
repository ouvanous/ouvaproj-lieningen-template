(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [liberator "0.10.0"]
                 [http-kit "2.1.13"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler {{name}}.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :main {{name}}.handler
  :aot :all)
