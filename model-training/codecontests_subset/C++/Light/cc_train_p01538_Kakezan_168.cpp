#include <bits/stdc++.h>
using namespace std;

int main() {
  cin.tie(nullptr);
  ios::sync_with_stdio(false);
  int q;
  cin >> q;
  while (q--) {
    int n;
    cin >> n;
    int res = 0;
    while (n >= 10) {
      auto s = to_string(n);
      int m = s.size(), mx = -1;
      for (int i = 1; i < m; ++i) {
        mx = max(mx, stoi(s.substr(0, i)) * stoi(s.substr(i)));
      }
      n = mx;
      ++res;
    }
    cout << res << '\n';
  }
}

