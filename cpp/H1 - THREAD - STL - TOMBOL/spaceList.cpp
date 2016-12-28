#include "spaceList.h"

SpaceList::SpaceList()
{
}

SpaceList::~SpaceList()
{
}

void SpaceList::getObject (int n, Shape& spaceObject)
{
    spaceObject = listOfObject[n];
}

void SpaceList::setObject(Shape S)
{
    listOfObject.push_back(S);
}

int SpaceList::getLength()
{
    return listOfObject.size();
}

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

SpaceList& SpaceList::deleteList (Shape checkObject)
{
    bool found = false;
    int i = 0;
    while ((!found) && (i < listOfObject.size()))
    {
        if (checkObject.getID() == listOfObject[i].getID())
        {
            found = true;
            listOfObject.erase(listOfObject.begin()+i);
        }
        else
        {
            i++;
        }
    }
    return *this;
}

SpaceList& SpaceList::BigBang()
{
    listOfObject.clear();
    return *this;
}


void SpaceList :: setList(int i, Shape X)
{
    listOfObject[i] = X;
}
