#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int n;
int k;
long long d[N][10];
long long d1[4][2];
vector<int> g[N][4];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> k;
    for (int j = 1; j <= k; j++) {
      int x, y;
      cin >> x >> y;
      g[i][x].push_back(y);
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= 3; j++) {
      int sz = (j == 1 ? 3 : 1);
      sort(g[i][j].rbegin(), g[i][j].rend());
      while ((int)g[i][j].size() > sz) g[i][j].pop_back();
    }
  }
  for (int i = 0; i <= n; i++)
    for (int j = 0; j < 10; j++) d[i][j] = -LONG_MAX;
  d[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    vector<pair<int, int>> a;
    for (int j = 1; j <= 3; j++)
      for (auto x : g[i][j]) a.push_back({j, x});
    for (int t = 0; t < 4; t++) d1[t][0] = d1[t][1] = -LONG_MAX;
    d1[0][0] = 0;
    sort(a.begin(), a.end());
    do {
      int cur = 0;
      int cnt = 3;
      int mx = 0;
      long long sum = 0;
      for (auto x : a) {
        cur++;
        if (cnt < x.first) break;
        cnt -= x.first;
        sum += x.second;
        mx = max(mx, x.second);
        d1[cur][0] = max(d1[cur][0], sum);
        d1[cur][1] = max(d1[cur][1], sum + mx);
      }
    } while (next_permutation(a.begin(), a.end()));
    for (int j = 0; j < 10; j++) {
      for (int k = 0; k <= 3; k++) {
        int nxt = (j + k) % 10;
        int f = ((j + k) >= 10);
        d[i][nxt] = max(d[i][nxt], d[i - 1][j] + d1[k][f]);
      }
    }
  }
  long long res = 0;
  for (int i = 0; i < 10; i++) res = max(res, d[n][i]);
  cout << res << "\n";
}
