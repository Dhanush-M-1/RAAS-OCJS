#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int ans = 98754312;
  for (int i = 0; i < n; i++) {
    int val;
    cin >> val;
    if (k % val == 0) ans = min(ans, k / val);
  }
  cout << ans;
  return 0;
}
