#include <stdio.h>
#include <iostream>
#include <unistd.h>
#include "Shape.h"
#include "spaceList.h"

using namespace std;

/** @brief Header kelas Board

    Detailed
    @author MALVIN J
 */

#ifndef Board_h
#define Board_h
class Board {
    public :
        ///Constructor Board
        Board();
        ///Copy Constructor Board
        Board(const Board&);
        ///Destructor Board
        ~Board();
        int getLength();
        int getWidth();
        int getBoardID(int,int);
        /** Method untuk menciptakan semesta
          * Objek dari semesta dimasukkan ke dalam matriks
        */
        void makeSpace (SpaceList&);
        /** Method untuk mencetak semesta ke layar
          * Membuat Semesta menjadi kosong lagi
        */
        void setBoardID(int, int , int);
        void printBoard (SpaceList ListOfSpace);
        void printBoardEks(SpaceList ListofSpace);
    private :
        int** matrixBoard; ///< matriks semesta
        static const int defaultLength = 77; ///< panjangAwalSemesta
        static const int defaultWidth = 21 ; ///< LebarAwalSemesta
        int width; ///< LebarSemesta
        int length; ///<PanjangSemesta

};
#endif // Board_h
