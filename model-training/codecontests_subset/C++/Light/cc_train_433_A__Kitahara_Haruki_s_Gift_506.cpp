#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j;
  cin >> n;
  int a[n + 1], ans = 0, x = 0, y = 0, l, m, k;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == 100)
      x++;
    else
      y++;
  }
  k = x * 100 + y * 200;
  if (k % 200 == 0) {
    if (x == 0 && y % 2 == 0)
      cout << "YES";
    else if (x != 0)
      cout << "YES";
    else
      cout << "NO";
  } else {
    cout << "NO";
  }
  return 0;
}
