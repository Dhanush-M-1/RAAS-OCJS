#include<iostream>
#include <map>
using namespace std;
int main()
{
int n;
cin>>n;
map<string,int>freq;
for(int i=0; i<n; ++i)
{
string s;
cin>>s;
++freq[s];
}
cout<<"AC x"<<" "<<freq["AC"]<<"\n";
cout<<"WA x"<<" "<<freq["WA"]<<"\n";
cout<<"TLE x"<<" "<<freq["TLE"]<<"\n";
cout<<"RE x"<<" "<<freq["RE"];
}
