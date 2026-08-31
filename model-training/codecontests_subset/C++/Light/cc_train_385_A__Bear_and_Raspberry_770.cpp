#include <bits/stdc++.h>
using namespace std;
int n, c, ans = 0;
int a[105];
int main() {
  cin >> n >> c;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i < n; i++)
    if (a[i] - a[i + 1] > ans) ans = a[i] - a[i + 1];
  ans = ans - c;
  if (ans > 0)
    cout << ans << endl;
  else
    cout << "0\n";
  return 0;
}
