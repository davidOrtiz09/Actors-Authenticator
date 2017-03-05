package com.co.chat.core

import com.co.chat.api.WebServer


trait ApiCore {
  this: Core with BootedCore =>

  /**
    * Web server initialize
    */
  WebServer()
}
