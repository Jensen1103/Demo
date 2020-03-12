import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ntkom on 2017/6/13 0013.
 */
public class go {
    public static final String uname="ntkomata";//设置登录用户名
    public static final String pswd="pswd";//设置登录密码
    go(){
        JFrame frame=new JFrame("Login");//创建一个窗口,它的标题是Login
        JPanel jp=new JPanel();//创建一个分组,这个分组用来放文本框和文本提示
        frame.add(jp);//把这个分组放到frame窗口中
        frame.setLayout(new FlowLayout());//设置frame的布局为流式布局
        JButton jb=new JButton("登录");//创建一个"登录"按钮
        JButton jb2=new JButton("退出");//创建一个"退出"按钮,
        JLabel jl=new JLabel("用户名");//创建一个"用户名"标签 用于提示用户在此行输入用户名
        JLabel j2=new JLabel("密码");//创建一个"密码"标签 用于提示用户在此行输入密码
        JLabel j3=new JLabel("登录状态");//创建一个"登录状态"标签 用于提示用户登录是否成功
        JTextField username=new JTextField(15);//创建一个可输入15个字符的文本框,用于输入用户名
        JTextField password=new JTextField(15);//创建一个可输入15个字符的文本框,用于输入密码
        jb.addMouseListener(new MouseAdapter() {//在"登录"按钮上增加一个监听器,用以监听鼠标与该按钮交互的事件,由于实现监听器很复杂,所以用监听器的一个抽象类"适配器"来实现,
                                                //实现监听器时我们必须实现它所有的方法,而实现适配器我们只需要实现我们需要实现的方法即可
                                                //这里我们实现mouseReleased方法,监听鼠标松开事件,当鼠标松开"登录"按钮(jb)时执行该方法
            @Override
            public void mouseReleased(MouseEvent e) {
                if(username.getText().equals(uname)&&password.getText().equals(pswd)){//用getText方法从username和password文本框中取得它们的文本,
                    // 与我们在一开始设置的用户名和密码来比较,如果都相等则将j3也就是"登录状态"标签的文本改为"登陆成功!"
                    j3.setText("登陆成功!");
                }
                else{
                    j3.setText("登录失败!");//否则,将"登录状态"标签的文本改为"登录失败!"
                }
            }
        });

        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });//同样,在退出按钮上实现另一个适配器,同样监听鼠标松开事件,当松开鼠标时,执行mouseReleased方法,用System.exit(0);来关闭整个程序
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });//我们在窗口上实现一个WindowAdapter适配器,当发生windowClosing即当我们点击关闭程序时,程序将执行这个方法,同样用System.exit(0);来关闭整个程序
        jp.add(jl);
        jp.add(username);
        jp.add(j2);
        jp.add(password);
        jp.add(j3);//将j1,username,j2,password,j3加入到jp分组中,由于jp分组在之前已经被加入到frame窗口中,所以这些被加入的对象
        JPanel jp2=new JPanel();//为了使界面美观,我们又创建了一个分组
        frame.add(jp2);//把新创建的分组加入到frame中
        jp2.add(jb);//
        jp2.add(jb2);//将jb和jb2即”登录”和”退出”两个按钮加入到jp2分组中
        frame.setSize(600,200);//设置frame窗口的宽为600,高为200
        frame.setVisible(true);//设置frame窗口为可见的,此句的意义是显示frame窗口
    }

    public static void main(String[] args){
        new go();//直接创建一个go类型的对象,它的构造方法就是运行一个窗口程序
    }
}

