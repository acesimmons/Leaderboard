package team6;
public class MissingEntryException extends RuntimeException{
	
	public MissingEntryException(String id){
		super(id);
	}
	
}