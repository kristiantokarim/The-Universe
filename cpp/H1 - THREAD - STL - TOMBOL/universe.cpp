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
void print(SpaceList &L, Board X)
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
    int timex = 0; // COUNTER WAKTU
    Board X;
    int id = 0;
    Shape *newobj;
    vector <thread> threadList;
    bool pause = false;
    while(1)
    {
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
        else if (GetAsyncKeyState( VK_SPACE )) // JIKA TOMBOL SPACE DITEKAN MAKA PROGRAM AKAN DIPAUSE
        {
            pause = true;
        }
        else if (GetAsyncKeyState(VK_DELETE)) // TEKAN TOMBOL DELETE UNTUK MEMUSNAHKAN SEMUA OBJEK
        {
            L.BigBang();
        }
        else if (GetAsyncKeyState(VK_DOWN)) // TEKAN TOMBOL DOWN UNTUK KELUAR DARI PROGRAM
        {
            exit(10);
        }
        if (timex == 5) // COUNTER WAKTU SAMPAI DARI 0 SAMPAI 5
        {
            timex =0;
        }
        threadList.clear();
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
                    threadList.push_back(thread(moveobject,ref(L),ref(X),i)); // JIKA SUDAH SAMA PINDAHKAN OBJEK PER THREAD
                }
            }
        }
        for (auto& t : threadList) t.join(); //MELAKUKAN AKSI JOIN PADA THREAD YANG TELAH DI HASILKAN
        system("CLS"); // CLEAR SCREEN
        X.makeSpace(L); // POSISIKAN OBJEK - OBJEK DALAM MATRIKS
        X.printBoard(L); // CETAK KE LAYAR
        Sleep(500);
        if (GetAsyncKeyState(VK_HOME)) // JIKA TOMBOL HOME DITEKAN MAKA AKAN DISIMPAN SCREENSHOT KONDISI THE UNIVERSE
        {
            X.makeSpace(L);
            X.printBoardEks(L); // CETAK KE FILE EKSTERNAL
        }
        print(L,X); // CETAK LAGI JIKA ADA LIFE SELECTION
        Sleep(100);
        while(pause) // KONDISI JIKA SEDANG PAUSE
        {
            if (GetAsyncKeyState( VK_SPACE )) // JIKA TOMBOL SPACE DITEKAN LAGI MAKA PROGRAM AKAN PLAY SEPERTI SEMULA
            {
                pause = false;
            }
            else if (GetAsyncKeyState( VK_RIGHT )) // TEKAN TOMBOL RIGHT UNTUK MELIHAT PERGERAKAN OBJEK SECARA STEP BY STEP
            {
                break;
            }
            Sleep(100);
        }
    }
}
