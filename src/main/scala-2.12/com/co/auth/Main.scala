package com.co.auth

import com.co.auth.core.{ApiCore, BootedCore, Core}


object Main extends App with Core with BootedCore with ApiCore
