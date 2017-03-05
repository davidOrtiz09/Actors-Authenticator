package com.co.chat.api.routes

import akka.actor.ActorSystem
import com.co.chat.config.AppConfig
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


/**
  * Example route to test server functionality
  * @param appConfig
  * @param system
  */
case class ExampleRoute()(implicit appConfig: AppConfig, val system: ActorSystem){


  def route: Route =
    path("example") {
      get {
        complete("I'm running")
      }
    }

}
