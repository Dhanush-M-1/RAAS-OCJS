#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll n;
ll a[200001];
ll sum[200001];
ll bit[200001];
ll p[200001];
template <typename T>
inline T read() {
  T x = 0;
  T multiplier = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') {
      multiplier = -1;
    }
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch & 15);
    ch = getchar();
  }
  return x * multiplier;
}
inline ll query(ll idx) {
  ll ans = 0;
  for (; idx; idx -= idx & -idx) {
    ans += bit[idx];
  }
  return ans;
}
inline void add(ll n, ll idx, ll val) {
  for (; idx <= n; idx += idx & -idx) {
    bit[idx] += val;
  }
}
inline ll get_idx(ll x) {
  ll l = 1, r = n, mid;
  ll idx;
  while (l <= r) {
    mid = (l + r + 1) >> 1;
    if (query(mid) <= x) {
      l = mid + 1;
      idx = mid;
    } else {
      r = mid - 1;
    }
  }
  return idx;
}
int main() {
  n = read<ll>();
  for (ll i = 1; i <= n; i++) {
    a[i] = read<ll>();
  }
  for (ll i = 1; i <= n; i++) {
    sum[i] = sum[i - 1] + i - 1;
  }
  for (ll i = 1; i <= n; i++) {
    bit[i] = sum[i] - sum[i - (i & -i)];
  }
  for (ll i = n; i >= 1; i--) {
    ll x = get_idx(a[i]);
    p[i] = x;
    add(n, x + 1, -x);
  }
  for (ll i = 1; i <= n; i++) {
    printf("%lld ", p[i]);
  }
  puts("");
  return 0;
}
