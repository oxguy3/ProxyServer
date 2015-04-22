import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Utils {
	
	// name used for self-identification
	final static String SERVER_NAME = "AwesomeProxy";
	
	// should we log notices/errors?
	final static boolean LOG_MESSAGES = true;
	final static boolean LOG_ERRORS = true;
	
	// log RequestWorker messages/errors?
	final static boolean LOG_REQUEST_MESSAGES = true; // only if LOG_MESSAGES
	final static boolean LOG_REQUEST_ERRORS = true; // only if LOG_ERRORS
	final static boolean LOG_REQUEST_CLIENT_CONNECTIONS = true; // log requests w/client? (only if LOG_REQUEST_MESSAGES)
	final static boolean LOG_REQUEST_REMOTE_CONNECTIONS = true; // log requests w/remote? (only if LOG_REQUEST_MESSAGES)
	
	
	
	final static String HTTP_VERSION = "HTTP/1.1";
	final static String CRLF = "\r\n";
	final static String LF = "\n";
	final static String HTTP_HEADER_END = CRLF + CRLF;
	
	/**
	 * Returns the current datetime as an RFC 1123 formatted string
	 */
	public static String getRFC1123Date() {
		return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US).format(new Date());
	}
	
	public static String getSimpleHtmlMessage(String title, String message) {
		
		return getSimpleHtml(title, "<p>" + message + "</p>");
	}
	
	public static String getSimpleHtml(String title, String content) {
		String body = "<!doctype html>\n<html>";
		body += "<head><title>" + title + "</title></head>";
		body += "<body>";
		body += "<header><h1>" + title + "</h1></header>";
		body += "<main>" + content + "</main>";
		body += "<footer><i>Page generated by <a href=\"/\">" + SERVER_NAME + "</a> at " + getRFC1123Date() + "</i></footer>";
		body += "</body>";
		body += "</html>";
		
		return body;
	}
	
	/**
	 * Formats an HTTP header key-value pair
	 */
	public static String httpHeader(String key, String value) {
		return CRLF + key + ": " + value;
	}
	

	public static void log(String message) {
		if (LOG_MESSAGES) log(message, false);
	}
	
	public static void logError(String message) {
		if (LOG_ERRORS) log(message, true);
	}
	
	private static void log(String message, boolean isError) {
		(isError ? System.err : System.out).println(message);
	}
}
