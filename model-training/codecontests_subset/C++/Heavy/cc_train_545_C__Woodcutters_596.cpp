#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  ll n, x, h;
  cin >> n;
  if (n <= 2) {
    cout << n;
    return 0;
  }
  vector<pair<ll, ll>> v(n + 2);
  for (int i = 1; i <= n; ++i) cin >> v[i].first >> v[i].second;
  v[0] = make_pair(INT_MIN, 0);
  v[n + 1] = make_pair(INT_MAX, 0);
  sort(begin(v), end(v));
  vector<ll> vl(n + 2), vr(n + 2);
  for (int i = 1; i <= n; ++i) {
    if (v[i].first - v[i].second > v[i - 1].first) {
      vl[i] = vl[i - 1] + 1;
      if (v[i].first - v[i].second > v[i - 1].first + v[i - 1].second)
        vl[i] = max(vl[i], vr[i - 1] + 1);
      else
        vl[i] = max(vl[i], vr[i - 1]);
    } else
      vl[i] = max(vl[i - 1], vr[i - 1]);
    if (v[i].first + v[i].second < v[i + 1].first)
      vr[i] = max(vl[i - 1], vr[i - 1]) + 1;
    else
      vr[i] = max(vl[i - 1], vr[i - 1]);
  }
  cout << max(vl[n], vr[n]);
  return 0;
}
