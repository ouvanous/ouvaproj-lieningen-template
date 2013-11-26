








# •••  APP                        •••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••
 
window.app = angular.module 'app', ['ngRoute']









# •••  ROUTES                     •••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••


app.config [

  '$routeProvider', '$httpProvider'
  
  ($routeProvider, $httpProvider) ->
    $routeProvider

      .when '/', 
        templateUrl: '/templates/base-layout.html'
        controller: app.IndexCtrl

      .otherwise
        redirectTo: '/'


    # this is found here: https://vickev.com/#!/article/authentication-in-single-page-applications-node-js-passportjs-angularjs
    # it to intercept a 401 response status (user not logged) and redirect to /login
    # seems to be unnecessary since persona do the redirection. 
    
    # $httpProvider.responseInterceptors.push ($q, $location) ->
    #   (promise) ->
    #     promise.then(  
    #       (response) -> 
    #         response
    #       , 
    #       (response) -> 
    #         if res.ponse.status is 401
    #           $location.url '/login'
    #         $q.reject response)

]

