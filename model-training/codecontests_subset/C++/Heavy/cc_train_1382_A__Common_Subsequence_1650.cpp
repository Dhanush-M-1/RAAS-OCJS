#include <bits/stdc++.h>
const long long infl = 1e18;
const int infi = 2e9;
const int mod = 1e9 + 7;
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    long long ans;
    long long a[100000];
    long long b[100000];
    long long count = 0;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          count++;
          ans = a[i];
          break;
        }
      }
    if (count) {
      cout << "YES"
           << "\n";
      cout << 1 << " " << ans << "\n";
    } else {
      cout << "NO"
           << "\n";
    }
  }
}
