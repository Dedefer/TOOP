package methods

import java.io.File
import java.net.URI
import java.util
import java.util.concurrent.CompletableFuture

import scala.io.Source
import expressions.Parser
import org.eclipse.lsp4j.{DidChangeTextDocumentParams, DidCloseTextDocumentParams, DidOpenTextDocumentParams, DidSaveTextDocumentParams, DocumentFormattingParams, Position, Range, TextEdit}
import org.eclipse.lsp4j.services.TextDocumentService

class ToopTextDocumentService extends TextDocumentService {
  override def didChange(params: DidChangeTextDocumentParams): Unit = {}
  override def didOpen(params: DidOpenTextDocumentParams): Unit = {}
  override def didClose(params: DidCloseTextDocumentParams): Unit = {}
  override def didSave(params: DidSaveTextDocumentParams): Unit = {}

  override def formatting(params: DocumentFormattingParams): CompletableFuture[util.List[_ <: TextEdit]] = {

    val file = new File(
      new URI(params.getTextDocument.getUri)
    )
    val content = Source.fromFile(file)
    val content_str = content.mkString
    val result = Parser.parse(content_str)
      .getOrElse(content_str).toString
    val response = new util.ArrayList[TextEdit]
    response.add(new TextEdit(
      new Range(
        new Position(0, 0),
        new Position(content.length - 1, file.list.last.length - 1)
      ),
      result
    ))
    content.close()
    CompletableFuture.completedFuture(response)
  }
}