#include <bits/stdc++.h>
using namespace std;
namespace zzc {
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - 48;
    ch = getchar();
  }
  return x * f;
}
const int maxn = 55;
const int mod = 1e9 + 7;
int n, m;
int e[maxn][maxn], f[2][maxn][maxn << 1];
vector<int> str[maxn][maxn], trans[2][2][maxn][maxn];
bool extend(deque<int> &q, deque<int>::iterator it, int kind) {
  bool flag = true;
  if (!kind) {
    for (auto pre = prev(it); it != q.begin() && (int)q.size() <= 2 * n;
         it = pre, pre = prev(it)) {
      flag &= e[*pre][*it];
      q.insert(q.begin(), str[*pre][*it].begin(), str[*pre][*it].end());
    }
  } else {
    for (auto nxt = next(it); nxt != q.end() && (int)q.size() <= 2 * n;
         it = nxt, nxt = next(it)) {
      flag &= e[*it][*nxt];
      q.insert(q.end(), str[*it][*nxt].begin(), str[*it][*nxt].end());
    }
  }
  return flag & ((int)q.size() <= 2 * n);
}
void init() {
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (str[i][j].size() && str[i][j].back() == i) {
        deque<int> q(str[i][j].begin(), str[i][j].end());
        if (extend(q, prev(q.end()), false))
          trans[0][0][q.front()][j].push_back((int)q.size());
      }
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      auto p = find(str[i][j].begin(), str[i][j].end(), i);
      if (p == str[i][j].end() || (++p) == str[i][j].end() || (*p) != j)
        continue;
      deque<int> q(str[i][j].begin(), str[i][j].end());
      deque<int>::iterator it = q.begin() + (p - str[i][j].begin()) - 1;
      if (extend(q, it, false) && extend(q, it + 1, true))
        trans[0][1][q.front()][q.back()].push_back((int)q.size() - 1);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (e[i][j] && str[i][j].empty()) trans[1][0][i][j].push_back(1);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (str[i][j].size() && str[i][j].front() == j) {
        deque<int> q(str[i][j].begin(), str[i][j].end());
        if (extend(q, q.begin(), true))
          trans[1][1][i][q.back()].push_back((int)q.size());
      }
    }
}
void work() {
  int a, b, c;
  n = read();
  m = read();
  for (int i = 1; i <= n; i++) f[0][i][0] = 1;
  for (int i = 1; i <= m; i++) {
    a = read();
    b = read();
    e[a][b] = 1;
    c = read();
    while (c--) str[a][b].push_back(read());
  }
  init();
  for (int l = 0; l < 2 * n; l++)
    for (int i = 0; i <= 1; i++)
      for (int j = 1; j <= n; j++) {
        if (f[i][j][l]) {
          for (int x = 0; x <= 1; x++)
            for (int y = 1; y <= n; y++)
              for (auto v : trans[i][x][j][y])
                if (v + l <= 2 * n)
                  f[x][y][v + l] = (f[x][y][v + l] + f[i][j][l]) % mod;
        }
      }
  for (int l = 1; l <= 2 * n; l++) {
    int sum = 0;
    for (int i = 1; i <= n; i++) sum = (sum + f[1][i][l]) % mod;
    printf("%d\n", sum);
  }
}
}  // namespace zzc
int main() {
  zzc::work();
  return 0;
}
