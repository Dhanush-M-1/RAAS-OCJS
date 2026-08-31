#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, x, y;
  cin >> n >> x >> y;
  long p = n * y;
  long t = p % 100;
  long t1 = p / 100;
  long q;
  if (t == 0)
    q = t1;
  else
    q = t1 + 1;
  long ans;
  ans = (q - x);
  if (y < 100) {
    if ((q >= x))
      cout << ans;
    else
      cout << "0";
  } else if (y >= 100) {
    if (q >= x)
      cout << ans;
    else
      cout << "0";
  }
  return 0;
}
