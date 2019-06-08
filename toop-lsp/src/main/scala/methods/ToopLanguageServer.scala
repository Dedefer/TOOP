package methods

import java.util.concurrent.CompletableFuture

import org.eclipse.lsp4j.{InitializeParams, InitializeResult, InitializedParams, ServerCapabilities}
import org.eclipse.lsp4j.services.{LanguageServer, TextDocumentService, WorkspaceService}

class ToopLanguageServer extends LanguageServer {
  val documentService = new ToopTextDocumentService
  val workspaceService = new ToopWorkspaceService
  override def initialize(params: InitializeParams): CompletableFuture[InitializeResult] = {
    val capabilities = new ServerCapabilities
    capabilities.setDocumentFormattingProvider(true)
    CompletableFuture.completedFuture(new InitializeResult(capabilities))
  }

  override def initialized(params: InitializedParams): Unit = {}

  override def shutdown(): CompletableFuture[AnyRef] =
    CompletableFuture.completedFuture(None)

  override def exit(): Unit = {}

  override def getTextDocumentService: TextDocumentService = documentService

  override def getWorkspaceService: WorkspaceService = workspaceService
}