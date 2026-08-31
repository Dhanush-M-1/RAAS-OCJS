#include <bits/stdc++.h>
using namespace std;
int a[122], b[122];
int main() {
  int n, k, t, ans = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> k >> t;
    a[k]++;
    b[t]++;
  }
  for (int i = 1; i <= 100; i++)
    if (a[i] > 0) ans += a[i] * b[i];
  cout << ans << endl;
}
