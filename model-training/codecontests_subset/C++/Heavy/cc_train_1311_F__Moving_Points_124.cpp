#include <bits/stdc++.h>
using namespace std;
mt19937_64 mt_rnd_64(chrono::steady_clock::now().time_since_epoch().count());
long long rnd(long long l, long long r) {
  return (mt_rnd_64() % (r - l + 1)) + l;
}
using ll = long long;
using ld = long double;
using ull = unsigned long long;
const double PI = acos(-1.0);
const ll mod = 1e9 + 7;
const ll INF = 1e17;
ll n;
unordered_map<ll, ll> q;
void add(ll pos, ll val, vector<ll> &t) {
  while (pos < n) {
    t[pos] += val;
    pos = (pos | (pos + 1));
  }
}
ll sum(ll pos, vector<ll> &t) {
  ll ans = 0;
  while (pos >= 0) {
    ans += t[pos];
    pos = (pos & (pos + 1)) - 1;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout << setprecision(10) << fixed;
  cin >> n;
  vector<pair<ll, ll> > x(n);
  for (ll i = 0; i < n; ++i) {
    cin >> x[i].first;
    x[i].second = i;
  }
  vector<ll> v(n);
  set<ll> SET;
  for (ll i = 0; i < n; ++i) {
    cin >> v[i];
    SET.insert(v[i]);
  }
  ll c = 0;
  for (ll i : SET) {
    q[i] = c;
    ++c;
  }
  vector<ll> t(n * 2, 0), t1(n * 2, 0);
  sort(begin(x), end(x));
  ll ans = 0;
  for (ll i = 0; i < n; ++i) {
    ans += sum(q[v[x[i].second]], t) * x[i].first - sum(q[v[x[i].second]], t1);
    add(q[v[x[i].second]], 1, t);
    add(q[v[x[i].second]], x[i].first, t1);
  }
  cout << ans << endl;
  return 0;
}
