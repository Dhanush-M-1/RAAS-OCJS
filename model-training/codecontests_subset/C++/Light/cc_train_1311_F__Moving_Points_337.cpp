#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i;
  cin >> n;
  pair<long long, long long> p[n];
  long long a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
    p[i].second = a[i];
  }
  for (i = 0; i < n; i++) cin >> p[i].first;
  sort(a, a + n);
  sort(p, p + n);
  map<long long, long long> mp;
  long long ans = 0;
  for (i = 0; i < n; i++) {
    ans += a[i] * (2 * i + 1 - n);
    mp[a[i]] = i;
  }
  for (i = 0; i < n; i++) {
    ans -= p[i].second * (mp[p[i].second] - i);
  }
  cout << ans << endl;
  return 0;
}
