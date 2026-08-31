#include <bits/stdc++.h>
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
string direc = "URDL";
long long ln, lk, lm;
void etp(bool f = 0) {
  puts(f ? "YES" : "NO");
  exit(0);
}
void addmod(int& x, int y, int mod = 998244353) {
  assert(y >= 0);
  x += y;
  if (x >= mod) x -= mod;
  assert(x >= 0 && x < mod);
}
void et(int x = -1) {
  printf("%d\n", x);
  exit(0);
}
long long fastPow(long long x, long long y, int mod = 998244353) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = (x * ans) % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
long long gcd1(long long x, long long y) { return y ? gcd1(y, x % y) : x; }
int a[100035], pre[100035], pos[100035], dp[100035];
int SZ, ps[320][100035], S, add[320];
int pfx[100035];
void bd(int bid, int pos, int val) {
  int z = pfx[pos];
  addmod(ps[bid][z], 998244353 - dp[pos - 1]);
  if (z + add[bid] <= k) addmod(S, 998244353 - dp[pos - 1]);
  pfx[pos] += val;
  z = pfx[pos];
  addmod(ps[bid][z], dp[pos - 1]);
  if (z + add[bid] <= k) addmod(S, dp[pos - 1]);
}
int gid(int pos) { return (pos + SZ - 1) / SZ; }
void upt(int l, int r, int val) {
  int lid = gid(l), rid = gid(r);
  if (lid == rid) {
    for (int i = l; i <= r; i++) bd(lid, i, val);
    return;
  }
  for (int i = l; i <= n; i++) {
    bd(lid, i, val);
    if (i % SZ == 0) break;
  }
  for (int z = lid + 1; z < rid; z++) {
    if (val == 1) {
      if (k >= add[z]) addmod(S, 998244353 - ps[z][k - add[z]]);
      add[z]++;
    } else {
      if (k + 1 >= add[z]) addmod(S, ps[z][k + 1 - add[z]]);
      add[z]--;
    }
  }
  for (int i = (rid - 1) * SZ + 1; i <= r; i++) {
    bd(rid, i, val);
  }
}
void fmain(int tid) {
  scanf("%d%d", &n, &k);
  for (int(i) = 1; (i) <= (int)(n); (i)++) {
    scanf("%d", a + i);
    pre[i] = pos[a[i]];
    pos[a[i]] = i;
  }
  dp[0] = 1;
  S = 1;
  SZ = sqrt(n);
  ps[1][0] = 1;
  for (int(i) = 1; (i) <= (int)(n); (i)++) {
    upt(pre[i] + 1, i, 1);
    if (pre[i]) upt(pre[pre[i]] + 1, pre[i], -1);
    dp[i] = S;
    int z = gid(i + 1);
    addmod(ps[z][0], S);
    addmod(S, S);
  }
  printf("%d\n", dp[n]);
}
int main() {
  int t = 1;
  for (int(i) = 1; (i) <= (int)(t); (i)++) {
    fmain(i);
  }
  return 0;
}
