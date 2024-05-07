package searchengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class searchEngine extends javax.swing.JFrame {

    // arrayLists for files and ignoreList
    ArrayList<File> fileList = new ArrayList<>();
    ArrayList<String> ignoreList = new ArrayList<>();
    // binary search tree
    BinarySearchTree<String> binarySearchTree;

    public searchEngine() {
        initComponents();
    }

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
        btn_ignoreList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        txtArea_bstOrder.setEditable(false);
        txtArea_bstOrder.setColumns(20);
        txtArea_bstOrder.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        txtArea_bstOrder.setRows(5);
        jScrollPane1.setViewportView(txtArea_bstOrder);

        txtArea_wordList.setEditable(false);
        txtArea_wordList.setColumns(20);
        txtArea_wordList.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        txtArea_wordList.setRows(5);
        jScrollPane2.setViewportView(txtArea_wordList);

        txt_searched.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N

        btn_search.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        comboBox_order.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        comboBox_order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "InOrder", "PostOrder", "PreOrder" }));

        btn_order.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_order.setText("Order");
        btn_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderActionPerformed(evt);
            }
        });

        btn_select.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_select.setText("Select File");
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        btn_ignoreList.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_ignoreList.setText("Select Ignore File");
        btn_ignoreList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ignoreListActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(" TRAVERSAL");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("SEARCH RESULT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_searched, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ignoreList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox_order, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searched, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_select, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_ignoreList, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(comboBox_order, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btn_order, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed
        // add files to arrayList
        chooseFiles();
        readWords();
    }//GEN-LAST:event_btn_selectActionPerformed

    private void btn_ignoreListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ignoreListActionPerformed
        // ignore list file 
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    ignoreList.add(line);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_ignoreListActionPerformed

    private void btn_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderActionPerformed
        String selectedValue = comboBox_order.getSelectedItem().toString();
        try {
            switch (selectedValue) {
                case "InOrder":
                    txtArea_bstOrder.setText(binarySearchTree.inorder());
                    // prevent it automatically scrolling to the bottom of the text
                    txtArea_bstOrder.setCaretPosition(0);
                    break;
                case "PreOrder":
                    txtArea_bstOrder.setText(binarySearchTree.preorder());
                    txtArea_bstOrder.setCaretPosition(0);
                    break;
                case "PostOrder":
                    txtArea_bstOrder.setText(binarySearchTree.postorder());
                    txtArea_bstOrder.setCaretPosition(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane, "Select an order please!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } catch (NullPointerException e) { // null pointer exception for bst
            JOptionPane.showMessageDialog(rootPane, "Please select files! Binary Search Tree is null!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) { // exception for other exceptions
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_orderActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        try {
            String search = txt_searched.getText();
            if (search.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Enter a word to search please!", "Alert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String text = binarySearchTree.printWordsCount(search);
                if (!text.isEmpty()) {
                    txtArea_wordList.setText(binarySearchTree.printWordsCount(search));
                    txtArea_wordList.setCaretPosition(0);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data not found!", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                    txt_searched.setText("");
                    txtArea_wordList.setText("");
                }
            }
        } catch (NullPointerException e) { // null pointer exception for bst
            JOptionPane.showMessageDialog(rootPane, "Please select files! Binary Search Tree is null!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) { // exception for other exceptions
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void readWords() {
        binarySearchTree = new BinarySearchTree<>();
        for (File file : fileList) { // take file from fileList
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) { // reader for file
                String line; // line
                String fileName = file.getName(); // fileName 
                while ((line = reader.readLine()) != null) {
                    String[] lineWords = line.split("\\s+");
                    Pattern pattern = Pattern.compile("^[^[<>.,\\s]]+"); // regex to avoid html tags etc.
                    for (String word : lineWords) {
                        Matcher matcher = pattern.matcher(word);
                        if (matcher.matches() && !ignoreList.contains(word)) {
                            binarySearchTree.insert(word, fileName);
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // clear the list for repeated use to avoid recurrences
        fileList.clear();
    }

    // fileChooser
    private void chooseFiles() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int choose = fileChooser.showOpenDialog(this);
        // add files to arrayList
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
    private javax.swing.JButton btn_ignoreList;
    private javax.swing.JButton btn_order;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_select;
    private javax.swing.JComboBox<String> comboBox_order;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtArea_bstOrder;
    private javax.swing.JTextArea txtArea_wordList;
    private javax.swing.JTextField txt_searched;
    // End of variables declaration//GEN-END:variables
}
