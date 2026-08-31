#include <bits/stdc++.h>
using namespace std;
inline int Read() {
  char c = getchar();
  int num = 0;
  while ('0' > c || c > '9') c = getchar();
  while ('0' <= c && c <= '9') num = num * 10 + c - '0', c = getchar();
  return (num);
}
vector<int> e[400010];
vector<pair<int, int> > s[400010][2];
int f[400010][2], d[400010], n, m;
inline void Dp(int x, int y) {
  for (int i = 0; i < e[x].size(); i++)
    s[x][1].push_back(make_pair(-1, -1)), s[x][0].push_back(make_pair(-1, -1));
  if (d[x] == 1 && y) {
    f[x][0] = 1;
    return;
  }
  int g0 = -1, g1 = -1;
  for (int i = 0; i < e[x].size(); i++)
    if (e[x][i] != y) {
      Dp(e[x][i], x);
      if (g0 == -1) {
        if (f[e[x][i]][0]) g0 = 1, s[x][0][i] = make_pair(0, 0);
        if (f[e[x][i]][1]) g1 = 1, s[x][1][i] = make_pair(1, 1);
        if (g0 == -1) g0 = 0;
        if (g1 == -1) g1 = 0;
        continue;
      }
      int g0_ = g0, g1_ = g1;
      g0 = g1 = 0;
      if (g0_ && f[e[x][i]][1]) g1 = 1, s[x][1][i] = make_pair(0, 1);
      if (g1_ && f[e[x][i]][0]) g1 = 1, s[x][1][i] = make_pair(1, 0);
      if (g1_ && f[e[x][i]][1]) g0 = 1, s[x][0][i] = make_pair(1, 1);
      if (g0_ && f[e[x][i]][0]) g0 = 1, s[x][0][i] = make_pair(0, 0);
    }
  if (x == 1) {
    if (d[x] % 2 == 0)
      f[x][0] = g0;
    else
      f[x][0] = g1;
  } else {
    if (d[x] % 2 == 0)
      f[x][0] = g1, f[x][1] = g0;
    else
      f[x][0] = g0, f[x][1] = g1;
  }
}
inline void Write(int x, int y, int w) {
  if (x == 1) {
    if (d[x] % 2 == 1) w ^= 1;
  } else {
    if (d[x] % 2 == 0) w ^= 1;
  }
  int w0 = w;
  for (int i = e[x].size() - 1; i >= 0; i--)
    if (e[x][i] != y) {
      if (s[x][w][i].second == 1) Write(e[x][i], x, s[x][w][i].second);
      w = s[x][w][i].first;
    }
  printf("%d\n", x);
  if (x == 4) int deb = 0;
  w = w0;
  for (int i = e[x].size() - 1; i >= 0; i--)
    if (e[x][i] != y) {
      if (s[x][w][i].second == 0) Write(e[x][i], x, s[x][w][i].second);
      w = s[x][w][i].first;
    }
}
int p[400010];
int main() {
  n = Read();
  for (int i = 1; i <= n; i++) {
    p[i] = Read();
    if (p[i]) {
      e[i].push_back(p[i]), e[p[i]].push_back(i);
      d[p[i]]++, d[i]++;
    }
  }
  Dp(1, 0);
  if (!f[1][0]) {
    puts("NO");
    return (0);
  }
  puts("YES");
  Write(1, 0, 0);
}
