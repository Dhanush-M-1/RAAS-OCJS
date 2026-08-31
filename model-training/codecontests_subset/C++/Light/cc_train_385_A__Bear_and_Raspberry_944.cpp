#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, x[100], ans = 0;
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> x[i];
    if (i != 0 && x[i - 1] - x[i] - c > ans) ans = x[i - 1] - x[i] - c;
  }
  cout << ans << endl;
  return 0;
}
