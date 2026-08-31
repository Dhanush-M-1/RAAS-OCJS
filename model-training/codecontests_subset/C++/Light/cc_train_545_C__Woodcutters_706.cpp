#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a[100000][2], i, n, ans = 1, l;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i][0] >> a[i][1];
  l = a[0][0];
  for (i = 1; i < n - 1; i++) {
    if ((a[i][0] - a[i][1]) > l) {
      ans++;
      l = a[i][0];
    } else if ((a[i][0] + a[i][1]) < a[i + 1][0]) {
      ans++;
      l = a[i][0] + a[i][1];
    } else
      l = a[i][0];
  }
  if (n > 1) ans++;
  cout << ans << endl;
  return 0;
}
