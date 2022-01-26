package me.ulrichBarnstedt.libOutput;

import me.ulrichBarnstedt.libOutput.color.AsciiList;
import me.ulrichBarnstedt.libOutput.color.TextFormatting;
import me.ulrichBarnstedt.libOutput.color.TrueColor;
import me.ulrichBarnstedt.libOutput.render.*;
import me.ulrichBarnstedt.libOutput.terminal.Cursor;

public class Main {
    public static void main (String[] args) {
        Screen test1 = new Screen(
            new Container(true, true)
                .setPadding(3, 2)
                .setColor(new TrueColor(0, 255, 255, true).toString())
                .addElement(
                    new Text("Welcome to the demo")
                        .setColor(AsciiList.FG_GREEN.toString())
                )
                .addElement(
                    new Spacer(0, 1)
                )
                .addElement(
                    new MultilineText(
                        "This is the main text of the demo",
                        "In a convenient multi-",
                        "line-",
                        "box."
                    )
                )
                .addElement(
                    new Spacer(1)
                )
                .addElement(
                    new Container(true, true)
                        .addElement(
                            new Text("Even with nested boxes!")
                        )
                )
                .addElement(
                    new Spacer(1)
                )
                .addElement(
                    new Container(true, false)
                        .addElement(
                            new Container(true, true)
                                .addElement(new Text("Side-"))
                                .setPadding(1, 1)
                        )
                        .addElement(
                            new Container(true, true)
                                .addElement(new Text("ways!"))
                                .setPadding(1, 1)
                        )
                        .addElement(
                            new Container(true, true)
                                .addElement(new Text("(And separate padding!)"))
                                .setPadding(3, 3)
                        )
                )
                .addElement(
                    new Spacer(1)
                )
                .addElement(
                    new Container(true, true)
                        .addElement(
                            new Text("Titles? Yep.)")
                        )
                        .setTitle("Fancy")
                        .setPadding(2, 1)
                )
                .addElement(
                    new Spacer(1)
                )
                .addElement(
                    new MultilineText(
                        "Or some fancy sideways design?",
                        "Just an invisible container aligned sideways works!"
                    )
                )
                .addElement(
                    new Spacer(1)
                )
                .addElement(
                    new Container(false, false)
                        .addElement(
                            new Container(true, true)
                                .setPadding(3, 1)
                                .addElement(
                                    new Text("Works like normal")
                                        .setColor(AsciiList.BG_RED + "" + TextFormatting.SET_UNDERLINE)
                                )
                        )
                        .addElement(
                            new Container(true, true)
                                .setPadding(3, 1)
                                .addElement(
                                    new Text("With custom borders!")
                                )
                                .customBorderCharacters("|", "-", "+", "+", "+", "+")
                        )
                )
                .addElement(
                    new Spacer(2)
                )
                .addElement(
                    new Text("Quite the framework, eh?")
                        .setColor(AsciiList.FG_GREEN + "" + TextFormatting.SET_ITALIC)
                )
                .addElement(
                    new Spacer(2)
                )
                .addElement(
                    new Text("Oh and btw, mutiple screen support! (With auto-switching!)")
                )
        );

        ScreenManager scrmg = new ScreenManager()
            .addPage("test1", test1)
            .open("test1");

        Cursor.toPos(10, 2000).p();
    }
}

//TODO:
// - Screen manager

// - Check hierarchy for excess calls / optimize awy empty screen
// - Spacers (Vert/Horz)
// - Test multiline
// - Test redrawing
// - Custom borders (overload)
// - Colors
