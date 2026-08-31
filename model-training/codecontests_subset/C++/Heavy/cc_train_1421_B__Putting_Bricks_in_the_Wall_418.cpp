#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n = 0;
  cin >> n;
  vector<vector<long long>> arr(n, vector<long long>(n));
  for (long long i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (long long j = 0; j < n; j++) {
      for (long long j = 0; j < n; j++) arr[i][j] = s[j] - '0';
    }
  }
  long long n1 = arr[0][1];
  long long n2 = arr[1][0];
  long long n3 = arr[n - 1][n - 2];
  long long n4 = arr[n - 2][n - 1];
  if (n1 == n2 && n2 == n3 && n3 == n4) {
    cout << 2 << "\n";
    cout << 1 << " " << 2 << "\n";
    cout << 2 << " " << 1 << "\n";
  } else if (n1 == n2 && n3 == n4) {
    cout << 0 << "\n";
  } else if (n1 == n2) {
    cout << 1 << "\n";
    if (n2 == n3)
      cout << n << " " << n - 1 << "\n";
    else
      cout << n - 1 << " " << n << "\n";
  } else if (n3 == n4) {
    cout << 1 << "\n";
    if (n1 == n3)
      cout << 1 << " " << 2 << "\n";
    else
      cout << 2 << " " << 1 << "\n";
  } else if (n1 == n3) {
    cout << 2 << "\n";
    cout << 1 << " " << 2 << "\n";
    cout << n - 1 << " " << n << "\n";
  } else {
    cout << 2 << "\n";
    cout << 1 << " " << 2 << "\n";
    cout << n << " " << n - 1 << "\n";
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
