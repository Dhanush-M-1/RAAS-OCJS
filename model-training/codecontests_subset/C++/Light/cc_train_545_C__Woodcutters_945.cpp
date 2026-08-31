#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 1;
  cin >> n;
  int a[n + 1], b[n];
  a[n] = INT_MAX;
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  for (int i = 1; i < n; i++)
    if (a[i] - a[i - 1] > b[i])
      ans++;
    else if (a[i + 1] - a[i] > b[i])
      a[i] += b[i], ans++;
  cout << ans;
  return 0;
}
