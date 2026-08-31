#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
void c_p_c() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
double pi = 3.141592653589;
void solve() {
  long long n;
  cin >> n;
  long long a[n];
  for (long long &i : a) cin >> i;
  if (a[0] + a[1] <= a[n - 1]) {
    cout << 1 << " " << 2 << " " << n << "\n";
    return;
  }
  cout << -1 << "\n";
}
int32_t main() {
  long long x;
  cin >> x;
  while (x--) solve();
  return 0;
}
