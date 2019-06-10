package server


import methods.ToopLanguageServer
import org.eclipse.lsp4j.launch.LSPLauncher
import java.net.ServerSocket



object Main extends App {
  val port = 7999
  val socket = new ServerSocket(port).accept()
  val input = socket.getInputStream
  val output = socket.getOutputStream
  val server = new ToopLanguageServer
  val launcher = LSPLauncher.createServerLauncher(
    server,
    input,
    output,
  )
  launcher.startListening
}
