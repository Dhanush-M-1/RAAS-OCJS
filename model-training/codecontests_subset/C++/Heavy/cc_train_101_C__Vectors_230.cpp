#include <bits/stdc++.h>
using namespace std;
long long a[4][2], b[2], c[2][2];
long long x[2], y[2], z[2];
void init() {
  a[1][0] = a[0][1];
  a[1][1] = -a[0][0];
  a[2][0] = -a[0][0];
  a[2][1] = -a[0][1];
  a[3][0] = -a[0][1];
  a[3][1] = a[0][0];
  c[1][0] = c[0][1];
  c[1][1] = -c[0][0];
}
bool check() {
  long long det = x[0] * y[1] - x[1] * y[0];
  long long detx = z[0] * y[1] - z[1] * y[0];
  long long dety = x[0] * z[1] - x[1] * z[0];
  if (det == 0 && detx == 0 && dety == 0)
    return true;
  else if (det == 0 && (detx != 0 || dety != 0))
    return false;
  else if (detx % det == 0 && dety % det == 0)
    return true;
  else
    return false;
}
int main() {
  cin >> a[0][0] >> a[0][1];
  cin >> b[0] >> b[1];
  cin >> c[0][0] >> c[0][1];
  init();
  bool ans = false;
  if (c[0][0] == 0 && c[0][1] == 0) {
    for (int i = 0; i < 4; i++) {
      if (b[0] == a[i][0] && b[1] == a[i][1]) {
        ans = true;
        break;
      }
    }
  } else {
    for (int i = 0; i < 4; i++) {
      z[0] = b[0] - a[i][0];
      z[1] = b[1] - a[i][1];
      x[0] = c[0][0];
      x[1] = c[0][1];
      y[0] = c[1][0];
      y[1] = c[1][1];
      if (check()) {
        ans = true;
        break;
      }
    }
  }
  if (ans)
    puts("YES");
  else
    puts("NO");
}
