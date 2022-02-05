package me.ulrichBarnstedt.libOutput.render.xmlRender;

import me.ulrichBarnstedt.libOutput.render.elments.*;
import org.w3c.dom.Node;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class XMLElementGenerator {
    private static Class[] params = {Node.class};
    private static Pattern stringBefore = Pattern.compile("^\\s*");
    private static Pattern stringAfter = Pattern.compile("\\s*$");

    public static Element parse (Node node) {
        try {
            return (Element) XMLElementGenerator.class.getDeclaredMethod("parse_" + node.getNodeName(), XMLElementGenerator.params).invoke(XMLElementGenerator.class, node);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return new Text("INVALID-ELEMENT");
        }
    }

    private static Text parse_text (Node node) {
        String content = node.getTextContent();

        Matcher mB = stringBefore.matcher(content);
        Matcher mA = stringAfter.matcher(content);
        mB.find();
        mA.find();

        Text element = new Text(content.substring(mB.group(0).length(), content.length() - mA.group(0).length()));

        if (node.getAttributes().getNamedItem("color") != null)
            element.setColor(node.getAttributes().getNamedItem("color").getNodeValue());

        return element;
    }

    /*private static Container parse_container (Node node) {

    }

    private static Table parse_table (Node node) {

    }

    private static SubdividedTable parse_subdividedTable (Node node) {

    }

    private static Empty parse_empty (Node node) {

    }

    private static MultilineText parse_multilineText (Node node) {

    }

    private static Spacer parse_spacer (Node node) {

    }*/
}