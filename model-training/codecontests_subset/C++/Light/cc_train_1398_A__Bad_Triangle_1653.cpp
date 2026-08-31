#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int inf = 2e9 + 5;
double PI = 3.14159265358979323846;
void solve() {
  long long int n;
  cin >> n;
  long long int aa[n];
  for (int i = 0; i < n; i++) {
    cin >> aa[i];
  }
  long long int a = aa[0], b = aa[1], c = aa[n - 1];
  if (a + b <= c) {
    cout << 1 << " " << 2 << " " << n << "\n";
  } else {
    cout << -1 << "\n";
  }
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  while (T--) solve();
  return 0;
}
