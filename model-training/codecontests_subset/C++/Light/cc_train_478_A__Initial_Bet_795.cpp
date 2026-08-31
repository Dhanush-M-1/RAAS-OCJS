#include <bits/stdc++.h>
using namespace std;
int c[6], b, mn = 101, mx, d;
bool found;
int main() {
  for (int i = 1; i <= 5; i++) {
    cin >> c[i];
    mx = max(mx, c[i]);
    mn = min(mn, c[i]);
  }
  for (int i = mn; i <= mx; i++) {
    d = 0;
    b = i;
    for (int j = 1; j <= 5; j++) d += i - c[j];
    if (d == 0) {
      found = true;
      break;
    }
  }
  if (found && b != 0)
    cout << b << endl;
  else
    cout << -1 << endl;
  return 0;
}
