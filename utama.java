package utama;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class utama extends JFrame {

    private JPanel panelutama;

    private JList jListBarang;

    private JTextField txtFilter;

    private JButton btnFilter;

    private JTextField txtNamaBarang;

    private JTextField txtStokBarang;

    private JTextField txtHargaBarang;

    private JButton btnSave;

    private JButton btnDelete;
    private JButton btnClear;

    private JLabel lblNamaBarang;

    private JLabel lblStokBarang;
    private JLabel lblHargaBarang;

    List<Barang> arrayListBarang = new ArrayList<>();

    DefaultListModel defaultListModel = new DefaultListModel();

    class Barang {
        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getStok() {
            return stok;
        }

        public void setStok(String stok) {
            this.stok = stok;
        }
        public Double getHarga() {
            return harga;
        }

        public void setHarga(Double harga) {
            this.harga = harga;
        }

        public String nama;
        public String stok;
        public Double harga;
    }

    public utama() {
        super("Data Elektronik");
        this.setContentPane(panelutama);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNamaBarang.getText();
                String stok = txtStokBarang.getText();
                Double harga = Double.parseDouble(txtHargaBarang.getText());

                Barang barang = new Barang();
                barang.setNama(nama);
                barang.setStok(stok);
                barang.setHarga(harga);

                arrayListBarang.add(barang);
                clearForm();

                fromListBarangToListModel();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        jListBarang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int index = jListBarang.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListBarang.getSelectedValue().toString();
                for (int i = 0; i < arrayListBarang.size(); i++) {
                    if (arrayListBarang.get(i).getNama().equals(nama)) {
                        Barang barang = arrayListBarang.get(i);
                        txtNamaBarang.setText(barang.getNama());
                        txtStokBarang.setText(barang.getStok());
                        txtHargaBarang.setText(String.valueOf(barang.getHarga()));
                        break;
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListBarang.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListBarang.getSelectedValue().toString();

                for (int i = 0; i < arrayListBarang.size(); i++) {
                    if (arrayListBarang.get(i).getNama().equals(nama)) {
                        arrayListBarang.remove(i);
                    }
                }

                clearForm();
                fromListBarangToListModel();
            }
        });
        btnFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String keyWord = txtFilter.getText();

                List<String> filter = new ArrayList<>();

                for (int i = 0; i < arrayListBarang.size(); i++) {
                    if (arrayListBarang.get(i).getNama().contains(keyWord)) {
                        filter.add(arrayListBarang.get(i).getNama());
                    }
                }

                refreshListModel(filter);
            }
        });
        jListBarang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void clearForm() {
        txtNamaBarang.setText("");
        txtStokBarang.setText("");
        txtHargaBarang.setText("");
    }

    public void fromListBarangToListModel() {
        List<String> listNamaBarang = new ArrayList<>();

        for (int i = 0; i < arrayListBarang.size(); i++) {
            listNamaBarang.add(
                    arrayListBarang.get(i).getNama()
            );
        }

        refreshListModel(listNamaBarang);
    }

    public void refreshListModel(List<String> list) {
        defaultListModel.clear();
        defaultListModel.addAll(list);
        jListBarang.setModel(defaultListModel);
    }

    public static void main (String[] args) {
        utama mainScreen = new utama();
        mainScreen.setVisible(true);
    }

}








