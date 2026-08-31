#include <bits/stdc++.h>
using namespace std;
const long long INF = 2e15;
const long long MB = 20;
const long long MOD = 1e9 + 7;
void solve() {
  long long n;
  cin >> n;
  vector<long long> a(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
  if (a.back() >= a[0] + a[1]) {
    cout << "1 2 " << n << '\n';
    return;
  }
  cout << "-1\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout << fixed;
  cout.precision(12);
  srand(time(0));
  long long t;
  cin >> t;
  while (t--) solve();
}
