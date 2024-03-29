package com.fxwt.view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginView {
    public void creatJf() throws IOException {
//      	创建顶层窗口
        JFrame frame = new JFrame("管理系统登入界面");
//        frame.setFont(new Font("华文楷体", 0, 13));
//        设置窗体宽高
        frame.setSize(350, 200);
        //设置窗口居中显示
        frame.setLocationRelativeTo(null); 
        //设置关闭窗口结束程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        设置窗体禁止调节大小
        frame.setResizable(true);
        //改变窗口默认图标
        Image image = ImageIO.read(new File("src/static/image/login.jpg"));
        frame.setIconImage(image);
  
//      卡片式布局的面板
    	JPanel cards=new JPanel(new CardLayout());
//    	登入面板
    	JPanel login=new JPanel();
//    	注册面板
    	JPanel register=new JPanel();
        
//        创建JLabel(用户名)
        JLabel user_label = new JLabel("用户名:");
//        user_label.setFont(new Font("华文楷体", 0, 13));
        //定义组件的位置和宽高
        user_label.setBounds(10, 20, 80, 25);
        //把组件添加到JPanel上
        jPanel.add(user_label);

        //创建文不域用于用户输入
        JTextField user_text = new JTextField(20);
        //设置文本域的位置和宽高
        user_text.setBounds(100, 20, 165, 25);
        //把文本域组件添加上
        jPanel.add(user_text);

        //创建JLabel(密码)
        JLabel password_label = new JLabel("密码:");
//        password_label.setFont(new Font("华文楷体", 0, 13));
        //设置位置和大小
        password_label.setBounds(10, 50, 80, 25);
        //添加组件
        jPanel.add(password_label);

        //密码文本域输入
        JPasswordField password_text = new JPasswordField();  //密码输入框，输入密码自动隐藏
        //JTextField password_text = new JTextField(20);
        password_text.setBounds(100, 50, 165, 25);

        jPanel.add(password_text);


        //登录按钮
        JButton login = new JButton("登录");
        login.setBounds(80, 100, 80, 25);


        //注册按钮
        JButton register = new JButton("注册");
        register.setBounds(200, 100, 80, 25);

        jPanel.add(register);

        jPanel.add(login);


        //添加面板
        frame.add(jPanel);
        //设置可见
        frame.setVisible(true);
        LoginListener ll = new LoginListener(frame, user_text, password_text);
        login.addActionListener(ll);

        ReListener re = new ReListener();
        register.addActionListener(re);

    }

    public class ReListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	RegisterView.reShow();
        }
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
                JOptionPane.showMessageDialog(null, "登录名或密码错误", "失败", 0);
            }

        }
    }
}