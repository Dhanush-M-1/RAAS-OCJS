#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T& x) {
  x = 0;
  int fl = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') fl = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 1) + (x << 3) + ch - '0';
    ch = getchar();
  }
  x *= fl;
}
template <typename T, typename... Args>
inline void read(T& t, Args&... args) {
  read(t);
  read(args...);
}
const int N = 300005;
const int INF = 1e9;
int n, k, c;
vector<int> vec[N];
char s[N];
int fa[N << 1], sz[N << 1];
inline int lowbit(int x) { return x & -x; }
inline int findfa(int x) { return x == fa[x] ? x : fa[x] = findfa(fa[x]); }
inline void unionn(int x, int y) {
  x = findfa(x), y = findfa(y);
  fa[y] = x;
  if (sz[x] < INF) sz[x] += sz[y];
}
int main() {
  read(n, k);
  scanf("%s", s + 1);
  for (int i = 1; i <= k; i++) {
    read(c);
    for (int j = 1; j <= c; j++) {
      int x;
      read(x);
      vec[x].push_back(i);
    }
  }
  for (int i = 1; i <= k * 2; i++) fa[i] = i, sz[i] = (i <= k);
  fa[k * 2 + 1] = k * 2 + 1, sz[k * 2 + 1] = INF;
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (vec[i].size() == 1) {
      if (findfa(k * 2 + 1) != findfa(vec[i][0] + k * (s[i] == '0'))) {
        ans -= min(sz[findfa(vec[i][0])], sz[findfa(vec[i][0] + k)]);
        unionn(k * 2 + 1, vec[i][0] + k * (s[i] == '0'));
        ans += min(sz[findfa(vec[i][0])], sz[findfa(vec[i][0] + k)]);
      }
    } else if (vec[i].size() == 2) {
      if (s[i] == '0') {
        if (findfa(vec[i][0]) != findfa(vec[i][1] + k)) {
          ans -= min(sz[findfa(vec[i][0])], sz[findfa(vec[i][0] + k)]);
          ans -= min(sz[findfa(vec[i][1])], sz[findfa(vec[i][1] + k)]);
          unionn(vec[i][0], vec[i][1] + k);
          unionn(vec[i][0] + k, vec[i][1]);
          ans += min(sz[findfa(vec[i][0])], sz[findfa(vec[i][0] + k)]);
        }
      } else {
        if (findfa(vec[i][0]) != findfa(vec[i][1])) {
          ans -= min(sz[findfa(vec[i][0])], sz[findfa(vec[i][0] + k)]);
          ans -= min(sz[findfa(vec[i][1])], sz[findfa(vec[i][1] + k)]);
          unionn(vec[i][0], vec[i][1]);
          unionn(vec[i][0] + k, vec[i][1] + k);
          ans += min(sz[findfa(vec[i][0])], sz[findfa(vec[i][0] + k)]);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
