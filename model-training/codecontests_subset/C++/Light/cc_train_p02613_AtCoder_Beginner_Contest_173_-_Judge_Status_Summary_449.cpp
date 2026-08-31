#include<bits/stdc++.h>
using namespace std;
int main(){
  int n;
  string s;
  map<string,int> m;
  cin>>n;
  for(int i=1;i<=n;i++){
    cin>>s;
    m[s]++;
  }
  printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d",m["AC"],m["WA"],m["TLE"],m["RE"]);
  return 0;
}