
/**
 * Write a description of class AdminGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.util.List;

public class AdminGUI extends JFrame {
    private JTextField txtNpwp, txtNama, txtPenghasilan;
    private JComboBox<String> cmbStatus;
    private JTable table;
    private DefaultTableModel tableModel;
    private TaxService service;

    public AdminGUI() {
        service = new TaxService();

        setTitle("Coretax System - Admin Panel");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelInput = new JPanel(new GridLayout(6, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panelInput.add(new JLabel("NPWP:"));
        txtNpwp = new JTextField();
        panelInput.add(txtNpwp);

        panelInput.add(new JLabel("Nama Wajib Pajak:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Penghasilan Tahunan (IDR):"));
        txtPenghasilan = new JTextField();
        panelInput.add(txtPenghasilan);

        panelInput.add(new JLabel("Status Pembayaran:"));
        String[] opsiStatus = {"Belum Lunas", "Lunas"};
        cmbStatus = new JComboBox<>(opsiStatus);
        panelInput.add(cmbStatus);

        JPanel panelTombol = new JPanel(new GridLayout(1, 4, 5, 5));
        
        JButton btnSimpan = new JButton("Simpan Baru");
        JButton btnUpdate = new JButton("Update Data");
        JButton btnHapus = new JButton("Hapus");
        JButton btnClear = new JButton("Bersihkan");
        
        panelTombol.add(btnSimpan);
        panelTombol.add(btnUpdate);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        panelInput.add(new JLabel("Aksi:"));
        panelInput.add(panelTombol);

        add(panelInput, BorderLayout.NORTH);

        String[] columnNames = {"NPWP", "Nama", "Penghasilan", "Pajak", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnLogout = new JButton("Logout");
        add(btnLogout, BorderLayout.SOUTH);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtNpwp.setText(tableModel.getValueAt(row, 0).toString());
                txtNama.setText(tableModel.getValueAt(row, 1).toString());
                
                String penghasilanStr = tableModel.getValueAt(row, 2).toString();
                txtPenghasilan.setText(penghasilanStr.replaceAll("[^0-9]", ""));
                
                String status = tableModel.getValueAt(row, 4).toString();
                cmbStatus.setSelectedItem(status);

                txtNpwp.setEditable(false);
                txtNpwp.setBackground(Color.LIGHT_GRAY);
            }
        });

        btnSimpan.addActionListener(e -> prosesSimpan());
        btnUpdate.addActionListener(e -> prosesUpdate());
        btnHapus.addActionListener(e -> prosesHapus());
        btnClear.addActionListener(e -> clearForm());

        btnLogout.addActionListener(e -> {
            new LoginGUI().setVisible(true);
            this.dispose();
        });

        refreshTable();
    }

    private void prosesHapus() {
        String npwp = txtNpwp.getText();
        
        if(npwp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus dari tabel terlebih dahulu!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this, 
            "Yakin ingin menghapus data dengan NPWP: " + npwp + "?", 
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            if (service.deleteData(npwp)) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                refreshTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data.");
            }
        }
    }

    private void prosesSimpan() {
        try {
            String npwp = txtNpwp.getText();
            String nama = txtNama.getText();
            double penghasilan = Double.parseDouble(txtPenghasilan.getText());
            double pajak = service.hitungPajak(penghasilan);
            String status = cmbStatus.getSelectedItem().toString();

            WajibPajak wp = new WajibPajak(npwp, nama, penghasilan, pajak, status);

            if (service.simpanData(wp)) {
                JOptionPane.showMessageDialog(this, "Data Disimpan!");
                refreshTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal (NPWP Duplikat).");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Input Angka.");
        }
    }

    private void prosesUpdate() {
        try {
            if(txtNpwp.getText().isEmpty()) return;

            String npwp = txtNpwp.getText();
            String nama = txtNama.getText();
            double penghasilan = Double.parseDouble(txtPenghasilan.getText());
            double pajak = service.hitungPajak(penghasilan);
            String status = cmbStatus.getSelectedItem().toString();

            WajibPajak wp = new WajibPajak(npwp, nama, penghasilan, pajak, status);

            if (service.updateData(wp)) {
                JOptionPane.showMessageDialog(this, "Data & Status Diupdate!");
                refreshTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal Update.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Input Angka.");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<WajibPajak> data = service.getAllData();
        for (WajibPajak wp : data) {
            Object[] row = {
                wp.getNpwp(),
                wp.getNama(),
                String.format("Rp %,.0f", wp.getPenghasilan()),
                String.format("Rp %,.0f", wp.getPajak()),
                wp.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void clearForm() {
        txtNpwp.setText("");
        txtNama.setText("");
        txtPenghasilan.setText("");
        cmbStatus.setSelectedIndex(0); 
        txtNpwp.setEditable(true);
        txtNpwp.setBackground(Color.WHITE);
        table.clearSelection();
    }
}