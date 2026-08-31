#include <bits/stdc++.h>
using namespace std;
void initc() {}
int main() {
  initc();
  int n, c, i, t, x = 0;
  cin >> n >> c;
  int a[n], p[n - 1];
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n - 1; i++) p[i] = a[i] - a[i + 1];
  int m = 0;
  for (i = 1; i < n - 1; i++) {
    if (p[i] > p[m]) m = i;
  }
  t = a[m] - a[m + 1] - c;
  if (t > 0)
    cout << t;
  else
    cout << x;
}
