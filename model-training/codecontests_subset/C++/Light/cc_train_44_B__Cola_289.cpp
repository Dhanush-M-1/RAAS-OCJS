#include <bits/stdc++.h>
using namespace std;
int p[105][105], n, m, a[105], l, r, sum = 1e9, ans;
int main() {
  cin >> n;
  int a1, a2, a3;
  cin >> a1 >> a2 >> a3;
  for (int i = 0; i <= min(a3, n / 2); i++) {
    for (int j = 0; j <= min(a2, n); j++) {
      if ((n - i * 2 - j) * 2 <= a1 && n - i * 2 - j >= 0) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
