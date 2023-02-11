package com.soheiltjk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Requirements implements ActionListener {
    String pleaseChoose = " Please Choose ";
    int[] minimumArray, recommendedArray;
    boolean minimum , recommended;
    boolean cpuCoreMinimum = false;
    boolean cpuGenMinimum = false;
    boolean ramMinimum = false;
    boolean gpuMinimum = false;
    boolean cpuCoreRecommended = false;
    boolean cpuGenRecommended = false;
    boolean ramRecommended = false;
    boolean gpuRecommended = false;
    JFrame frame, frameRequirements;
    JLabel labelGame, labelCPU, labelRAM, labelGPU, labelGen;
    JComboBox<String> comboBoxGame, comboBoxCPU, comboBoxGPU;
    JTextField textFieldGen, textFieldRam, textFieldGPU;
    Font titleFont, textFont;

    //main body
    public void mainFrame() throws IOException, FontFormatException {
        frame = new JFrame("Games Requirements");
        frame.setSize(500, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    //labels, forms and Information
    public void placeComponents(JPanel panel) throws IOException, FontFormatException {
        panel.setLayout(null);

        File fontFile = new File("src/main/resources/fonts/Comfortaa-VariableFont_wght.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        titleFont = font.deriveFont(28f);
        textFont = font.deriveFont(18f);

        labelGame = new JLabel("Game", SwingConstants.LEFT);
        labelGame.setBounds(50, 30, 150, 40);
        labelGame.setFont(titleFont);
        panel.add(labelGame);

        labelCPU = new JLabel("CPU", SwingConstants.LEFT);
        labelCPU.setBounds(50, 110, 150, 40);
        labelCPU.setFont(titleFont);
        panel.add(labelCPU);

        labelRAM = new JLabel("RAM", SwingConstants.LEFT);
        labelRAM.setBounds(50, 190, 150, 40);
        labelRAM.setFont(titleFont);
        panel.add(labelRAM);

        labelGPU = new JLabel("GPU", SwingConstants.LEFT);
        labelGPU.setBounds(50, 270, 150, 40);
        labelGPU.setFont(titleFont);
        panel.add(labelGPU);

        String[] gamesList = {
                pleaseChoose,
                "Resident Evil Village",
                "Hogwarts Legacy"
        };
        comboBoxGame = new JComboBox<>(gamesList);
        comboBoxGame.setBounds(190, 30, 250, 30);
        comboBoxGame.setFont(textFont);
        panel.add(comboBoxGame);

        String[] cpuList = {
                pleaseChoose,
                "i3",
                "I5",
                "I7",
                "I9"
        };
        comboBoxCPU = new JComboBox<>(cpuList);
        comboBoxCPU.setBounds(190, 110, 115, 30);
        comboBoxCPU.setFont(textFont);
        panel.add(comboBoxCPU);


        textFieldGen = new JTextField("note");
        textFieldGen.setBounds(325, 110, 115, 30);
        textFieldGen.setFont(textFont);
        panel.add(textFieldGen);

        textFieldRam = new JTextField();
        textFieldRam.setBounds(190, 190, 250, 30);
        textFieldRam.setFont(textFont);
        panel.add(textFieldRam);

        String[] gpuList = {"RTX", "GTX"};
        comboBoxGPU = new JComboBox<>(gpuList);
        comboBoxGPU.setBounds(190, 270, 115, 30);
        comboBoxGPU.setFont(textFont);
        panel.add(comboBoxGPU);

        textFieldGPU = new JTextField();
        textFieldGPU.setBounds(325, 270, 115, 30);
        textFieldGPU.setFont(textFont);
        panel.add(textFieldGPU);

        JButton button = new JButton("check");
        button.setBounds(140, 370, 200, 60);
        button.setForeground(new Color(255, 86, 119));
        button.setFont(titleFont);
        button.addActionListener(this);
        panel.add(button);
    }

    //action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Resident Evil Village")) {
            minimumArray = new int[]{5, 7500, 8, 1050};
            recommendedArray = new int[]{7, 8700, 16, 1070};
        }
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Hogwarts Legacy")) {
            minimumArray = new int[]{5, 6600, 16, 960};
            recommendedArray = new int[]{7, 8700, 16, 1080};
        }

        //minimum for resident evil village
        if (Integer.parseInt(String.valueOf(Objects.requireNonNull(comboBoxCPU.getSelectedItem()).toString().charAt(comboBoxCPU.getSelectedItem().toString().length() - 1))) >= minimumArray[0]) {
            cpuCoreMinimum = true;
            if (Integer.parseInt(textFieldGen.getText().trim()) >= minimumArray[1]) {
                System.out.println("yes cpu minimum");
                cpuGenMinimum = true;
                if (Integer.parseInt(textFieldRam.getText()) >= minimumArray[2]) {
                    System.out.println("yes ram minimum");
                    ramMinimum = true;
                } else System.out.println("no ram minimum");
                if (Integer.parseInt(textFieldGPU.getText()) >= minimumArray[3]) {
                    System.out.println("yes gpu minimum");
                    gpuMinimum = true;
                } else System.out.println("no gpu minimum");
            } else System.out.println("no cpu gen minimum");
            if (cpuCoreMinimum && cpuGenMinimum && ramMinimum && gpuMinimum) {
                minimum = true;
            }
        } else System.out.println("no cpu core minimum");


        //recommended for resident evil village
        if (minimum) {
            if (Integer.parseInt(String.valueOf(Objects.requireNonNull(comboBoxCPU.getSelectedItem()).toString().charAt(comboBoxCPU.getSelectedItem().toString().length() - 1))) >= recommendedArray[0]) {
                cpuCoreRecommended = true;
                if (Integer.parseInt(textFieldGen.getText().trim()) >= recommendedArray[1]) {
                    System.out.println("yes cpu recommended");
                    cpuGenRecommended = true;
                    if (Integer.parseInt(textFieldRam.getText()) >= recommendedArray[2]) {
                        System.out.println("yes ram recommended");
                        ramRecommended = true;
                    } else System.out.println("no ram recommended");
                    if (Integer.parseInt(textFieldGPU.getText()) >= recommendedArray[3]) {
                        System.out.println("yes gpu recommended");
                        gpuRecommended = true;
                    } else System.out.println("no gpu recommended");
                } else System.out.println("no cpu gen recommended");
                if (cpuCoreRecommended && cpuGenRecommended && ramRecommended && gpuRecommended) {
                    recommended = true;
                }
            } else System.out.println("no cpu core recommended");
        } else recommended = false;
    }
}
