#include <bits/stdc++.h>
const int N = 51, Mod = 1e9 + 7;
inline void Add(int &x, int dat) {
  if ((x += dat) >= Mod) x -= Mod;
}
inline int read() {
  int x = 0;
  char ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return x;
}
int edg[N][N], a[N][N][N * 2], ac[N][N][N * 2], acb[N][N][N * 2],
    dacb[N][N][N * 2], ans[N][N * 2];
std::vector<int> E[N][N], A[N][N], B[N][N], C[N][N];
int main() {
  int n = read(), m = read();
  for (int i = 1; i <= m; ++i) {
    int u = read(), v = read(), k = read();
    edg[u][v] = true, E[u][v].resize(k);
    for (int i = 0; i < k; ++i) E[u][v][i] = read();
  }
  std::vector<int> Res;
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      for (int k = 0; k + 1 < E[i][j].size(); ++k)
        if (E[i][j][k] == i && E[i][j][k + 1] == j) {
          std::vector<int> cur = E[i][j], tmp;
          while (true) {
            if (cur.size() > n * 2 + 1) break;
            int flg = false;
            tmp.clear();
            for (int i = 0; i + 1 < cur.size(); ++i) {
              int u = cur[i], v = cur[i + 1];
              if (!edg[u][v]) {
                flg = true;
                break;
              }
              for (int w = 0; w < E[u][v].size(); ++w)
                tmp.push_back(E[u][v][w]);
            }
            if (flg) break;
            if (tmp == cur) {
              if (Res.empty()) Res = tmp;
              C[cur[0]][cur.back()].push_back(cur.size() - 1);
              break;
            }
            std::swap(tmp, cur);
          }
          break;
        }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (E[i][j].size() && E[i][j].back() == i) {
        std::vector<int> cur, tmp;
        cur.push_back(i);
        while (true) {
          if (cur.size() > 2 * n + 1) break;
          int flg = false;
          tmp = E[cur[0]][j];
          std::reverse(tmp.begin(), tmp.end());
          for (int i = 0; i + 1 < cur.size(); ++i) {
            int u = cur[i + 1], v = cur[i];
            if (!edg[u][v]) {
              flg = true;
              break;
            }
            for (int w = E[u][v].size() - 1; w >= 0; --w)
              tmp.push_back(E[u][v][w]);
          }
          if (flg) break;
          if (tmp == cur) {
            A[cur.back()][j].push_back(cur.size());
            break;
          }
          std::swap(tmp, cur);
        }
      }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (E[i][j].size() && E[i][j][0] == j) {
        std::vector<int> cur, tmp;
        cur.push_back(j);
        while (true) {
          if (cur.size() > 2 * n + 1) break;
          int flg = false;
          tmp = E[i][cur[0]];
          for (int i = 0; i + 1 < cur.size(); ++i) {
            int u = cur[i], v = cur[i + 1];
            if (!edg[u][v]) {
              flg = true;
              break;
            }
            for (int w = 0; w < E[u][v].size(); ++w) tmp.push_back(E[u][v][w]);
          }
          if (flg) break;
          if (tmp == cur) {
            B[i][cur.back()].push_back(cur.size());
            break;
          }
          std::swap(tmp, cur);
        }
      }
  for (int i = 1; i <= n; ++i) a[i][i][0] = 1;
  for (int l = 0; l <= n * 2; ++l)
    for (int s = 1; s <= n; ++s)
      for (int i = 1; i <= n; ++i)
        for (int j = 1; j <= n; ++j)
          for (auto x : A[i][j])
            if (x + l <= 2 * n) Add(a[s][j][l + x], a[s][i][l]);
  for (int l = 0; l <= n * 2; ++l)
    for (int s = 1; s <= n; ++s)
      for (int i = 0; i <= n; ++i)
        for (int j = 1; j <= n; ++j)
          for (auto x : C[i][j])
            if (x + l <= 2 * n) Add(ac[s][j][l + x], a[s][i][l]);
  memcpy(acb, ac, sizeof(ac));
  for (int l = 0; l <= n * 2; ++l)
    for (int s = 1; s <= n; ++s)
      for (int i = 0; i <= n; ++i)
        for (int j = 1; j <= n; ++j)
          for (auto x : B[i][j])
            if (x + l <= 2 * n) Add(acb[s][j][l + x], acb[s][i][l]);
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      for (int l = 1; l <= 2 * n; ++l) Add(ans[j][l], acb[i][j][l]);
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (edg[i][j] && E[i][j].empty())
        for (int k = 1; k <= n; ++k)
          for (int l = 0; l <= n * 2 - 1; ++l)
            Add(dacb[i][k][l + 1], acb[j][k][l]);
  for (int l = 1; l <= n * 2; ++l)
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j)
        for (int L = 1; L + l <= n * 2; ++L)
          Add(ans[j][l + L], 1LL * ans[i][l] * dacb[i][j][L] % Mod);
  for (int i = 1; i <= n * 2; ++i) {
    int res = 0;
    for (int j = 1; j <= n; ++j) Add(res, ans[j][i]);
    printf("%d\n", res);
  }
  return 0;
}
