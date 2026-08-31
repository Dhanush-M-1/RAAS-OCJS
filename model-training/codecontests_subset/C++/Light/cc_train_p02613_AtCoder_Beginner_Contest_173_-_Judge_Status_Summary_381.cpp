#include <bits/stdc++.h>
using namespace std;
int main(){
  int N; cin>>N;
  map<string, int> m;
  while(N--) {
    string s; cin>>s;
    
    ++m[s];
  }
  cout<<"AC x "<<m["AC"]<<endl;
  cout<<"WA x "<<m["WA"]<<endl;
  cout<<"TLE x "<<m["TLE"]<<endl;
  cout<<"RE x "<<m["RE"]<<endl;
}