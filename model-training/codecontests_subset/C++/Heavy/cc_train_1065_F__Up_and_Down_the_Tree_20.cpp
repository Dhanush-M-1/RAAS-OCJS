#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T read(register T& t) {
  register T f = 1;
  register char ch = getchar();
  t = 0;
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -f;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') t = t * 10 + ch - '0', ch = getchar();
  t *= f;
  return t;
}
template <typename T, typename... Args>
inline void read(T& t, Args&... args) {
  read(t);
  read(args...);
}
const long long p = 1e9 + 7;
inline long long power(register long long x, register long long k = p - 2) {
  register long long re = 1;
  for (; k; k >>= 1, x = x * x % p)
    if (k & 1) re = re * x % p;
  return re;
}
int n, k;
vector<int> to[1000005];
int ned[1000005];
int dep[1000005];
int dfs1(int now, int fa) {
  dep[now] = dep[fa] + 1;
  if (to[now].size() == 0) return ned[now] = dep[now];
  ned[now] = 1e9;
  for (int i : to[now]) ned[now] = min(ned[now], dfs1(i, now));
  return ned[now];
}
int f[1000005];
void dfs2(int now) {
  if (to[now].size() == 0) return f[now] = 1, void();
  for (int i : to[now]) {
    dfs2(i);
    if (ned[i] - dep[now] <= k) {
      f[now] += f[i];
      f[i] = 0;
    }
  }
}
int ans;
void dfs3(int now, int s) {
  ans = max(ans, s);
  for (int i : to[now]) dfs3(i, s + f[i]);
}
int main() {
  read(n, k);
  for (int i = 1, x; i < n; i++) read(x), to[x].push_back(i + 1);
  dfs1(1, 0);
  dfs2(1);
  dfs3(1, f[1]);
  printf("%d\n", ans);
}
