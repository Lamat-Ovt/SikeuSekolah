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
public class FormKelas extends javax.swing.JInternalFrame {
    Koneksi kon;
    ResultSet rs;
    String mode;
    /**
     * Creates new form FormKelas
     */
    public FormKelas() {
        initComponents();
          kon = new Koneksi();
          tampilData("");
          cbjurusan();
    }
    private void tampilData(String filter){
        Object[] judulKolom = {"No", "id","Kode Kelas","Nama Jurusan"};
        DefaultTableModel modelAkun = new DefaultTableModel(null,judulKolom);
        tableKelas.setModel(modelAkun);

        try{
            String sql="select kelas.id, kode_kelas, jurusan, nama_jurusan from kelas INNER JOIN jurusan on kelas.jurusan=jurusan.id  where kode_kelas like '%"+filter+"%' or jurusan like '%"+filter+"%'";
            rs = kon.perintah.executeQuery(sql);
            int no = 0;
            while (rs.next()) {
                no++;
                String txtId =rs.getString("id");
                String txtKode_kelas =rs.getString("kode_kelas");
                String txtNama_jurusan =rs.getString("nama_jurusan");
                String[] barisBaru = {Integer.toString(no), txtId, txtKode_kelas, txtNama_jurusan};
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
    
     public void tampilJurusan(String txtJurusan){
      try {
            String sql="select * from jurusan where id='"+txtJurusan+"'";
            rs = kon.perintah.executeQuery(sql);
            if (rs.next()) {
                String jurusan1 = rs.getString("nama_jurusan");
                jurusan.setText(jurusan1);
            }
        } catch (Exception salahe) {
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

        dialogKelas = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        kodekelas = new javax.swing.JTextField();
        jurusan = new javax.swing.JTextField();
        simpan = new javax.swing.JToggleButton();
        cbjurusan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKelas = new javax.swing.JTable();
        tambah = new javax.swing.JToggleButton();
        edit = new javax.swing.JToggleButton();
        hapus = new javax.swing.JToggleButton();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("ID");

        jLabel3.setText("Kode Kelas");

        jLabel4.setText("Jurusan");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        cbjurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbjurusanMouseClicked(evt);
            }
        });

        jLabel5.setText("Nama Jurusan");

        javax.swing.GroupLayout dialogKelasLayout = new javax.swing.GroupLayout(dialogKelas.getContentPane());
        dialogKelas.getContentPane().setLayout(dialogKelasLayout);
        dialogKelasLayout.setHorizontalGroup(
            dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogKelasLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbjurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kodekelas, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jurusan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogKelasLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        dialogKelasLayout.setVerticalGroup(
            dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogKelasLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kodekelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(dialogKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addComponent(simpan)
                .addGap(51, 51, 51))
        );

        setBackground(new java.awt.Color(102, 102, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tableKelas.setBackground(new java.awt.Color(204, 204, 204));
        tableKelas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableKelas);

        tambah.setBackground(new java.awt.Color(153, 153, 153));
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(153, 153, 153));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
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
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
           mode="tambah";
        id.setText(null);
        cbjurusan.setSelectedItem(null);
        kodekelas.setText(null);
        jurusan.setEnabled(false);
        id.setEnabled(true);
        dialogKelas.setTitle("Form Kelas - Tambah");
        dialogKelas.pack();
        dialogKelas.setLocationRelativeTo(null);
        dialogKelas.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int baris_index = tableKelas.getSelectedRow();
        if(baris_index >= 0) {
            mode="edit";
            String id_pilih = (tableKelas.getModel().getValueAt(baris_index, 1).toString());
            try {
                String sql="select * from kelas where id='"+id_pilih+"'";
                rs = kon.perintah.executeQuery(sql);
                if (rs.next()) {
                    String txtId = rs.getString("id");
                    String txtKode_kelas = rs.getString("kode_kelas");
                    String txtJurusan = rs.getString("jurusan");
                    id.setText(txtId);
                    kodekelas.setText(txtKode_kelas);
                    cbjurusan.setSelectedItem(rs.getString("jurusan"));
                    jurusan.setText(txtJurusan);
                    tampilJurusan(txtJurusan);
                    
                    id.setEnabled(false);
                    dialogKelas.setTitle("Form Kelas - Edit");
                    dialogKelas.setLocationRelativeTo(null);
                    dialogKelas.setVisible(true);
                }
            } catch (Exception salahe) {
                System.err.println("Gagal Tampil data: "+salahe.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        }      // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int baris_index = tableKelas.getSelectedRow();
        if (baris_index >= 0) {
            int jwb = JOptionPane.showConfirmDialog(this, "Yakin mau hapus data ini ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jwb == JOptionPane.YES_OPTION) {
                String id_pilih = (tableKelas.getModel().getValueAt(baris_index, 1).toString());
                try {
                    String sql="delete from kelas where id='"+id_pilih+"'";
                    kon.perintah.execute(sql);
                    tampilData("");
                } catch (Exception salahe) {
                    System.err.println("Gagal Tampil data: "+salahe.getMessage());
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        } // TODO add your handling code here:
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        String txtCari = cari.getText();
        tampilData(txtCari);         // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
       String txtId = id.getText();
        String txtKode_kelas = kodekelas.getText();
        String txtJurusan = (String) cbjurusan.getSelectedItem();
        String sql = "";
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);
        
        if (mode == "tambah") {
            sql = "insert into kelas values ("
                + "'" + txtId +"',"
                + "'" + txtKode_kelas +"',"
                + "'" + txtJurusan +"',"
                + "'" + waktu_sekarang +"',"
                + "'" + waktu_sekarang +"',"
                + "null"
                + ")";
        } else {
            sql = "update kelas set kode_kelas='"+txtKode_kelas+"',"
                + "jurusan='"+txtJurusan+"',"
                + "updated_at='"+waktu_sekarang+"'"
                + "where id='"+txtId+"'";
        }
        
        try {
            kon.perintah.execute(sql);
            dialogKelas.setVisible(false);
            tampilData("");
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
            JOptionPane.showConfirmDialog(this, "Gagal Simpan");
        }      // TODO add your handling code here:
    }//GEN-LAST:event_simpanActionPerformed

    private void cbjurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbjurusanMouseClicked
    tampilJurusan((String) 
    cbjurusan.getSelectedItem());    // TODO add your handling code here:
    }//GEN-LAST:event_cbjurusanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cbjurusan;
    private javax.swing.JDialog dialogKelas;
    private javax.swing.JToggleButton edit;
    private javax.swing.JToggleButton hapus;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jurusan;
    private javax.swing.JTextField kodekelas;
    private javax.swing.JToggleButton simpan;
    private javax.swing.JTable tableKelas;
    private javax.swing.JToggleButton tambah;
    // End of variables declaration//GEN-END:variables
}
