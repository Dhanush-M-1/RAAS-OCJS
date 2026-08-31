#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<int>;
using db = double;
ll a[1000006];
ll p[1000006];
ll s[1000006];
void add(ll l, ll r, ll L, ll R) {
  if (L <= R) {
    a[l] += 1;
    a[r] -= 1;
    p[r] -= r - l;
    p[l] += L - 1;
    p[r] -= L - 1;
  } else {
    a[l] -= 1;
    a[r] += 1;
    p[r] += r - l;
    p[l] += L + 1;
    p[r] -= L + 1;
  }
}
int n;
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    ll a;
    scanf("%lld", &a);
    --a;
    if (i >= a) {
      add(0, n - i, i - a, n - a);
      add(n - i, n - i + a, a - 0, 0);
      add(n - i + a, n, 0, i - a);
    } else {
      add(0, a - i, a - i, 0);
      add(a - i, n - i, 0, n - a);
      add(n - i, n, a, a - i);
    }
  }
  partial_sum(a, a + n, a);
  partial_sum(a, a + n, a);
  partial_sum(p, p + n, p);
  transform(a, a + n, p, s, plus<ll>());
  auto t = min_element(s, s + n);
  cout << *t << ' ' << t - s << endl;
  return 0;
}
