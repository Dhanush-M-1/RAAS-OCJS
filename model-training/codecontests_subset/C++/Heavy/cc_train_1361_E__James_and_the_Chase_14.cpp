#include <bits/stdc++.h>
#pragma GCC optimize("Ofast", "unroll-loops", "omit-frame-pointer", "inline")
#pragma GCC option("arch=native", "tune=native", "no-zero-upper")
#pragma GCC target("avx2")
using namespace std;
template <typename T>
void maxtt(T& t1, T t2) {
  t1 = max(t1, t2);
}
template <typename T>
void mintt(T& t1, T t2) {
  t1 = min(t1, t2);
}
bool debug = 0;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
string direc = "RDLU";
const long long MOD2 = (long long)1000000007 * (long long)1000000007;
long long ln, lk, lm;
void etp(bool f = 0) {
  puts(f ? "YES" : "NO");
  exit(0);
}
void addmod(int& x, int y, int mod = 1000000007) {
  x += y;
  if (x >= mod) x -= mod;
  if (x < 0) x += mod;
  assert(x >= 0 && x < mod);
}
void et(int x = -1) {
  printf("%d\n", x);
  exit(0);
}
long long fastPow(long long x, long long y, int mod = 1000000007) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = (x * ans) % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
long long gcd1(long long x, long long y) { return y ? gcd1(y, x % y) : x; }
vector<int> mp[(100035)];
int d[(100035)];
int dp[(100035)][2];
bool ins[(100035)], vis[(100035)];
bool ck(int x, int pa) {
  d[x] = d[pa] + 1;
  vis[x] = 1;
  ins[x] = 1;
  for (int c : mp[x]) {
    if (!vis[c]) {
      if (!ck(c, x)) return 0;
    } else {
      if (!ins[c]) return 0;
    }
  }
  ins[x] = 0;
  return 1;
}
void add(int x, int dis) {
  if (dis == (1 << 30)) return;
  if (d[dis] >= d[x]) return;
  if (dp[x][0] == (1 << 30) || d[dis] < d[dp[x][0]]) {
    dp[x][1] = dp[x][0];
    dp[x][0] = dis;
  } else if (dp[x][1] == (1 << 30) || d[dis] < d[dp[x][1]]) {
    dp[x][1] = dis;
  }
}
void dfs(int x) {
  for (int c : mp[x]) {
    if (d[c] > d[x]) {
      dfs(c);
      add(x, dp[c][0]);
      add(x, dp[c][1]);
    } else {
      add(x, c);
    }
  }
}
void dfs2(int x, int rt) {
  if (x != rt) assert(dp[x][0] < (1 << 30));
  if (!vis[x] && dp[x][1] == (1 << 30)) {
    int w = dp[x][0];
    if (vis[w]) {
      vis[x] = 1;
    }
  }
  for (int c : mp[x])
    if (d[c] > d[x]) dfs2(c, rt);
}
void fmain(int tid) {
  scanf("%d%d", &n, &m);
  for (int(i) = 1; (i) <= (int)(n); (i)++) {
    mp[i].clear();
  }
  for (int(i) = 1; (i) <= (int)(m); (i)++) {
    int u, v;
    scanf("%d%d", &u, &v);
    mp[u].push_back(v);
  }
  if (m == 0) {
    puts("1");
    return;
  }
  mt19937 ttrand((int)time(0));
  for (int(z) = 1; (z) <= (int)(100); (z)++) {
    int x = n <= 100 ? z : uniform_int_distribution<int>(1, n)(ttrand);
    for (int(i) = 1; (i) <= (int)(n); (i)++) {
      d[i] = 0;
      ins[i] = 0;
      vis[i] = 0;
    }
    bool fg = ck(x, 0);
    if (!fg) continue;
    for (int(i) = 1; (i) <= (int)(n); (i)++) dp[i][0] = dp[i][1] = (1 << 30);
    for (int(i) = 1; (i) <= (int)(n); (i)++) vis[i] = 0;
    dfs(x);
    vis[x] = 1;
    dfs2(x, x);
    int cnt = 0;
    for (int(i) = 1; (i) <= (int)(n); (i)++)
      if (vis[i]) cnt++;
    if (cnt * 5 < n) {
      puts("-1");
      return;
    }
    for (int(i) = 1; (i) <= (int)(n); (i)++)
      if (vis[i]) printf("%d ", i);
    puts("");
    return;
  }
  puts("-1");
}
int main() {
  int t = 1;
  scanf("%d", &t);
  for (int(i) = 1; (i) <= (int)(t); (i)++) {
    fmain(i);
  }
  return 0;
}
