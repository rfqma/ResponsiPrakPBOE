package MovieDb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerReview {
    ModelReview modelReview;
    ViewReview viewReview;
    public String data;

    public ControllerReview(ModelReview modelReview, ViewReview viewReview) {
        this.modelReview = modelReview;
        this.viewReview = viewReview;

        if (modelReview.getBanyakData()!=0) {
            String dataTrans[][] = modelReview.readData();
            viewReview.tabel.setModel((new JTable(dataTrans, viewReview.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewReview.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = viewReview.getJudul();
                int Alur = viewReview.getAlur();
                int Penokohan = viewReview.getPenokohan();
                double Akting = viewReview.getAkting();
                double Nilai = ((Alur+Penokohan+Akting)/3);
                if(Judul.isEmpty() || Alur==0 || Penokohan==0 || Akting==0 || Nilai==0){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else{
                    modelReview.insertData(Judul, Alur, Penokohan, (int) Akting, (int) Nilai);
                }


                String dataTrans[][] = modelReview.readData();
                viewReview.tabel.setModel((new JTable(dataTrans, viewReview.namaKolom)).getModel());
            }
        });

        viewReview.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Judul = viewReview.getJudul();
                int Alur = viewReview.getAlur();
                int Penokohan = viewReview.getPenokohan();
                double Akting = viewReview.getAkting();
                double Nilai = (Alur+Penokohan+Akting)/3;
                if(Judul.isEmpty() || Alur==0 || Penokohan==0 || Akting==0 || Nilai==0){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else{
                    modelReview.updateData(Judul, Alur, Penokohan, (int )Akting,(int) Nilai);
                }


                String dataTrans[][] = modelReview.readData();
                viewReview.tabel.setModel((new JTable(dataTrans, viewReview.namaKolom)).getModel());
            }
        });

        viewReview.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                viewReview.tfJudul.setText("");
                viewReview.tfAlur.setText("");
                viewReview.tfPenokohan.setText("");
                viewReview.tfAkting.setText("");
            }
        });

        viewReview.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = viewReview.tabel.getSelectedRow();
                data = viewReview.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = viewReview.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = viewReview.tabel.getValueAt(baris, 1).toString();

                System.out.println(data);
            }
        });

        viewReview.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Judul " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelReview.deleteData(data);
                    String dataTrans[][] = modelReview.readData();
                    viewReview.tabel.setModel((new JTable(dataTrans, viewReview.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    }
}
