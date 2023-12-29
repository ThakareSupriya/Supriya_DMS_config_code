package dataSourceReader;

import java.io.IOException;

public class ExcelFileData {
	
	// static String filePath = ".//TestData//Functional_Suite_Data.xlsx";
	
	public static String url () throws IOException {
		String url = ExcelFileReader.getRowAndColumn(1, 1); // 0, 1
		return url ;
	}
	
	public static String username() throws IOException {
		String username = ExcelFileReader.getRowAndColumn(3, 0); // 2, 0
		return username ; 
	} 
	
	public static String password() throws IOException {
		String password = ExcelFileReader.getRowAndColumn(3, 1); // 2, 1
		return password ; 
	}
	
	
	// ------------------------ Deal Room Data ------------------------
	public static String dealRoomName() throws IOException {
		String dealRoomName = ExcelFileReader.getRowAndColumn(5, 1); // 4, 1
		return dealRoomName;
	}
	
	
	// ------------------------ Doc-Set Data ------------------------
	// ***** Doc-Set 1 data *****
	public static String docset1Name() throws IOException {
		String docsetName = ExcelFileReader.getRowAndColumn(32, 1); // 31, 1
		return docsetName ; 
	}
	
	public static String dropdownValue1() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(34, 1); // 33, 1
		return dropdownValue ; 
	}
	
	public static String dropdownValue2() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(35, 1); // 34, 1
		return dropdownValue ; 
	}
	
	public static String dropdownValue3() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(36, 1); // 35, 1
		return dropdownValue ; 
	}
	
	public static String dropdownValue4() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(37, 1); // 36, 1
		return dropdownValue ; 
	}
	
	// ***** Doc-Set 2 data *****
	public static String docset2Name() throws IOException {
		String docsetName = ExcelFileReader.getRowAndColumn(32, 4); // 31, 4
		return docsetName ; 
	}
	
	public static String dropdownValue5() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(34, 4); // 33, 4
		return dropdownValue ; 
	}
	
	public static String dropdownValue6() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(35, 4); // 34, 4
		return dropdownValue ; 
	}
	
	public static String dropdownValue7() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(36, 4); // 35, 4
		return dropdownValue ; 
	}
	
	// ***** Doc-Set 3 data *****
	public static String docset3Name() throws IOException {
		String docsetName = ExcelFileReader.getRowAndColumn(32, 7); // 31, 7
		return docsetName ; 
	}
	
	public static String dropdownValue8() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(34, 7); // 33, 7 
		return dropdownValue ; 
	}
	
	public static String dropdownValue9() throws IOException {
		String dropdownValue = ExcelFileReader.getRowAndColumn(35, 7); // 34, 7
		return dropdownValue ; 
	}

	
	// ------------------------ Index Master Data ------------------------
	// IM 1 data
	public static String im1Name() throws IOException {
		String imName = ExcelFileReader.getRowAndColumn(41, 1); // 40, 1
		return imName ; 
	}
	
	public static String im1Description() throws IOException {
		String imDescription = ExcelFileReader.getRowAndColumn(42, 1); // 41, 1 
		return imDescription ; 
	}
	
	// IM 2 data
	public static String im2Name() throws IOException {
		String imName = ExcelFileReader.getRowAndColumn(41, 4); // 40, 4
		return imName ; 
	}
	
	public static String im2Description() throws IOException {
		String imDescription = ExcelFileReader.getRowAndColumn(42, 4); // 41, 4
		return imDescription ; 
	}
	
		//-:- Usable only when field type is Select Menu -:-
		public static String dropValue1() throws IOException {
			String dropValue1 = ExcelFileReader.getRowAndColumn(49, 4); // 48, 4 
			return dropValue1 ; 
		}
		public static String dropValue2() throws IOException {
			String dropValue2 = ExcelFileReader.getRowAndColumn(50, 4); // 49, 4
			return dropValue2 ; 
		}
		
	
		
// ------------------------ Index Group Data ------------------------
		// ***** IG 1 data *****
		public static String ig1Name() throws IOException {
			String igName = ExcelFileReader.getRowAndColumn(55, 1); // 54, 1
			return igName ; 
		}
		
		// ***** IG 2 data *****
		public static String ig2Name() throws IOException {
			String igName = ExcelFileReader.getRowAndColumn(55, 4); // 54, 4
			return igName ; 
		}
		
				// ***** DropDown/Multi-select fields data data : Kept common for both IG *****
				public static String field_1() throws IOException {
					String fieldValue = ExcelFileReader.getRowAndColumn(60, 4); // 59, 4
					return fieldValue ; 
				}
				public static String field_2() throws IOException {
					String fieldValue = ExcelFileReader.getRowAndColumn(61, 4); // 60, 4
					return fieldValue ; 
				}
				public static String field_3() throws IOException {
					String fieldValue = ExcelFileReader.getRowAndColumn(62, 4); // 61, 4
					return fieldValue ; 
				}
								
/*	
	// Document's Actions data-------------------------------------------------
		public static String mailId() throws IOException {                   	// Reading mailID to send Documents[Send Documents & send External]
			String mailId = ExcelFileReader.getFormattedRowAndColumn(79, 1);  
			return mailId ;
		}	
	
	*/	
// ------------------------ Category Data ------------------------
		public static String category1Name() throws IOException {  // Article Category
			String categoryName = ExcelFileReader.getRowAndColumn(65, 1);  // 64, 1
			return categoryName ; 
		}
				// child categories for the parent category : Article Category
				public static String childCatgeory1() throws IOException {  // Correspondent Articles
					String categoryName = ExcelFileReader.getRowAndColumn(66, 1);  // 65, 1
					return categoryName ; 
				}
				public static String childCatgeory2() throws IOException {  // Research Articles
					String categoryName = ExcelFileReader.getRowAndColumn(67, 1); // 66, 1  
					return categoryName ; 
				}
			
		public static String category2Name() throws IOException {  // Loan Category
			String categoryName = ExcelFileReader.getRowAndColumn(65, 4); // 64, 4
			return categoryName ; 
		}

		

// ------------------------ Documents ------------------------ 
		// PATH OF FOLDER FROM WHERE DOCS TO BE UPLOADED
		public static String documentsFolderPath() throws IOException {
			String doc = ExcelFileReader.getRowAndColumn(69, 1);  // 68, 1
			return doc ; 
		}	
		
		
		
// --------------------------------- Reports data --------------------------------
		// Report Span ::- Years
		public static String reportSpan () throws IOException {
		String documentReportsSpan = ExcelFileReader.getFormattedRowAndColumn(80, 0); // 79, 0
		return documentReportsSpan ; 
		}
		// Report Period ::- 1
		public static String reportPeriod_inNumber() throws IOException {
		String documentReportPeriod = ExcelFileReader.getFormattedRowAndColumn(80, 1); // 79, 1
		return documentReportPeriod ; 
		}
		
	
	

				
		
		public static void main(String[] args) throws IOException {
		ExcelFileData.url();
	}
	
	
}
