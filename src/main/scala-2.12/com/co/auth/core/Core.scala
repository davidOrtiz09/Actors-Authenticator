package com.co.auth.core

import akka.actor.ActorSystem
import com.co.auth.config.AppConfig

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
