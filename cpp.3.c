 namespace std;
cl#include<iostream.h>
usingass myclass{
int a;
public:
myclass();
void show();
};
myclass::myclass()
{
cout<<"In constructor\n";
a=10;
}
void myclass::show()
{
cout<<a;
}
int main()
{
myclass ob;
ob.show();
return 0;
}




