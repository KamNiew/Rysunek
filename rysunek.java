import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;

public class rysunek implements ActionListener {
    private final Timer timer;
    public  render render;
    final JFrame jframe = new JFrame();
    private int wspkometyx=0;
    private int wspkometyy=0;
    private int wspsloncay=0;
    private int widocznosc=0;
    private int wspchmuryx=0;
    private int wspchmuryy=0;
    public static rysunek rysunek;
    private Color nightgreen = Color.decode("#004953");
    private Color sky = Color.BLACK;
    private Color dach =Color.decode("#A52A2A");
    private Color budynek =Color.decode("#422B6A");
    private Color drzwi =Color.decode("#64362C");
    private Color oknanoc;
    private Color oknadzien =Color.decode("#9FBBB3");
    private Color sierz =Color.decode("#773B0F");
    public rysunek() {
        timer = new Timer(60, this);
        render = new render();
        jframe.setContentPane(render);
        jframe.setTitle("Z nocy w dzień");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1000,700);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setFocusable(true);
        timer.start();

    }

    public class render extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            rysuj(g);

        }
    }
    public void rysuj(Graphics g) {

        slonce(g,wspsloncay);

        horyzont(g);
        if(widocznosc==0){
        ksiezyc(g);
        gwiazdozbiur(g);

        kometa(g,wspkometyx,wspkometyy);}
        trawy(g);
        domek(g);
        scierzka(g);
        chmura(g,wspchmuryx,wspchmuryy);
        chmura(g,wspchmuryx-200,wspchmuryy+30);
        chmura(g,wspchmuryx-400,wspchmuryy-30);
        chmura(g,wspchmuryx-600,wspchmuryy-30);
        chmura(g,wspchmuryx-800,wspchmuryy-30);
    }

    private void horyzont(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GeneralPath closedCurve = new GeneralPath();
        g2d.setColor(nightgreen);
        QuadCurve2D horyzont = new QuadCurve2D.Float(0, 300, 320, 300, 1000, 400);
        g2d.draw(horyzont);
        closedCurve.moveTo(0, 700);
        closedCurve.lineTo(0, 700);
        closedCurve.append(horyzont, true);
        closedCurve.lineTo(1000, 700);
        closedCurve.closePath();

        g2d.fill(closedCurve);


    }
    private void scierzka(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        int[] x = {50, 100, 300,250};
        int[] y = {450,  450, 700,700};
        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                x.length);


        path.moveTo(x[0], y[0]);
        for (int i = 1; i < x.length; i++) {

            path.lineTo(x[i], y[i]);
        }
      path.curveTo(50, 500,70, 500,50, 450);
        path.closePath();
        g2d.setColor(Color.BLACK);
        g2d.draw(path);
        g2d.setColor(sierz.darker());
        g2d.fill(path);


    }
   private void trawa(Graphics g,int x,int y){

       g.setColor(nightgreen.darker().darker());

       g.drawLine (x, y, x+10, y-10);
       g.drawLine (x, y, x, y-10);
       g.drawLine (x, y, x-10, y-10);


   }
   private void trawy(Graphics g){

       int a[] = {100,117,835,155,170,190,211,345,456,499,532,670,760,790,800,850,900,990,456,499,532,670,760,
               790,820,870,930,890,317,735,195,970,190,511,345,756,899,532 };
       int b[] = {400,430,530,500,430,400,700,500,600,400,600,650,620,640,700,490,400,430,430,530,500,430,400,
               700,500,600,400,600,430,530,500,430,400,700,500,600,400,600};
       for ( int j = 1; j < a.length; j++ )
           trawa(g,a[j], b[j] );



    }
    public void gwiazda(Graphics g,int x,int y){
        int a[] = { x+50,x+55,x+50,x+45};
        int b[] = { y+50,y+55,y+60,y+55};
        Graphics2D g2d = ( Graphics2D )g;
        GeneralPath starFigure = new GeneralPath();
        starFigure.moveTo( a[ 0 ], b[ 0 ] );
        for ( int j = 1; j < a.length; j++ )
            starFigure.lineTo( a[ j ], b[ j ] );
        starFigure.closePath();
        g2d.setColor(Color.orange.darker().darker());
       g2d.fill( starFigure );





    }
    public void gwiazdozbiur(Graphics g){
        int x[] = {10,10,60,110,110,110,110,230,230,330,460,460,560,660,690,690,690,710,710,460,460,560,660,690,690,690,810,810 };
        int y[] = {10,25,33,55,67,78,105,10,25,33,55,67,78,105,45,79,44,89,110,33,55,67,178,105,210,125,40,110 };
        for ( int j = 1; j < x.length; j++ )
        gwiazda(g,x[ j ], y[ j ] );





    }
    public  void kometa(Graphics g,int x,int y){
        g.setColor(Color.WHITE);
        g.fillOval(10+x, 10+y, 20, 20);

        g.drawLine(15+x,11+y,-20+x,11+y);
        g.drawLine(15+x,15+y,-20+x,15+y);
        g.drawLine(15+x,19+y,-20+x,19+y);
        g.drawLine(15+x,23+y,-20+x,23+y);
        g.drawLine(15+x,27+y,-20+x,27+y);

    }
    public  void ksiezyc(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(800 ,30, 50, 50);
        g.setColor(sky);
        g.fillOval(810 ,30, 50, 50);

    }
    public  void slonce(Graphics g,int y){
        g.setColor(Color.ORANGE);
        g.fillOval(700 ,450-y, 70, 70);
    }
    public  void chmura(Graphics g,int x ,int y){
        g.setColor(Color.lightGray);
        g.fillOval(-200+x ,70+y, 150, 70);
        g.fillOval(-190+x,80+y, 70, 70);
        g.fillOval(-190+x,60+y, 70, 70);
        g.fillOval(-130+x,82+y, 90, 70);
        g.fillOval(-130+x,54+y, 90, 70);
        g.fillOval(-150+x,84+y, 90, 70);
        g.fillOval(-150+x,58+y, 90, 70);
        g.fillOval(-90+x,80+y, 70, 70);
        g.fillOval(-90+x,60+y, 70, 70);
    }

    public  void  domek(Graphics g){
        int x[] = { 10,100,120,120,130, 130,210,220,30 };
        int y[] = {200,150,150,130,130, 150,150,200,200};
        g.setColor(budynek);
        g.fillRect(10,200,210,250);
        g.setColor(dach);
        g.fillPolygon(x,y,x.length);

        g.fillPolygon(x,y,x.length);
        g.setColor(Color.BLACK);
        g.drawPolygon(x,y,x.length);
        g.drawRect(10,200,210,250);
        g.drawLine(40,200,40,450);
        g.drawLine(100,150,40,200);
        g.drawRect(50,220,60,60);
        g.drawRect(140,220,60,60);
        g.drawRect(50,370,50,80);
        g.setColor(oknanoc);
        g.fillRect(50,220,60,60);
        g.fillRect(140,220,60,60);
        g.setColor(drzwi);
        g.fillRect(50,370,50,80);
    }
    public void kolory(){
        if(wspsloncay==100){
            sky=Color.blue.darker().darker().darker().darker();
            nightgreen = Color.decode("#004953").brighter();
        }
        if(wspsloncay==150){
            sky=Color.blue.darker().darker().darker();
            nightgreen = Color.decode("#004953").brighter().brighter();
           dach= dach.brighter();
          budynek=  budynek.brighter();
          sierz=sierz.brighter();
        }
        if(wspsloncay==200){
            sky=Color.blue.darker().darker();
            nightgreen = Color.decode("#004953").brighter().brighter().brighter();
            sierz=sierz.brighter().brighter();

            widocznosc=1;}
        if(wspsloncay==250){
            sky=Color.blue.darker();
        nightgreen=Color.green.brighter().brighter().brighter();}
        if(wspsloncay==300){
            sky=Color.blue;
            nightgreen=Color.green.brighter().brighter();}
        if(wspsloncay==320){
            sky=Color.blue.brighter();
            nightgreen=Color.green.brighter();}
        if(wspsloncay==340){
            sky=Color.blue.brighter().brighter();           }
        if(wspsloncay==350){
            sky=Color.CYAN.darker();
        }
        if(wspsloncay==400){
            sky=Color.CYAN;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)  {
        render.setBackground(sky);

        wspkometyx+=10;
        wspkometyy+=1;
        render.repaint();
        if (wspkometyx<1100){


        if(wspkometyy%3==0)
            oknanoc=Color.decode("#DAD32F");
        else
            oknanoc =Color.decode("#DAD32F").darker().darker();}
        else oknanoc=oknadzien;

       if(wspkometyx>1100&&wspsloncay!=400){
         wspsloncay+=10;
         wspchmuryx+=25;
          kolory();
       }


    }

        public static void main(String[] args) {

        rysunek=new rysunek();
    }
}
