package com.co.chat.persistence.tables

import java.sql.Date
import java.util.UUID

import com.co.chat.persistence.dtos.UserDTO
import slick.jdbc.PostgresProfile.api._

class UserTable(tag: Tag) extends Table[UserDTO](tag, "users") {

  def id = column[UUID]("id", O.PrimaryKey)

  def name = column[String]("name")

  def lastTimeConnection = column[Date]("last_time_connection")

  def createdAt = column[Date]("created_at")

  def originIp = column[String]("origin_ip")

  override def * = (id, name, lastTimeConnection, createdAt, originIp) <> (UserDTO.tupled, UserDTO.unapply)
}

