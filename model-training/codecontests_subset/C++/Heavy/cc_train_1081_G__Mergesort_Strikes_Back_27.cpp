#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
const int MAXN = 100000;
int n, mxdepth, MOD;
int INV2;
int inv[2 * MAXN + 1];
vector<int> parts;
void rec(int l, int r, int h) {
  if (l > r) return;
  if (h == 1 || l == r) {
    parts.push_back(r - l + 1);
    return;
  }
  int m = (l + r) / 2;
  rec(l, m, h - 1);
  rec(m + 1, r, h - 1);
}
int cntpairs(int sz) { return (long long)sz * (sz - 1) / 2 % MOD; }
int calc(int sz) { return (long long)cntpairs(sz) * INV2 % MOD; }
int calc(int sza, int szb) {
  int ret = 0;
  for (int den = (2); den <= (sza + szb); ++den) {
    int lo = max(1, den - szb), hi = min(sza, den - 1), cnt = hi - lo + 1;
    if (lo > hi) continue;
    int cur = (long long)(den - 2) % MOD * inv[den] % MOD * INV2 % MOD;
    ret = (ret + (long long)cnt * cur) % MOD;
  }
  return ret;
}
int solve() {
  INV2 = (MOD + 1) / 2;
  inv[1] = 1;
  for (int i = (2); i <= (2 * n); ++i)
    inv[i] = (long long)(MOD - MOD / i) * inv[MOD % i] % MOD;
  parts.clear();
  rec(1, n, mxdepth);
  int sz1 = -1, cnt1 = 0, sz2 = -1, cnt2 = 0;
  for (int i = (0); i < (((int)(parts).size())); ++i) {
    int x = parts[i];
    if (x == sz1)
      ++cnt1;
    else if (x == sz2)
      ++cnt2;
    else if (sz1 == -1)
      sz1 = x, ++cnt1;
    else if (sz2 == -1)
      sz2 = x, ++cnt2;
    else
      assert(false);
  }
  int ret = 0;
  if (cnt1 != 0) ret = (ret + (long long)cnt1 * calc(sz1)) % MOD;
  if (cnt2 != 0) ret = (ret + (long long)cnt2 * calc(sz2)) % MOD;
  if (cnt1 != 0) ret = (ret + (long long)cntpairs(cnt1) * calc(sz1, sz1)) % MOD;
  if (cnt1 != 0 && cnt2 != 0)
    ret = (ret + (long long)cnt1 * cnt2 % MOD * calc(sz1, sz2)) % MOD;
  if (cnt2 != 0) ret = (ret + (long long)cntpairs(cnt2) * calc(sz2, sz2)) % MOD;
  return ret;
}
void run() {
  scanf("%d%d%d", &n, &mxdepth, &MOD);
  printf("%d\n", solve());
}
int main() {
  run();
  return 0;
}
