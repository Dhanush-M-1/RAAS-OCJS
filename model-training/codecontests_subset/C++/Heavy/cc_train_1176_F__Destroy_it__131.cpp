#include <bits/stdc++.h>
using namespace std;
mt19937 rng(time(0));
uniform_int_distribution<int> uid(-1e9, 1e9);
long long d1[10], d2[10];
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  long long res = 0;
  cin >> n;
  fill(d1 + 1, d1 + 10, -1e18);
  fill(d2 + 1, d2 + 10, -1e18);
  while (n--) {
    int k, x, y;
    map<int, vector<int>> mp;
    vector<vector<vector<long long>>> p(
        4, vector<vector<long long>>(4, {(long long)-1e18, (long long)-1e18}));
    cin >> k;
    p[0][0] = {0, 0};
    while (k--) cin >> x >> y, mp[x].push_back(y);
    for (auto& i : mp)
      sort((i.second).begin(), (i.second).end()),
          reverse((i.second).begin(), (i.second).end());
    for (auto& i : mp)
      while (i.second.size() > 4 - i.first) i.second.pop_back();
    for (auto& j : mp)
      for (auto& k : j.second)
        for (int i = 3; i >= j.first; --i)
          for (int ii = 3; ii >= 1; --ii) {
            if (p[i - j.first][ii - 1][0] >= 0)
              p[i][ii][0] = max(p[i - j.first][ii - 1][0] + k, p[i][ii][0]);
            if (p[i - j.first][ii - 1][1] >= 0)
              p[i][ii][1] = max({p[i - j.first][ii - 1][1] + k, p[i][ii][1],
                                 p[i - j.first][ii - 1][0] + 2 * k});
          }
    for (int i = 0; i < 10; ++i) {
      for (int j = 0; j < 4; ++j) {
        for (int k = 0; k < 4; ++k) {
          d2[(i + k) % 10] =
              max({d2[(i + k) % 10], d1[(i + k) % 10],
                   d1[i] + (i + k >= 10 ? p[j][k][1] : p[j][k][0])});
          res = max(res, d2[(i + k) % 10]);
        }
      }
    }
    swap(d1, d2);
  }
  cout << res;
}
