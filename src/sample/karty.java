package sample;

import javafx.scene.image.Image;

public class karty {

    String nazwa;
    Image xd;
    int wybor;

    public void setWybor(int wybor) {
        this.wybor = wybor;
    }

    public int getWybor() {
        return wybor;
    }

    public void setXd(Image xd) {
        this.xd = xd;
    }

    public Image getXd() {
        return xd;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}
