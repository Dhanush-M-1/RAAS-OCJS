#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0;
  cin >> n;
  int h[n], a[n];
  for (int i = 0; i < n; i++) cin >> h[i] >> a[i];
  for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      if (h[i] == a[j]) ans++;
    }
  }
  for (int i = n - 1; i > 0; i--) {
    for (int j = i - 1; j >= 0; j--) {
      if (h[i] == a[j]) ans++;
    }
  }
  cout << ans;
}
