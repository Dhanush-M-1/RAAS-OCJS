#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<(n);++i)
using namespace std;
 
int main() {
  int N;
  cin >> N;
  map<string,int> cnt;
  rep(i,N){
    string s;
    cin >> s;
    cnt[s]++;    
  }
  for(string s : {"AC", "WA", "TLE", "RE"}){
    cout << s << " x " << cnt[s] << endl;
  }
  return 0;
}