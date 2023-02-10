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
    int[] minimumArray, recomendedArray;
    boolean minimum , recomended;
    boolean cpuCoreMinimum = false;
    boolean cpuGenMinimum = false;
    boolean ramMinimum = false;
    boolean gpuMinimum = false;
    boolean cpuCoreRecomended = false;
    boolean cpuGenRecomended = false;
    boolean ramRecomended = false;
    boolean gpuRecomended = false;
    JFrame frame, frameRequirements;
    JLabel labelGame, labelCPU, labelRAM, labelGPU, labelGen;
    JComboBox<String> comboBoxGame, comboBoxCPU, comboBoxGPU;
    JTextField textFieldGen, textFieldRam, textFieldGPU;
    Font titleFont, textFont;

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
                "Resident Evil Village"
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Resident Evil Village")) {
            minimumArray = new int[]{5, 7500, 8, 1050};
            recomendedArray = new int[]{7, 8700, 16, 1070};
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


        //recomended
        if (minimum) {
            if (Integer.parseInt(String.valueOf(Objects.requireNonNull(comboBoxCPU.getSelectedItem()).toString().charAt(comboBoxCPU.getSelectedItem().toString().length() - 1))) >= recomendedArray[0]) {
                cpuCoreRecomended = true;
                if (Integer.parseInt(textFieldGen.getText().trim()) >= recomendedArray[1]) {
                    System.out.println("yes cpu recomended");
                    cpuGenRecomended = true;
                    if (Integer.parseInt(textFieldRam.getText()) >= recomendedArray[2]) {
                        System.out.println("yes ram recomended");
                        ramRecomended = true;
                    } else System.out.println("no ram recomended");
                    if (Integer.parseInt(textFieldGPU.getText()) >= recomendedArray[3]) {
                        System.out.println("yes gpu recomended");
                        gpuRecomended = true;
                    } else System.out.println("no gpu recomended");
                } else System.out.println("no cpu gen recomended");
                if (cpuCoreRecomended && cpuGenRecomended && ramRecomended && gpuRecomended) {
                    recomended = true;
                }
            } else System.out.println("no cpu core recomended");
        } else recomended = false;
    }
}
