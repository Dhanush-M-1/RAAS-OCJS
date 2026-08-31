#include <bits/stdc++.h>
using namespace std;
int x[33], y[33];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> x[i] >> y[i];
  }
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (i == j) continue;
      if (x[i] == y[j]) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
