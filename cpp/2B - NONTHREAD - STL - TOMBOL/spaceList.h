#include <stdio.h>
#include <iostream>
#include "Shape.h"
#include <vector>
using namespace std;

#ifndef List_h
#define List_h
class SpaceList {
    public :
        SpaceList();
        //SpaceList(const SpaceList&);
        ~SpaceList();
        SpaceList& deleteList (Shape);
        Shape getShape (int);
        void setObject (Shape);
        int getLength();
        void deleteList(int);
        void getObject (int, Shape&);
        void setList(int,Shape);
        SpaceList& BigBang();
    private :
        vector<Shape>listOfObject;
};
#endif
