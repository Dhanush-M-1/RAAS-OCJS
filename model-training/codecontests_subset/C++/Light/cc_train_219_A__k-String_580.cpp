#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int k, flg = 1;
  cin >> k;
  string s;
  cin >> s;
  int n = s.size();
  map<char, int> m;
  set<char> a;
  for (int i = 0; i < n; ++i) {
    ++m[s[i]];
    a.insert(s[i]);
  }
  for (auto &x : a)
    if (m[x] % k != 0) {
      flg = 0;
      break;
    }
  if (flg == 1)
    for (int i = 0; i < k; ++i)
      for (auto &x : a) {
        int l = m[x] / k;
        while (l--) cout << x;
      }
  else
    cout << -1;
}
