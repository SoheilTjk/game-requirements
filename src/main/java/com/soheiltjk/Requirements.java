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


        textFieldGen = new JTextField();
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

        //minimum
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


        //recommended
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

        if (e.getActionCommand().equals("check")) {
            frameRequirements = new JFrame("%s Requirements".formatted(comboBoxGame.getSelectedItem()));
            frameRequirements.setSize(500, 540);
            frameRequirements.setLocationRelativeTo(null);
            frameRequirements.setResizable(false);
            JPanel panelRequirements = new JPanel();
            frameRequirements.add(panelRequirements);
            showRequirements(panelRequirements);
            panelRequirements.setLayout(null);
            frameRequirements.setVisible(true);
        }
    }
    public void showRequirements(JPanel panelRequirements) {
        JLabel labelGameSelected = new JLabel("%s Requirements".formatted(comboBoxGame.getSelectedItem()), SwingConstants.CENTER);
        labelGameSelected.setBounds(0, 20, 500, 40);
        labelGameSelected.setFont(textFont);
        panelRequirements.add(labelGameSelected);
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        separator.setBounds(100, 90, 300,10);
        panelRequirements.add(separator);

        JLabel labelUnder30fps = new JLabel("fps < 30", JLabel.CENTER);
        labelUnder30fps.setBounds(30, 200, 120, 40);
        labelUnder30fps.setOpaque(true);
        labelUnder30fps.setForeground(Color.WHITE);
        labelUnder30fps.setBackground(new Color(255, 102, 102));
        labelUnder30fps.setFont(textFont);
        panelRequirements.add(labelUnder30fps);

        JLabel label30to60fps = new JLabel("30 < fps < 60", JLabel.CENTER);
        label30to60fps.setBounds(150, 200, 200, 40);
        label30to60fps.setOpaque(true);
        label30to60fps.setForeground(Color.WHITE);
        label30to60fps.setBackground(new Color(0, 255, 127));
        label30to60fps.setFont(textFont);
        panelRequirements.add(label30to60fps);

        JLabel labelUpper60fps = new JLabel("60 < fps", JLabel.CENTER);
        labelUpper60fps.setBounds(350, 200, 100, 40);
        labelUpper60fps.setOpaque(true);
        labelUpper60fps.setForeground(Color.WHITE);
        labelUpper60fps.setBackground(new Color(0, 204, 0));
        labelUpper60fps.setFont(textFont);
        panelRequirements.add(labelUpper60fps);

        JLabel lineUnder30fps = new JLabel("", JLabel.CENTER);
        lineUnder30fps.setBounds(91, 180, 3, 20);
        lineUnder30fps.setOpaque(true);
        lineUnder30fps.setBackground(new Color(128, 128, 128));
        panelRequirements.add(lineUnder30fps);

        JLabel line30to60fps = new JLabel("", JLabel.CENTER);
        line30to60fps.setBounds(251, 180, 3, 20);
        line30to60fps.setOpaque(true);
        line30to60fps.setBackground(new Color(128, 128, 128));
        panelRequirements.add(line30to60fps);

        JLabel lineUpper60fps = new JLabel("", JLabel.CENTER);
        lineUpper60fps.setBounds(401, 180, 3, 20);
        lineUpper60fps.setOpaque(true);
        lineUpper60fps.setBackground(new Color(128, 128, 128));
        panelRequirements.add(lineUpper60fps);

        JLabel fpsUnder30 = new JLabel("your fps", JLabel.CENTER);
        fpsUnder30.setBounds(30, 150, 120, 20);
        fpsUnder30.setOpaque(true);
        fpsUnder30.setFont(textFont);
        panelRequirements.add(fpsUnder30);

        JLabel fps30to60 = new JLabel("your fps", JLabel.CENTER);
        fps30to60.setBounds(150, 150, 200, 20);
        fps30to60.setOpaque(true);
        fps30to60.setFont(textFont);
        panelRequirements.add(fps30to60);

        JLabel fpsUpper60 = new JLabel("your fps", JLabel.CENTER);
        fpsUpper60.setBounds(350, 150, 100, 20);
        fpsUpper60.setOpaque(true);
        fpsUpper60.setFont(textFont);
        panelRequirements.add(fpsUpper60);

        JLabel cpuLabel = new JLabel("Your CPU: ");
        cpuLabel.setBounds(30, 300, 200, 20);
        cpuLabel.setFont(textFont);
        panelRequirements.add(cpuLabel);

        JLabel ramLabel = new JLabel("Your RAM: ");
        ramLabel.setBounds(30, 340, 200, 20);
        ramLabel.setFont(textFont);
        panelRequirements.add(ramLabel);

        JLabel gpuLabel = new JLabel("Your GPU: ");
        gpuLabel.setBounds(30, 380, 200, 20);
        gpuLabel.setFont(textFont);
        panelRequirements.add(gpuLabel);

        JLabel yourCpuLabel = new JLabel(comboBoxCPU.getSelectedItem() + " " + textFieldGen.getText());
        yourCpuLabel.setBounds(140, 300, 200, 20);
        yourCpuLabel.setFont(textFont);
        panelRequirements.add(yourCpuLabel);

        JLabel yourRamLabel = new JLabel(textFieldRam.getText() + " GB");
        yourRamLabel.setBounds(140, 340, 200, 20);
        yourRamLabel.setFont(textFont);
        panelRequirements.add(yourRamLabel);

        JLabel yourGpuLabel = new JLabel(comboBoxGPU.getSelectedItem() + " " + textFieldGPU.getText());
        yourGpuLabel.setBounds(140, 380, 200, 20);
        yourGpuLabel.setFont(textFont);
        panelRequirements.add(yourGpuLabel);
    }
}
