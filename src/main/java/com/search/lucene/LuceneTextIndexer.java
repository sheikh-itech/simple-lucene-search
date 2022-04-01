package com.search.lucene;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;

import com.search.lucene.beans.Text;

/**
 * @author Hapheej
 *
 */
public class LuceneTextIndexer {

	private static String indexDirPath;
	private static Map<Integer, String> lucenePageWiseText;
	
	public static void indexText(String indexDirPath, Map<Integer, List<Text>> pageWiseText/*lineWiseText*/) 
		throws Exception {
		LuceneTextIndexer.indexDirPath = indexDirPath;
		lucenePageWiseText = new HashMap<Integer, String>();
		
		for(int pageNum : pageWiseText.keySet()) {
			String pageText = "";
			List<Text> pageTexts = pageWiseText.get(pageNum);
			for(Text text : pageTexts) {
				//Hole page wise indexing
				pageText += text.getText() + " ";
				//Not need of space if line, segment, word wise indexing
				//pageText += text.getText() + " ";
			}
			lucenePageWiseText.put(pageNum, pageText.trim());
		}
		
		doIndexing();
	}

	private static void doIndexing() throws Exception {
		try {
			StandardIndexWriter standartWriter = new StandardIndexWriter();
			IndexWriter writer = standartWriter.getIndexWriter(indexDirPath);
			
			for(int pageNum : lucenePageWiseText.keySet()) {
				Document luceneDoc = LuceneDocument.getDocument(pageNum, lucenePageWiseText.get(pageNum));
				writer.addDocument(luceneDoc);
			}
			
			writer.commit();
			writer.close();
			
		} catch (Exception ex) {
			throw new Exception("Error creating index");
		}
	}
	
}
