package com.mycompany.todowithspring1.ui;

import com.mycompany.todowithspring1.model.CompletionStatus;
import com.mycompany.todowithspring1.model.Importance;
import com.mycompany.todowithspring1.model.Todo;
import com.mycompany.todowithspring1.model.Details;
import com.mycompany.todowithspring1.controller.TodoController;
import com.mycompany.todowithspring1.controller.DetailsController;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class FrameTodo extends javax.swing.JFrame {

    private final TodoController TodoController;
    private final DetailsController detailsController;
    boolean isClick;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrameTodo.class.getName());

    public FrameTodo(TodoController TodoController, DetailsController detailsController) {
        this.TodoController = TodoController;
        this.detailsController = detailsController;
        this.isClick = false;
        initComponents();
        populateTable();
    }

    private void populateTable() {
        TodoController.getAllTodos();
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0); // önce temizle

        for (Todo t : TodoController.getAllTodos()) {
            model.addRow(new Object[]{
                t.getDuty(),
                t.getDate(),
                t.getImportance(),
                t.getCompletionStatus()
            });
        }
    }

    private void populateImportantTable() {
        TodoController.getImportantTodos();
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0); // önce temizle

        for (Todo t : TodoController.getImportantTodos()) {
            model.addRow(new Object[]{
                t.getDuty(),
                t.getDate(),
                t.getImportance(),
                t.getCompletionStatus()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnComplete = new javax.swing.JButton();
        btnAddImportance = new javax.swing.JButton();
        btnImportant = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtAdd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "duty", "date", "importance", "conpletion status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0) {
            tblData.getColumnModel().getColumn(0).setResizable(false);
            tblData.getColumnModel().getColumn(1).setResizable(false);
            tblData.getColumnModel().getColumn(2).setResizable(false);
            tblData.getColumnModel().getColumn(3).setResizable(false);
        }

        btnComplete.setText("complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        btnAddImportance.setText("add importance");
        btnAddImportance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImportanceActionPerformed(evt);
            }
        });

        btnImportant.setText("important");
        btnImportant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportantActionPerformed(evt);
            }
        });

        btnDelete.setText("delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddImportance, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnImportant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAdd)))
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnComplete)
                .addGap(18, 18, 18)
                .addComponent(btnAddImportance)
                .addGap(18, 18, 18)
                .addComponent(btnImportant)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow != -1) {
            String duty = tblData.getValueAt(selectedRow, 0).toString();
            TodoController.updateCompletionStatus(duty, CompletionStatus.completed);
            tblData.clearSelection();
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "öncelikle bir satır seç", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void btnAddImportanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImportanceActionPerformed
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow != -1) {
            String duty = tblData.getValueAt(selectedRow, 0).toString();
            TodoController.updateImportance(duty, Importance.important);
            tblData.clearSelection();
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "öncelikle bir satır seç", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddImportanceActionPerformed

    private void btnImportantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportantActionPerformed
        if (!isClick) {
            isClick = true;
            populateImportantTable();
        } else {
            isClick = false;
            populateTable();
        }
    }//GEN-LAST:event_btnImportantActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow != -1) {
            String duty = tblData.getValueAt(selectedRow, 0).toString();
            TodoController.deleteTodo(duty);
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "öncelikle bir satır girin", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String text = txtAdd.getText();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "girdi boş olamaz", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            TodoController.createTodo(text, Importance.insignificant, CompletionStatus.continues);
            txtAdd.setText("");
            populateTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        if(evt.getClickCount() == 2){
            int selectedRow = tblData.getSelectedRow();
            String duty = tblData.getValueAt(selectedRow, 0).toString();
            Todo todo = TodoController.findTodobyDuty(duty);
            if(todo == null) {
                JOptionPane.showMessageDialog(null, "ilgili görev bulunamadı", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Details> detailsList = detailsController.getDetailsByDuty(todo.getDuty());
            JList<String> listUI = new JList<>(
    detailsList.stream()
    .map(Details::getTitle)
    .toArray(String[]::new)
);
            JScrollPane pane = new JScrollPane(listUI);
            pane.setPreferredSize(new Dimension(250, 150));
            String[] options = {"ekle", "sil", "kapat"};
            int secim = JOptionPane.showOptionDialog(
                    null,
                    pane,
                    "Details",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]
            );
            
            switch (secim) {

                // 4️⃣ DETAY EKLE
                case 0:
                    String text = JOptionPane.showInputDialog("Listeye eklemek istediğiniz detayı girin:");
                    if (text != null && !text.trim().isEmpty()) {
                        detailsController.addDetails(text, todo.getDuty());
                        JOptionPane.showMessageDialog(null, "Detay eklendi.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Boş değer girilemez!");
                    }
                    break;

                // 5️⃣ DETAY SİL
                case 1:
                    int index = listUI.getSelectedIndex();
                    if (index == -1) {
                        JOptionPane.showMessageDialog(null, "Lütfen silinecek detayı seçin!");
                    } else {
                        String selectedDetail = listUI.getSelectedValue();
                        detailsController.deleteDetail(selectedDetail, todo.getDuty());
                        JOptionPane.showMessageDialog(null, "Detay silindi.");
                    }
                    break;

                default:
                    break;
            }
        }
    
        
    }//GEN-LAST:event_tblDataMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddImportance;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnImportant;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAdd;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
