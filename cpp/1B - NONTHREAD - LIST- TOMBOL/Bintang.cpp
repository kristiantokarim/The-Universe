/*  Nama: Sashi Novitasari/13514027
    Tanggal: 3/3/2016
    Kelas Makhluk */

#include "Shape.h"

using namespace std;

Bintang::Bintang(){
    arahGerak = 0;
    kekuatan = 0;
    starttime = 0;
    ID = 0;
    pos = new Point;
    dTime = 0;
    gambar = '-';
    cahaya = 0;

}

Bintang::Bintang(int id, int x, int y, int time){
    setArah();
    setKekuatan();
    starttime = time;
    ID = id;
    pos = new Point(x,y);
    setDTime();
    gambar = '*';
    cahaya = (int) 0.3*kekuatan;
}

Bintang::~Bintang(){
    arahGerak = 0;
    starttime = 0;
    kekuatan = 0;
    ID = 0;
    //delete pos;
    dTime = 0;
    gambar = '-';
    cahaya= 0;
}

int Bintang::getKekuatan(){
    return kekuatan + cahaya;
}
