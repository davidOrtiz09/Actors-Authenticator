package com.co.chat.persistence.dtos

import java.sql.Date
import java.util.UUID



/**
  * Represents a chat user dto
  */
case class UserDTO(id: UUID , name: String , lastTimeConnection: Date ,createdAt : Date , originIp: String)

