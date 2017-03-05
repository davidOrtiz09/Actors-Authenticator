package com.co.chat

import com.co.chat.core.{ApiCore, BootedCore, Core}


object Main extends App with Core with BootedCore with ApiCore
