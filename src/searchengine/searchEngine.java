package searchengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

public class searchEngine extends javax.swing.JFrame {

    public searchEngine() {
        initComponents();
        fillIgnoreList();
    }

    ArrayList<File> fileList = new ArrayList<>();
    ArrayList<String> ignoreList = new ArrayList<>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_bstOrder = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_wordList = new javax.swing.JTextArea();
        txt_searched = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        comboBox_order = new javax.swing.JComboBox<>();
        btn_order = new javax.swing.JButton();
        btn_select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        txtArea_bstOrder.setColumns(20);
        txtArea_bstOrder.setRows(5);
        jScrollPane1.setViewportView(txtArea_bstOrder);

        txtArea_wordList.setColumns(20);
        txtArea_wordList.setRows(5);
        jScrollPane2.setViewportView(txtArea_wordList);

        btn_search.setText("Search");

        comboBox_order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "InOrder", "PostOrder", "PreOrder" }));

        btn_order.setText("Order");

        btn_select.setText("Select File");
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_order)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_searched, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_search)
                        .addGap(44, 44, 44)
                        .addComponent(btn_select)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searched, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_select))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(comboBox_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_order)))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ignoreList kısmı
    private void fillIgnoreList() {
        File ignoreListFile = new File("/Users/iremayvaz/Downloads/Project#2/docs/ignoreList.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(ignoreListFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ignoreList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("-------------------------------");
//        System.out.println("Ignore List:");
//        System.out.println("-------------------------------");
//        for (String word : ignoreList) {
//            System.out.println(word);
//        }
//        System.out.println("-------------------------------");
    }

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed
        // file'ları arrayList'e ekle
        chooseFiles();
        readWords();
    }//GEN-LAST:event_btn_selectActionPerformed

    // kelimeleri okuma ve .... ekleme
    private void readWords() {
        // kelimeleri arrayList'e ekle ekle
        ArrayList<String> words = new ArrayList<>();
        for (File file : fileList) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineWords = line.split("\\s+");
                    Pattern pattern = Pattern.compile("^[^[<>.,\\s]]+");
                    for (String word : lineWords) {
                        Matcher matcher = pattern.matcher(word);
                        if (matcher.matches() && !ignoreList.contains(word)) {
                            words.add(word);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("WORDS");
        System.out.println("-------------------------------");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("-------------------------------");
    }

    // fileChooser
    private void chooseFiles() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int choose = fileChooser.showOpenDialog(this);
        // file'ları arrayliste ekle
        if (choose == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < fileChooser.getSelectedFiles().length; i++) {
                fileList.add(fileChooser.getSelectedFiles()[i]);
            }
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchEngine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_order;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_select;
    private javax.swing.JComboBox<String> comboBox_order;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtArea_bstOrder;
    private javax.swing.JTextArea txtArea_wordList;
    private javax.swing.JTextField txt_searched;
    // End of variables declaration//GEN-END:variables
}
