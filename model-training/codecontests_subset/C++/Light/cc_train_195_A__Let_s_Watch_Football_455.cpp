#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c, d = 0, f = 0, x, y, flag = 0;
  cin >> a >> b >> c;
  x = a * c;
  y = b * c;
  if ((x - y) % b == 0) flag = 1;
  for (;;) {
    f = f + b;
    if (f <= (x - y)) {
      d++;
    } else
      break;
  }
  if (flag == 1)
    cout << d;
  else
    cout << d + 1;
  return 0;
}
