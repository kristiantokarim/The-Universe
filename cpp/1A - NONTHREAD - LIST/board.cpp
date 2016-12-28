#include "board.h"
#include "windows.h"
#include "fstream"
#include "string"
#include <ctime>

//Constructor Board
Board::Board()
{
    // MENGHASILKAN BOARD DENGAN DEFAULT WITH DAN LENGTH
    width = Board::defaultWidth;
    length = Board::defaultLength;
    matrixBoard = new int*[width];
    for (int i=0;i<width;i++)
    {
        matrixBoard[i] = new int[length];
    }

    for (int i=0;i<width;i++)
    {
        for (int j=0;j<length;j++)
        {
            matrixBoard[i][j] = 0; // INISIALISASI MATRIKS DENGAN ID = 0
        }
    }
}

//Copy Contructor Board
Board::Board(const Board& B)
{
    length = B.length;
    width = B.width;
    matrixBoard = new int*[width];
    for (int i=0;i<width;i++)
    {
        matrixBoard[i] = new int [length];
    }

    for (int i=0;i<width;i++)
    {
        for (int j=0;j<length;j++)
        {
            matrixBoard[i][j] = 0;
        }
    }
}

//Destructor Board
Board::~Board()
{
    for (int i=0;i<width;i++)
    {
        delete [] matrixBoard[i];
    }
    delete [] matrixBoard;
    width = 0;
    length = 0;
}

//Mengembalikan ukuran panjang semesta (Board)
int Board::getLength()
{
    return length;
}

//Mengembalikan ukuran lebar semesta(Board)
int Board::getWidth()
{
    return width;
}

//Mengembalikan id Makhluk pada kolom dan baris tertentu dari Board
int Board::getBoardID(int i, int j)
{
    return matrixBoard[i][j];
}

//Menciptakan semesta
//Memasukkan id makhluk dari listOfMakhluk
//Melakukan kondisi terhadap makhluk yang bertabrakkan
void Board::makeSpace(SpaceList &ListofSpace)
{
    Shape object;

    //Memasukkan id Makhluk dari listOfSpace ke Board(Semesta)
    for (int i=0;i<ListofSpace.getLength();i++)
    {
        ListofSpace.getObject(i,object);
        if (matrixBoard[object.GetX()][object.GetY()] == 0)
            matrixBoard[object.GetX()][object.GetY()] = object.getID();
        else //collision
        {
            int idVictim = matrixBoard[object.GetX()][object.GetY()];
            Shape victim;
            victim = ListofSpace.getShape(idVictim);
            //Inisiasi matriks dengan val_undef (999)
            matrixBoard[victim.GetX()][victim.GetY()] = 999;
            //Menghapus objek dari list ketika objek bertabrakkan
            ListofSpace.deleteList(victim);
            ListofSpace.deleteList(object);
        }
    }
}

//Memasukkan nilai x pada matriks[i][j]
void Board :: setBoardID(int i, int j, int x)
{
    matrixBoard[i][j] = x;
}

//Mecetak semesta ke layar
void Board::printBoard(SpaceList ListofSpace)
{
    ios::sync_with_stdio(false);
    Shape temp;
    string s;
    for (int i = 0 ; i <=length+1 ; i++)
    {
        s = s + "-";
    }
    cout<<s<<endl;
    for (int i=0;i<width;i++)
    {
        cout<<'|';
        for (int j=0;j<length;j++)
        {
            if (matrixBoard[i][j] == 0)
            {
                cout<<' ';
            }
            //Kondisi tabrakkan
            else if (matrixBoard[i][j] == 999)
            {

                cout<<"!";
            }
            else
            {
                temp = ListofSpace.getShape(matrixBoard[i][j]);
                cout<<temp.getGambar();
            }
            matrixBoard[i][j] = 0;
        }

        cout<<'|'<<endl;
    }
    cout<<s<<endl;
}


void Board::printBoardEks(SpaceList ListofSpace)
{
    time_t t = time(0);
    struct tm * now = localtime( & t );

    char buffer [100];
    strftime (buffer,100,"Capture-%d-%m-%Y-%I-%M-%S.txt",now);
    ofstream file;
    file.open(buffer);
    if(file.is_open())
     {
         std::cout<<"Success Screen Capture "<<buffer<<std::endl;
        Sleep(1000);

      }
    Shape temp;
    for (int i = 0 ; i <= length+1 ; i++)
    {
        file<<"-";
    }

    file<<endl;
    for (int i=0;i<width;i++)
    {
        file<<"|";
        for (int j=0;j<length;j++)
        {
            if (matrixBoard[i][j] == 0)
            {
                file<<" ";
            }
            else if (matrixBoard[i][j] == 999)
            {

                file<<"!";
            }
            else
            {
                temp = ListofSpace.getShape(matrixBoard[i][j]);
                file<<temp.getGambar();
            }
            matrixBoard[i][j] = 0;
        }
        file<<"|"<<endl;
    }
    for (int i = 0 ; i <= length+1 ; i++)
    {
        file<<"-";
    }
    file.close();
}
