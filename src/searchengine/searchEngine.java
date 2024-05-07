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

        txtArea_bstOrder.setColumns(20);
        txtArea_bstOrder.setRows(5);
        jScrollPane1.setViewportView(txtArea_bstOrder);

        txtArea_wordList.setColumns(20);
        txtArea_wordList.setRows(5);
        jScrollPane2.setViewportView(txtArea_wordList);

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        comboBox_order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "InOrder", "PostOrder", "PreOrder" }));

        btn_order.setText("Order");
        btn_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderActionPerformed(evt);
            }
        });

        btn_select.setText("Select File");
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        btn_ignoreList.setText("Select Ignore File");
        btn_ignoreList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ignoreListActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(" TRAVERSAL");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("SEARCH RESULT");

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
                        .addComponent(btn_select)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ignoreList, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searched, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_select)
                    .addComponent(btn_ignoreList))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed
        // add files to arrayList
        chooseFiles();
        readWords();
    }//GEN-LAST:event_btn_selectActionPerformed

    private void btn_ignoreListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ignoreListActionPerformed
        // ignore list file 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    ignoreList.add(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_ignoreListActionPerformed

    private void btn_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderActionPerformed
        String selectedValue = comboBox_order.getSelectedItem().toString();
        try {
            switch (selectedValue) {
                case "InOrder":
                    txtArea_bstOrder.setText(binarySearchTree.inorder());
                    break;
                case "PreOrder":
                    txtArea_bstOrder.setText(binarySearchTree.preorder());
                    break;
                case "PostOrder":
                    txtArea_bstOrder.setText(binarySearchTree.postorder());
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane, "Select an order please!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane, "Please select files! Binary Search Tree is null!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
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
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data not found!", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane, "Please select files! Binary Search Tree is null!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void readWords() {
        binarySearchTree = new BinarySearchTree<>();
        for (File file : fileList) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String fileName = file.getName();
                while ((line = reader.readLine()) != null) {
                    String[] lineWords = line.split("\\s+");
                    Pattern pattern = Pattern.compile("^[^[<>.,\\s]]+");
                    for (String word : lineWords) {
                        Matcher matcher = pattern.matcher(word);
                        if (matcher.matches() && !ignoreList.contains(word)) {
                            binarySearchTree.insert(word, fileName);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
