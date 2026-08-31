#include <bits/stdc++.h>
using namespace std;
char sl = '\n';
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  pair<int, int> r, c, d;
  cin >> r.first >> r.second;
  cin >> c.first >> c.second;
  cin >> d.first >> d.second;
  for (int i = 1; i <= 9; ++i) {
    for (int j = 1; j <= 9; ++j) {
      for (int k = 1; k <= 9; ++k) {
        for (int t = 1; t <= 9; ++t) {
          if (i == j || i == k || i == t || j == k || j == t || k == t)
            continue;
          if (i + j == r.first && k + t == r.second && i + k == c.first &&
              j + t == c.second && i + t == d.first && j + k == d.second) {
            cout << i << " " << j << sl;
            cout << k << " " << t << sl;
            return 0;
          }
        }
      }
    }
  }
  cout << -1 << sl;
  return 0;
}
