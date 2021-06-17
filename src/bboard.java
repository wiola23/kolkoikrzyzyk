

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class bboard extends JPanel implements MouseListener {
    public void sr(Graphics g){
        for(int ii=0;ii<3;ii++){
            if(tab[0][ii]!=0 && tab[0][ii]==tab[1][ii] && tab[1][ii]==tab[2][ii] ){
                g.setColor(Color.RED);
                g.drawLine(0,ii*100+50,300,ii*100+50);
                tura=0;
            }}
        for(int j=0;j<3;j++){
            if(tab[j][0]!=0 && tab[j][0]==tab[j][1] && tab[j][1]==tab[j][2] ){
                g.setColor(Color.RED);
                g.drawLine(j*100+50,0,j*100+50,300);
                tura=0;
            }}
        if(tab[0][0]!=0 && tab[0][0]==tab[1][1] && tab[1][1]==tab[2][2] ){
            g.setColor(Color.RED);
            g.drawLine(0,0,300,300);
            tura=0;
        }
        if(tab[0][2]!=0 && tab[0][2]==tab[1][1] && tab[1][1]==tab[2][0] ){
            g.setColor(Color.RED);
            g.drawLine(0,300,300,0);
            tura=0;
        }
        if(zaj==0) tura=0;

    }
    ImageIcon[] symbole = new ImageIcon[3];
    int x,xx,yy;
    int y,xxx,yyy,n;
    boolean z;
    int d,c;
    Integer [][] tab = new Integer[3][3];
    Integer [][] tabb = new Integer[3][3];
    int tura,tu;
    int zaj;
    public bboard() {
        symbole[0]  = new ImageIcon("src/pole.png");
        symbole[1] = new ImageIcon("src/kółko.png");
        symbole[2] = new ImageIcon("src/krzyzyk.png");
        addMouseListener(this);
        for(int h=0;h<3;h++)
            for(int k=0;k<3;k++){
                tab[h][k]=0;
                tabb[h][k]=0;
            }
        tura=-1;
        tu=tura;
        zaj=0;
        xx=0;
        yy=0;
        d=0;
        c=0;
        n=0;
        z=true;

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int h=0;h<3;h++){
            System.out.println();
            for(int k=0;k<3;k++){
                System.out.print(tab[k][h]);
            }}
        System.out.println();
        g.setColor(Color.BLACK);
        zaj=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){


                if(tab[j][i]==(-1)){g.drawImage(symbole[2].getImage(),j*100,i*100,100,100,null);
                    continue;}
                if(tab[j][i]==1){g.drawImage(symbole[1].getImage(),j*100,i*100,100,100,null);
                }
                else {
                    g.drawImage(symbole[0].getImage(),j*100,i*100,100,100,null);
                    zaj++;
                }

            }
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){


                g.drawRect(j*100,i*100,100,100);
            }
        sr(g);















        if(tura==-1 && z){
            if(zaj!=9){
                System.out.println("zaczeto");

                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++){
                        if(tab[i][j]==0) {
                            tab[i][j] = 3;

                            for (int ii = 0; ii < 3; ii++) {

                                if ((tab[0][ii] == 1 || tab[0][ii] == 3) && (tab[1][ii] == 1 || tab[1][ii] == 3) && (tab[2][ii] == 1 || tab[2][ii] == 3)) {
                                    c++;
                                }
                            }
                            for (int jj = 0; jj < 3; jj++) {
                                if ((tab[jj][0] == 1 || tab[jj][0] == 3) && (tab[jj][1] == 1 || tab[jj][1] == 3) && (tab[jj][2] == 1 || tab[jj][2] == 3)) {
                                    c++;
                                }
                            }
                            if ((tab[0][0] == 1 || tab[0][0] == 3) && (tab[1][1] == 1 || tab[1][1] == 3) && (tab[2][2] == 1 || tab[2][2] == 3)) {
                                c++;
                            }
                            if ((tab[0][2] == 1 || tab[0][2] == 3) && (tab[1][1] == 1 || tab[1][1] == 3) && (tab[2][0] == 1 || tab[2][0] == 3)) {
                                c++;
                            }

                            for (int ii = 0; ii < 3; ii++) {

                                if ((tab[0][ii] == -1 || tab[0][ii] == 3) && (tab[1][ii] == -1 || tab[1][ii] == 3) && (tab[2][ii] == -1 || tab[2][ii] == 3)) {
                                    //  d++;
                                    d+=2;
                                }
                            }
                            for (int jj = 0; jj < 3; jj++) {
                                if ((tab[jj][0] == -1 || tab[jj][0] == 3) && (tab[jj][1] == -1 || tab[jj][1] == 3) && (tab[jj][2] == -1 || tab[jj][2] == 3)) {
                                    //d++;
                                    d+=2;
                                }
                            }
                            if ((tab[0][0] == -1 || tab[0][0] == 3) && (tab[1][1] == -1 || tab[1][1] == 3) && (tab[2][2] == -1 || tab[2][2] == 3)) {
                                // d++;
                                d+=2;
                            }
                            if ((tab[0][2] == -1 || tab[0][2] == 3) && (tab[1][1] == -1 || tab[1][1] == 3) && (tab[2][0] == -1 || tab[2][0] == 3)) {
                                //  d++;
                                d+=2;
                            }
                            tab[i][j]=0;
                        }

                        tabb[i][j]+=c;
                        tabb[i][j]+=d;
                        d=0;
                        c=0;
                    }
                for(int u=0;u<3;u++)
                    for(int t=0;t<3;t++){
                        if(tabb[u][t]>n){
                            n=tabb[u][t];
                            xxx=u;
                            yyy=t;}
                        tabb[u][t]=0;
                    }
                System.out.println("moze");
                if (tab[xxx][yyy] == 0 && n>0){
                    tab[xxx][yyy]=tura;
                    System.out.println();
                    System.out.println("działa ale nie");
                    System.out.println();
                    z=false;
                    n=0;
                }
                else  {
                    while(z){
                        xx = (int) (Math.random() * 3);
                        yy = (int) (Math.random() * 3);
                        if (tab[xx][yy] == 0) {
                            tab[xx][yy] = tura;
                            z=false;
                        }}
                }



            }
            else {
                xx = (int) (Math.random() * 3);
                yy = (int) (Math.random() * 3);
                if (tab[xx][yy] == 0) {
                    tab[xx][yy] = tura;
                }
                z=false;
            }
            tura*=(-1);
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(tura==1){
            y=Math.round(e.getY()/100);
            x=Math.round(e.getX()/100);

            if(tab[x][y]==0) {
                tab[x][y]=tura;
                tura*=(-1);
                z=true;
                repaint();}
        }

        if(tura==0){
            if(e.getX()>0 && e.getX()<300)
                if(e.getY()>0 && e.getY()<300){
                    for(int h=0;h<3;h++)
                        for(int k=0;k<3;k++){
                            tab[h][k]=0;
                        }
                    tura=-1;
                    z=true;
                    repaint();
                }}


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
