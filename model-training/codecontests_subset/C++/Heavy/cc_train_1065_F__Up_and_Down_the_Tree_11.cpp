#include <bits/stdc++.h>
using namespace std;
char buf[1 << 21], *p1 = buf, *p2 = buf;
template <class T>
inline bool cmin(T& a, const T& b) {
  return a > b ? a = b, 1 : 0;
}
template <class T>
inline bool cmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
inline int read() {
  char ch;
  bool flag = 0;
  int res;
  while (!isdigit(
      ch = (p1 == p2 &&
                    (p2 = (p1 = buf) + fread(buf, 1, 1 << 21, stdin), p1 == p2)
                ? EOF
                : *p1++)))
    (ch == '-') && (flag = true);
  for (res = ch - '0'; isdigit(
           ch = (p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1 << 21, stdin),
                             p1 == p2)
                     ? EOF
                     : *p1++));
       res = res * 10 + ch - '0')
    ;
  (flag) && (res = -res);
  return res;
}
const int N = 1e6 + 5, inf = 0x3f3f3f3f;
int head[N], Next[N], ver[N], tot;
inline void add(int u, int v) {
  ver[++tot] = v, Next[tot] = head[u], head[u] = tot;
}
int dp[N], a[N], h[N], n, k;
void dfs(int u) {
  h[u] = inf;
  for (int i = head[u]; i; i = Next[i]) {
    int v = ver[i];
    dfs(v);
    cmin(h[u], h[v] + 1), a[u] += a[v], cmax(dp[u], dp[v] - a[v]);
  }
  dp[u] += a[u];
  if (h[u] == inf) dp[u] = a[u] = 1, h[u] = 0;
  if (h[u] >= k) a[u] = 0;
}
int main() {
  n = read(), k = read();
  for (int i = 2, fa; i <= n; ++i) fa = read(), add(fa, i);
  dfs(1);
  printf("%d\n", dp[1]);
  return 0;
}
