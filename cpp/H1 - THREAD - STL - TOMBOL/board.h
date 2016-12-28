/* Author: Malvin Juanda*/
#include <stdio.h>
#include <iostream>
#include <unistd.h>
#include "Shape.h"
#include "spaceList.h"

using namespace std;
#ifndef Board_h
#define Board_h
class Board {
    public :
        //Constructor Board
        Board();
        //Copy Constructor Board
        Board(const Board&);
        //Destructor Board
        ~Board();
        //Getter panjang board
        int getLength();
        //Getter lebar board
        int getWidth();
        //Getter ID makhluk pada posisi i,j pada board
        int getBoardID(int,int);
        /* Method untuk menciptakan semesta
           Objek dari semesta dimasukkan ke dalam matriks*/
        void makeSpace (SpaceList&);
        /* Method untuk mencetak semesta ke layar
           Membuat Semesta menjadi kosong lagi*/
        void setBoardID(int, int , int);
        //Mencetak board ke layar
        void printBoard (SpaceList ListOfSpace);
        //Mencetak board ke file txt
        void printBoardEks(SpaceList ListofSpace);
    private :
        int** matrixBoard; // matriks semesta
        static const int defaultLength = 77; // panjangAwalSemesta
        static const int defaultWidth = 21 ; // LebarAwalSemesta
        int width; // LebarSemesta
        int length; //PanjangSemesta

};
#endif // Board_h
