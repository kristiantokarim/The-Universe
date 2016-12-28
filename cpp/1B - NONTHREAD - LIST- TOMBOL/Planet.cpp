/*  Nama: Sashi Novitasari/13514027
    Tanggal: 3/3/2016
    Kelas Makhluk */
#include "Shape.h"

using namespace std;

Planet::Planet(){
    arahGerak = 0;
    kekuatan = 0;
    ID = 0;
    starttime = 0;
    pos = new Point;
    dTime = 0;
    gambar = '-';
    gravitasi= 0;
}

Planet::Planet(int id, int x,int y, int time){
    setArah();
    starttime = time;
    setKekuatan();
    ID = id;
    pos = new Point(x,y);
    setDTime();
    gambar = 'A';
    gravitasi = (int)0.5*kekuatan;
}

Planet::~Planet(){
    arahGerak = 0;
    kekuatan = 0;
    ID = 0;
    delete pos;
    dTime = 0;
    gambar = '-';
    gravitasi= 0;
}

int Planet::getKekuatan(){
    return kekuatan + gravitasi;
}
