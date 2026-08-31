#include <bits/stdc++.h>
using namespace std;

int main(){
  int n; cin >> n;
  map<string,int> mp;
  
  for(int i=0; i<n; ++i){
    string s; cin >> s;
    mp[s]++;
  }
  
  printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",mp["AC"],mp["WA"],mp["TLE"],mp["RE"]);
  return 0;
  
}