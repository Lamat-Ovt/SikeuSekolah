/*
 * Aplikasi by : MarufNM
 * FIKOM - Universitas Duta Bangsa
 */
package com.mycompany.sikeusekolah.form;
    import com.mycompany.sikeusekolah.Koneksi;
    import java.sql.ResultSet;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import javax.swing.JOptionPane;
    import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lamat
 */
public class FormAngkatan extends javax.swing.JInternalFrame {
    Koneksi kon;
    ResultSet rs;
    String mode;
    /**
     * Creates new form FormAngkatan
     */
    public FormAngkatan() {
        initComponents();
        kon = new Koneksi();
        tampilData("");
    }
   private void tampilData(String filter){
        Object[] judulKolom = {"No","Tahun",};
        DefaultTableModel modelAngkatan = new DefaultTableModel(null,judulKolom);
        tableAngkatan.setModel(modelAngkatan);

        try{
            String sql="select * from angkatan where tahun like '%"+filter+"%'";
            rs = kon.perintah.executeQuery(sql);
            int no = 0;
            while (rs.next()) {
                no++;
                String txtTahun =rs.getString("tahun");
          
                String[] barisBaru = {Integer.toString(no), txtTahun};
                modelAngkatan.addRow(barisBaru);
            }
        }catch(Exception salahe){
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogAngkatan = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        simpan = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAngkatan = new javax.swing.JTable();
        tambah = new javax.swing.JToggleButton();
        hapus = new javax.swing.JToggleButton();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Tahun");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogAngkatanLayout = new javax.swing.GroupLayout(dialogAngkatan.getContentPane());
        dialogAngkatan.getContentPane().setLayout(dialogAngkatanLayout);
        dialogAngkatanLayout.setHorizontalGroup(
            dialogAngkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAngkatanLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(dialogAngkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogAngkatanLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58)
                        .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogAngkatanLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        dialogAngkatanLayout.setVerticalGroup(
            dialogAngkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogAngkatanLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(dialogAngkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(simpan)
                .addGap(69, 69, 69))
        );

        setBackground(new java.awt.Color(102, 102, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tableAngkatan.setBackground(new java.awt.Color(204, 204, 204));
        tableAngkatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAngkatan);

        tambah.setBackground(new java.awt.Color(153, 153, 153));
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(153, 153, 153));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addGap(18, 18, 18)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(hapus)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
  mode="tambah";
        tahun.setText(null);
        tahun.setEnabled(true);
        dialogAngkatan.setTitle("Form Angkatan - Tambah");
        dialogAngkatan.pack();
        dialogAngkatan.setLocationRelativeTo(null);
        dialogAngkatan.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int baris_index = tableAngkatan.getSelectedRow();
        if (baris_index >= 0) {
            int jwb = JOptionPane.showConfirmDialog(this, "Yakin mau hapus data ini ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jwb == JOptionPane.YES_OPTION) {
                String id_pilih = (tableAngkatan.getModel().getValueAt(baris_index, 1).toString());
                try {
                    String sql="delete from angkatan where tahun='"+id_pilih+"'";
                    kon.perintah.execute(sql);
                    tampilData("");
                } catch (Exception salahe) {
                    System.err.println("Gagal Tampil data: "+salahe.getMessage());
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        String txtCari = cari.getText();
        tampilData(txtCari);
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
           String txtTahun = tahun.getText();        
  
        String sql = "";
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);
        
        if (mode == "tambah") {
            sql = "insert into angkatan values ("
                + "'" + txtTahun +"',"
                + "'" + waktu_sekarang +"',"
                + "'" + waktu_sekarang +"',"
                + "null"
                + ")";
        } else {
            sql = "update angkatan set tahun='"+txtTahun+"',"
                + "updated_at='"+waktu_sekarang+"'";
           
        }
        
        try {
            kon.perintah.execute(sql);
            dialogAngkatan.setVisible(false);
            tampilData("");
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
            JOptionPane.showConfirmDialog(this, "Gagal Simpan");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JDialog dialogAngkatan;
    private javax.swing.JToggleButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton simpan;
    private javax.swing.JTable tableAngkatan;
    private javax.swing.JTextField tahun;
    private javax.swing.JToggleButton tambah;
    // End of variables declaration//GEN-END:variables
}
