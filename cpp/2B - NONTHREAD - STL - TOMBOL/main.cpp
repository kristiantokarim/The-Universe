
#include <iostream>
#include "universe.h"
#include "windows.h"
using namespace std;

int main()
{
    bool space = false;
    int choose = 1;
    do
    {
        system("CLS");
        cout<<endl<<endl;
        cout<<"              .---..          .   ."<<endl;
        cout<<"                |  |          |   |       o"<<endl;
        cout<<"                |  |--. .-.   |   |.--.   ..    ._.-. .--..--. .-."<<endl;
        cout<<"                |  |  |(.-'   :   ;|  |   | \\  / (.-' |   `--.(.-'"<<endl;
        cout<<"                '  '  `-`--'   `-' '  `--' `-`'   `--''   `--' `--'"<<endl;
        cout<<endl<<endl;
        if (choose == 1)
        {
            cout<<"                                   > START"<<endl;
            cout<<"                                     HELP"<<endl;
        }
        else
        {
            cout<<"                                     START"<<endl;
            cout<<"                                   > HELP"<<endl;
        }

        Sleep(200);
        if (GetAsyncKeyState( VK_UP ) && (choose != 1))
        {
            choose--;
        }
        else if (GetAsyncKeyState( VK_DOWN ) && (choose != 2))
        {
            choose++;
        }
        else if (GetAsyncKeyState( VK_SPACE ))
        {
            space = true;
        }
        if (space && (choose == 2))
        {
            system("CLS");
            cout<<"                        ,--.  ,--.,------.,--.   ,------."<<endl;
            cout<<"                        |  '--'  ||  .---'|  |   |  .--. '"<<endl;
            cout<<"                        |  .--.  ||  `--, |  |   |  '--' |"<<endl;
            cout<<"                        |  |  |  ||  `---.|  '--.|  | --'"<<endl;
            cout<<"                        `--'  `--'`------'`-----'`--'"<<endl;
            cout<<"                                       PRESS :"<<endl;
            cout<<"                    HOME BUTTON     - SCREENSHOT"<<endl;
            cout<<"                    SPACE BUTTON    - PAUSE"<<endl;
            cout<<"                    DOWN BUTTON     - EXIT"<<endl;
            cout<<"                    UP BUTTON       - CREATE NEW OBJECT"<<endl;
            cout<<"                    DELETE BUTTON   - BIGBANG"<<endl;
            cout<<"                        RIGHT BUTTON    - SEE THE UNIVERSE STEP-BY-STEP"<<endl;
            cout<<"                        SPACE BUTTON    - PLAY"<<endl;

            cout<<endl<<endl<<endl<<"                      PRESS SPACE BUTTON TO BACK TO MAIN MENU "<<endl;
            bool backx = false;
            while(!backx)
            {
                Sleep(100);
                if (GetAsyncKeyState( VK_SPACE ))
                {
                    space = false;
                    backx = true;
                }
            }
        }
    }
    while(!space);
    for (int i = 0 ; i < 3 ; i++)
    {
        system("CLS");
        cout<<endl<<endl<<endl<<endl<<endl<<"                               UNIVERSE START";
        cout<<".";
        Sleep(200);
        cout<<".";
        Sleep(200);
        cout<<".";
        Sleep(200);
    }
    for (int i = 0 ; i < 3 ; i++)
    {
        system("CLS");
        cout<<endl<<endl<<endl<<endl<<endl<<"                             INITIALIZE UNIVERSE";
        cout<<".";
        Sleep(200);
        cout<<".";
        Sleep(200);
        cout<<".";
        Sleep(200);
    }
    system("CLS");
    cout<<endl<<endl<<endl<<endl<<endl<<"                          WELCOME TO THE UNIVERSE"<<endl;
    Sleep(1000);
    system("CLS");
    universe U;
}
