package com.co.auth.config

import com.typesafe.config.{Config, ConfigFactory}


/**
  * Main configuration system
  * @param config: Typesafe config
  */
case class AppConfig(config: Config = ConfigFactory.load()) {

  private lazy val akkaConfig: Config = config.getConfig("akka-config")
  lazy val akkaSystemName: String = akkaConfig.getString("system-name")


}
