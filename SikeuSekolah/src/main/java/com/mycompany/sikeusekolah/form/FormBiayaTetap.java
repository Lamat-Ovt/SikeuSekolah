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
public class FormBiayaTetap extends javax.swing.JInternalFrame {
    Koneksi kon;
    ResultSet rs;
    String mode;
    /**
     * Creates new form FormBiayaTetap
     */
    public FormBiayaTetap() {
        initComponents();
     kon = new Koneksi();
       tampilData("");
        cbjurusan();
        cbakun();
    }
     private void tampilData(String filter){
        Object[] judulKolom = {"No","Id","Akun ID","Nama Biaya","Jumlah","Jurusan","Semester"," Tahun Angkatan"};
        DefaultTableModel modelAkun = new DefaultTableModel(null,judulKolom);
        tableTetap.setModel(modelAkun);

        try{
             String sql="select * from biaya_tetap where id like '%"+filter+"%' or akun_id like '%"+filter+"%'" ;
            rs = kon.perintah.executeQuery(sql);
            int no = 0;
            while (rs.next()) {
                no++;
                String txtId =rs.getString("id");
                String txtAkun_id =rs.getString("akun_id");
                String txtNama_biaya =rs.getString("nama_biaya");
                String txtJumlah =rs.getString("jumlah");
                String txtJurusan =rs.getString("jurusan");
                String txtSmt =rs.getString("smt");
                String txtTahun =rs.getString("tahun_angkatan");
                String[] barisBaru = {Integer.toString(no), txtId, txtAkun_id, txtNama_biaya, txtJumlah, txtJurusan, txtSmt, txtTahun};
                modelAkun.addRow(barisBaru);
            }
        }catch(Exception salahe){
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
        }
    }
      public void cbjurusan(){
     try{
         String sql="select * from jurusan";
         rs = kon.perintah.executeQuery(sql);
         cbjurusan.addItem("-Pilih Jurusan-");
         while (rs.next()) {
             cbjurusan.addItem(rs.getString("id"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
       }
    }
      public void cbakun(){
     try{
         String sql="select * from akun";
         rs = kon.perintah.executeQuery(sql);
         cbakun.addItem("-Pilih Akun-");
         while (rs.next()) {
             cbakun.addItem(rs.getString("kode"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
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

        dialogTetap = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        cbakun = new javax.swing.JComboBox<>();
        namabiaya = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        semester = new javax.swing.JTextField();
        simpan = new javax.swing.JToggleButton();
        cbjurusan = new javax.swing.JComboBox<>();
        tahun = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTetap = new javax.swing.JTable();
        tambah = new javax.swing.JToggleButton();
        edit = new javax.swing.JToggleButton();
        hapus = new javax.swing.JToggleButton();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("ID Biaya");

        jLabel3.setText("Akun ID");

        jLabel4.setText("Nama Biaya");

        jLabel5.setText("Jumlah");

        jLabel6.setText("Jurusan");

        jLabel7.setText("Semester");

        jLabel8.setText("Tahun Ajaran");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogTetapLayout = new javax.swing.GroupLayout(dialogTetap.getContentPane());
        dialogTetap.getContentPane().setLayout(dialogTetapLayout);
        dialogTetapLayout.setHorizontalGroup(
            dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTetapLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dialogTetapLayout.createSequentialGroup()
                        .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namabiaya)
                            .addComponent(jumlah)
                            .addComponent(cbjurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(dialogTetapLayout.createSequentialGroup()
                        .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semester)
                            .addComponent(tahun)))
                    .addGroup(dialogTetapLayout.createSequentialGroup()
                        .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(54, 54, 54)
                        .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogTetapLayout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addComponent(cbakun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogTetapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpan)
                .addGap(174, 174, 174))
        );
        dialogTetapLayout.setVerticalGroup(
            dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTetapLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbakun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(namabiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTetapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(simpan)
                .addGap(16, 16, 16))
        );

        tableTetap.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableTetap);

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        mode="tambah";
        id.setText(null);
        cbakun.setSelectedItem(null);
        namabiaya.setText(null);
        jumlah.setText(null);
        cbjurusan.setSelectedItem(null);
        semester.setText(null);
        tahun.setText(null);
        dialogTetap.setTitle("Form BIaya Tetap - Tambah");
        dialogTetap.pack();
        dialogTetap.setLocationRelativeTo(null);
        dialogTetap.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

          int baris_index = tableTetap.getSelectedRow();
        if(baris_index >= 0) {
            mode="edit";
            String id_pilih = (tableTetap.getModel().getValueAt(baris_index, 1).toString());
            try {
                String sql="select * from biaya_tetap where id='"+id_pilih+"'";
                rs = kon.perintah.executeQuery(sql);
                if (rs.next()) {
                String txtId =rs.getString("id");
                 String txtAkun_id =rs.getString("akun_id");
                  String txtNama_biaya =rs.getString("nama_biaya");
                   String txtJumlah =rs.getString("jumlah");
                 String txtJurusan =rs.getString("jurusan");
                   String txtSmt =rs.getString("smt");
                 String txtTahun =rs.getString("tahun_angkatan");
             
                    
                    id.setText(txtId);
                    cbakun.setSelectedItem(txtAkun_id);
                    namabiaya.setText(txtNama_biaya);
                    jumlah.setText(txtJumlah);
                    cbjurusan.setSelectedItem(txtJurusan);
                    semester.setText(txtSmt);       
                    tahun.setText(txtTahun);     
                    
                 
                    
                    dialogTetap.setTitle("Form Biaya Tetap - Edit");
                    dialogTetap.pack();
                    dialogTetap.setLocationRelativeTo(null);
                    dialogTetap.setVisible(true);
                }
            } catch (Exception salahe) {
                System.err.println("Gagal Tampil data: "+salahe.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        
                                    

    }        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
int baris_index = tableTetap.getSelectedRow();
        if (baris_index >= 0) {
            int jwb = JOptionPane.showConfirmDialog(this, "Yakin mau hapus data ini ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jwb == JOptionPane.YES_OPTION) {
                String id_pilih = (tableTetap.getModel().getValueAt(baris_index, 1).toString());
                try {
                    String sql="delete from biaya_tetap where id='"+id_pilih+"'";
                    kon.perintah.execute(sql);
                    tampilData("");
                } catch (Exception salahe) {
                    System.err.println("Gagal Tampil data: "+salahe.getMessage());
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        String txtCari = cari.getText();
        tampilData(txtCari);        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String txtId = id.getText();
        String txtAkun_id = (String) cbakun.getSelectedItem();
        String txtNama_biaya = namabiaya.getText();
        String txtJumlah = jumlah.getText();
        String txtJurusan = (String) cbjurusan.getSelectedItem() ;
        String txtSmt =(String) semester.getText();
        String txtTahun =(String) tahun.getText();

        String sql = "";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);

        if (mode == "tambah") {
            sql = "insert into biaya_tetap values ("
            + "'" + txtId +"',"
            + "'" + txtAkun_id +"',"
            + "'" + txtNama_biaya +"',"
            + "'" + txtJumlah +"',"
            + "'" + txtJurusan +"',"
            + "'" + txtSmt +"',"
            + "'" + txtTahun +"',"
            + "'" + waktu_sekarang +"',"
            + "'" + waktu_sekarang +"',"
            + "null"
            + ")";
        } else {
            sql = "update biaya_tetap set akun_id='"+txtAkun_id+"',"
            + "nama_biaya='"+txtNama_biaya+"',"
            + "jumlah='"+txtJumlah+"',"
            + "jurusan='"+txtJurusan+"',"
            + "smt='"+txtSmt+"',"
            + "tahun_angkatan='"+txtTahun+"',"
            + "updated_at='"+waktu_sekarang+"'"
            + "where id='"+txtId+"'";
        }

        try {
            kon.perintah.execute(sql);
            dialogTetap.setVisible(false);
            tampilData("");
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
            JOptionPane.showConfirmDialog(this, "Gagal Simpan");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_simpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cbakun;
    private javax.swing.JComboBox<String> cbjurusan;
    private javax.swing.JDialog dialogTetap;
    private javax.swing.JToggleButton edit;
    private javax.swing.JToggleButton hapus;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField namabiaya;
    private javax.swing.JTextField semester;
    private javax.swing.JToggleButton simpan;
    private javax.swing.JTable tableTetap;
    private javax.swing.JTextField tahun;
    private javax.swing.JToggleButton tambah;
    // End of variables declaration//GEN-END:variables
}