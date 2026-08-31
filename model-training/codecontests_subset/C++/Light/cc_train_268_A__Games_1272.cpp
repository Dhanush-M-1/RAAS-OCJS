#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, h[50], a[50], i, j, ans = 0;
  cin >> n;
  for (i = 0; i < n; i++) cin >> h[i] >> a[i];
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (h[i] == a[j]) ans++;
    }
  }
  cout << ans;
}
