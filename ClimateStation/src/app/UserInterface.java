package app;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Albert
 */
public class UserInterface extends javax.swing.JFrame {

    private HashMap<String, Athlete> athleteList;
    private StopWatch stopWatch;
    private Timer timerUpdater;
    private boolean buttonPressed;
    private boolean resetFlag;
    private long minutes;
    private long seconds;
    private long hundreds;
    private boolean timerUsed;
    private int roundIndex;
    private long prevMinutes;
    private long prevSeconds;
    private long prevHundreds;
    private URLReader urlReader;
    private Algorithm algorithm;

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
        fillDropdownBoxes();

        athleteList = new HashMap<>();
        algorithm = new Algorithm();
        stopWatch = new StopWatch();
        readyTimer();

        resetButton.setVisible(false);

        prevHundreds = 0;
        prevMinutes = 0;
        prevSeconds = 0;

        try {
            urlReader = new URLReader();
            boolean success = urlReader.parseURL();
            System.out.println("Attempting to parse URL...");
            if (!success) {
                urlReader = new URLReader(true);
                urlReader.parseURL();
            } else {
                System.out.println("Success!");
            }
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL Exception");
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
        weatherUpdateTimer();
        getAndDisplayWeatherData();
    }

    private void getAndDisplayWeatherData() {
        String[] weatherData = urlReader.getWeatherData();
        if (weatherData != null) {
            //Convert Pa to hPa

            float atmPressure = convertTohPa(weatherData[1]);
            dateLabel.setText(weatherData[0]);
            temp1.setText(weatherData[4] + " [ºC]");
            temp2.setText(weatherData[3] + " [ºC]");
            temp3.setText(weatherData[5] + " [ºC]");
            pressure.setText(atmPressure + " [hPa]");
            if (weatherData[2] != null) {
                humidity.setText(Float.parseFloat(weatherData[2]) + " [%]");
            }
        }
    }

