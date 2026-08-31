#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, k1, x, su(0), n, a(0), b(0), s1(0);
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      a++;
    else
      b++;
    su += x;
  }
  su /= 2;
  if ((su / 50) & 1) {
    cout << "NO";
    return 0;
  }
  x = su / 200;
  for (i = x; i >= 0; i--) {
    k = i;
    k1 = (su - (k * 200)) / 100;
    if (k > b || k1 > a)
      continue;
    else {
      if (((b - k) * 200 + (a - k1) * 100) == su) {
        cout << "YES";
        return 0;
      } else
        continue;
    }
  }
  cout << "NO";
  return 0;
}
