package com.co.chat.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import com.co.chat.api.routes.ExampleRoute
import com.co.chat.config.AppConfig
import com.typesafe.scalalogging.LazyLogging


/**
  * Web server that initialize akka-http server
  * @param system
  * @param appConfig
  */
case class WebServer() (implicit val system: ActorSystem, val appConfig: AppConfig) extends LazyLogging {

  import appConfig._

  implicit private val actorMat: ActorMaterializer = ActorMaterializer(ActorMaterializerSettings(system))


  private val routes : Route = ExampleRoute().route

  Http().bindAndHandle(routes, apiServerHost, apiServerPort)

  logger.info(s"Server online at http://$apiServerHost:$apiServerPort.....")

}
