#include "Shape.h"
#include "spaceList.h"
#include "board.h"

using namespace std;

#ifndef lifeControl_h
#define lifeControl_h
class LifeControl {
    public :
        void checkCell (Board&, SpaceList &, int, const int cell, int*);
        void lifeSelection (Board &, SpaceList &, const int cell);
        void moveObj(Shape& makhluk, Board boardID);
    private :

        int len;
        static const int defaultObject = 10;
};
#endif