    private void fillDropdownBoxes() {
        String[] fill = new String[60];
        String[] fill2 = new String[100];
        for (int i = 0; i < 60; i++) {
            fill[i] = "" + i;
        }
        for (int j = 0; j < 100; j++) {
            fill2[j] = "" + j;
        }
        boxSec.setModel(new javax.swing.DefaultComboBoxModel<>(fill));
        boxMS.setModel(new javax.swing.DefaultComboBoxModel<>(fill2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        data_label = new javax.swing.JLabel();
        temp1_lab2 = new javax.swing.JLabel();
        temp2 = new javax.swing.JLabel();
        temp1_lab3 = new javax.swing.JLabel();
        temp3 = new javax.swing.JLabel();
        temp1_lab4 = new javax.swing.JLabel();
        pressure = new javax.swing.JLabel();
        temp1_lab5 = new javax.swing.JLabel();
        humidity = new javax.swing.JLabel();
        temp1_lab1 = new javax.swing.JLabel();
        temp1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        temp1_lab6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        data_label1 = new javax.swing.JLabel();
        boxAthlete = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boxSec = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        boxMS = new javax.swing.JComboBox<>();
        addAthleteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        boxDistance = new javax.swing.JComboBox<>();
        startTimerButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        roundTimeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        roundTimeTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textTop = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textIce = new javax.swing.JTextField();
        textMiddle = new javax.swing.JTextField();
        textPressure = new javax.swing.JTextField();
        textHumidity = new javax.swing.JTextField();
        checkBox_corrector = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        previewTimeLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        corrLabel = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        referenceButton = new javax.swing.JButton();
        displayReferenceButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Experts In Teamwork 2017");
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1024, 600));
        setPreferredSize(new java.awt.Dimension(1198, 695));
        setResizable(false);
        setSize(new java.awt.Dimension(1198, 695));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        data_label.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        data_label.setText("Real-Time Climate Data");

        temp1_lab2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp1_lab2.setText("Temp. (Middle)");

        temp2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp2.setText("NaN");

        temp1_lab3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp1_lab3.setText("Temp. (Ice)");

        temp3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp3.setText("NaN");

        temp1_lab4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp1_lab4.setText("Atm. Pressure");

        pressure.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        pressure.setText("NaN");

        temp1_lab5.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp1_lab5.setText("Rel. Humidity");

        humidity.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        humidity.setText("NaN");

        temp1_lab1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp1_lab1.setText("Temp. (Top)");

        temp1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        temp1.setText("NaN");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("Last Recorded Data: ");

        dateLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        dateLabel.setText("Insert Date Here");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(temp1_lab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(temp1_lab2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(temp1_lab1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(temp1_lab4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp1_lab5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(temp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(humidity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pressure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(temp3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(temp1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(data_label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(data_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temp1_lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temp1_lab2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temp1_lab3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp1_lab4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pressure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp1_lab5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humidity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        temp1_lab6.setFont(new java.awt.Font("Verdana", 3, 20)); // NOI18N
        temp1_lab6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp1_lab6.setText("Climate Station and Time Corrector for Speed Skating - DEMO - Experts In Teamwork 2017");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        data_label1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        data_label1.setText("Speed Skater Profile");

        boxAthlete.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        boxAthlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAthleteActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        submitButton.setForeground(new java.awt.Color(0, 153, 0));
        submitButton.setText("Submit Time!");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Seconds:");

        boxSec.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        boxSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00" }));
        boxSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSecActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("hundreds");

        boxMS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        boxMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00" }));

        addAthleteButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        addAthleteButton.setText("Add new Athlete");
        addAthleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAthleteButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Distance (m)");

        boxDistance.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        boxDistance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500", "600", "1000", "1200", "1500", " " }));

        startTimerButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        startTimerButton.setText("Start Timer");
        startTimerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimerButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Timer");

        timerLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00:00");

        resetButton.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        resetButton.setText("Reset Timer");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        roundTimeButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        roundTimeButton.setText("Round");
        roundTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundTimeButtonActionPerformed(evt);
            }
        });

        roundTimeTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        roundTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Index", "Round Times"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(roundTimeTable);

        jButton1.setText("Clear Round Times");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Manual time corrector");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("ºC (TOP)");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("ºC (ICE)");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("ºC (MIDDLE)");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Pressure [hPa]");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Humidity [Norm]");

        textIce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIceActionPerformed(evt);
            }
        });

        checkBox_corrector.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        checkBox_corrector.setSelected(true);
        checkBox_corrector.setText("Real-Time Data");
        checkBox_corrector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_correctorActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setText("Preview");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        previewTimeLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        previewTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewTimeLabel.setText("00:00");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Time Subtracted");

        corrLabel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        corrLabel.setText("00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(previewTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(corrLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(textTop)
                                    .addComponent(textIce))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBox_corrector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textPressure)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(textHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 26, Short.MAX_VALUE)))))))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(textHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textIce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox_corrector))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previewTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(corrLabel))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jCheckBox1.setText("Flying-Start");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        referenceButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        referenceButton.setText("Submit Ref. Time");
        referenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceButtonActionPerformed(evt);
            }
        });

        displayReferenceButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        displayReferenceButton.setText("Display Selected Athlete's Reference");
        displayReferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayReferenceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(displayReferenceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(submitButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(referenceButton)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(data_label1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxAthlete, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boxSec, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boxMS, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(timerLabel)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundTimeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startTimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAthleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(startTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxAthlete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timerLabel)
                            .addComponent(resetButton))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(boxSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(referenceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(displayReferenceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(roundTimeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addAthleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        scoreboard.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        scoreboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Distance", "Time", "Adj Time", "Subtract", "Date", "ºC top", "ºC middle", "ºC ice", "Atm. Press [hPa]", "R.H"
            }
        ));
        scoreboard.setRowHeight(20);
        jScrollPane1.setViewportView(scoreboard);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(temp1_lab6, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(temp1_lab6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startTimerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimerButtonActionPerformed
        if (!buttonPressed) {
            stopWatch.start();
            timerUpdater.start();
            buttonPressed = true;
            startTimerButton.setText("Stop");
            resetButton.setVisible(false);
            timerUsed = false;
        } else if (buttonPressed) {
            stopWatch.stop();
            timerUpdater.stop();
            buttonPressed = false;
            startTimerButton.setText("Start");
            resetButton.setVisible(true);
            timerUsed = true;
        }

    }//GEN-LAST:event_startTimerButtonActionPerformed

    private void addAthleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAthleteButtonActionPerformed
        try {
            addNewAthlete();
            JOptionPane.showMessageDialog(this, "Success! Remember to submit a reference time", "Note", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Enter Correct Info!", "Error", JOptionPane.OK_CANCEL_OPTION);
        }
    }//GEN-LAST:event_addAthleteButtonActionPerformed

    private void boxSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSecActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        Athlete athlete;
        String[] weatherData = urlReader.getWeatherData();
        String temp_1 = weatherData[3];
        String temp_2 = weatherData[4];
        String temp_3 = weatherData[5];
        String airP = weatherData[1];
        String hum = weatherData[2];

        try {
            athlete = athleteList.get((String) boxAthlete.getSelectedItem());
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "Add an athlete first", "Error", JOptionPane.OK_CANCEL_OPTION);
            return;
        }

        String time = getTimeFromChoice();
        String distance = (String) boxDistance.getSelectedItem();

        try {
            Object[] data = algorithm.calculateAdjustedTime(time, p(temp_3), 0, p(hum), p(airP), p(temp_2), athlete.getWeight(), athlete.getSurfaceArea(), athlete.getReferenceTime());
            String biasTerm = String.format("%.2f", data[1]);
            String adjustedTime = (String) data[0];
            SimpleDateFormat d = new SimpleDateFormat("EEE, d MMM, ''yy 'at' HH:mm:ss");
            Object[] dataModel = new Object[]{"" + (athlete.getListIndex()), distance, time, adjustedTime, biasTerm, (d.format(new Date())), temp_2, temp_1, temp_3, convertTohPa(airP), hum};
            DefaultTableModel model = athlete.getModel();
            model.insertRow(athlete.getListIndex() - 1, dataModel);

            scoreboard.setModel(model);
            resizeColumnWidth(scoreboard);
            athlete.setModel(model);
            athleteList.replace(athlete.getName(), athlete);
            athlete.incrementListIndex();

        } catch (NullPointerException npe2) {
            JOptionPane.showMessageDialog(this, "Add an athlete first", "Error", JOptionPane.OK_CANCEL_OPTION);
            athlete.decrementListIndex();
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetFlag = !resetFlag;
        timerUsed = false;
        timerLabel.setText("00:00:00");
        resetButton.setVisible(false);
        prevMinutes = 0;
        prevSeconds = 0;
        prevHundreds = 0;
    }//GEN-LAST:event_resetButtonActionPerformed

    private void roundTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundTimeButtonActionPerformed
        long localMin = getMinutes();//store all synchronized variables first
        long localSec = getSeconds();
        long localHun = getHundreds();
        String time = "" + (localMin - prevMinutes) + ":" + (Math.abs(localSec - prevSeconds)) + ":" + (Math.abs(localHun - prevHundreds));
        DefaultTableModel model = (DefaultTableModel) roundTimeTable.getModel();
        try {
            String[] dataModel = new String[]{"" + (roundIndex + 1), time};
            model.insertRow(roundIndex, dataModel);
            roundTimeTable.setModel(model);
            roundIndex++;
        } catch (NullPointerException npe2) {
            JOptionPane.showMessageDialog(this, "Error in round time", "Error", JOptionPane.OK_CANCEL_OPTION);
            roundIndex--;
        }
        prevMinutes = localMin;
        prevSeconds = localSec;
        prevHundreds = localHun;
    }//GEN-LAST:event_roundTimeButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) roundTimeTable.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (int i = 0; i <= 11; i++) {
            model.insertRow(i, new String[]{"", ""});
        }
        roundIndex = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkBox_correctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_correctorActionPerformed

    }//GEN-LAST:event_checkBox_correctorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String time = getTimeFromChoice();
        Athlete athlete = athleteList.get((String) boxAthlete.getSelectedItem());
        String[] weatherData = urlReader.getWeatherData();
        String temp_1 = weatherData[3];
        String temp_2 = weatherData[4];
        String temp_3 = weatherData[5];
        String airP = weatherData[1];
        String hum = weatherData[2];
        Object[] data = new Object[2];
        if (checkBox_corrector.isSelected()) {
            data = algorithm.calculateAdjustedTime(time, p(temp_3), 0, p(hum), p(airP), p(temp_2), athlete.getWeight(), athlete.getSurfaceArea(), athlete.getReferenceTime());
        } else {
            //code for manually submitted data
            try {

                data = algorithm.calculateAdjustedTime(time, p(textIce.getText()), 0, p(textHumidity.getText()), 100 * p(textPressure.getText()), p(textTop.getText()), athlete.getWeight(), athlete.getSurfaceArea(), athlete.getReferenceTime());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Enter real numbers only", "Error", JOptionPane.NO_OPTION);
            }
        }

        String corr = String.format("%.2f", data[1]);
        String corrTime = (String) data[0];
        previewTimeLabel.setText(corrTime);
        corrLabel.setText(corr);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void boxAthleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAthleteActionPerformed
        Athlete atl = athleteList.get((String) boxAthlete.getSelectedItem());
        DefaultTableModel personalModel = atl.getModel();
        scoreboard.setModel(personalModel);
        resizeColumnWidth(scoreboard);

    }//GEN-LAST:event_boxAthleteActionPerformed

    private void referenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceButtonActionPerformed
        Athlete atl = athleteList.get((String) boxAthlete.getSelectedItem());
        String[] weatherData = urlReader.getWeatherData();
        String time = getTimeFromChoice();
        String temp_1 = weatherData[3];
        String temp_2 = weatherData[4];
        String temp_3 = weatherData[5];
        String airP = weatherData[1];
        String hum = weatherData[2];
        atl.setAthletesReferenceTime(time, temp_1, temp_2, temp_3, airP, hum);
    }//GEN-LAST:event_referenceButtonActionPerformed

    private void displayReferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayReferenceButtonActionPerformed
        try {
            Athlete athlete = athleteList.get((String) boxAthlete.getSelectedItem());
            JDisplayReferenceFrame frame = new JDisplayReferenceFrame(athlete);
            frame.displayFrame();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Submit a reference first!", "Error", JOptionPane.OK_OPTION);

        }
    }//GEN-LAST:event_displayReferenceButtonActionPerformed

    private void textIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    private void addNewAthlete() throws NumberFormatException {
        String[] athleteData = new JOptionPaneMultiInput().promptInputs();
        String fullName = athleteData[0];
        Float weight = Float.parseFloat(athleteData[1]);
        Athlete athlete = new Athlete(fullName, weight, getInitialModel());
        scoreboard.setModel(athlete.getModel());

        athleteList.put(fullName, athlete);
        Object[] objectArr = athleteList.keySet().toArray();
        String[] stringArray = new String[objectArr.length];
        for (int i = 0; i < objectArr.length; i++) {
            try {
                stringArray[i] = objectArr[i].toString();
            } catch (NullPointerException ex) {
            }
        }

        boxAthlete.setModel(new javax.swing.DefaultComboBoxModel(stringArray));
        boxAthlete.setSelectedItem(athlete.getName());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAthleteButton;
    private javax.swing.JComboBox<String> boxAthlete;
    private javax.swing.JComboBox<String> boxDistance;
    private javax.swing.JComboBox<String> boxMS;
    private javax.swing.JComboBox<String> boxSec;
    private javax.swing.JCheckBox checkBox_corrector;
    private javax.swing.JLabel corrLabel;
    private javax.swing.JLabel data_label;
    private javax.swing.JLabel data_label1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton displayReferenceButton;
    private javax.swing.JLabel humidity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel pressure;
    private javax.swing.JLabel previewTimeLabel;
    private javax.swing.JButton referenceButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton roundTimeButton;
    private javax.swing.JTable roundTimeTable;
    private javax.swing.JTable scoreboard;
    private javax.swing.JButton startTimerButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel temp1;
    private javax.swing.JLabel temp1_lab1;
    private javax.swing.JLabel temp1_lab2;
    private javax.swing.JLabel temp1_lab3;
    private javax.swing.JLabel temp1_lab4;
    private javax.swing.JLabel temp1_lab5;
    private javax.swing.JLabel temp1_lab6;
    private javax.swing.JLabel temp2;
    private javax.swing.JLabel temp3;
    private javax.swing.JTextField textHumidity;
    private javax.swing.JTextField textIce;
    private javax.swing.JTextField textMiddle;
    private javax.swing.JTextField textPressure;
    private javax.swing.JTextField textTop;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables

    private void readyTimer() {
        timerUpdater = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateTimerFields(stopWatch.getElapsedTime());
            }

            private void updateTimerFields(long elapsedTimeMs) {
                setMinutes(TimeUnit.MILLISECONDS.toMinutes(elapsedTimeMs));
                setSeconds(TimeUnit.MILLISECONDS.toSeconds(elapsedTimeMs) - TimeUnit.MINUTES.toSeconds(minutes));
                setHundreds((elapsedTimeMs - TimeUnit.MINUTES.toMillis(minutes) - TimeUnit.SECONDS.toMillis(seconds)) / 10);
                String time = String.format("%02d:%02d:%02d",
                        getMinutes(),
                        getSeconds(), getHundreds()
                );

                timerLabel.setText(time);
            }
        });

    }

    private void weatherUpdateTimer() {
        Timer weatherUpdater = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    urlReader.parseURL();
                } catch (IOException ex) {
                    System.out.println("Error in weather Timer.. IO Exception");
                }
                getAndDisplayWeatherData();
            }
        });
        weatherUpdater.start();
    }

    /**
     *
     * @param minutes
     */
    public synchronized void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public synchronized void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public synchronized void setHundreds(long hundreds) {
        this.hundreds = hundreds;
    }

    public synchronized long getMinutes() {
        return minutes;
    }

    public synchronized long getSeconds() {
        return seconds;
    }

    public synchronized long getHundreds() {
        return hundreds;
    }

    private String getTimeFromChoice() {
        int sec;
        int hundreds;
        if (timerUsed) {
            sec = (int) getSeconds();
            hundreds = (int) getHundreds();
        } else {
            sec = Integer.parseInt((String) boxSec.getSelectedItem());
            hundreds = Integer.parseInt((String) boxMS.getSelectedItem());
        }
        return String.format("%02d:%02d", sec, hundreds);
    }

    private float p(String text) throws NumberFormatException {
        return Float.parseFloat(text);
    }

    private DefaultTableModel getInitialModel() {
        DefaultTableModel initialMod = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "#", "Distance", "Time", "Corr. Time", "Subtract.", "Date", "ºC top", "ºC middle", "ºC ice", "Atm.Press[hPa]", "R.H"
                }
        );
        return initialMod;
    }

    private void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 20; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private float convertTohPa(String string) {
        return Float.parseFloat(string) / 100.f;
    }
}
