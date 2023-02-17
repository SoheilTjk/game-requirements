package com.soheiltjk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Requirements implements ActionListener {
    String pleaseChoose = " Please Choose ";
    int[] minimumArray, recommendedArray;
    boolean minimum = false;
    boolean recommended = false;
    boolean cpuCoreMinimum = false;
    boolean cpuGenMinimum = false;
    boolean ramMinimum = false;
    boolean gpuMinimum = false;
    boolean cpuCoreRecommended = false;
    boolean cpuGenRecommended = false;
    boolean ramRecommended = false;
    boolean gpuRecommended = false;
    boolean cpu = false;
    boolean ram = false;
    boolean gpu = false;

    boolean notSupported = false;
    boolean low = false;
    boolean high = false;
    boolean ultra = false;
    JFrame frame, frameRequirements;
    JLabel labelGame, labelCPU, labelRAM, labelGPU;
    JComboBox<String> comboBoxGame, comboBoxCPU, comboBoxGPU;
    JTextField textFieldGen, textFieldRam, textFieldGPU;
    Font titleFont, textFont, infoFont, buttonFont;

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
    private void placeComponents(JPanel panel) throws IOException, FontFormatException {
        panel.setLayout(null);

        File fontFile1 = new File("src/main/resources/fonts/Comfortaa-Regular.ttf");
        Font font1 = Font.createFont(Font.TRUETYPE_FONT, fontFile1);
        File fontFile2 = new File("src/main/resources/fonts/Comfortaa-Bold.ttf");
        Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
        titleFont = font1.deriveFont(28f);
        textFont = font1.deriveFont(18f);
        infoFont = font1.deriveFont(22f);
        buttonFont = font2.deriveFont(30f);

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
                "Hogwarts Legacy",
                "Control",
                "Red Dead Redemption 2",
                "Resident Evil 2 Remake",
                "Cyberpunk 2077",
                "Resident Evil 3 Remake",
                "Dying Light 2"
        };
        Arrays.sort(gamesList);

        comboBoxGame = new JComboBox<>(gamesList);
        comboBoxGame.setBounds(190, 30, 250, 30);
        comboBoxGame.setFont(textFont);
        panel.add(comboBoxGame);

        String[] cpuList = {
                pleaseChoose,
                "Core i3",
                "Core i5",
                "Core i7",
                "Core i9"
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

        JButton button = new JButton("Check");
        button.setBounds(140, 370, 200, 60);
        button.setForeground(new Color(255, 86, 119));
        button.setFont(buttonFont);
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
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Control")) {
            minimumArray = new int[]{5, 4690, 8, 780};
            recommendedArray = new int[]{5, 7600, 16, 1660};
        }
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Red Dead Redemption 2")) {
            minimumArray = new int[]{5, 2500, 8, 770};
            recommendedArray = new int[]{7, 4770, 12, 1060};
        }
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Resident Evil 2 Remake")) {
            minimumArray = new int[]{5, 4460, 8, 960};
            recommendedArray = new int[]{7, 3770, 8, 2060};
        }
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Cyberpunk 2077")) {
            minimumArray = new int[]{5, 3570, 8, 780};
            recommendedArray = new int[]{7, 4790, 12, 1060};
        }
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Resident Evil 3 Remake")) {
            minimumArray = new int[]{5, 4460, 8, 960};
            recommendedArray = new int[]{7, 3770, 8, 2060};
        }
        if (Objects.equals(Objects.requireNonNull(comboBoxGame.getSelectedItem()).toString(), "Dying Light 2")) {
            minimumArray = new int[]{3, 9100, 8, 1050};
            recommendedArray = new int[]{5, 8600, 16, 2060};
        }


        //recommended and minimum

        if (Integer.parseInt(String.valueOf(Objects.requireNonNull(comboBoxCPU.getSelectedItem()).toString().charAt(comboBoxCPU.getSelectedItem().toString().length() - 1))) >= recommendedArray[0]) {
            cpuCoreRecommended = true;
            cpuCoreMinimum = true;
            System.out.println("cpu core recommended: " + cpuCoreRecommended);
        } else if (Integer.parseInt(String.valueOf(Objects.requireNonNull(comboBoxCPU.getSelectedItem()).toString().charAt(comboBoxCPU.getSelectedItem().toString().length() - 1))) >= minimumArray[0]) {
            cpuCoreMinimum = true;
            cpuCoreRecommended = false;
            System.out.println("cpu core minimum: " + cpuCoreMinimum);
        } else {
            cpuCoreRecommended = false;
            cpuCoreMinimum = false;
        }

        if (Integer.parseInt(textFieldGen.getText().trim()) >= recommendedArray[1]) {
            cpuGenRecommended = true;
            cpuGenMinimum = true;
            System.out.println("cpu gen recommended: " + cpuGenRecommended);
        } else if (Integer.parseInt(textFieldGen.getText().trim()) >= minimumArray[1] && Integer.parseInt(textFieldGen.getText().trim()) <= recommendedArray[1]) {
            cpuGenMinimum = true;
            cpuGenRecommended = false;
            System.out.println("cpu gen minimum: " + cpuGenRecommended);
        } else {
            cpuGenRecommended = false;
            cpuGenMinimum = false;
        }

        if (cpuCoreMinimum && cpuGenMinimum || cpuCoreRecommended && cpuGenRecommended) {
            cpu = true;
        }

        if (Integer.parseInt(textFieldRam.getText()) >= recommendedArray[2]) {
            ramRecommended = true;
            ramMinimum = false;
            System.out.println("ram recommended : " + ramRecommended);
        } else if (Integer.parseInt(textFieldRam.getText()) >= minimumArray[2] && Integer.parseInt(textFieldRam.getText()) <= recommendedArray[2]) {
            ramMinimum = true;
            ramRecommended = false;
            System.out.println("ram min: " + ramMinimum);
        } else {
            ramRecommended = false;
            ramMinimum = false;
        }

        if (ramMinimum || ramRecommended) {
            ram = true;
        }

        if (Integer.parseInt(textFieldGPU.getText()) >= recommendedArray[3]) {
            gpuRecommended = true;
            gpuMinimum = true;
            System.out.println("gpu recommended: " + gpuRecommended);
        } else if (Integer.parseInt(textFieldGPU.getText()) >= minimumArray[3] && Integer.parseInt(textFieldGPU.getText()) <= recommendedArray[3]) {
            gpuMinimum = true;
            gpuRecommended = false;
            System.out.println("gpu minimum: " + gpuMinimum);
        } else {
            gpuRecommended = false;
            gpuMinimum = false;
        }

        if (gpuMinimum || gpuRecommended) {
            gpu = true;
        }


        if (cpuCoreRecommended && cpuGenRecommended && ramRecommended && gpuRecommended) recommended = true;
        System.out.println("full recommended accepted");
        if (cpuCoreMinimum && cpuGenMinimum && ramMinimum && gpuMinimum) minimum = true;
        System.out.println("full minimum accepted");


        if (e.getActionCommand().equals("Check")) {
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

    private void showRequirements(JPanel panelRequirements) {
        JLabel labelGameSelected = new JLabel("%s Requirements".formatted(comboBoxGame.getSelectedItem()), SwingConstants.CENTER);
        labelGameSelected.setBounds(0, 20, 500, 40);
        labelGameSelected.setFont(textFont);
        panelRequirements.add(labelGameSelected);
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        separator.setBounds(100, 90, 300, 10);
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
        lineUnder30fps.setVisible(false);
        panelRequirements.add(lineUnder30fps);

        JLabel line30to60fps = new JLabel("", JLabel.CENTER);
        line30to60fps.setBounds(251, 180, 3, 20);
        line30to60fps.setOpaque(true);
        line30to60fps.setBackground(new Color(128, 128, 128));
        line30to60fps.setVisible(false);
        panelRequirements.add(line30to60fps);

        JLabel lineUpper60fps = new JLabel("", JLabel.CENTER);
        lineUpper60fps.setBounds(401, 180, 3, 20);
        lineUpper60fps.setOpaque(true);
        lineUpper60fps.setBackground(new Color(128, 128, 128));
        lineUpper60fps.setVisible(false);
        panelRequirements.add(lineUpper60fps);

        JLabel fpsUnder30 = new JLabel("your fps", JLabel.CENTER);
        fpsUnder30.setBounds(30, 150, 120, 20);
        fpsUnder30.setOpaque(true);
        fpsUnder30.setFont(textFont);
        fpsUnder30.setVisible(false);
        panelRequirements.add(fpsUnder30);

        JLabel fps30to60 = new JLabel("your fps", JLabel.CENTER);
        fps30to60.setBounds(150, 150, 200, 20);
        fps30to60.setOpaque(true);
        fps30to60.setFont(textFont);
        fps30to60.setVisible(false);
        panelRequirements.add(fps30to60);

        JLabel fpsUpper60 = new JLabel("your fps", JLabel.CENTER);
        fpsUpper60.setBounds(350, 150, 100, 20);
        fpsUpper60.setOpaque(true);
        fpsUpper60.setFont(textFont);
        fpsUpper60.setVisible(false);
        panelRequirements.add(fpsUpper60);

        JLabel cpuLabel = new JLabel("Your CPU: ");
        cpuLabel.setBounds(30, 280, 200, 20);
        cpuLabel.setFont(infoFont);
        panelRequirements.add(cpuLabel);

        JLabel ramLabel = new JLabel("Your RAM: ");
        ramLabel.setBounds(30, 330, 200, 20);
        ramLabel.setFont(infoFont);
        panelRequirements.add(ramLabel);

        JLabel gpuLabel = new JLabel("Your GPU: ");
        gpuLabel.setBounds(30, 380, 200, 20);
        gpuLabel.setFont(infoFont);
        panelRequirements.add(gpuLabel);

        JLabel suggestedResolution = new JLabel("Suggested resolution: ", SwingConstants.CENTER);
        suggestedResolution.setBounds(0, 440, 500, 40);
        suggestedResolution.setFont(textFont);
        panelRequirements.add(suggestedResolution);

        JLabel yourCpuLabel = new JLabel(comboBoxCPU.getSelectedItem() + " " + textFieldGen.getText());
        yourCpuLabel.setBounds(170, 280, 200, 20);
        yourCpuLabel.setFont(infoFont);
        panelRequirements.add(yourCpuLabel);

        JLabel yourRamLabel = new JLabel(textFieldRam.getText() + " GB");
        yourRamLabel.setBounds(170, 330, 200, 20);
        yourRamLabel.setFont(infoFont);
        panelRequirements.add(yourRamLabel);

        JLabel yourGpuLabel = new JLabel(comboBoxGPU.getSelectedItem() + " " + textFieldGPU.getText());
        yourGpuLabel.setBounds(170, 380, 200, 20);
        yourGpuLabel.setFont(infoFont);
        panelRequirements.add(yourGpuLabel);

        JLabel notSupportedLabel = new JLabel("You can't run this game", SwingConstants.CENTER);
        notSupportedLabel.setBounds(0, 460, 500, 40);
        notSupportedLabel.setFont(textFont);

        JLabel lowResolutionLabel = new JLabel("Low Resolution", SwingConstants.CENTER);
        lowResolutionLabel.setBounds(0, 460, 500, 40);
        lowResolutionLabel.setFont(textFont);

        JLabel highResolutionLabel = new JLabel("High Resolution", SwingConstants.CENTER);
        highResolutionLabel.setBounds(0, 460, 500, 40);
        highResolutionLabel.setFont(textFont);

        JLabel ultraResolutionLabel = new JLabel("Ultra Resolution", SwingConstants.CENTER);
        ultraResolutionLabel.setBounds(0, 460, 500, 40);
        ultraResolutionLabel.setFont(textFont);

        if (cpu && ram && gpu) {
            lineUpper60fps.setVisible(true);
            fpsUpper60.setVisible(true);
        } else if (cpu && ram) {
            lineUnder30fps.setVisible(true);
            fpsUnder30.setVisible(true);
        } else if (cpu && !gpu) {
            lineUnder30fps.setVisible(true);
            fpsUnder30.setVisible(true);
        } else if (!cpu && ram && !gpu) {
            lineUnder30fps.setVisible(true);
            fpsUnder30.setVisible(true);
        } else if (!cpu && ram) {
            line30to60fps.setVisible(true);
            fps30to60.setVisible(true);
        } else if (cpu) {
            line30to60fps.setVisible(true);
            fps30to60.setVisible(true);
        } else if (gpu) {
            lineUnder30fps.setVisible(true);
            fpsUnder30.setVisible(true);
        } else {
            lineUnder30fps.setVisible(true);
            fpsUnder30.setVisible(true);
        }


        if (!cpuCoreRecommended && !cpuGenRecommended && !cpuCoreMinimum && !cpuGenMinimum) {
            yourCpuLabel.setForeground(Color.RED);
        } else if (cpuCoreRecommended && cpuGenRecommended && cpuCoreMinimum && cpuGenMinimum) {
            yourCpuLabel.setForeground(Color.BLUE);
        } else if (cpuCoreRecommended && !cpuGenRecommended && cpuCoreMinimum && cpuGenMinimum) {
            yourCpuLabel.setForeground(Color.GREEN);
        } else if (cpuCoreRecommended && !cpuGenRecommended && cpuCoreMinimum) {
            yourCpuLabel.setForeground(Color.GREEN);
        } else if (!cpuCoreRecommended && cpuGenRecommended && !cpuCoreMinimum && cpuGenMinimum) {
            yourCpuLabel.setForeground(Color.GREEN);
        } else if (!cpuCoreRecommended && !cpuGenRecommended && !cpuCoreMinimum) {
            yourCpuLabel.setForeground(Color.GREEN);
        } else if (!cpuCoreRecommended && cpuGenRecommended && cpuCoreMinimum && cpuGenMinimum) {
            yourCpuLabel.setForeground(Color.GREEN);
        } else if (!cpuCoreRecommended && !cpuGenRecommended && cpuGenMinimum) {
            yourCpuLabel.setForeground(Color.GREEN);
        } else if (!cpuCoreRecommended && !cpuGenRecommended) {
            yourCpuLabel.setForeground(Color.RED);
        }

        if (!ramRecommended && !ramMinimum) {
            yourRamLabel.setForeground(Color.RED);
        } else if (ramMinimum && !ramRecommended) {
            yourRamLabel.setForeground(Color.GREEN);
        } else {
            yourRamLabel.setForeground(Color.BLUE);
        }

        if (!gpuRecommended && !gpuMinimum) {
            yourGpuLabel.setForeground(Color.RED);
        } else if (gpuRecommended) {
            yourGpuLabel.setForeground(Color.BLUE);
        } else yourGpuLabel.setForeground(Color.GREEN);


        if (cpuCoreRecommended && cpuGenRecommended && ramRecommended && gpuRecommended) {
            ultra = true;
        } else if (cpuCoreMinimum && cpuGenMinimum && ramMinimum && gpuMinimum && !cpuCoreRecommended && !cpuGenRecommended && !ramRecommended && !gpuRecommended) {
            low = true;
        } else if (!cpuCoreMinimum && !cpuGenMinimum && !ramMinimum && !gpuMinimum && !cpuCoreRecommended && !cpuGenRecommended && !ramRecommended && !gpuRecommended) {
            notSupported = true;
        } else {
            high = true;
        }

        if (ultra) {
            ultraResolutionLabel.setForeground(Color.BLUE);
            panelRequirements.add(ultraResolutionLabel);
        } else if (low) {
            lowResolutionLabel.setForeground(Color.MAGENTA);
            panelRequirements.add(lowResolutionLabel);
        } else if (high){
            highResolutionLabel.setForeground(Color.GREEN);
            panelRequirements.add(highResolutionLabel);
        } else {
            notSupportedLabel.setForeground(Color.RED);
            panelRequirements.add(notSupportedLabel);
        }
    }
}