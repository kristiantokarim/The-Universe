#include "Point.h"
using namespace std;

Point::Point(){
    x = 0;
    y = 0;
}
Point::Point(int _x,int _y){
    x = _x;
    y = _y;
}

void Point::SetPoint(int _x,int _y){
    x = _x;
    y = _y;
}
int Point::GetX(){ return x;}
int Point::GetY(){ return y;}
void Point::movePoint(int _x,int _y){
    x = _x + x;
    y = _y + y;
}
