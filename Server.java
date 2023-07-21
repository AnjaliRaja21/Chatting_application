
package chatting_application;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;


import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.BorderLayout;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.util.Calendar;


import java.text.*;


import java.net.*;                            //serverSocket and Socket class ke liye


import java.io.*;                      //for DataInputStream;

public class Server implements ActionListener{

     JTextField text;
     JButton send;
     JPanel a1;
     static Box vertical = Box.createVerticalBox();
     static JFrame f = new JFrame();
     static DataOutputStream dout;
     
    
    Server(){
        
        f.setLayout(null);
        
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(7 , 94 , 84));
        panel_1.setBounds(0 , 0 , 450 , 70);
        panel_1.setLayout(null);
        f.add(panel_1);
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/back_arrow.png"));                             //ClassLoader.getSystemResource      system se image uthaane ke liye
        Image img2 = img1.getImage().getScaledInstance(25 , 25 , Image.SCALE_DEFAULT);        
        ImageIcon img3 = new ImageIcon(img2);
        JLabel back = new JLabel(img3);
        back.setBounds(5,20,25,25);
        panel_1.add(back);
        
        
        
        back.addMouseListener(new MouseAdapter(){                                                          //kyunki hum click karenge mouse ki help se isliye MouseListener function ko use kiya fir iske andar ek class ka object banana padta h jo h MouseAdapter of fir ek method ko call karna padega
             public void mouseClicked(MouseEvent me){                                                             //kyunki mouse ka clickevent chahiye to MouseClicked method lenge or ye leta h apne andar ek MouseEvent ka object
        
//             setVisible(false);
             System.exit(0);
             }
             
             } );
                
                
        
        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icons/dp_1.png"));                             //ClassLoader.getSystemResource      system se image uthaane ke liye
        Image img5 = img4.getImage().getScaledInstance(50 , 50 , Image.SCALE_DEFAULT);        
        ImageIcon img6 = new ImageIcon(img5);
        JLabel profile = new JLabel(img6);
        profile.setBounds(40,10,50,50);
        panel_1.add(profile);
        
        
        
        ImageIcon img7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));                             //ClassLoader.getSystemResource      system se image uthaane ke liye
        Image img8 = img7.getImage().getScaledInstance(30 , 30 , Image.SCALE_DEFAULT);        
        ImageIcon img9 = new ImageIcon(img8);
        JLabel vedio = new JLabel(img9);
        vedio.setBounds(300,20,30,30);
        panel_1.add(vedio);
        
        
        
        ImageIcon img10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));                             //ClassLoader.getSystemResource      system se image uthaane ke liye
        Image img11 = img10.getImage().getScaledInstance(35 , 30 , Image.SCALE_DEFAULT);        
        ImageIcon img12 = new ImageIcon(img11);
        JLabel phone = new JLabel(img12);
        phone.setBounds(360,20,35,30);
        panel_1.add(phone);
        
        
        
        ImageIcon img13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));                             //ClassLoader.getSystemResource      system se image uthaane ke liye
        Image img14 = img13.getImage().getScaledInstance(10 , 25 , Image.SCALE_DEFAULT);        
        ImageIcon img15 = new ImageIcon(img14);
        JLabel morevert = new JLabel(img15);
        morevert.setBounds(410,20,10,25);
        panel_1.add(morevert);
        
        
                
        JLabel name = new JLabel("Nawazuddin ");
        name.setBounds(110,15,120,18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF" ,Font.BOLD,18));
        panel_1.add(name);
        
        
        
        JLabel status = new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF" ,Font.BOLD,14));
        panel_1.add(status);
        
        
//        JPanel
                a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        f.add(a1);
        
        
//        JTextField
                text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);
        
        
        
//        JButton
                send = new JButton("Send"); 
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        send.addActionListener(this);
        f.add(send);
        
        
        
        
        f.setSize(450 , 700);
        f.setLocation(200,50);
        f.getContentPane().setBackground(Color.WHITE);                                                     //getContentPane() se poora frame hume miljata h 
        f.setUndecorated(true);
        f.setVisible(true);                                                                              // isko humesh sabse neache likhte h
    }
    
    public void actionPerformed(ActionEvent ae){
        
       try{ 
        
        String out = text.getText();
        
        
//        converting string into JPanel 
        JPanel p2 = formatLabel(out);
       
        
        
        a1.setLayout(new BorderLayout());                                                              //borderLayout elements ko place karta h top bottom left right or center
   
        JPanel right = new JPanel(new BorderLayout());
//         right.add(out , BorderLayout.LINE_END);         yhaan par error ara kyunki out humara string h or ye string leta ni h to JPanel me convert karna padega
    
        right.add(p2 , BorderLayout.LINE_END);                       //matlab jahan line end horae vhaan message display karo
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        
        a1.add(vertical , BorderLayout.PAGE_START);
        
        
        dout.writeUTF(out);
        
        text.setText("");
        
       f.repaint();
       f.invalidate();
       f.validate();
       }catch(Exception e){
           System.out.println(e);
       }
    }

    public static JPanel formatLabel(String out){
        
        JPanel panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel , BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel(out);
        output.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        output.setBackground(new Color(37 ,211 ,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        
        panel.add(output);
        
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    
    
    
    
    public static void main(String args[]) {
       new Server();
       
       
       try{
           
           ServerSocket skt = new ServerSocket(5001);
           
           while(true){
              Socket s = skt.accept();
              
              DataInputStream  din = new DataInputStream(s.getInputStream());                                 //for taking input
              dout = new DataOutputStream(s.getOutputStream());                               //for sending output
              
              while(true){
                  String msg = din.readUTF();
                  JPanel panel = formatLabel(msg);
                  
                  JPanel left = new JPanel(new BorderLayout());
                  left.add(panel , BorderLayout.LINE_START);
                  vertical.add(left);
                  f.validate();  
              }
           }
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
}
