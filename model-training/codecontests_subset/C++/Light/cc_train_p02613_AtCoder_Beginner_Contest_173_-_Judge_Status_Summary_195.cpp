#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  int n;
  cin >> n;
  map<string, int> cnt;
  for(int i = 0; i < n; ++i) {
    string s;
    cin >> s;
    cnt[s] += 1;
  }
  for(auto s : {"AC", "WA", "TLE", "RE"}) {
    cout << s << " x " << cnt[s] << '\n';
  }
}