package com.co.chat.core

import akka.actor.ActorSystem
import com.co.chat.config.AppConfig

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Core elements initiated
  */
trait BootedCore extends Core {

  implicit val appConfig: AppConfig = AppConfig()
  implicit val system: ActorSystem = ActorSystem(appConfig.akkaSystemName , appConfig.config)

  sys.addShutdownHook {
    Await.ready(system.terminate(), Duration.Inf)
    ()
  }
}

/**
  * Core elements of the app
  */
trait Core {

  implicit def appConfig: AppConfig

  implicit def system: ActorSystem
}
