package com.co.auth.core

import com.co.auth.api.WebServer


trait ApiCore {
  this: Core with BootedCore =>

  /**
    * Web server initialize
    */
  WebServer()
}
