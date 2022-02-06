package ulrichbarnstedt.lib.output.render.xmlRender;

import ulrichbarnstedt.lib.output.render.elments.Element;
import ulrichbarnstedt.lib.output.render.elments.Screen;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Unfinished/WIP XML Parser
 * @deprecated
 */
public class Parser {
    DocumentBuilder builder;

    public Parser () {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);

        try {
            this.builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.exit(3);
        }

        this.builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.err.println("Error validating XML:");
                exception.printStackTrace();
                System.exit(3);
            }
            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
                System.exit(3);
            }

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
                System.exit(3);
            }
        });
    }

    public Screen parseXML (String XML) {
        ByteArrayInputStream input = new ByteArrayInputStream(XML.getBytes(StandardCharsets.UTF_8));
        Document doc = null;

        try {
            doc = this.builder.parse(input);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            System.exit(3);
        }

        org.w3c.dom.Element root = doc.getDocumentElement();
        Element screenRoot = XMLElementGenerator.parse(root.getFirstChild());

        return new Screen(screenRoot);
    }
}
