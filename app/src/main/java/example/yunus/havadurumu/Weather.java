package example.yunus.havadurumu;

import android.widget.ImageView;

/**
 * Created by yunus on 15.08.2017.
 */

public class Weather
{
    public double sicaklik;
    public String tanim;
    public String sehir;
    public String aciklama;
    public String iconURL;

    public String getIcon() {
        return iconURL;
    }

    public void setIcon(String iconURL) {
        this.iconURL = iconURL;
    }

    public double getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(double sicaklik) {
        this.sicaklik = sicaklik;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
