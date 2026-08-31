#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
map<ll, ll> mp1, mp;
vector<pair<ll, pair<ll, ll> > > vpp1;
vector<pair<ll, ll> > vp, vp1;
vector<ll> v, v1, v2, fin;
map<pair<ll, ll>, bool> mbb;
map<ll, bool> mb;
ll a, b, c, n, d, e, f, ta, sum = 0, cnt = 0, m, l, req, sz, maxi, k;
bool sortbysec(const pair<pair<ll, ll>, ll> &a,
               const pair<pair<ll, ll>, ll> &b) {
  return (a.second < b.second);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll ans = 0;
  cin >> n;
  ll arr[n + 10];
  ll sum = 0;
  for (ll i = 0; i < n; i++) {
    cin >> arr[i];
    maxi = max(maxi, arr[i]);
    sum += arr[i];
  }
  ll need = ((2 * sum) + (n - 1)) / n;
  ans = max(need, maxi);
  if ((ans * n) - sum <= sum) ans++;
  cout << ans << endl;
  return 0;
}
