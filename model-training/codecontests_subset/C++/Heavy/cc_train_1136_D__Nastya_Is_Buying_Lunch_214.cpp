#include <bits/stdc++.h>
using namespace std;
using ll = int;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  ll n, m;
  cin >> n >> m;
  vector<ll> p(n);
  for (auto &a : p) cin >> a, a--;
  vector<vector<ll> > adj(n);
  vector<bool> good(n);
  for (ll i = 0; i < m; i++) {
    ll a, b;
    cin >> a >> b;
    a--;
    b--;
    adj[a].push_back(b);
    if (b == p[n - 1]) good[a] = true;
  }
  vector<bool> bad(n);
  ll sizeofbad = 0;
  for (ll i = n - 2; i >= 0; i--) {
    ll ourbad = 0;
    for (ll a : adj[p[i]])
      if (bad[a]) ourbad++;
    if (ourbad != sizeofbad || !good[p[i]]) bad[p[i]] = true, sizeofbad++;
  }
  cout << n - 1 - sizeofbad << endl;
}
