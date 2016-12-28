/*  Nama: Sashi Novitasari/13514027
    Tanggal: 3/3/2016
    Kelas Makhluk */

#include "Shape.h"

using namespace std;

Matahari::Matahari(int id, int x, int y, int time){
    setArah();
    setKekuatan();
    ID = id;
    pos = new Point(x,y);
    setDTime();
    gambar = '@';
    starttime = time;
    cahaya = (int) 0.8*kekuatan;
}

Matahari::~Matahari(){}
