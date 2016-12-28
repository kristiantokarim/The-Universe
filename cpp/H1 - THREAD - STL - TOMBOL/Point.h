#ifndef POINT_H
#define POINT_H

class Point{
    public:
        Point();
        Point(int _x,int _y);
        void SetPoint(int,int);
        virtual int GetX();
        virtual int GetY();
        void movePoint(int,int);
    private:
        int x;
        int y;
};

#endif
