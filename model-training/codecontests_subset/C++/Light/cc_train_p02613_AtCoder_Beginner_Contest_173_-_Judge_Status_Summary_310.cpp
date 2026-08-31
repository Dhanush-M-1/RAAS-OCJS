#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n;
  cin>>n;
  unordered_map<string,int> um;
  while(n--)
  {
    string s;
    cin>>s;
    um[s]++;
  }
  cout<<"AC x "<<um["AC"]<<endl;
  cout<<"WA x "<<um["WA"]<<endl;
  cout<<"TLE x "<<um["TLE"]<<endl;
  cout<<"RE x "<<um["RE"]<<endl;


  return 0;
}