package com.co.chat.config

import slick.basic.DatabaseConfig
import slick.jdbc.{JdbcBackend, JdbcProfile, PostgresProfile}



sealed trait SlickDbConfig {

  protected def configDefined: DatabaseConfig[_ <: JdbcProfile]

  /**
    * Data base Connection.
    */
  lazy val db: JdbcBackend#Database = configDefined.db

  /**
    * Slick's profile to connect to a db
    */
  lazy val profile: JdbcProfile = configDefined.profile


}


case class PostgreesConfig(implicit appConfig: AppConfig) extends SlickDbConfig {


  protected def configDefined: DatabaseConfig[PostgresProfile] = {
    DatabaseConfig.forConfig[PostgresProfile]("",appConfig.postgreesConfig)
  }
}


