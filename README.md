# shrikant101.github.io
dprasa
## Welcome to GitHub Pages

You can use the [editor on GitHub](https://github.com/shrikant101/shrikant101.github.io/edit/master/README.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3
package com.mlc.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



/** 
* The below program is used to run web services for compass application
* 
* @author  Shrikant Prasad
* @version 1.0 
* @since   2019-09-10
* 
*/

public class Cws {
	private static final Logger LOGGER = Logger.getLogger(Cws.class);
	public static String outputDir,outputXMLFile,inputExtension = "";
	public static String currentPath = System.getProperty("user.dir");
	static File inputFolderPath, outputFolderPath;
	static int totalTime;
	static ExtentTest test;
	static ExtentReports report;
	public static String workingDir;

	public static void main(String[] args) throws IOException {
		
		Helper.intiateLoggers();
		startTest();
		// + Load Config file
		Properties configFile = new Properties();
		InputStream fis = new FileInputStream(workingDir  + File.separator + "Settings" + File.separator + "config.properties");
		configFile.load(fis);
		String wsEndPoint = configFile.getProperty("wsEndPoint");
		inputExtension = configFile.getProperty("InputFileExtension");
		
		String inputXMLFolderPath = configFile.getProperty("SourceXMLFolder");
		String outputXMLFolderPath = configFile.getProperty("DestinationXMLFolder");
		inputFolderPath = new File(currentPath + File.separator + inputXMLFolderPath);
		outputFolderPath = new File(currentPath + File.separator + outputXMLFolderPath);

		String responseString = "";
		String outputString = "";
		String xmlHeader = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "Settings" + File.separator +"headers.xml")));
		String xmlFooter = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "Settings" + File.separator +"footer.xml")));
		String xmlBody = "";
		String xmlCompass = "";
		boolean successful = false;
		if (inputExtension == null) {
			inputExtension = ".xml";
		}
		LOGGER.info("File extension used for processing : " +inputExtension);
		FilenameFilter textFilter = new FilenameFilter() {
	        public boolean accept(File inputFolderPath, String name) {
	        	
	            return name.toLowerCase().endsWith(inputExtension.toLowerCase());
	        }
	    };
		File[] listOfFiles = inputFolderPath.listFiles(textFilter);
		String currentFolder = inputFolderPath.getAbsolutePath();
		System.out.println("Processing request XML : " + wsEndPoint + "\n");
		
		for (int i = 0; i < listOfFiles.length; i++) {

		//	if (listOfFiles[i].isFile()) {
				Instant start = Instant.now();
				// System.out.println("File " + listOfFiles[i].getName()); //Filename
				String file = listOfFiles[i].getName();
				test = report.startTest(file);
				xmlBody = new String(Files.readAllBytes(Paths.get(currentFolder + File.separator + file)));
				xmlBody = xmlBody.replaceAll("\\$\\{param1\\}", "51606101");
				xmlBody = xmlBody.replaceAll("<", "&lt;");
				xmlCompass = xmlHeader + xmlBody + xmlFooter;
				outputXMLFile = "output_" + file;

				URL url = new URL(wsEndPoint);
				URLConnection connection = url.openConnection();
				HttpURLConnection httpConn = (HttpURLConnection) connection;
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

				// System.out.println("Input xml is "); System.out.println(xmlCompass);
				byte[] buffer = new byte[xmlCompass.length()];
				buffer = xmlCompass.getBytes();
				byteArrayOutputStream.write(buffer);
				byte[] byteArray = byteArrayOutputStream.toByteArray();

				String SOAPAction = "getUserDetails";
				httpConn.setRequestProperty("Content-Length", String.valueOf(byteArray.length));
				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
				httpConn.setRequestProperty("SOAPAction", SOAPAction);
				httpConn.setRequestMethod("POST");
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				OutputStream out = httpConn.getOutputStream();
				out.write(byteArray);
				out.close();

				InputStreamReader inputStreamReader = new InputStreamReader(httpConn.getInputStream(),
						Charset.forName("UTF-8"));
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				// Dump the SOAP message response to a String.
				while ((responseString = bufferedReader.readLine()) != null) {
					outputString = outputString + responseString;
				}

				outputString = StringUtils.remove(outputString, "<env:Header/>");

				// print on console
				// System.out.println(formattedSOAPResponse);
				outputString = outputString.replaceAll("&lt;", "<");
				outputString = outputString.replaceAll("&gt;", ">");

				// remove headers to avoid parse error
				Pattern patterHeader = Pattern.compile("COMPASSi>");

				String[] newString = patterHeader.split(outputString);
				outputString = newString[1];
				outputString = outputString.substring(0, outputString.length() - 2);

				// Dump the formatted SOAP message formatted to the console.
				String formattedSOAPResponse = formatXML(outputString);
				// System.out.println(formattedSOAPResponse);

				// Write to ouput XML file
				PrintStream outputCompassXml = new PrintStream(
						new FileOutputStream(outputFolderPath + File.separator + outputXMLFile));
				outputCompassXml.print(formattedSOAPResponse);
				outputCompassXml.close();
				httpConn.disconnect();
				String message;

				successful = validateOutput(formattedSOAPResponse);
				Instant end = Instant.now();
				Duration timeElapsed = Duration.between(start, end);
				totalTime = (int) (totalTime + timeElapsed.toMillis());
				start = end; // To get the time for each file processing

				if (successful)
					message = "Processing complete. Output file : \"" + outputXMLFile + ". Time taken: "
							+ timeElapsed.toMillis() + " milliseconds";
				else
					message = "Processing FAILED. Output file : \"" + outputXMLFile + ". Time taken: "
							+ timeElapsed.toMillis() + " milliseconds";
				LOGGER.info(message);

				httpConn.disconnect();
				endTest();
		//	}
		}
		System.out.println("Processed total " + listOfFiles.length + " request in " + totalTime + " milliseconds\n\n");
	}

	public static void startTest() {
		
		 workingDir = System.getProperty("user.dir");
		 report = new ExtentReports(workingDir+ File.separator +"ExtentReports"+ File.separator +"ExtentReportResults_" + System.currentTimeMillis() +".html", true);
	}

	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	/**
	 * @param formattedSOAPResponse
	 * @author P790892
	 * @description This method is used to check if the response XML is generated successfully
	 * @return flag if validation is successful or not
	 */
	private static boolean validateOutput(String formattedSOAPResponse) {
		boolean outputValid = false;
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentbuilder = domFactory.newDocumentBuilder();

			String outputlocation = outputFolderPath + File.separator + outputXMLFile;
			Document document = documentbuilder.parse(outputlocation);
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression xpathExpr = xpath.compile("//RsRsltCd/text()");
			Object result = xpathExpr.evaluate(document, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;

			for (int i = 0; i < nodes.getLength(); i++) {
				String value = nodes.item(i).toString();
				// System.out.println(value); //Sucess factors for output
				String successFactor = "Succeeded";
				if (value.contains(successFactor)) {
					outputValid = true;
					test.log(LogStatus.PASS, "Expected '" + successFactor + "' to be present in '" + value + "'");
				} else {
					outputValid = false;
					test.log(LogStatus.FAIL, "Expected '" + successFactor + "'. Found '" + value + "'");
					break;
				}
			}
			if (outputValid) {
				// System.out.println("Response XML successful for "+ outputXMLFile);
				// validateAllOutputFields();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return outputValid;
	}

	
	
	/**
	 * @param formattedSOAPResponse
	 * @author P790892
	 * @description This method is used to retrieve fields from the response XML
	 * @return none
	 */
	private static void validateAllOutputFields() {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentbuilder = domFactory.newDocumentBuilder();
			outputDir = currentPath + File.separator + "xmlSamples" + File.separator + "Output" + File.separator;

			Document document = documentbuilder.parse(outputDir + outputXMLFile);
			XPath xpath = XPathFactory.newInstance().newXPath();
			try {
				XPathExpression xpathExpr1 = xpath.compile("(//CYC_DT)[1]/text()");
				XPathExpression xpathExpr2 = xpath.compile("(//LAST_MOD_USER)[1]/text()");
				Object result1 = xpathExpr1.evaluate(document, XPathConstants.NODESET);
				Object result2 = xpathExpr2.evaluate(document, XPathConstants.NODESET);
				NodeList nodes1 = (NodeList) result1;
				NodeList nodes2 = (NodeList) result2;
				System.out.println("Field Level Validation Starts for " + outputXMLFile);
				String val1 = nodes1.item(0).toString();
				String val2 = nodes2.item(0).toString();
				String val1Exp = "20190818";
				String val2Exp = "MERCURY";
			
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(val1.contains(val1Exp));
				String messge =  "Expected '" +val1Exp+ "' to be present in '" + val1 + "'";
				LOGGER.info(messge);
				test.log(LogStatus.PASS,messge);
				
				softAssert.assertTrue(val2.contains(val2Exp));
				messge = "Expected '" +val2Exp+ "' to be present in '" + val2 + "'";
				LOGGER.info(messge);
				test.log(LogStatus.PASS,messge );
				softAssert.assertAll();

				System.out.println("Field Level Validation Ends for " + outputXMLFile);
			} catch (NullPointerException npe) {
				System.out.println("Field validation error. Field not found in response XML.");
			}
			catch (AssertionError ae) {
			System.out.println("Field assertion failed. Expected MERCURY");
		}
		
		} catch (Exception e) {
			System.out.println("Error while doing output file validation. ");
			e.printStackTrace();
		}
	}

	public static String formatXML(String input) {
		String xmlString;
		try {

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			// initialize StreamResult with File object to save to file
			StreamResult result = new StreamResult(new StringWriter());
			// DOMSource source = new DOMSource(doc);
			transformer.transform(new StreamSource(new StringReader(input)), result);
			xmlString = result.getWriter().toString();
		} catch (Exception e) {
			throw new RuntimeException(e); // simple exception handling, please review it
		}
		return xmlString;
	}
}
- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/shrikant101/shrikant101.github.io/settings). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact
package com.mlc.util;

import java.io.File;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Helper {

	private static final Logger LOGGER = Logger.getLogger(Helper.class);
	
	/**
	 * Initialize log4j logger instance.
	 */
	public static void intiateLoggers() {
		try {
			String fileName = "log";
			System.setProperty("log4j.time", fileName + "_" + Long.toString(Calendar.getInstance().getTimeInMillis()));
			System.setProperty("pwd", System.getProperty("user.dir"));
			String logfileName = System.getProperty("user.dir") + File.separator + "Settings" + File.separator +"log4j.properties";
			PropertyConfigurator.configure(logfileName);
			LOGGER.info("log4j properties filepath: " + logfileName);
		} catch (Exception e) {
			LOGGER.error("Error while intiating Loggers.", e);
		}
	}
}

Having trouble with Pages? Check out our [documentation](https://help.github.com/categories/github-pages-basics/) or [contact support](https://github.com/contact) and we’ll help you sort it out.
