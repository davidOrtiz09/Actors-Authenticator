package com.co.chat.config

import com.typesafe.config.{Config, ConfigFactory}


/**
  * Main configuration system
  * @param config: Typesafe config
  */
case class AppConfig(config: Config = ConfigFactory.load()) {


  //------------------------------------------------
  //                 AKKA CONFIGURATIONS
  //------------------------------------------------
  private lazy val akkaConfig: Config = config.getConfig("akka-config")
          lazy val akkaSystemName: String = akkaConfig.getString("system-name")


  //------------------------------------------------
  //                   API CONFIGURATIONS
  //------------------------------------------------
  private lazy val apiServerConfig: Config = config.getConfig("api-config")
          lazy val apiServerHost: String = apiServerConfig.getString("host")
          lazy val apiServerPort: Int = apiServerConfig.getInt("port")



  //------------------------------------------------
  //                   SLICK CONFIGURATIONS
  //------------------------------------------------

   lazy val postgreesConfig: Config = config.getConfig("postgrees-config")




}
