//
// Created by 林靖博 on 4/8/22.
//

#include <iostream>
using namespace std;  // scope binding

class A
        {
                public:
                void display()
                {
                    cout << "a" << endl;
                }
        };

class B : public A
{
public:
void display()
{
    cout << "b" << endl;
}
};


int main()
{
    B b;
    b.display();
    b.A::display(); // scope ::
    b.B::display();

    return 0;
}
