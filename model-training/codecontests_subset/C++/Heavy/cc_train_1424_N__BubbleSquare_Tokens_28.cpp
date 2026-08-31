#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 1) + (x << 3) + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, m;
int main() {
  n = read();
  m = read();
  vector<vector<int> > graf(n);
  vector<int> fa(n), cnt(n), last;
  for (int i = 0; i < m; ++i) {
    int u = read() - 1, v = read() - 1;
    graf[((u) > (v) ? (u) : (v))].push_back(((u) < (v) ? (u) : (v)));
    cnt[u]++;
    cnt[v]++;
  }
  vector<pair<pair<int, int>, int> > E;
  for (int i = 0; i < n; ++i) {
    map<int, int> vis;
    vector<int> up, down;
    for (auto v : graf[i]) {
      vis[cnt[v]] = 1;
      if (fa[v])
        up.push_back(v);
      else
        down.push_back(v);
    }
    if (!vis[cnt[i]]) {
      for (auto v : up) E.push_back({{v, i}, 1});
      for (auto v : down) E.push_back({{v, i}, 1});
      continue;
    }
    bool fl = 0;
    for (int j = 1; j <= up.size(); ++j)
      if (!vis[cnt[i] + j]) {
        cnt[i] += j;
        for (auto v : down) E.push_back({{v, i}, 1});
        for (int k = 0; k < up.size(); ++k)
          if (k < j) {
            E.push_back({{up[k], i}, 2});
            fa[up[k]] ^= 1;
          } else
            E.push_back({{up[k], i}, 1});
        fl = 1;
        break;
      }
    if (!fl)
      for (int j = 1; j <= down.size(); ++j)
        if (!vis[cnt[i] - j]) {
          cnt[i] -= j;
          for (auto v : up) E.push_back({{v, i}, 1});
          for (int k = 0; k < down.size(); ++k)
            if (k < j) {
              E.push_back({{down[k], i}, 0});
              fa[down[k]] ^= 1;
            } else
              E.push_back({{down[k], i}, 1});
          fl = 1;
          break;
        }
  }
  for (int i = 0; i < n; ++i)
    if (fa[i]) last.push_back(i);
  printf("%d ", last.size());
  for (auto v : last) printf("%d ", v + 1);
  puts("");
  for (auto v : E)
    printf("%d %d %d\n", v.first.first + 1, v.first.second + 1, v.second);
  return 0;
}
