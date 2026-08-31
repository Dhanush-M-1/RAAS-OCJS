#include <bits/stdc++.h>

using namespace std;

int main(){
  int n;
  string s;
  map<string, int> mp;
  cin >> n;
  for(int i=0;i<n;i++){
    cin >> s;
    mp[s]++;
  }
  for(auto p: {"AC", "WA", "TLE", "RE"}){
    cout << p << " x " << mp[p] << endl;
  }
}

