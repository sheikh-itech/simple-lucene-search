package com.search.lucene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.search.lucene.beans.Text;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Map<Integer, List<Text>> content = getPageWiseText();
    	
    	String indexDirPath = "D:\\LuceneIndexDiretory\\";
    	LuceneTextIndexer.indexText(indexDirPath, content);
    	Set<Long> id1 = LuceneTextFinder.searchKeywordId(indexDirPath, "text1");
    	List<String> id2 = LuceneTextFinder.searchKeywordText(indexDirPath, "TEXT1");
    	
    	System.out.println("id1: " + id1 + "id2: "+ id2);
    }

	
	private static Map<Integer, List<Text>> getPageWiseText() {
		
		Map<Integer, List<Text>> pageText = new HashMap<Integer, List<Text>>();
		List<Text> list = new ArrayList<Text>();
		List<Text> list1 = new ArrayList<Text>();
		
		Text text1 = new Text();
		text1.setText("text1");
		text1.setTextId(1L);
		
		Text text2 = new Text();
		text2.setText("mansoori");
		text2.setTextId(2L);
		
		Text text3 = new Text();
		text3.setText("arham");
		text3.setTextId(3L);
		
		Text text4 = new Text();
		text4.setText("hapheej");
		text4.setTextId(4L);
		
		Text text5 = new Text();
		text5.setText("sheikh");
		text5.setTextId(5L);
		
		list.add(text1);
		list.add(text2);
		list.add(text3);
		list.add(text4);
		list.add(text5);
		
		list1.add(text1);
		list1.add(text2);
		list1.add(text3);
		list1.add(text4);
		list1.add(text5);
		
		pageText.put(1, list);
		pageText.put(2, list1);
		return pageText;
	}
}
