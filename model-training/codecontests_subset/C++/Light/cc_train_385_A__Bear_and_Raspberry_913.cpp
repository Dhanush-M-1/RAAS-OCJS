#include <bits/stdc++.h>
using namespace std;
int main() {
  int ans = 0;
  int n, c;
  cin >> n >> c;
  int x[101];
  for (int i = 0; i < n; i++) {
    cin >> x[i];
  }
  for (int i = 0; i < n - 1; i++) {
    if (x[i] - x[i + 1] > ans) ans = x[i] - x[i + 1];
  }
  if (ans - c > 0)
    cout << ans - c;
  else
    cout << 0;
}
