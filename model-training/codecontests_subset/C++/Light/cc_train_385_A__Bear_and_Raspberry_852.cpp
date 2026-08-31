#include <bits/stdc++.h>
using namespace std;
int main() {
  int prices[105];
  int n, m, ans = 0, last = 0, temp;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> prices[i];
  }
  for (int i = 0; i < n - 1; i++) {
    ans = max(ans, (prices[i] - prices[i + 1]) - m);
  }
  cout << ans << '\n';
  return 0;
}
