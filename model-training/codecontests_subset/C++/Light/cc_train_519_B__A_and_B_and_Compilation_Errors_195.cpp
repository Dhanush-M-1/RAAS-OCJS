#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100005], b[100005], c[100005], ans = 0, res = 0, sum = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    ans += a[i];
  }
  for (int i = 1; i <= n - 1; i++) {
    cin >> b[i];
    res += b[i];
  }
  for (int i = 1; i <= n - 2; i++) {
    cin >> c[i];
    sum += c[i];
  }
  cout << ans - res << "\n" << res - sum;
}
