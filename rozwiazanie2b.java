class FileType{
	public String fileName;
	public boolean hideData;
}
class Raw extends FileType{
	Raw(){
		fileName="raw";
		hideData=true;
	}
}
class CleanedUp extends FileType{
	CleanedUp(){
		fileName="cleanedUp";
		hideData=true;
	}
}
class Processed extends FileType{
	Processed(){
		fileName="processed";
		hideData=true;
	}
}
class Publication extends FileType{
	Publication(){
		fileName="publication";
		hideData=false;
	}
}
class SurveyData {
	String path;
	boolean hideData;
	void setSavePath(FileType file) {
		path="c:/application/data/"+file.fileName+".dat";
		hideData=file.hideData;
	}
}