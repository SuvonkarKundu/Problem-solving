#include<iostream>
using namespace std;
class employee{
char name[80];
float age;
public:
void getdata(void);
void putdata(void);
};
void employee::getdata(void)
{
cout<<"Enter name:";
cin>>name;
cout<<"Enter age: ";
cin>>age;
}
void employee::putdata(void)
{
cout<<"name: "<<name<<"\n";
cout<<"Age: "<<age<<"\n";
}
const int size=3;
int main()
{
employee manager[size];
for(int i=0;i<size;i++)
{
cout<<"\ndetails of manager"<<i+1<<"\n";
manager[i].getdata();
}
cout<<"\n";
for(int i=0;i<size;i++)
{
cout<<"\nmanazer"<<i+1<<"\n";
manager[i].putdata();
}

return 0;
}









