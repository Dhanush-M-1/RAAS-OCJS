#include <bits/stdc++.h>
using namespace std;
inline int Read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 3) + (x << 1) + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, m, a[55][55];
vector<int> w[55][55];
int extend(deque<int> &q, deque<int>::iterator it, int opt) {
  int flag = 1;
  if (opt == 1)
    for (deque<int>::iterator nxt = next(it);
         nxt != q.end() && q.size() <= 2 * n; it = nxt, nxt = next(it))
      flag &= a[*it][*nxt],
          q.insert(q.end(), w[*it][*nxt].begin(), w[*it][*nxt].end());
  else
    for (deque<int>::iterator pre = prev(it);
         it != q.begin() && q.size() <= 2 * n; it = pre, pre = prev(it))
      flag &= a[*pre][*it],
          q.insert(q.begin(), w[*pre][*it].begin(), w[*pre][*it].end());
  return flag && (q.size() <= 2 * n);
}
int f[2][55][205];
vector<int> trans[2][2][55][55];
void solve() {
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (w[i][j].size() && w[i][j][w[i][j].size() - 1] == i) {
        deque<int>::iterator it;
        deque<int> q(w[i][j].begin(), w[i][j].end());
        it = prev(q.end());
        if (extend(q, it, -1)) trans[0][0][q.front()][j].push_back(q.size());
      }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      vector<int>::iterator it = find(w[i][j].begin(), w[i][j].end(), i);
      if (it == w[i][j].end() || (++it) == w[i][j].end() || *it != j) continue;
      deque<int> q(w[i][j].begin(), w[i][j].end());
      deque<int>::iterator it2 = q.begin() + (it - w[i][j].begin()) - 1;
      if (extend(q, it2, -1) && extend(q, it2 + 1, 1))
        trans[0][1][q.front()][q.back()].push_back(q.size() - 1);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (a[i][j] && !w[i][j].size()) trans[1][0][i][j].push_back(1);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (w[i][j].size() && w[i][j][0] == j) {
        deque<int> q(w[i][j].begin(), w[i][j].end());
        if (extend(q, q.begin(), 1))
          trans[1][1][i][q.back()].push_back(q.size());
      }
}
int Add(int x) { return (x >= 1000000007) ? x - 1000000007 : x; }
signed main() {
  n = Read(), m = Read();
  for (int i = 1; i <= m; i++) {
    int x = Read(), y = Read(), k = Read();
    a[x][y] = 1;
    w[x][y].resize(k);
    for (int j = 0; j < k; j++) w[x][y][j] = Read();
  }
  solve();
  for (int i = 1; i <= n; i++) f[0][i][0] = 1;
  for (int i = 0; i < 2 * n; i++)
    for (int j = 0; j < 2; j++)
      for (int k = 1; k <= n; k++)
        if (f[j][k][i])
          for (int p = 0; p < 2; p++)
            for (int q = 1; q <= n; q++)
              for (int l = 0; l < trans[j][p][k][q].size(); l++)
                f[p][q][i + trans[j][p][k][q][l]] =
                    Add(f[p][q][i + trans[j][p][k][q][l]] + f[j][k][i]);
  for (int i = 1; i <= n * 2; i++) {
    int sum = 0;
    for (int j = 1; j <= n; j++) sum = Add(sum + f[1][j][i]);
    cout << sum << endl;
  }
  return 0;
}
