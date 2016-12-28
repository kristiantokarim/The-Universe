/*  Nama: Sashi Novitasari/13514027
    Tanggal: 3/3/2016
    Kelas Makhluk */

#include "Shape.h"
#include <cmath>
#include <time.h>

using namespace std;


int Shape::GetX(){
//Getter nilai posisi absis (x) makhluk
    return this->pos->GetX();
}

int Shape::GetY(){
//Getter nilai posisi ordinat (y) makhluk
    return this->pos->GetY();
}
int Shape::getKekuatan(){
//Getter nilai kekuatan makhluk
    return kekuatan;
}

char Shape::getArah(){
//Getter arah gerak (sesuai mata angin) makhluk
    return arahGerak;
}

int Shape::getID(){
//Getter nilai ID makhluk
    return ID;
}

int Shape::getDTime(){
//Getter nilai delta waktu makhluk
    return dTime;
}

char Shape::getGambar(){
//Getter gambar makhluk
    return gambar;
}

int Shape::getStartTime(){
//Getter gambar makhluk
    return starttime;
}

void Shape::setKekuatan(){
//Setter nilai kekuatan makhluk. Penentuan besar kekuatan dirandom (10~100)
//I.S:-
//F.S: Besar kekuatan makhluk terdefinisikan (random)
    kekuatan = rand() % 91 + 10;
}
void Shape::setArah(){
//Setter arah gerak makhluk. Penentuan arah dirandom (sesuai arah mata angin)
//I.S:-
//F.S: Arah gerak makhluk terdefinisikan (random)
    int arah = rand() % 8+1;
    switch (arah){
        case 1 : arahGerak = 'U'; break;//Utara, delta (0,1)
        case 2 : arahGerak = 'T'; break;//Timur, delta (1,0)
        case 3 : arahGerak = 'S'; break;//Selatan, delta (0,-1)
        case 4 : arahGerak = 'B'; break;//Barat, delta (-1,0)
        case 5 : arahGerak = 'A'; break;//Timur Laut, delta (1,1)
        case 6 : arahGerak = 'C'; break;//Tenggara, delta (1,-1)
        case 7 : arahGerak = 'D'; break;//Barat Daya, delta (-1,-1)
        case 8 : arahGerak = 'E'; break;//Barat Laut, delta (-1,1)
    }
}

void Shape::setArah(char a){
    arahGerak = a;
}

void Shape::setID(int v){
//Setter nilai ID makhluk.
//I.S: Nilai pengisi ID, v, terdefinisikan
//F.S: ID makhluk terdefinisikan
    ID = v;
}
void Shape::setDTime(){
//Setter nilai delta waktu makhluk. Penentuan nilai dirandom (1~6)
//I.S:-
//F.S: Besar delta waktu makhluk terdefinisikan (random)
    srand((unsigned)time(NULL));
    dTime = rand() % 4+1;
}
void Shape::setGambar(char d){
//Setter gambar makhluk.
//I.S: Char pengisi gambar, d, terdefinisikan.
//F.S: Gambar makhluk terdefinisikan
    gambar = d;
}

void Shape::movePos(int _x,int _y){
//Menggerakkan makhluk sebanyak _x,_y (tidak bergantung mata angin. (PURE)
//I.S: Nilai penggerak terdefinisikan.
//F.S: Koordinat posisi makhluk berubah menjadi (x+ _x), (y+ _y)
    this->pos->movePoint( _x, _y);
}

void Shape::setKekuatan(int pow){kekuatan = pow;}
//Setter nilai kekuatan (tidak dirandom, untuk dari pembacaan file).
//I.S: Nilai pengisi kekuatan pow terdefinisikan.
//F.S: Besar kekuatan makhluk terdefinisikan menjadi sebesar pow.

void Shape::setDTime(int time){ dTime = time;}
//Setter nilai delta waktu (tidak dirandom, untuk dari pembacaan file).
//I.S: Nilai pengisi kekuatan time terdefinisikan.
//F.S: Besar delta waktu makhluk terdefinisikan menjadi sebesar time.
