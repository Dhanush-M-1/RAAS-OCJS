#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, ans = 0;
  cin >> n;
  int h[n], a[n];
  for (i = 0; i < n; i++) cin >> h[i] >> a[i];
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (i != j) {
        if (h[i] == a[j]) ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
