#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for (int i = 0; i < (int)(n); i++)

int main(){
  int N; cin >> N;
  map<string, int> mp;
  rep(i, N) {
    string S; cin >> S;
    mp[S]++;
  }
  vector<string> L = {"AC", "WA", "TLE", "RE"};
  rep(i, 4)  cout << L[i] << " x " << mp[L[i]] << endl;
}
