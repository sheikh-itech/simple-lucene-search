package com.search.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

/**
 * @author Hapheej
 *
 */
public class LuceneDocument {

	static Document getDocument(int pageNo, String text) {
		
		Document luceneDocument = new Document();
		StringField pageNumField = new StringField(FIELD_NAMES.TEXTID.toString(), pageNo+"", Field.Store.YES);
		StringField textField = new StringField(FIELD_NAMES.TEXT.toString(), text, Field.Store.YES);
		TextField textFieldCase = new TextField(FIELD_NAMES.TEXT.toString() + "_case", text, Field.Store.NO);
		TextField textFieldNoCase = new TextField(FIELD_NAMES.TEXT.toString() + "_nocase", text, Field.Store.NO);
		
		luceneDocument.add(pageNumField);
		luceneDocument.add(textField);
		luceneDocument.add(textFieldCase);
		luceneDocument.add(textFieldNoCase);
		
		return luceneDocument;
	}
}
