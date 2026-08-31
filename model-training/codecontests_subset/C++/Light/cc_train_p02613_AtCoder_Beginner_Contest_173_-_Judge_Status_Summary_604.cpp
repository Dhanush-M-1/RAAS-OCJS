#include<bits/stdc++.h>
using namespace std;
int main(){
  int n;
  cin>>n;
  map<string,int>m;
  for(int i=0;i<n;i++)
  {
    string s;
    cin>>s;
    m[s]+=1;
  }
  cout<<"AC"<<" x "<<m["AC"]<<"\n";
  cout<<"WA"<<" x "<<m["WA"]<<"\n";
  cout<<"TLE"<<" x "<<m["TLE"]<<"\n";
  cout<<"RE"<<" x "<<m["RE"];
  return 0;
}