#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long i, j, n, m, k, cnt = 0, ans = 0, t = 1;
  long long l = 0, r = 0, a = 0, b = 0;
  cout << "? " << 0 << " " << 0 << endl;
  cin >> k;
  for (i = 29; i >= 0; i--) {
    long long c = ((1 << i) + l), d = r, a1, a2;
    cout << "? " << c << " " << d << endl;
    cin >> a1;
    c = l, d = ((1 << i) + r);
    cout << "? " << c << " " << d << endl;
    cin >> a2;
    if (a1 == a2) {
      if (k == 1)
        a += (1 << i), l += (1 << i);
      else
        b += (1 << i), r += (1 << i);
      if (a1 == 1)
        k = 1;
      else
        k = -1;
    } else {
      if (a1 == -1 && a2 == 1)
        a += (1 << i), b += (1 << i), l += (1 << i), r += (1 << i);
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
