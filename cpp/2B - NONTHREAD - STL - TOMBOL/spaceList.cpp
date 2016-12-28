#include "spaceList.h"

//Consturctor SpaceList
//Karena memakai STL maka constructor tidak ada
SpaceList::SpaceList()
{
}

//Copy Consturctor SpaceList
//Karena memakai STL maka constructor tidak ada
SpaceList::~SpaceList()
{
}

//Mendapatkan objek dari list dengan memasukkan indeks dari objek tersebut
void SpaceList::getObject (int n, Shape& spaceObject)
{
    spaceObject = listOfObject[n];
}

//Memasukkan objek baru ke dalam list
void SpaceList::setObject(Shape S)
{
    listOfObject.push_back(S);
}

//Mengembalilan panjang list
int SpaceList::getLength()
{
    return listOfObject.size();
}

//Mengembalikan objek dengan memasukkan id objek
Shape SpaceList::getShape (int id)
{
    bool found = false;
    int i =0;

    while ((!found) && (i< listOfObject.size()))
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

//Menghapus objek dari list
SpaceList& SpaceList::deleteList (Shape checkObject)
{
    bool found = false;
    int i = 0;
    while ((!found) && (i < listOfObject.size()))
    {
        //Mencari objek di list
        if (checkObject.getID() == listOfObject[i].getID())
        {
            found = true;
            //Menghapus objek dari list dengan method yang ada pada std::Vector
            listOfObject.erase(listOfObject.begin()+i);
        }
        else
        {
            i++;
        }
    }
    return *this;
}

//Memusahkan semua objek di list
SpaceList& SpaceList::BigBang()
{
    listOfObject.clear();
    return *this;
}

//Mengubah objek pada indeks ke-1
void SpaceList :: setList(int i, Shape X)
{
    listOfObject[i] = X;
}
