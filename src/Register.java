import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterForm extends JFrame implements ActionListener{
    private Container c;
    private JButton resetButton;
    private JButton loginButton;
    private JTextField namaPengguna;
    private JTextField email;
    private JComboBox cbDay;
    private JComboBox cbMonth;
    private JComboBox cbYear;
    private JPasswordField kataSandi;
    private JPasswordField confirmKataSandi;
    private JLabel jLabel;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private String dates[]
            = { "--","1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "--","Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "----","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };



    public RegisterForm(){
    setTitle("Program Pendaftaran");
    setBounds(300, 90, 400, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    c = getContentPane();
    c.setLayout(null);

    jLabel = new JLabel("Nama Pengguna");
    jLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    jLabel.setSize(140, 20);
    jLabel.setLocation(10, 10);
    c.add(jLabel);


    namaPengguna = new JTextField();
    namaPengguna.setFont(new Font("Arial", Font.PLAIN, 12));
    namaPengguna.setSize(200, 20);
    namaPengguna.setLocation(160, 10);
    c.add(namaPengguna);


    jLabel = new JLabel("Kata Sandi");
    jLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    jLabel.setSize(140, 20);
    jLabel.setLocation(10, 40);
    c.add(jLabel);


    kataSandi = new JPasswordField();
    kataSandi.setFont(new Font("Arial", Font.PLAIN, 12));
    kataSandi.setSize(200, 20);
    kataSandi.setLocation(160, 40);
    c.add(kataSandi);



    jLabel = new JLabel("Konfirmasi Kata Sandi");
    jLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    jLabel.setSize(140, 20);
    jLabel.setLocation(10, 70);
    c.add(jLabel);


    confirmKataSandi = new JPasswordField();
    confirmKataSandi.setFont(new Font("Arial", Font.PLAIN, 12));
    confirmKataSandi.setSize(200, 20);
    confirmKataSandi.setLocation(160, 70);
    c.add(confirmKataSandi);


    jLabel = new JLabel("Email");
    jLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    jLabel.setSize(140, 20);
    jLabel.setLocation(10, 100);
    c.add(jLabel);


    email = new JTextField();
    email.setFont(new Font("Arial", Font.PLAIN, 12));
    email.setSize(200, 20);
    email.setLocation(160, 100);
    c.add(email);


    jLabel = new JLabel("Tanggal Lahir");
    jLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    jLabel.setSize(140, 20);
    jLabel.setLocation(10, 130);
    c.add(jLabel);


    cbDay = new JComboBox(dates);
    cbDay.setFont(new Font("Arial", Font.PLAIN, 12));
    cbDay.setSize(50, 20);
    cbDay.setLocation(160, 130);
    c.add(cbDay);

    cbMonth = new JComboBox(months);
    cbMonth.setFont(new Font("Arial", Font.PLAIN, 12));
    cbMonth.setSize(60, 20);
    cbMonth.setLocation(220, 130);
    c.add(cbMonth);

    cbYear = new JComboBox(years);
    cbYear.setFont(new Font("Arial", Font.PLAIN, 12));
    cbYear.setSize(60, 20);
    cbYear.setLocation(290, 130);
    c.add(cbYear);


    resetButton = new JButton("Reset");
    resetButton.setFont(new Font("Arial", Font.PLAIN, 12));
    resetButton.setSize(100, 20);
    resetButton.setLocation(20, 180);
    resetButton.addActionListener(this);
    c.add(resetButton);


    loginButton = new JButton("Login");
    loginButton.setFont(new Font("Arial", Font.PLAIN, 12));
    loginButton.setSize(100, 20);
    loginButton.setLocation(200, 180);
    loginButton.addActionListener(this);
    c.add(loginButton);

    setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loginButton){
            String kataSandi1 = new String(kataSandi.getPassword());
            String confirm1 = new String(confirmKataSandi.getPassword());
            if(namaPengguna.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Nama Pengguna Harus Diisi!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(kataSandi.getPassword().length == 0){
                JOptionPane.showMessageDialog(null, "Kata Sandi Harus Diisi!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(!kataSandi1.equals(confirm1)){
                JOptionPane.showMessageDialog(null, "Kata Sandi dan Konfirmasi Kata Sandi Harus Sama!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(email.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Email Pengguna Harus Diisi!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(!email.getText().matches(EMAIL_PATTERN)){
                JOptionPane.showMessageDialog(null, "Format Email Salah!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(cbDay.getSelectedItem() == "--"){
                JOptionPane.showMessageDialog(null, "Tanggal Harus Dipilih!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(cbMonth.getSelectedItem() == "--"){
                JOptionPane.showMessageDialog(null, "Bulan Harus Dipilih!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else if(cbYear.getSelectedItem() == "----"){
                JOptionPane.showMessageDialog(null, "Tahun Harus Dipilih!","Informasi", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Sukses Login!","Informasi", JOptionPane.INFORMATION_MESSAGE);
            }


        }else if(e.getSource() == resetButton){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda yakin?","Konfimasi",dialogButton);
            if(dialogResult==JOptionPane.YES_OPTION){
                String set ="";
                namaPengguna.setText(set);
                kataSandi.setText(set);
                confirmKataSandi.setText(set);
                email.setText(set);
                cbDay.setSelectedIndex(0);
                cbMonth.setSelectedIndex(0);
                cbYear.setSelectedIndex(0);
            }
        }
    }


}

    public class Register {
        public static void main(String[] args) throws Exception
        {
            RegisterForm f = new RegisterForm();
        }
}
