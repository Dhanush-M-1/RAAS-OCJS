#include <bits/stdc++.h>
using namespace std;
map<string,int>m;
string gs()
{
  string t;
  cin>>t;
  return t;
}
int main(){
  int n;
  cin>>n;
  while(n--)
    m[gs()]++;
  cout<<"AC x "<<m["AC"]<<endl;
  cout<<"WA x "<<m["WA"]<<endl;
  cout<<"TLE x "<<m["TLE"]<<endl;
  cout<<"RE x "<<m["RE"]<<endl;
  return 0;
}