#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n;
  cin >> n;
  vector<long long int> a(n);
  for (auto &x : a) cin >> x;
  long long int p = -1, q = -1, r = -1;
  long long int big = a[n - 1];
  bool ok = false;
  for (int i = n - 2; i >= 0; i--) {
    if (a[i] + a[i - 1] <= big && i - 1 >= 0) {
      p = i;
      q = i + 1;
      r = n;
      ok = true;
    }
  }
  if (ok == true)
    cout << p << " " << q << " " << r << endl;
  else
    cout << -1 << endl;
}
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
