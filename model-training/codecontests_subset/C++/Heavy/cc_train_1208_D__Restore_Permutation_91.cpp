#include <bits/stdc++.h>
using namespace std;
using ll = long long;
inline ll read();
const int M = 500016, MOD = 1000000007;
struct BinaryIndexTree {
  ll bit[M], n;
  inline void modify(ll p, ll x) {
    for (; p <= n; p += p & -p) bit[p] += x;
  }
  inline ll sum(ll p) {
    ll res = 0;
    for (; p; p -= p & -p) res += bit[p];
    return res;
  }
  inline ll sum(ll l, ll r) { return sum(r) - sum(l - 1); }
} bit;
ll s[M], save[M], vis[M];
int cal(ll s, int n) {
  ll lef = 1, rig = n;
  while (lef <= rig) {
    ll mid = (lef + rig) >> 1;
    ll val = mid * (mid - 1) / 2 - bit.sum(mid - 1);
    if (val == s && !vis[mid])
      return mid;
    else if (val <= s)
      lef = mid + 1;
    else
      rig = mid - 1;
  }
  assert(0);
  return -1;
}
int main(void) {
  int n = read();
  bit.n = n;
  for (int i = 1; i <= n; ++i) s[i] = read();
  for (int i = n; i >= 1; --i) {
    save[i] = cal(s[i], n);
    bit.modify(save[i], save[i]);
    vis[save[i]] = 1;
  }
  for (int i = 1; i <= n; ++i) cout << save[i] << " ";
  cout << endl;
  return 0;
}
inline ll read() {
  ll x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
