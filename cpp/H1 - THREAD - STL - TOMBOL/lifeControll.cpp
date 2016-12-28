#include "lifeControll.h"
#include "windows.h"
#include "board.h"
#include "spaceList.h"
void LifeControl::checkCell(Board& boardId, SpaceList& L, int nObject, const int cell, int* listNumber)
//
{
    int i,j;
    SpaceList temp;
    bool cek;
    Shape temp1, temp2;

    //Mengecek apakah ada makhluk di sel
    if (nObject != 0)
    {
        //Menegecek apa makhluk melebihi kpasitas sel
        if (nObject>=cell)
        {
            //Masukkan Shape ke dalam array berdasrkan id shape
            for (i=0;i<nObject;i++)
            {
                temp.setObject(L.getShape(listNumber[i]));
            }
            //Musnahkan makhluk jika makhluk melebihi kapasitas sel
            while (nObject>=cell)
            {
                i = 0;
                cek = true;
                while ((i<temp.getLength()) && cek)
                {
                    j = i+1;
                    while ((j<temp.getLength()) && cek)
                    {
                        temp.getObject(i,temp1);
                        temp.getObject(j,temp2);
                        if (temp1.getKekuatan() < temp2.getKekuatan())
                        {
                            boardId.setBoardID(temp1.GetX(),temp1.GetY(),0);
                            L = L.deleteList(temp1);
                            temp = temp.deleteList(temp1);
                            nObject--;

                            //update boardID
                            cek = false;
                        }
                        else if (temp1.getKekuatan() > temp2.getKekuatan())
                        {
                            boardId.setBoardID(temp2.GetX(),temp2.GetY(),0);
                            L = L.deleteList(temp2);
                            temp = temp.deleteList(temp2);
                            nObject--;

                            //update boardID
                            cek = false;
                        }
                        j++;
                    }
                    i++;
                }
            }
        }
    }
}
/*
void LifeControl::lifeSelection (Board &boardId, SpaceList& L, const int cell)
{
        int currentRow, currentColumn;
        int positionRow, positionColumn;
        int *listNumber;
        listNumber = new int[cell*cell];//yg mau dihspus
		int i,j,k;


        for (currentRow = 1; currentRow<boardId.getWidth();currentRow+=cell)
        {
            for (currentColumn = 1;currentColumn<boardId.getLength();currentColumn+=cell)
            {
                k = 0;
                positionRow = currentRow/cell * cell;
                positionColumn = currentColumn / cell * cell;
                for (i=0;i<cell;i++)
                {
                    for (j=0;j<cell;j++)
                    {
                        if (boardId.getBoardID((positionRow+i),(positionColumn+j)) != 0)
                        {
                            listNumber[k] = boardId.getBoardID((positionRow+i),(positionColumn+j));
                            k++;
                        }
                    }
                }

                checkCell(boardId, L, k, cell, listNumber);
            }
        }
}*/
void LifeControl::lifeSelection (Board &boardId, SpaceList& L, const int cell)
{
    for (int i = 0 ; i < boardId.getWidth()-cell ; i++)
    {
        for (int j = 0 ; j < boardId.getLength()-cell ; j++)
        {
            SpaceList Lx;
            for (int x = i ; x< i+cell ; x++)
            {
                for (int y = j ; y< j+cell ; y++)
                {
                    if (boardId.getBoardID(x,y) != 0)
                    {
                        Lx.setObject(L.getShape(boardId.getBoardID(x,y)));
                    }
                }
            }
            while(Lx.getLength()>=cell)
            {
                Shape lamest;
                Lx.getObject(0,lamest);
                for (int u = 1; u < Lx.getLength() ; u++)
                {
                    Shape tempx;
                    Lx.getObject(u,tempx);
                    if (lamest.getKekuatan() > tempx.getKekuatan())
                    {
                        lamest = tempx;
                    }
                }
                boardId.setBoardID(lamest.GetX(),lamest.GetY(),0);
                Lx.deleteList(lamest);
                L.deleteList(lamest);
            }
        }
    }
}
void LifeControl::moveObj(Shape& makhluk, Board boardID){
    bool movValid = false;
    Shape temp;
    int dX =0, dY=0, tX=0, tY=0;
    while (movValid==false){
        switch (makhluk.getArah()){
            case 'U': dX=0; dY=1; break;
            case 'T': dX=1; dY=0; break;
            case 'S': dX=0; dY=-1; break;
            case 'B': dX=-1; dY=0; break;
            case 'A': dX=1; dY=1; break;
            case 'C': dX=1; dY=-1; break;
            case 'D': dX=-1; dY=-1; break;
            case 'E': dX=-1; dY=1; break;
        }
        tX = makhluk.GetX()+dX;
        tY = makhluk.GetY()+dY;
        if ((tX>boardID.getWidth()-1)||(tY>boardID.getLength()-1)||(tX<0)||(tY<0))
            movValid = false;//
        else
            movValid = true;

        if (movValid==false){
            switch (makhluk.getArah()){
                case 'U': makhluk.setArah('T'); break;
                case 'T': makhluk.setArah('S'); break;
                case 'S': makhluk.setArah('B'); break;
                case 'B': makhluk.setArah('A'); break;
                case 'A': makhluk.setArah('C'); break;
                case 'C': makhluk.setArah('D'); break;
                case 'D': makhluk.setArah('E'); break;
                case 'E': makhluk.setArah('U'); break;
            }
        }
    }
    makhluk.movePos(dX,dY);
}
