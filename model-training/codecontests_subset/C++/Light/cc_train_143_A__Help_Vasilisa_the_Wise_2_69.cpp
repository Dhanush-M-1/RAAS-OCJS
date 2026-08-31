#include <bits/stdc++.h>
using namespace std;
int a[111111], b[111111], n, k, i, j, p, f[111111], w, ans, m1, m2, m3, m4, m5,
    m6, q, z, x, y;
int main() {
  cin >> m1 >> m2 >> m3 >> m4 >> m5 >> m6;
  if ((m2 + m3 + m5) % 2 == 0 && m3 <= (m2 + m3 + m5) / 2)
    q = (m2 + m3 + m5) / 2 - m3;
  else {
    cout << "-1";
    return 0;
  }
  x = m5 - q;
  y = m1 - x;
  z = m3 - x;
  if (x > 0 && y > 0 && z > 0 && q > 0 && x != y && y != z && x != q &&
      x != z && y != q && z != q && x <= 9 && y <= 9 && z <= 9 && q <= 9)
    cout << x << " " << y << endl << z << " " << q;
  else
    cout << "-1";
  cin >> n;
}
