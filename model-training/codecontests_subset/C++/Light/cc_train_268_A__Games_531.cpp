#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, j, a[30], h[30], c = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (i != j && h[i] == a[j]) {
        c++;
      }
    }
  }
  cout << c << "\n";
  return 0;
}
