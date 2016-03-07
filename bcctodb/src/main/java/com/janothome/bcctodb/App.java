package com.janothome.bcctodb;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println("Hello World!");
    	
    	//BCCEpub bccEpub = new BCCEpub();
        //bccEpub.Read();
    	    	
    	BCCXhtml bccXhtml = new BCCXhtml();
    	bccXhtml.Read();
    	
    	@SuppressWarnings("unused")
		BCCBible bccBible = new BCCBible();
    }
}
