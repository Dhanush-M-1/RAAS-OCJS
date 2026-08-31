#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
long long ii = 1;
void solve() {
  long long n;
  long long kk;
  cin >> n >> kk;
  vector<long long> alice;
  vector<long long> bob;
  vector<long long> all;
  long long al = 0;
  long long bo = 0;
  for (long long i = 0; i < n; i++) {
    long long t;
    long long a;
    long long b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) {
      all.push_back(t);
      al++;
      bo++;
    } else if (a == 1) {
      al++;
      alice.push_back(t);
    } else if (b == 1) {
      bo++;
      bob.push_back(t);
    }
  }
  if (al >= kk && bo >= kk) {
    sort(all.begin(), all.end());
    sort(alice.begin(), alice.end());
    sort(bob.begin(), bob.end());
    long long j = 0;
    long long k = 0;
    long long l = 0;
    long long cn = 0;
    long long ans = 0;
    while (1) {
      if (cn == kk) break;
      if (j < all.size() && k < alice.size() && l < bob.size()) {
        if (all[j] <= alice[k] + bob[l])
          ans += all[j++];
        else
          ans += alice[k++] + bob[l++];
      } else if (j < all.size())
        ans += all[j++];
      else
        ans += alice[k++] + bob[l++];
      cn++;
    }
    cout << ans << '\n';
  } else
    cout << "-1" << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long TestCase;
  TestCase = 1;
  while (TestCase--) solve();
  return 0;
}
