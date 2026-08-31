#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n][2];
  for (int i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  int ans = 0;
  if (n >= 2)
    ans = 2;
  else if (n == 1)
    ans = 1;
  for (int i = 1; i < n - 1; i++) {
    if (a[i][0] - a[i][1] > a[i - 1][0])
      ans += 1;
    else if (a[i][0] + a[i][1] < a[i + 1][0]) {
      a[i][0] = a[i][0] + a[i][1];
      ans += 1;
    }
  }
  cout << ans;
  return 0;
}
