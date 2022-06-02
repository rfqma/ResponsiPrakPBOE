package MovieDb;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewReview extends JFrame {
    JLabel lJudul = new JLabel("Judul");
    JLabel lAlur = new JLabel("Alur");
    JLabel lPenokohan = new JLabel("Penokohan");
    JLabel lAkting = new JLabel("Akting");

    public JTextField tfJudul = new JTextField();
    public JTextField tfAlur = new JTextField();
    public JTextField tfPenokohan = new JTextField();
    public JTextField tfAkting = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public ViewReview() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Film");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(745,500);
        setLocationRelativeTo(null);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 570, 400);

        add(lJudul);
        lJudul.setBounds(600, 20, 90, 20);
        add(tfJudul);
        tfJudul.setBounds(600, 40, 120, 20);

        add(lAlur);
        lAlur.setBounds(600, 60, 90, 20);
        add(tfAlur);
        tfAlur.setBounds(600, 80, 120, 20);

        add(lPenokohan);
        lPenokohan.setBounds(600, 100, 90, 20);
        add(tfPenokohan);
        tfPenokohan.setBounds(600, 120, 120, 20);

        add(lAkting);
        lAkting.setBounds(600, 140, 90, 20);
        add(tfAkting);
        tfAkting.setBounds(600, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(600, 270, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(600, 300, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(600, 330, 90, 20);

        add(btnClear);
        btnClear.setBounds(600, 360, 90, 20);
    }

    public String getJudul(){
        return tfJudul.getText();
    }

    public int getAlur(){
        if(tfAlur.getText().isEmpty()) {
            int alur = 0;
            return alur;
        } else {
            return Integer.parseInt(tfAlur.getText());
        }
    }

    public int getPenokohan(){
        if(tfPenokohan.getText().isEmpty()) {
            int penokohan = 0;
            return penokohan;
        } else {
            return Integer.parseInt(tfPenokohan.getText());
        }
    }

    public int getAkting(){
        if(tfAkting.getText().isEmpty()) {
            int akting = 0;
            return akting;
        } else {
            return Integer.parseInt(tfAkting.getText());
        }
    }
}
