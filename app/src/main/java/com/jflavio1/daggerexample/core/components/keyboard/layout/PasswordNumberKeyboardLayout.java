package com.jflavio1.daggerexample.core.components.keyboard.layout;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.jflavio1.daggerexample.core.components.keyboard.controller.KeyboardController;

import java.util.ArrayList;
import java.util.List;

/**
 * NumberKeyboardLayout
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since 2/7/2019
 */
public class PasswordNumberKeyboardLayout extends KeyboardLayout {

    private ArrayList<String> serverKeyValues = new ArrayList<>();

    public PasswordNumberKeyboardLayout(Context context, boolean hasNextFocus, KeyboardController keyboardController) {
        super(context, hasNextFocus, keyboardController);
    }

    public void setServerKeyValues(ArrayList<String> serverKeyValues) {
        this.keyboardController.setMAX_CHARACTERS(1);
        this.serverKeyValues = serverKeyValues;
    }

    @Override
    protected List<LinearLayout> createRows() {

        // since there are going to be 3 keys, they represent the 33% of the screen
        float columnWidth = 0.20f;
        textSize = 22.0f;

        ArrayList<View> rowOne = new ArrayList<>();
        rowOne.add(createButton(serverKeyValues.get(0), columnWidth, '0'));
        rowOne.add(createButton(serverKeyValues.get(1), columnWidth, '1'));
        rowOne.add(createButton(serverKeyValues.get(2), columnWidth, '2'));

        ArrayList<View> rowTwo = new ArrayList<>();
        rowTwo.add(createButton(serverKeyValues.get(3), columnWidth, '3'));
        rowTwo.add(createButton(serverKeyValues.get(4), columnWidth, '4'));
        rowTwo.add(createButton(serverKeyValues.get(5), columnWidth, '5'));

        ArrayList<View> rowThree = new ArrayList<>();
        rowThree.add(createButton(serverKeyValues.get(6), columnWidth, '6'));
        rowThree.add(createButton(serverKeyValues.get(7), columnWidth, '7'));
        rowThree.add(createButton(serverKeyValues.get(8), columnWidth, '8'));

        ArrayList<View> rowFour = new ArrayList<>();
        rowFour.add(createButton("", columnWidth, KeyboardController.SpecialKey.NONE));
        rowFour.add(createButton(serverKeyValues.get(9), columnWidth, '9'));
        rowFour.add(createButton("⌫", columnWidth, KeyboardController.SpecialKey.DELETE_ALL));

        ArrayList<LinearLayout> keyboardRows = new ArrayList<>();
        keyboardRows.add(createKeyboardRow(rowOne));
        keyboardRows.add(createKeyboardRow(rowTwo));
        keyboardRows.add(createKeyboardRow(rowThree));
        keyboardRows.add(createKeyboardRow(rowFour));

        return keyboardRows;
    }
}
