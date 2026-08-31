#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int tt;
  cin >> tt;
  while (tt--) {
    int n;
    cin >> n;
    vector<string> grid(n);
    for (auto &it : grid) cin >> it;
    vector<array<int, 2>> pos = {
        {0, 1}, {1, 0}, {n - 1, n - 2}, {n - 2, n - 1}};
    array<char, 4> an1 = {'0', '0', '1', '1'}, an2 = {'1', '1', '0', '0'};
    int cnt = 0;
    for (int i = 0; i < 4; ++i)
      if (an1[i] != grid[pos[i][0]][pos[i][1]]) {
        ++cnt;
      }
    if (cnt <= 2) {
      cout << cnt << '\n';
      for (int i = 0; i < 4; ++i)
        if (an1[i] != grid[pos[i][0]][pos[i][1]]) {
          cout << pos[i][0] + 1 << ' ' << pos[i][1] + 1 << '\n';
        }
      continue;
    }
    cnt = 0;
    for (int i = 0; i < 4; ++i)
      if (an2[i] != grid[pos[i][0]][pos[i][1]]) {
        ++cnt;
      }
    if (cnt <= 2) {
      cout << cnt << '\n';
      for (int i = 0; i < 4; ++i)
        if (an2[i] != grid[pos[i][0]][pos[i][1]]) {
          cout << pos[i][0] + 1 << ' ' << pos[i][1] + 1 << '\n';
        }
      continue;
    }
  }
  return 0;
}
