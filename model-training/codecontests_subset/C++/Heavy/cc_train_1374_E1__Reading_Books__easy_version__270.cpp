#include <bits/stdc++.h>
using namespace std;
long long inf = 1e9;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, k;
  cin >> n >> k;
  vector<long long> l;
  vector<long long> m;
  vector<long long> r;
  for (long long i = 0; i < n; ++i) {
    long long a, b, c;
    cin >> a >> b >> c;
    if (b == 1 && c == 1) {
      m.push_back(a);
    } else if (b == 1 && c == 0) {
      l.push_back(a);
    } else if (b == 0 && c == 1) {
      r.push_back(a);
    }
  }
  sort(l.begin(), l.end());
  sort(r.begin(), r.end());
  sort(m.begin(), m.end());
  auto it1 = l.begin();
  auto it2 = m.begin();
  auto it3 = r.begin();
  long long ans = 0;
  long long x = 0, y = 0;
  while ((x < k && y < k) &&
         (((it1 != l.end()) && (it3 != r.end())) || (it2 != m.end()))) {
    if ((it2 == m.end()) ||
        (it1 != l.end() && it3 != r.end() && *it1 + *it3 < *it2)) {
      ans += (*it1 + *it3);
      it1++;
      it3++;
    } else if ((it2 != m.end()) || ((it1 == l.end() || (it3 == r.end())))) {
      ans += *it2;
      it2++;
    }
    x++;
    y++;
  }
  if (x == k && y == k)
    cout << ans << "\n";
  else
    cout << -1 << "\n";
}
