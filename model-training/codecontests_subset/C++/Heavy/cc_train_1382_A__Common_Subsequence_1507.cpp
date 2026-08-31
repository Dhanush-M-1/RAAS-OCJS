#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c, i, j, k, t;
  cin >> t;
  for (i = 0; i < t; i++) {
    cin >> a >> b;
    long long int h[a];
    long long int h1[b];
    for (j = 0; j < a; j++) {
      cin >> h[j];
    }
    for (j = 0; j < b; j++) {
      cin >> h1[j];
    }
    int count = 0, ans = 0;
    for (j = 0; j < a; j++) {
      for (k = 0; k < b; k++) {
        if (h[j] == h1[k]) {
          ans = h[j];
          count = 1;
          break;
        }
      }
    }
    if (count == 1) {
      cout << "YES"
           << "\n";
      cout << "1"
           << " " << ans << "\n";
    } else {
      cout << "NO"
           << "\n";
    }
  }
}
