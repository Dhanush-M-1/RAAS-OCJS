#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using vi = vector<int>;
using vll = vector<ll>;
using pill = pair<int, ll>;
using vvi = vector<vi>;
ll gcd(ll a, ll b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
ll fast_exp(ll base, ll n, ll m) {
  if (n == 0) return 1;
  ll t = fast_exp(base, n / 2, m);
  if (n % 2 == 0)
    return (t * t) % m;
  else
    return (((t * t) % m) * base) % m;
}
int main() {
  ios::sync_with_stdio(false);
  int n, d;
  cin >> n >> d;
  vi a(n + 1, 0);
  a[0] = 0;
  vi v;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    if (a[i] == 0) v.push_back(i);
    a[i] += a[i - 1];
    if (a[i] > d) {
      cout << "-1\n";
      return 0;
    }
  }
  vi ma(n + 1, 0);
  ma[n] = a[n];
  for (int i = n - 1; i > 0; --i) ma[i] = max(a[i], ma[i + 1]);
  int p = 0, ans = 0;
  ll sh = 0;
  while (p < v.size()) {
    while (p < v.size() and a[v[p]] + sh >= 0) ++p;
    if (p == v.size()) break;
    if (-a[v[p]] > d - ma[v[p]]) {
      cout << "-1\n";
      return 0;
    }
    ++ans, sh = d - ma[v[p]];
  }
  cout << ans << "\n";
  return 0;
}
