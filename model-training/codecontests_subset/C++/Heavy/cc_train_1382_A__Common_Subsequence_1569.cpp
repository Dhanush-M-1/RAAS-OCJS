#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC optimize("O3")
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  long long t, i, j, a, b;
  cin >> t;
  for (int z = 1; z <= t; z++) {
    cin >> a >> b;
    int x[a], y[b];
    for (i = 0; i <= a - 1; i = i + 1) cin >> x[i];
    for (i = 0; i <= b - 1; i = i + 1) cin >> y[i];
    for (i = 0; i <= a - 1; i = i + 1) {
      for (j = 0; j <= b - 1; j = j + 1) {
        if (x[i] == y[j]) {
          cout << "YES"
               << "\n";
          cout << "1 " << x[i] << "\n";
          a = 0;
          goto A;
        }
      }
    }
  A:
    if (a)
      cout << "NO"
           << "\n";
  }
  return 0;
}
