#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;
using ll = long long;
const int N = 100005;
int n, kk, P;
ll ans, inv[N], sum[N];
map<int, int> cnt;
ll qpow(ll a, ll b) {
  ll ret = 1;
  while (b) {
    if (b & 1) ret = ret * a % P;
    a = a * a % P;
    b >>= 1;
  }
  return ret;
}
void proc(int l, int r, int dep) {
  if (dep <= 1 || l == r) {
    cnt[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  proc(l, mid, dep - 1);
  proc(mid + 1, r, dep - 1);
}
int calc(int x, int y) {
  ll ret = ll(x) * y % P;
  for (int i = 1; i <= x; i++)
    ret = (ret + P - (sum[i + y] - sum[i]) * 2 % P) % P;
  return ret;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> kk >> P;
  for (int i = 1; i < N; i++)
    inv[i] = qpow(i, P - 2), sum[i] = (sum[i - 1] + inv[i]) % P;
  proc(1, n, kk);
  for (auto &i : cnt) {
    ll t = i.first, s = i.second;
    ans = (ans + t * (t - 1) % P * inv[2] % P * s % P +
           s * (s - 1) % P * inv[2] % P * calc(t, t) % P) %
          P;
  }
  for (auto &i : cnt)
    for (auto &j : cnt)
      if (i.first < j.first)
        ans =
            (ans + calc(i.first, j.first) * 1ll * i.second % P * j.second % P) %
            P;
  cout << ans * inv[2] % P << endl;
  return 0;
}
