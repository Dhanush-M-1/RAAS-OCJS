#include <bits/stdc++.h>
using namespace std;
int n, k, a, ans = 10000;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (k >= a && k % a == 0) ans = min(ans, k / a);
  }
  cout << ans << endl;
  return 0;
}
