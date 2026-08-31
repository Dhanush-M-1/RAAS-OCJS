#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int x[n];
  for (int i = 0; i < n; i++) cin >> x[i];
  int ans = 0;
  for (int i = 0; i < n - 1; i++) {
    int diff = x[i] - x[i + 1] - c;
    ans = max(ans, diff);
  }
  cout << ans << endl;
  return 0;
}
