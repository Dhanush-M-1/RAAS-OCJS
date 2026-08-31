#include <bits/stdc++.h>
using namespace std;
long long bin_pow(long long a, long long b) {
  if (b == 0) return 1;
  if (b % 2 == 0) {
    long long t = bin_pow(a, b / 2);
    return t * t % 1000000007;
  } else
    return a * bin_pow(a, b - 1) % 1000000007;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t = 1, n, m, k = 0, x = 0, y = 0, z = 0, sum = 0, l = 0, r = 0,
            ans = 0, mn = LLONG_MAX, mx = LLONG_MIN;
  cin >> n;
  vector<long long> a(n), b(n);
  for (int i = 0; i < n; i++) cin >> a[i], b[i] = a[i];
  sort(b.begin(), b.end());
  reverse(b.begin(), b.end());
  cin >> m;
  while (m--) {
    map<long long, long long> mp, mp1, mp2;
    cin >> k >> x;
    vector<long long> c, d;
    for (int i = 0; i < k; i++) c.push_back(b[i]), mp[b[i]]++;
    for (int i = 0; i < n; i++) mp1[a[i]]++;
    reverse(c.begin(), c.end());
    c.erase(unique(c.begin(), c.end()), c.end());
    l = 0;
    for (int i = 0; i < n; i++) {
      if (mp[a[i]] == 0) continue;
      mp2[a[i]]++;
      if (a[i] == c[l]) {
        d.push_back(a[i]);
        mp[a[i]]--;
        if (mp[a[i]] == 0) l++;
        continue;
      }
      if (mp[a[i]] > mp1[a[i]] - mp2[a[i]]) {
        d.push_back(a[i]);
        mp[a[i]]--;
      }
    }
    ans = d[x - 1];
    cout << ans;
    cout << "\n";
  }
  return 0;
}
