package java_penjualan_desktop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class FJual extends javax.swing.JFrame {

    ArrayList<Barang> arrBarang = new ArrayList<>();
    ArrayList<Customer> arrCustomer = new ArrayList<>();
    String sql, id_customer, id_barang, nama_barang; //penampung
    boolean edit = false; //status data edit? atau tambah data baru?
    
    private DefaultTableModel tableModel;
    
    public FJual() {
        initComponents();
        loadBarang();
        loadCustomer();
        setTable();
    }

    private void loadBarang(){
        cb_barang.removeAllItems();
        
        try {
            ResultSet rs = DB.read( "select idbarang, namabarang, hargabeli, hargajual, stok from barang" );
            
            //masukkan kedalam class Divisi ( tampung )
            while( rs.next() ){
                arrBarang.add( 
                        new Barang( 
                            rs.getString("idbarang"),
                            rs.getString("namabarang"),
                            rs.getInt("hargabeli"),
                            rs.getInt("hargajual"),
                            rs.getInt("stok")
                        )
                );
            }
            
            //ambil dari class divisi dan munculkan pada combo box cbx_divisi
            for( int i = 0; i < arrBarang.size(); i++ ){
                cb_barang.addItem( arrBarang.get( i ).getId() + " - " + arrBarang.get( i ).getNama());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    private void loadCustomer(){
        cb_customer.removeAllItems();
        
        try {
            ResultSet rs = DB.read( "select idcustomer, namacustomer from customer" );
            
            //masukkan kedalam class Divisi ( tampung )
            while( rs.next() ){
                arrCustomer.add( 
                    new Customer( 
                        rs.getString("idcustomer"),
                        rs.getString("namacustomer")
                    )
                );
            }
            
            //ambil dari class divisi dan munculkan pada combo box cbx_divisi
            for( int i = 0; i < arrCustomer.size(); i++ ){
                cb_customer.addItem(arrCustomer.get( i ).getId() + " - " + arrCustomer.get( i ).getNama());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    void setTable(){
        Object[]baris = { 
            "#Barang", 
            "Nama", 
            "Qty", 
            "Harga", 
            "Jumlah"
        };
        
        tableModel = new DefaultTableModel(null, baris);
        table.setModel(tableModel);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        popup = new javax.swing.JPopupMenu();
        mUbah = new javax.swing.JMenuItem();
        mHapus = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        tf_no_faktur = new javax.swing.JTextField();
        dc_tanggal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        cb_customer = new javax.swing.JComboBox();
        cb_barang = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_harga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_jumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        bt_simpan = new javax.swing.JButton();
        bt_cetak = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_faktur_baru = new javax.swing.JButton();
        tf_cari = new javax.swing.JTextField();
        bt_cari = new javax.swing.JButton();

        mUbah.setText("Ubah");
        mUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUbahActionPerformed(evt);
            }
        });
        popup.add(mUbah);

        mHapus.setText("Hapus");
        mHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHapusActionPerformed(evt);
            }
        });
        popup.add(mHapus);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("#Faktur");

        dc_tanggal.setDateFormatString("dd-MM-yyyy");

        jLabel2.setText("Tanggal");

        jLabel3.setText("#Pemasok");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.setComponentPopupMenu(popup);
        jScrollPane1.setViewportView(table);

        cb_customer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_customerActionPerformed(evt);
            }
        });

        cb_barang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_barangActionPerformed(evt);
            }
        });

        jLabel4.setText("#Barang");

        tf_qty.setText("0");
        tf_qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_qtyFocusLost(evt);
            }
        });
        tf_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_qtyKeyReleased(evt);
            }
        });

        jLabel5.setText("Qty");

        tf_total.setText("0");

        jLabel6.setText("Total");

        tf_harga.setText("0");

        jLabel7.setText("Harga");

        tf_jumlah.setText("0");

        jLabel8.setText("Jumlah");

        bt_tambah.setText("+");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_simpan.setText("Simpan");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        bt_cetak.setText("Cetak Faktur");
        bt_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cetakActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");

        bt_faktur_baru.setText("Tambah");
        bt_faktur_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_faktur_baruActionPerformed(evt);
            }
        });

        tf_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cariActionPerformed(evt);
            }
        });

        bt_cari.setText("Cari");
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_barang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_tambah)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dc_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_cari)))
                                .addGap(34, 34, 34))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_no_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_faktur_baru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_cetak)
                                .addGap(18, 18, 18)
                                .addComponent(bt_hapus)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dc_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tf_no_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_tambah)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(bt_simpan)
                        .addComponent(bt_cetak)
                        .addComponent(bt_hapus)
                        .addComponent(bt_faktur_baru))
                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_customerActionPerformed
        int idx = cb_customer.getSelectedIndex();
        
        if ( arrCustomer.size() > 0 ){
            id_customer = arrCustomer.get(idx).getId();
        }
    }//GEN-LAST:event_cb_customerActionPerformed

    private void cb_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_barangActionPerformed
        int idx = cb_barang.getSelectedIndex();
        
        if ( arrBarang.size() > 0 ){
            id_barang = arrBarang.get(idx).getId();
            nama_barang = arrBarang.get(idx).getNama();
            tf_harga.setText( String.valueOf( arrBarang.get(idx).getH_jual() ) );
            
            if( tf_qty.getText().equals( "0" ) ) tf_qty.setText("1");
            
            hitung();
        }
    }//GEN-LAST:event_cb_barangActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
        //kalo qty masih "0" maka batal
        if( tf_qty.getText().equals( "0" )) return;
        
        //persiapakan 5 kolom berupa objek
        Object[] row = new Object[5];
        
        //atur data yang akan di masukkan kedalam objek baris
        row[0] = id_barang;
        row[1] = nama_barang;
        row[2] = tf_qty.getText();
        row[3] = tf_harga.getText();
        row[4] = tf_jumlah.getText();
        
        //masukkan kedalam grid
        tableModel.addRow(row);
        
        //kosongkan
        cb_barang.setSelectedIndex(0);
        tf_qty.setText( "0" );
        tf_jumlah.setText( "0" );
        
        total();
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void tf_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_qtyKeyReleased
        hitung();
    }//GEN-LAST:event_tf_qtyKeyReleased

    private void tf_qtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_qtyFocusLost
        if( tf_qty.getText().equals("") ) 
            tf_qty.setText("0");
        
        hitung();
    }//GEN-LAST:event_tf_qtyFocusLost

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        //jika sedang edit, maka hapus data lama dahulu
        if (edit){
            try {
                DB.exec("delete from detjual where faktur = '"+ tf_no_faktur.getText().trim() +"'");
                DB.exec("delete from jual where faktur = '"+ tf_no_faktur.getText().trim() +"'");
            } catch (SQLException ex) {
                Logger.getLogger(FJual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if ( tf_no_faktur.getText().equals( "" ) ){
            JOptionPane.showMessageDialog(null, "Nomer Faktur belum terisi");
        }else if ( tf_total.getText().equals( "0" ) ) {
            JOptionPane.showMessageDialog(null, "Belum ada transaksi");
        }else if( dc_tanggal.getDate() == null ){
            JOptionPane.showMessageDialog(null, "Tanggal tak boleh kosong");
        }else{
            //ubah format tanggal sesuai format mysql
            String pattern  = "yyyy-MM-dd";
            DateFormat formatter = new SimpleDateFormat(pattern);
            String tgl = formatter.format( dc_tanggal.getDate());
            
            String no_faktur = tf_no_faktur.getText().trim();
            try {
                //simpan jual
                sql = "insert into jual values ('"+ no_faktur +"', "
                        + "'"+ tgl +"', '"+ id_customer +"')";
            
                DB.exec(sql); //simpan jual
                
                //2. simpan data detil jual diambil yang diambil dari jtable
                for( int i = 0; i < tableModel.getRowCount(); i++){
                    sql = "insert into detjual values ('"+ no_faktur +"', "
                            + "'"+ tableModel.getValueAt(i, 0).toString() +"', " //id
                            + ""+ tableModel.getValueAt(i, 2).toString() +", " //qty
                            + ""+ tableModel.getValueAt(i, 3).toString() +" )"; //harga
            
                    DB.exec(sql); //simpan jual
                }
                
                JOptionPane.showMessageDialog(null, "Faktur berhasil disimpan");
            } catch (SQLException ex) {
                System.out.println( ex );
            }
        }    
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void mUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUbahActionPerformed
        int idx_cb_barang = 0;
        int idx = table.getSelectedRow();        
        String temp_id_barang = tableModel.getValueAt( idx, 0).toString();
        
        //temukan index ( urutan ) pada combobox cb_barang, otomatis agar bergeser
        for( int i = 0; i < arrBarang.size(); i++){
            if ( arrBarang.get( i ).getId().equals( temp_id_barang ) ) {
                idx_cb_barang = i;
                break;
            }
        }
        
        //geser combo box agar menuju kode barang yang terpilih
        cb_barang.setSelectedIndex( idx_cb_barang );
        tf_qty.setText( tableModel.getValueAt( idx, 2).toString() ); //qty berada pada index ke 2  
        tableModel.removeRow( idx );
        total();
    }//GEN-LAST:event_mUbahActionPerformed

    private void mHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHapusActionPerformed
        int idx = table.getSelectedRow();
        tableModel.removeRow( idx );
        total();
    }//GEN-LAST:event_mHapusActionPerformed

    private void bt_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cetakActionPerformed
        String dir = System.getProperty("user.dir");
        String noFaktur = tf_no_faktur.getText().trim();
        
        JasperPrint jp;
        
        try{
            JasperCompileManager.compileReportToFile(
                    dir + "/src/java_penjualan_desktop/nota.jrxml",
                    dir + "/src/java_penjualan_desktop/nota.jasper");
            
            //parameter diatur pada kode dibawah ini
            Map parameters = new HashMap();
            parameters.put("p_faktur", noFaktur);
            
            jp = JasperFillManager.fillReport(
                    getClass().getResourceAsStream("nota.jasper"), 
                    parameters,
                    DB.connectDB());
            
            JasperViewer.viewReport(jp, false);
        }catch( Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_bt_cetakActionPerformed

    private void bt_faktur_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_faktur_baruActionPerformed
        tf_no_faktur.setText("");
        tf_total.setText( "0" );
        dc_tanggal.setDate( null );
        edit = false;

        //bersihkan jtable
        ((DefaultTableModel)table.getModel()).setRowCount(0);
    }//GEN-LAST:event_bt_faktur_baruActionPerformed

    private void tf_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cariActionPerformed

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        //jika tf_cari tak ada, maka skip
        if( tf_cari.getText().trim() == "" ) return;
        
        try{
            //inisiasi variabel
            String faktur = null, idCustomer = null;
            int idxCustomer = 0;
            Date tgl = null;
            
            edit = true; //berikan status sedang melakukan "edit data"
        
            sql = "select * from vtransaksijual where faktur = '"+ tf_cari.getText().trim() +"'";
            ResultSet rs = DB.read(sql);
            
            //bersihkan baris table
            ( (DefaultTableModel) table.getModel() ).setRowCount(0);
            
            //tampilkan data kedalam form
            while( rs.next() ){
                faktur = rs.getString("faktur");
                tgl = new SimpleDateFormat("yyyy-MM-dd").parse( rs.getString("tanggal") );
                idCustomer = rs.getString("idcustomer");
                
                //persiapkan 5 kolom berupa objek
                Object[] row = new Object[5];

                //atur data yang akan di masukkan kedalam objek baris
                row[0] = rs.getString("idbarang");
                row[1] = rs.getString("namabarang");
                row[2] = rs.getString("qty");
                row[3] = rs.getString("harga");
                row[4] = rs.getString("jumlah");

                //masukkan kedalam grid
                tableModel.addRow(row);
            }
            
            //letakkan nilai pada textfield dan date chooser
            tf_no_faktur.setText( faktur );
            tf_no_faktur.setEditable( false ); //kunci agar tak dapat diubah
            dc_tanggal.setDate( tgl );
            
            //set index combo box customer
            for( int i = 0; i < arrCustomer.size(); i++ ){
                if( arrCustomer.get(i).getId().equals( idCustomer )){
                    idxCustomer = i;
                    break; //jika sudah ditemukan, maka hentikan
                }
            }
            
            //set
            cb_customer.setSelectedIndex( idxCustomer );
            
            total();
                    
            DB.closeDB();
        } catch( Exception ex ){
            System.out.println( ex.getMessage() );
        }
    }//GEN-LAST:event_bt_cariActionPerformed

    void hitung(){
        try {
            int q = Integer.valueOf( tf_qty.getText() );
            int h = Integer.valueOf( tf_harga.getText() );
            int j = q * h;
            tf_jumlah.setText( String.valueOf( j ) );
        } catch ( Exception ex ) {
            System.out.println( ex.getMessage() );
        }
    }
    
    void total(){
        int total = 0;
        for( int i = 0; i < tableModel.getRowCount(); i++){
            //kolom ke 5, dalam index(4)
            total += Integer.valueOf( tableModel.getValueAt(i, 4).toString() ); 
        }
        tf_total.setText( String.valueOf( total ) );
    }
    
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
            java.util.logging.Logger.getLogger(FJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FJual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_cetak;
    private javax.swing.JButton bt_faktur_baru;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JComboBox cb_barang;
    private javax.swing.JComboBox cb_customer;
    private com.toedter.calendar.JDateChooser dc_tanggal;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mHapus;
    private javax.swing.JMenuItem mUbah;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_harga;
    private javax.swing.JTextField tf_jumlah;
    private javax.swing.JTextField tf_no_faktur;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables
}
