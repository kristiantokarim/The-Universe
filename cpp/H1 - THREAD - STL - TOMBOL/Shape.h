/*  Nama: Sashi Novitasari/13514027
    Tanggal: 3/3/2016
    Header Kelas Makhluk */

#ifndef SHAPE_H
#define SHAPE_H
#include <iostream>
#include <cstdlib>
#include "Point.h"


/**
 * Abstrak base class 'Makhluk'
 * Class 'Makhluk' merupakan ABC dari semua makhluk.
 */
class Makhluk{
    protected:
        /**
         * A protected variable
         * variable 'kekuatan' mewakili besar kekuatan yang dimiliki oleh makhluk
         */
        int kekuatan;
        int starttime;
        char arahGerak;
        int ID;
        Point * pos;
        int dTime;
        char gambar;
    public:
        /** @brief Mengembalikan besar kekuatan makhluk
         *  Pure virtual member
         */
        virtual int GetX()=0;
        virtual int GetY()=0;
        virtual int getKekuatan()=0;
        virtual char getArah()=0;
        virtual int getID() =0;
        virtual int getDTime()=0;
        virtual char getGambar()=0;
        virtual int getStartTime()=0;
};

class Shape: public Makhluk{
    public:
        int GetX();
        int GetY();
        virtual int getKekuatan();
        char getArah();
        int getID();
        int getDTime();
        int getStartTime();
        char getGambar();
        void setKekuatan();
        void setArah();
        void setArah(char);
        void setID(int);
        void setDTime();
        void setGambar(char);

        //DEFAULT MOVE
        void movePos(int,int);

        //SETTER READ FILE
        void setKekuatan(int);
        void setDTime(int);
};

class Planet: public Shape{
protected:
        int gravitasi;
    public:
        Planet();
        Planet(int id, int x, int y, int time);
        virtual ~Planet();
        int getKekuatan();
};

class Satelit: public Planet{
    public:
        Satelit(int id, int x, int y, int time);
        ~Satelit();
};

class Bintang: public Shape{
    protected:
        int cahaya;
    public:
        Bintang();
        Bintang(int id, int x, int y, int time);
        virtual ~Bintang();
        int getKekuatan();
};

class Matahari: public Bintang{
    public:
        Matahari(int id, int x, int y, int time);
        ~Matahari();
};

#endif
