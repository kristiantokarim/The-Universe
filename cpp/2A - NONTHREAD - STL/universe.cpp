#include "universe.h"
#include "spaceList.h"
#include "Point.h"
#include "board.h"
#include "lifeControll.h"
#include "Shape.h"
#include "windows.h"
#include "cstdlib"
#include "conio.h"
#include <cmath>
#include <time.h>
#include <vector>
#include <thread>
/* PROSEDUR UNTUK MEMINDAHKAN OBJEK DAN MENGUPDATE LIST */
void moveobject(SpaceList &L,Board& X, int index)
{
    LifeControl Tuhan;
    Shape S;
    L.getObject(index,S); // GETTER OBJEK DARI LIST
    Tuhan.moveObj(S,X); // PINDAHKAN OBJEK SESUAI ARAH
    L.setList(index,S); // UPDATE LIST
}

/*PROSEDUR UNTUK MENCETAK ISI LIST OBJEK KE LAYAR*/
void cetak(SpaceList &L, Board X)
{
    LifeControl Tuhan;
    X.makeSpace(L);  // MEMPOSISIKAN LIST OBJEK KE POSISI PADA MATRIKS
    Tuhan.lifeSelection(X,L,2); // LIFE SELECTION JIKA DUA OBJEK DALAM 1 SEL
    system("CLS"); // CLEAR SCREEN
    X.printBoard(L); // CETAK ISI MATRIKS
}
universe:: universe()
{
    SpaceList L;
    int timex = 0; // TIME COUNTER
    Board X;
    int id = 0;
    Shape *newobj;
    while(1)
    {
        Sleep(100);
        if( GetAsyncKeyState( VK_UP )) // KONDISI JIKA TOMBOL UP DITEKAN
        {
            srand((unsigned)time(NULL)); // RANDOMIZE
            id++; //PENAMBAHAN ID OBJEK
            int object = rand() % 4; // RANDOMIZE CREATE OBJEK
            if (object == 0)
            {
                newobj = new Bintang(id,rand()%X.getWidth(),rand()%X.getLength(),timex); // OBJEK BINTANG DI HASILKAN
            }
            else if (object == 1)
            {
                newobj = new Matahari(id,rand()%X.getWidth(),rand()%X.getLength(),timex); // OBJEK MATAHARI DI HASILKAN
            }
            else if (object == 2)
            {
                newobj = new Planet(id,rand()%X.getWidth(),rand()%X.getLength(),timex); // OBJEK PLANET DI HASILKAN
            }
            else
            {
                newobj = new Satelit(id,rand()%X.getWidth(),rand()%X.getLength(),timex); // OBJEK SATELIT DI HASILKAN
            }
            L.setObject(*newobj); // MEMASUKAN OBJEK YANG DI HASILKAN KE DALAM LIST OF OBJECT
        }
        if (timex == 5) // COUNTER WAKTU SAMPAI DARI 0 SAMPAI 5
        {
            timex =0;
        }
        timex++; // PENAMBAHAN COUNTER WAKTU
        if(L.getLength() != 0) // JIKA LIST TIDAK KOSONG
        {
            // PERULANGAN UNTUK MEMINDAHKAN OBJEK SESUAI DELTA TIME MASING MASING
            for (int i = 0 ; i <=L.getLength()-1; i++)
            {
                Shape tempx;
                L.getObject(i,tempx); // AMBIL OBJEK DARI LIST
                int x = timex - tempx.getStartTime(); // HITUNG PERBEDAAN WAKTU SEKARANG
                if (x < 0) // JIKA PERBEDAAN DENGAN WAKTU SEKARANG < 0
                {
                    x = x + 5;
                }
                if (x == tempx.getDTime()) // PERIKSA APAKAH PERBEDAAN WAKTU SUDAH SAMA
                {
                    moveobject(L,X,i); // JIKA SUDAH SAMA PINDAHKAN OBJEK
                }
            }
        }
        system("CLS"); // CLEAR SCREEN
        X.makeSpace(L); // POSISIKAN OBJEK - OBJEK DALAM MATRIKS
        X.printBoard(L); // CETAK KE LAYAR
        Sleep(100); // DELAY
        cetak(L,X); // JIKA ADA PERSAINGAN HIDUP MAKA DICETAK ULANG
        Sleep(100);
    }
}
