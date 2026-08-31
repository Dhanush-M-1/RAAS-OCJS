#include<iostream>
using namespace std;
int main(){
int a,b;
cin>>a>>b;
a*=b;
if(a%2==0)
cout<<"Even";
else
cout<<"Odd";
return 0;
}