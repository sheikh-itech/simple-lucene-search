package com.search.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @author Hapheej
 *
 */
public class StandardIndexWriter {

	private IndexWriter indexWriter;
	private Directory indexDirectory;
	
	/**
	 * @param indexDirPath
	 * @return IndexWriter which writes text to directory
	 * @throws IOException 
	 */
	public IndexWriter getIndexWriter(String indexDirPath) throws IOException {
		
		indexDirectory = FSDirectory.open(Paths.get(indexDirPath));
		IndexWriterConfig config = new IndexWriterConfig(CategoryAnalyzer.getAnalyzer());
		config.setOpenMode(OpenMode.CREATE);
		indexWriter = new IndexWriter(indexDirectory, config);
		return indexWriter;
	}

}
