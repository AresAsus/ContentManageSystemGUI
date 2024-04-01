																																																									package com.fxwt.view;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;
import com.fxwt.controller.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LoginView extends JFrame{
	private UserController userController;
	
    public void creatJf()  throws IOException{
    	
    	FlatLightLaf.setup();
//      	创建顶层窗口
        JFrame frame = new JFrame("管理系统登入界面");
//        设置窗体宽高
        frame.setSize(350, 200);
//    	卡片布局
        JPanel cards=new JPanel(new CardLayout ());
//    	登录窗口
    	JPanel loginWindow=new JPanel();
    	
//    	loginWindow.setSize(getPreferredSize());
//    	注册窗口
    	JPanel registerWindow=new JPanel();
//    	找回密码
    	JPanel retrieveWindow=new JPanel();

//        改变窗口默认图标
        Image image = ImageIO.read(new File("src/static/image/login.jpg"));
        frame.setIconImage(image);
  
//    	用户栏
    	JPanel userPanel=new JPanel();
//    	密码栏
    	JPanel pwdPanel=new JPanel();
//    	按钮栏
    	JPanel butPanel=new JPanel();
    	
//        创建JLabel(用户名)
    	JLabel user_label=new JLabel("用户名:");
//        创建文本域用于用户输入
        JTextField user_text = new JTextField(10);

        //        创建JLabel(密码)
        JLabel password_label = new JLabel("密   码:");
//        密码文本域输入
        JPasswordField password_text = new JPasswordField(10);
        password_text.setEchoChar('*');
//      添加显示密码图标按钮
      JButton showPassWordBtn = new JButton(new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("./static/image/show.gif"))));
//      添加隐藏密码图标按钮
      JButton hidePassWordBtn = new JButton(new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("./static/image/hide.gif"))));
//      将图标按钮添加进密码框里面，需要使用FlatLightLaf主题库
      password_text.putClientProperty("JTextField.trailingComponent", showPassWordBtn);
       
//      给显示密码图标绑定单击事件
      showPassWordBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
          	 password_text.putClientProperty("JTextField.trailingComponent", hidePassWordBtn);//设置隐藏按钮显示，未使用FlatLightLaf则不需要
               password_text.setEchoChar((char) 0);//设置密码显示
           }
      });
      //给隐藏密码图标绑定单击事件
      hidePassWordBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
          	   password_text.putClientProperty("JTextField.trailingComponent", showPassWordBtn);//设置显示按钮显示，未使用FlatLightLaf则不需要
          	   password_text.setEchoChar('*');//设置密码隐藏
             }
      });

//        登录按钮
        JButton loginBut = new JButton("登录");
//        注册按钮
        JButton registerBut = new JButton("注册");
//        忘记密码
        JButton retrieveBut = new JButton("忘记密码");
        
        loginWindow.setLayout(new GridLayout(4,1,0,0));
        loginWindow.setPreferredSize(new Dimension(50, 20));
        
//      组装用户名栏
      userPanel.add(user_label);
      userPanel.add(user_text);
//      组装密码栏
      pwdPanel.add(password_label);
      pwdPanel.add(password_text);
      
//        组装按钮栏
//        butPanel.add(loginBut);
        butPanel.add(registerBut);
        butPanel.add(retrieveBut);
        
//        组装到登录窗口
        loginWindow.add(userPanel);
        loginWindow.add(pwdPanel);
        loginWindow.add(loginBut);
        loginWindow.add(butPanel);
        
//        组装到卡片
        cards.add(loginWindow);
        cards.add(registerWindow);
        cards.add(retrieveWindow);
        
        frame.add(cards);
        
//      设置窗体宽高
        frame.setSize(350, 200);
//    设置窗口居中显示
        frame.setLocationRelativeTo(null); 
//      设置可见
        frame.setVisible(true);
        LoginListener ll = new LoginListener(frame, user_text, password_text);
        loginBut.addActionListener(ll);
    }


    public class LoginListener implements ActionListener {
        private javax.swing.JTextField jt;//账号输入框对象
        private javax.swing.JPasswordField jp;//密码输入框对象
        private javax.swing.JFrame login;//定义一个窗体对象

        public LoginListener(javax.swing.JFrame login, javax.swing.JTextField jt, javax.swing.JPasswordField jp) {
            this.login = login;//获取登录界面
            this.jt = jt;//获取登录界面中的账号输入框对象
            this.jp = jp;//获取登录界面中的密码输入框对象
        }

        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
            //用户名密码判断
            if (jt.getText().equals("user") && jp.getText().equals("root")) {
                //设置弹框
                JOptionPane.showMessageDialog(null, "登陆成功", "成功", 1);
                HomePage.createShow();
                login.setVisible(false);
            } else if (!(jt.getText().equals("1") && jp.getText().equals("1"))) {
                JOptionPane.showMessageDialog(null, "用户名或密码错误", "失败", 0);
            }

        }
    }
}