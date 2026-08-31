#include <bits/stdc++.h>
using namespace std;
using ll = long long;
vector<ll> L, R, M;
ll p(const vector<ll>& v, ll c) {
  if (c <= 0) return 0;
  return v[c - 1];
}
const ll INF = 5e10;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  ll N, K;
  cin >> N >> K;
  for (int i = 0; i < N; ++i) {
    ll time, l, r;
    cin >> time >> l >> r;
    if ((l + r) == 2) {
      M.push_back(time);
    } else if (l + r == 1) {
      if (l)
        L.push_back(time);
      else
        R.push_back(time);
    }
  }
  sort(L.begin(), L.end());
  sort(R.begin(), R.end());
  sort(M.begin(), M.end());
  for (int i = 1; i < ((int)(L.size())); ++i) {
    L[i] += L[i - 1];
  }
  for (int i = 1; i < ((int)(R.size())); ++i) {
    R[i] += R[i - 1];
  }
  for (int i = 1; i < ((int)(M.size())); ++i) {
    M[i] += M[i - 1];
  }
  ll ans = INF;
  for (int m = 0; m <= ((int)(M.size())); ++m) {
    ll LR = K - m;
    if (((int)(L.size())) < LR || ((int)(R.size())) < LR) {
      continue;
    }
    ll t = p(M, m) + p(L, LR) + p(R, LR);
    ans = min(ans, t);
  }
  cout << (ans == INF ? -1 : ans);
  return 0;
}
