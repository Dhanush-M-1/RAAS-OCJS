#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n, m, i, j;
  cin >> n >> m;
  vector<long long int> a(n);
  for (i = 0; i < n; i++) cin >> a[i];
  vector<long long int> b(m);
  for (i = 0; i < m; i++) cin >> b[i];
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
      if (a[i] == b[j]) {
        cout << "YES"
             << "\n";
        cout << 1 << " " << a[i] << "\n";
        return;
      }
    }
  }
  cout << "NO"
       << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin.exceptions(cin.failbit);
  long long int tc = 1;
  cin >> tc;
  while (tc--) {
    solve();
  }
}
