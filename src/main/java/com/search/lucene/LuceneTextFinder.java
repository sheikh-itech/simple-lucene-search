package com.search.lucene;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.FSDirectory;

/**
 * @author Hapheej
 *
 */
public class LuceneTextFinder {

	private static int maxHits = 10000;
	private static IndexSearcher searcher = null;
	private static IndexReader indexReader = null;
	
	public static Set<Long> searchKeywordId(String indexDirPath, String text) throws Exception {
		
		Set<Long> textNumbers = new HashSet<Long>();
		
		try {
			ScoreDoc[] docs = getScoredDocuments(indexDirPath, text);
			
			for(int count=0; count < docs.length; count++) {
				Document luceneDoc = searcher.doc(docs[count].doc);
				String textId = luceneDoc.get(FIELD_NAMES.TEXTID.toString());
				textNumbers.add(Long.parseLong(textId));
			}			
			
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error while searching keyword");
		}
		
		return textNumbers;
	}
	
	public static List<String> searchKeywordText(String indexDirPath, String text) throws Exception {
		
		List<String> textNumbers = new ArrayList<String>();
		
		try {
			ScoreDoc[] docs = getScoredDocuments(indexDirPath, text);
			
			for(int count=0; count < docs.length; count++) {
				Document luceneDoc = searcher.doc(docs[count].doc);
				textNumbers.add(luceneDoc.get(FIELD_NAMES.TEXT.toString()));
			}			
			
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error while searching keyword");
		}
		
		return textNumbers;
	}

	private static ScoreDoc[] getScoredDocuments(String indexDirPath, String text) throws Exception {
		
		ScoreDoc[] docs = null;
		try {
			indexReader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDirPath)));
			searcher = new IndexSearcher(indexReader);
			String queryInput = "TEXT_nocase:\"" + text + "\"";
			QueryParser queryParser = new QueryParser("TEXT", CategoryAnalyzer.getAnalyzer());
			Query query = queryParser.parse(queryInput);
			docs = searcher.search(query, maxHits).scoreDocs;
							
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error while searching keyword");
		}
		return docs;
	}
	
	public static void closeResources() {
		try {
			LuceneTextFinder.indexReader.close();
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
