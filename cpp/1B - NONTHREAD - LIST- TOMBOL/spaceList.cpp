#include "spaceList.h"

//Constructor SpaceList
//Inisialisai len=0 dan array dengan panjang defaultObject
SpaceList::SpaceList()
{
    len = 0;
    listOfObject = new Shape[defaultObject];
}

//Destructor
SpaceList::~SpaceList()
{
}

//Mendaptakan objek pada indeks ke-n
void SpaceList::getObject (int n, Shape& spaceObject)
{
    spaceObject = listOfObject[n];
}

//Menambahkan objek baru pada list
void SpaceList::setObject(Shape S)
{
    listOfObject[len] = S;
    len++;
}

//Mengembalikan panjang list
int SpaceList::getLength()
{
    return len;
}

//Mengembalikan objek dengan id tertentu
Shape SpaceList::getShape (int id)
{
    bool found = false;
    int i =0;

    while ((!found) && (i<=len))
    {
        if (listOfObject[i].getID() == id)
        {
            found = true;
        }
        else
        {
            i++;
        }

    }
    return listOfObject[i];
}

//Menghapus objek pada list
SpaceList& SpaceList::deleteList (Shape checkObject)
{
    bool found = false;
    int i =0, j;
    Shape tes;
    while ((!found) && (i<len))
    {
        getObject(i,tes);
        //Jika ID objek sama maka keluar loop
        if (checkObject.getID() == tes.getID())
            found = true;
        else
              i++;
    }

    if (found)
    {
        //Hapus objek dengan mundur 1 indeks
        for (j=i; j<len-1;j++)
        {
            listOfObject[j] = listOfObject[j+1];
        }
        len--;
    }

    return *this;
}

//Memusnahkan semua objek
SpaceList& SpaceList::BigBang()
{
    len = 0;
    delete listOfObject;
    listOfObject = new Shape[defaultObject];
    return *this;
}

//Mengubah objek pada indeks ke-i
void SpaceList :: setList(int i, Shape X)
{
    listOfObject[i] = X;
}
