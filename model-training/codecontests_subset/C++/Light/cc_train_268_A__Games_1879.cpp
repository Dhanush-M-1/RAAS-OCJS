#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans(0);
  cin >> n;
  int h[n], a[n];
  for (int i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
  }
  for (int b = 0; b < n; b++) {
    for (int c = 0; c < n; c++) {
      if (c != b) {
        if (h[b] == a[c]) ans++;
      }
    }
  }
  cout << ans << endl;
}
