#include <bits/stdc++.h>
using namespace std;
long long int ivalue(string s) {
  long long int x = 0;
  stringstream obj(s);
  obj >> x;
  return x;
}
const long long int M = 1e9 + 7;
const long long int N = 1e5 + 5;
const long long int inf = 2e18;
long long int mod(long long int x) { return (x % M); }
long long int mod_minus(long long int a, long long int b) {
  long long int ans = (mod(a) - mod(b));
  if (ans < 0) ans = mod(ans + M);
  return ans;
}
long long int mod_mul(long long int a, long long int b) {
  return mod(mod(a) * mod(b));
}
long long int mod_add(long long int a, long long int b) {
  return mod(mod(a) + mod(b));
}
long long int power(long long int a, long long int n) {
  if (n == 0)
    return 1;
  else if (n == 1)
    return a;
  long long int R = power(a, n / 2) % M;
  if (n % 2 == 0) {
    return mod(mod_mul(R, R));
  } else {
    return mod(mod_mul(mod_mul(R, a), mod(R)));
  }
}
long long int mod_div(long long int a, long long int b) {
  long long int ans = mod(a);
  long long int b1 = power(b, M - 2);
  ans = mod(mod_mul(ans, b1));
  return ans;
}
long long int mod_inv(long long int n) { return power(n, M - 2); }
long long int fact_mod(long long int n) {
  vector<long long int> fact(n + 1);
  fact[0] = 1;
  for (long long int i = 1; i < n + 1; i++) {
    fact[i] = mod_mul(fact[i - 1], i);
  }
  return fact[n];
}
long long int nCr_mod(long long int n, long long int r) {
  if (r == 0 || n == 0) return 1;
  long long int fac[n + 1];
  fac[0] = 1;
  for (long long int i = 1; i <= n; i++) fac[i] = (fac[i - 1] * i) % M;
  return (fac[n] * mod_inv(fac[r]) % M * mod_inv(fac[n - r]) % M) % M;
}
long long int upper_fraction(long long int a, long long int b) {
  if (a % b == 0)
    return a / b;
  else
    return (a / b) + 1;
}
bool isInt(double d) {
  double dummy;
  return modf(d, &dummy) == 0.0;
}
struct CompareHeight {
  bool operator()(pair<long long int, long long int> const& x,
                  pair<long long int, long long int> const& y) {
    if (x.first == y.first) return x.second > y.second;
    return x.first < y.first;
  }
};
void solve() {
  long long int n;
  cin >> n;
  vector<long long int> a(n);
  long long int i;
  for (i = 0; i < n; i++) cin >> a[i];
  long long int m;
  cin >> m;
  while (m--) {
    long long int k, pos;
    priority_queue<pair<long long int, long long int>,
                   vector<pair<long long int, long long int>>, CompareHeight>
        pq;
    for (i = 0; i < n; i++) pq.push({a[i], i + 1});
    cin >> k >> pos;
    vector<pair<long long int, long long int>> v(k);
    long long int j = 0;
    while (pq.empty() == false) {
      if (j == k) break;
      v[j] = {pq.top().second, pq.top().first};
      j++;
      pq.pop();
    }
    sort((v).begin(), (v).end());
    cout << v[pos - 1].second << endl;
  }
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  t = 1;
  while (t--) solve();
}
