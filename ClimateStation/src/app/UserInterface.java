package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert
 */
public class UserInterface extends javax.swing.JFrame {

    private HashMap<String, Athlete> athleteList;
    private int listIndex;
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

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
        fillDropdownBoxes();

        athleteList = new HashMap<>();
        listIndex = 0;

        stopWatch = new StopWatch();
        readyTimer();

        resetButton.setVisible(false);

        prevHundreds = 0;
        prevMinutes = 0;
        prevSeconds = 0;

        try {
            urlReader = new URLReader();
            urlReader.parseURL();
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
        dateLabel.setText(weatherData[0]);
        temp1.setText(weatherData[3] + " ºC");
        temp2.setText(weatherData[4] + " ºC");
        temp3.setText(weatherData[5] + " ºC");
        pressure.setText(weatherData[1] + " [Pa]");
        humidity.setText(weatherData[2] + " [%]");
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1024, 800));
        setPreferredSize(new java.awt.Dimension(1850, 1000));
        setSize(new java.awt.Dimension(1850, 1000));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        data_label.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        data_label.setText("Real-Time Climate Data");

        temp1_lab2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp1_lab2.setText("Air Temperature (Middle)");

        temp2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp2.setText("NaN");

        temp1_lab3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp1_lab3.setText("Ice Temperature (Bottom)");

        temp3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp3.setText("NaN");

        temp1_lab4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp1_lab4.setText("Atmospheric Pressure");

        pressure.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        pressure.setText("NaN");

        temp1_lab5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp1_lab5.setText("Relative Humidity");

        humidity.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        humidity.setText("NaN");

        temp1_lab1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        temp1_lab1.setText("Air Temperature (Top)");

        temp1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(temp1_lab2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(temp2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(data_label))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(temp1_lab3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(temp3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(temp1_lab5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(temp1_lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(temp1_lab4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humidity, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temp1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pressure, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(data_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp1_lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp1_lab2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp1_lab3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pressure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp1_lab4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(humidity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp1_lab5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        temp1_lab6.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        temp1_lab6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp1_lab6.setText("Climate Station and Time Corrector for Speed Skating - DEMO - Experts In Teamwork 2017");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        data_label1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        data_label1.setText("Speed Skater Profile");

        boxAthlete.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        submitButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        submitButton.setText("Submit Time!");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Seconds:");

        boxSec.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        boxSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00" }));
        boxSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSecActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("hundreds");

        boxMS.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        boxMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00" }));

        addAthleteButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        addAthleteButton.setText("Add new Athlete");
        addAthleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAthleteButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Distance (m)");

        boxDistance.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        boxDistance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500", "600", "1000", "1200", "1500", " " }));

        startTimerButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        startTimerButton.setText("Start");
        startTimerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimerButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Timer");

        timerLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00:00");

        resetButton.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        resetButton.setText("Reset Timer");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        roundTimeButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Manual time corrector");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("ºC (TOP)");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("ºC (ICE)");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("ºC (MIDDLE)");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Pressure [Pa]");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("Humidity [Norm]");

        checkBox_corrector.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        checkBox_corrector.setText("Use Real Time weather data");
        checkBox_corrector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_correctorActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setText("Preview");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        previewTimeLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        previewTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewTimeLabel.setText("00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(previewTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(checkBox_corrector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMiddle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textIce, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPressure, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHumidity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIce, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPressure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBox_corrector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previewTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addContainerGap())
        );

        jCheckBox1.setText("Flying-Start");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data_label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxAthlete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxSec, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(resetButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addAthleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundTimeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(data_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxAthlete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boxMS)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(boxSec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boxDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(resetButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(startTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(roundTimeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addComponent(addAthleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        scoreboard.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
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
                "Number", "Distance", "Time(sec:hsec)", "Adjusted Time", "Factor", "Date", "ºC top", "ºC middle", "ºC ice", "Air Pressure", "Relative Humidity"
            }
        ));
        scoreboard.setRowHeight(20);
        jScrollPane1.setViewportView(scoreboard);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(temp1_lab6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(temp1_lab6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
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
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Enter Correct Info!", "Error", JOptionPane.OK_CANCEL_OPTION);
        }
    }//GEN-LAST:event_addAthleteButtonActionPerformed

    private void boxSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSecActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        Athlete atl;
        String[] weatherData = urlReader.getWeatherData();
        String temp_1 = weatherData[3];
        String temp_2 = weatherData[4];
        String temp_3 = weatherData[5];
        String airP = weatherData[1];
        String hum = weatherData[2];

        try {
            atl = athleteList.get((String) boxAthlete.getSelectedItem());
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "Add an athlete first", "Error", JOptionPane.OK_CANCEL_OPTION);
            return;
        }

        String time = getTimeFromChoice();
        String distance = (String)boxDistance.getSelectedItem();
        String biasTerm = "";
        String adjustedTime = "";
        try {
            //SimpleDateFormat date = new SimpleDateFormat("E, d-M-y 'at' h:m:s a z");
            Object[] dataModel = new Object[]{"" + (listIndex+1),distance, time, adjustedTime, biasTerm, (new Date().toString()), temp_1, temp_2, temp_3, airP, hum};
            DefaultTableModel model = (DefaultTableModel) scoreboard.getModel();
            model.insertRow(listIndex, dataModel);
            scoreboard.setModel(model);
            listIndex++;
            scoreboard.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            
        } catch (NullPointerException npe2) {
            JOptionPane.showMessageDialog(this, "Add an athlete first", "Error", JOptionPane.OK_CANCEL_OPTION);
            listIndex--;
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
            String[] dataModel = new String[]{"" + (roundIndex+1), time};
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
        float[] weatherData = new float[5];
        if (checkBox_corrector.isSelected()) {

            //code for real time data use here
            //weatherData=
            time = runAdvancedAndAwesomeAlgorithm(time, weatherData);
        } else {
            //code for manually submitted data
            try {
                weatherData = new float[]{p(textTop.getText()), p(textMiddle.getText()), p(textIce.getText()), p(textPressure.getText()), p(textHumidity.getText())};
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Enter real numbers only", "Error", JOptionPane.OK_CANCEL_OPTION);
            }
            //weatherData=
            time = runAdvancedAndAwesomeAlgorithm(time, weatherData);
        }

        previewTimeLabel.setText(time);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
        Float circumference = Float.parseFloat(athleteData[2]);
        Float legLength = Float.parseFloat(athleteData[3]);
        Athlete athlete = new Athlete(fullName, weight, circumference, legLength);
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAthleteButton;
    private javax.swing.JComboBox<String> boxAthlete;
    private javax.swing.JComboBox<String> boxDistance;
    private javax.swing.JComboBox<String> boxMS;
    private javax.swing.JComboBox<String> boxSec;
    private javax.swing.JCheckBox checkBox_corrector;
    private javax.swing.JLabel data_label;
    private javax.swing.JLabel data_label1;
    private javax.swing.JLabel dateLabel;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel pressure;
    private javax.swing.JLabel previewTimeLabel;
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
        Timer weatherUpdater = new Timer(30000, new ActionListener() {
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
     * This is where the algorithm for correcting speed skating times is
     * implemented It's creators are Group 4 of EiT 2017. Idrettsteknologi.
     *
     * @param measuredTime
     * @param weatherData
     * @return
     */
    public String runAdvancedAndAwesomeAlgorithm(String measuredTime, float[] weatherData) {
        for (int i = 0; i < weatherData.length; i++) {
            System.out.println(weatherData[i]);
        }
        int localSec = 0;
        int localHundreds = 0;
        String newTime = String.format("%02d:%02d", localSec, localHundreds);
        return newTime;
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
        return "" + sec + ":" + hundreds;
    }

    private float p(String text) throws NumberFormatException {
        return Float.parseFloat(text);
    }
}