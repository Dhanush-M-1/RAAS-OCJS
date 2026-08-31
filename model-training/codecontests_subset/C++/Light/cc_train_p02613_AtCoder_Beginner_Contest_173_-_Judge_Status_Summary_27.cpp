#include<bits/stdc++.h>
using namespace std;
map<string,int> mapping;
string s;
int n;
int main(){
  cin>>n;
  while(n--){
     cin>>s;
     mapping[s]++;
  }
  cout<<"AC x "<<mapping["AC"]<<'\n';
  cout<<"WA x "<<mapping["WA"]<<'\n';
  cout<<"TLE x "<<mapping["TLE"]<<'\n';
  cout<<"RE x "<<mapping["RE"]<<'\n';
}
