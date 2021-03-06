/*
 * Copyright 2016 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.heikoseeberger.trialsbtweb

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object App {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    implicit val mat = ActorMaterializer()

    def route = {
      import Directives._
      def assets =
        getFromResourceDirectory("web") ~ pathSingleSlash(get(redirect("index.html", StatusCodes.PermanentRedirect)))
      assets
    }

    Http(system).bindAndHandle(route, "localhost", 8000)
    Await.ready(system.whenTerminated, Duration.Inf)
  }
}
