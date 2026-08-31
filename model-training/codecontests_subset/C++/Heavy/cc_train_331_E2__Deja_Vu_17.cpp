#include <bits/stdc++.h>
using namespace std;
int n, m, l[85][85], dp1[85][85][85 * 4], dp2[85][85][85 * 4];
vector<int> ken[85], yume[85][85];
vector<int> r[85], rw[85], a[85], aw[85], b[85], bw[85];
int main() {
  cin >> n >> m;
  memset(l, -1, sizeof l);
  for (int x, y, t, i = 1; i <= m; ++i) {
    cin >> x >> y, cin >> l[x][y];
    if (l[x][y] == 0) ken[x].push_back(y);
    for (int j = 1; j <= l[x][y]; ++j) cin >> t, yume[x][y].push_back(t);
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j) {
      int pos = -1;
      for (int k = 0; k < l[i][j] - 1; ++k)
        if (yume[i][j][k] == i && yume[i][j][k + 1] == j) pos = k;
      if (pos == -1) continue;
      deque<int> q;
      int len = 0;
      for (int k = pos; k >= 0; --k) q.push_back(yume[i][j][k]), ++len;
      while (q.size() > 1) {
        if (len > 2 * n) {
          pos = -1;
          break;
        }
        if (l[q[1]][q[0]] == -1) {
          pos = -1;
          break;
        }
        for (int k = l[q[1]][q[0]] - 1; k >= 0; --k)
          q.push_back(yume[q[1]][q[0]][k]), ++len;
        q.pop_front();
      }
      if (pos == -1) continue;
      int op = q[0];
      while (!q.empty()) q.pop_back();
      for (int k = pos + 1; k < l[i][j]; ++k) q.push_back(yume[i][j][k]), ++len;
      while (q.size() > 1) {
        if (len > 2 * n) {
          pos = -1;
          break;
        }
        if (l[q[0]][q[1]] == -1) {
          pos = -1;
          break;
        }
        for (int k = 0; k < l[q[0]][q[1]]; ++k)
          q.push_back(yume[q[0]][q[1]][k]), ++len;
        q.pop_front();
      }
      if (pos == -1) continue;
      r[op].push_back(q[0]), rw[op].push_back(len - 1);
    }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (l[i][j] > 0 && yume[i][j].back() == i) {
        int pos = 0;
        deque<int> q;
        int len = 0;
        for (int k = l[i][j] - 1; k >= 0; --k)
          q.push_back(yume[i][j][k]), ++len;
        while (q.size() > 1) {
          if (len > 2 * n) {
            pos = -1;
            break;
          }
          if (l[q[1]][q[0]] == -1) {
            pos = -1;
            break;
          }
          for (int k = l[q[1]][q[0]] - 1; k >= 0; --k)
            q.push_back(yume[q[1]][q[0]][k]), ++len;
          q.pop_front();
        }
        if (pos == -1) continue;
        a[q[0]].push_back(j), aw[q[0]].push_back(len);
      }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (l[i][j] > 0 && yume[i][j][0] == j) {
        int pos = 0;
        deque<int> q;
        int len = 0;
        for (int k = 0; k < l[i][j]; ++k) q.push_back(yume[i][j][k]), ++len;
        while (q.size() > 1) {
          if (len > 2 * n) {
            pos = -1;
            break;
          }
          if (l[q[0]][q[1]] == -1) {
            pos = -1;
            break;
          }
          for (int k = 0; k < l[q[0]][q[1]]; ++k)
            q.push_back(yume[q[0]][q[1]][k]), ++len;
          q.pop_front();
        }
        if (pos == -1) continue;
        b[i].push_back(q[0]), bw[i].push_back(len);
      }
  for (int i = 1; i <= n; ++i) dp2[i][i][0] = 1;
  for (int len = 0; len <= n * 2; ++len) {
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j) {
        for (int k = 0; k < (int)r[j].size(); ++k)
          (dp1[i][r[j][k]][len + rw[j][k]] += dp2[i][j][len]) %= 1000000007;
        for (int k = 0; k < (int)a[j].size(); ++k)
          (dp2[i][a[j][k]][len + aw[j][k]] += dp2[i][j][len]) %= 1000000007;
        for (int k = 0; k < (int)b[j].size(); ++k)
          (dp1[i][b[j][k]][len + bw[j][k]] += dp1[i][j][len]) %= 1000000007;
        for (int k = 0; k < (int)ken[j].size(); ++k)
          (dp2[i][ken[j][k]][len + 1] += dp1[i][j][len]) %= 1000000007;
      }
  }
  for (int len = 1; len <= n * 2; ++len) {
    int ans = 0;
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j) (ans += dp1[i][j][len]) %= 1000000007;
    cout << ans << endl;
  }
  return 0;
}
