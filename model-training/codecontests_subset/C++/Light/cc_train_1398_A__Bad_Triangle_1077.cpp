#include <bits/stdc++.h>
using namespace std;
using namespace chrono;
const long long int MOD = 1000000007;
const long long int MAXN = 1000005;
const long long int INF = 100000000000005;
void solve() {
  long long int n;
  cin >> n;
  vector<long long int> a(n);
  for (long long int i = 0; i < n; ++i) cin >> a[i];
  if (a[0] + a[1] > a[n - 1]) {
    cout << "-1\n";
    return;
  }
  cout << "1 2 " << n << endl;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
