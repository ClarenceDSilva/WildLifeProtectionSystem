/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkAreaJPanel;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Continent.Continent;
import Business.Country.Country;
import Business.Organization.Organization;
import Business.State.State;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Rohit
 */
public class ManageAutoGeneratedTicketsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private ArrayList<Continent> continentList;
    private ArrayList<Enterprise> enterpriseList;
    private ArrayList<Organization> organizationList;
    private Continent continent;
    private Country country;
    private State state;
    private Enterprise enterprise;
    private Organization organization;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageAutoGeneratedTicketsJPanel(JPanel userProcessContainer, EcoSystem system, ArrayList<Continent> continentList, ArrayList<Enterprise> enterpriseList, ArrayList<Organization> organizationList, Continent continent, Country country, State state, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.continentList = continentList;
        this.organizationList = organizationList;
        workRequestJTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        populateTable();
        
    }

    public void populateTable() {
      DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        
                model.setRowCount(0);
for (int i = 0; i < system.getContinentList().size(); i++) {
            continent = continentList.get(i);

            for (int j = 0; j < continent.getCountryDirectory().getCountryList().size(); j++) {
                country = continent.getCountryDirectory().getCountryList().get(j);
                for (int k = 0; k < country.getEnterpriseDirectory().getEnterpriseList().size(); k++) {
                    enterprise = country.getEnterpriseDirectory().getEnterpriseList().get(k);
                    for (int l = 0; l < enterprise.getOrganizationDirectory().getOrganizationList().size(); l++) {
                    organization = enterprise.getOrganizationDirectory().getOrganizationList().get(l);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if(request.getSender().getUsername().equalsIgnoreCase("Auto-Generated")){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = enterprise.getName();
            row[2] = request.getTicketPriority();
            row[3] = request.getStatus();
            row[4] = request.getRequestDate();
            if(null==request.getResolveDate()){
            row[5] = "NA";
            }
            else
            {
               row[5] = request.getResolveDate();  
            }
            model.addRow(row);
            }
        }}}
        }}
    }  

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();

        backJButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "State", "Priority", "Status", "Created Date", "Resolve Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        refreshJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 150, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshJButton)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton))
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (UserInterface.SystemAdminWorkAreaJPanel.SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
