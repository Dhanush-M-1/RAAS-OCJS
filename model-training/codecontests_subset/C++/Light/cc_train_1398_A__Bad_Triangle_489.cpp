#include <bits/stdc++.h>
using namespace std;
template <class T>
bool mini(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool maxi(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.precision(10);
  cout << fixed;
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<long long> a(n + 3);
    for (int i = 0; i < (int)(n); i++) cin >> a[i];
    if (a[0] + a[1] <= a[n - 1])
      cout << 1 << " " << 2 << " " << n << "\n";
    else
      cout << -1 << "\n";
  }
}
