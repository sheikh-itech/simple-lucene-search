package com.search.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
/**
 * @author Hapheej
 *
 */
public class CategoryAnalyzer {

	private static Analyzer analyzer;
	private static String IsCaseSensitive = "Yes";
	
	private static Analyzer getFieldSpecificAnalyzer() {
		
		CategoryAnalyzer.analyzer = null;
		final boolean caseSensitive = IsCaseSensitive.equalsIgnoreCase("yes") ? true : false;
		
		CategoryAnalyzer.analyzer = new Analyzer() {
			
			@Override
			protected TokenStreamComponents createComponents(String arg0) {

				Tokenizer tokenizer = new StandardTokenizer();
				
				TokenStream stream = tokenizer;
				
				if(caseSensitive) {
					stream = new LowerCaseFilter(stream);
				} else {
					stream = new ASCIIFoldingFilter(stream);
				}
				
				return new TokenStreamComponents(tokenizer, stream);
			}
		};
		
		return analyzer;
	}
	
	public static Analyzer getAnalyzer() {
		
		if(null == analyzer) {
			getFieldSpecificAnalyzer();
		}
		return analyzer;
	}
}
