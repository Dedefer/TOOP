package methods

import org.eclipse.lsp4j.services.WorkspaceService
import org.eclipse.lsp4j.{DidChangeConfigurationParams, DidChangeWatchedFilesParams}


class ToopWorkspaceService extends WorkspaceService {
  override def didChangeConfiguration(params: DidChangeConfigurationParams): Unit = {}
  override def didChangeWatchedFiles(params: DidChangeWatchedFilesParams): Unit = {}
}