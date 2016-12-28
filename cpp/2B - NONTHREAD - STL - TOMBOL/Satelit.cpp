/*  Nama: Sashi Novitasari/13514027
    Tanggal: 3/3/2016
    Kelas Makhluk */

#include "Shape.h"
using namespace std;

Satelit::Satelit(int id, int x, int y,int time){
    setArah();
    setKekuatan();
    ID = id;
    starttime = time;
    pos = new Point(x,y);
    setDTime();
    gambar = 'C';
    gravitasi = (int) 0.2*kekuatan;
}

Satelit::~Satelit(){}
