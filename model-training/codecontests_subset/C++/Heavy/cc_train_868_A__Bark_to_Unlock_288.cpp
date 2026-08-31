#include <bits/stdc++.h>
using namespace std;
void solve() {
  string s;
  cin >> s;
  ;
  long long n;
  cin >> n;
  ;
  string a[n];
  int z = 0;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    if (s == a[i]) z = 1;
  }
  if (z == 1) {
    cout << "YES"
         << "\n";
    return;
  }
  for (long long i = 0; i < n; i++) {
    for (long long j = i; j < n; j++) {
      if (a[i][1] == s[0] && a[j][0] == s[1]) {
        cout << "YES"
             << "\n";
        return;
      }
    }
  }
  for (long long i = n - 1; i >= 0; i--) {
    for (long long j = i; j >= 0; j--) {
      if (a[i][1] == s[0] && a[j][0] == s[1]) {
        cout << "YES"
             << "\n";
        return;
      }
    }
  }
  cout << "NO"
       << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
